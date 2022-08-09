package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC01_DelegatePageOpen extends BaseClass{

	@Test
	public void delegatePageOpen() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create Delegation')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(text(),'Create Delegation')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Delegate page not displayed");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false,"Test case fail -Delegate page not displayed");
		}
		driver.quit();
	}
}
