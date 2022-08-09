package p01_login_Non_SSO;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC09_validmailid_Validpassword extends BaseClass{

	@Test
	public void validmailid_Validpassword() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.username().sendKeys("sdtest.user@neeyamo.com");
		objlogin.password().sendKeys("Neeyamo!123");
		objlogin.signin().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='nav-mobile-right']")));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert failed Mail ID-Login fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed Mail ID -Login fail");
		}
		driver.quit();
	}
}
