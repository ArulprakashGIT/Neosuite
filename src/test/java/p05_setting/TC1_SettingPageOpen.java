package p05_setting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC1_SettingPageOpen  extends BaseClass{

	@Test
	public void settingPageOpen() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Settings']")));
		objlogin.settings().click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='headingSpan']")));
			String actual= driver.findElement(By.xpath("//span[@id='headingSpan']")).getText();
			String expected= "Settings";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass - Setting page displayed");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed - Setting page not displayed");
		}

		driver.quit();
	 }
}
