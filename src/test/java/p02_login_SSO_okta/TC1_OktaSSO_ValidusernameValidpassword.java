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

public class TC1_OktaSSO_ValidusernameValidpassword extends ExtentReport{

	@Test
	public void oktaLogin() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("OktaSSO_ValidusernameValidpassword");
		
		DriverClass setup = new DriverClass();
		WebDriver driver= setup.driverSetup();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://dev-801778.oktapreview.com/home/dev-801778_neosuiteautomation_1/0oa14xgjibihlTxHX0h8/aln14xguz78IhFxgZ0h8");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@id='social-saml']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sdtest.user@neeyamo.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Okta@123");
		driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
		try {
			String actual= driver.findElement(By.xpath("//h1[contains(text(),'Sign in to your account')]")).getText();
			String expected= "Sign in to your account";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass-Login sucessfull ");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed -Login fail");
		}
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("AT1001");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Neeyamo!123");
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
		Thread.sleep(4000);
		try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).getText();
			String expected= "Welcome To NeeyamoWorks";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass-Login sucessfull ");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed -Login fail");
		}
		
		
		driver.close();	
	}
}
