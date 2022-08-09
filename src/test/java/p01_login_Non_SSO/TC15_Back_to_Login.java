package p01_login_Non_SSO;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC15_Back_to_Login extends BaseClass {

	@Test
	public void back_To_Login() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Forgot Password?')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Back to Login')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Back to Login')]")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Forgot Password?']")));
			boolean validate = driver.findElement(By.xpath("//a[text()='Forgot Password?']")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Back to login failed");
		}
		catch(Exception e) {
			Assert.fail("Test case failed-Back to login failed");
		}
		driver.quit();
	}
}
