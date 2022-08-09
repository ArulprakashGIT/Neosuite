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

public class TC7_Back_to_Login_Okta extends ExtentReport{

	@Test
	public void Login() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Back_to_Login_Okta");
		
		DriverClass setup = new DriverClass();
		WebDriver driver= setup.driverSetup();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://dev-801778.oktapreview.com/home/dev-801778_neosuiteautomation_1/0oa14xgjibihlTxHX0h8/aln14xguz78IhFxgZ0h8");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[@id='social-saml']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Need help signing in?')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Need help signing in?')]")).click();
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Back to sign in')]")).click();
		Thread.sleep(3000);
		try {
			String actual= driver.findElement(By.xpath("//a[contains(text(),'Need help signing in?')]")).getText();
			String expected= "Need help signing in?";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed -Back to sigin");
		}
		
		driver.close();
		
		
	}
}
