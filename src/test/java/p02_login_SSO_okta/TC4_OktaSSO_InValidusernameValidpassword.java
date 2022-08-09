package p02_login_SSO_okta;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.DriverClass;
import ObjectRepositoryNeosuite.ExtentReport;

public class TC4_OktaSSO_InValidusernameValidpassword extends ExtentReport{

	@Test
	public void oktaLogin() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("OktaSSO_InValidusernameValidpassword");
		
		DriverClass setup = new DriverClass();
		WebDriver driver= setup.driverSetup();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://dev-801778.oktapreview.com/home/dev-801778_neosuiteautomation_1/0oa14xgjibihlTxHX0h8/aln14xguz78IhFxgZ0h8");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@id='social-saml']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sdtest.user@neeyamo");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Okta@123");
		driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
		try {
			String actual= driver.findElement(By.xpath("//p[contains(text(),'Unable to sign in')]")).getText();
			String expected= "Unable to sign in";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass-Negative test case invalid credentials");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Negative Test case -failed");
		}
		driver.close();
		
	}
}
