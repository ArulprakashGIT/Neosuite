package p01_login_Non_SSO;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC05_validGlobalid_validpassword extends BaseClass{

	@Test
	public void validGlobalid_validpassword() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.username().sendKeys("ET1101");
		objlogin.password().sendKeys("Neeyamo$123");
		objlogin.signin().click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert failed Global ID-Login fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed Global ID -Login fail");
		}
		driver.quit();
	}
}
