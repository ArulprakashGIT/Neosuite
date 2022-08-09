package p01_login_Non_SSO;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC08_InvalidGlobalid_ValidPassword extends BaseClass{

	@Test
	public void invalidGlobalid_ValidPassword() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.username().sendKeys("ET11");
		objlogin.password().sendKeys("Neeyamo!123");
		objlogin.signin().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id,'input-error')]")));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id,'input-error')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(@id,'input-error')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail Global ID-invalid credentials");
			
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Negative Test case fail Global ID-invalid credentials");
		}
		driver.quit();
	}
}
