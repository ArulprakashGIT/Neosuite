package p05_setting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC6_SettingPageClose extends BaseClass{

	@Test
	public void settingPageClose() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Settings']")));
		objlogin.settings().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='right closeBtn']")));
		driver.findElement(By.xpath("//a[@class='right closeBtn']")).click();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='right closeBtn']")));
			boolean close = driver.findElement(By.xpath("//a[@class='right closeBtn']")).isDisplayed();
			Assert.assertEquals(close, false, "Setting page close  assert fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Setting page close fail");
		}
		driver.quit();
		
	}
}
