package p02_login_SSO_okta;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.DriverClass;
import ObjectRepositoryNeosuite.ExtentReport;

public class TC5_OktaSSO_Remember_me extends ExtentReport{

	@Test
	public void remember_Me() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("OktaSSO_Remember_me");
		
		DriverClass setup = new DriverClass();
		WebDriver driver= setup.driverSetup();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://dev-801778.oktapreview.com/home/dev-801778_neosuiteautomation_1/0oa14xgjibihlTxHX0h8/aln14xguz78IhFxgZ0h8");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sdtest.user@neeyamo.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Okta@123");
		//driver.findElement(By.xpath("//input[@id='input41']")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Remember me')]")).click();
		driver.findElement(By.xpath("//input[@id='okta-signin-submit']")).click();
		Thread.sleep(8000);
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.switchTo().window(tabs.get(0));
	    driver.close();
	    driver.switchTo().window(tabs.get(1));
	    driver.get("https://dev-801778.oktapreview.com/home/dev-801778_neosuiteautomation_1/0oa14xgjibihlTxHX0h8/aln14xguz78IhFxgZ0h8");
	    Thread.sleep(5000);
	    try {
			String actual= driver.findElement(By.xpath("//h1[contains(text(),'Sign in to your account')]")).getText();
			String expected= "Sign in to your account";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass-Remenber me functionality working");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Remember me functionality fail");
		}
		driver.close();
		
		
		
	}
}
