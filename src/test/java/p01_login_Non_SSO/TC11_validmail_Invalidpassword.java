package p01_login_Non_SSO;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC11_validmail_Invalidpassword extends BaseClass{

	@Test
	public void validmail_Invalidpassword() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.username().sendKeys("sdtest.user@neeyamo.com");
		objlogin.password().sendKeys("Neeyamo@");
		objlogin.signin().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id,'input-error')]")));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@id,'input-error')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(@id,'input-error')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail Mail ID-invalid credentials");
			
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Negative Test case fail Mail ID-invalid credentials");
		}
		driver.quit();
	}
}
