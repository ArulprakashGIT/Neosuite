package p06_Profile_Tab;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC01_Profile_tab_open extends BaseClass
{

	@Test
	public void Profile_tab_open() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='name myFont truncate']")));
			boolean name  = driver.findElement(By.xpath("//span[@class='name myFont truncate']//span")).isDisplayed();
			Assert.assertEquals(name, true, "profile tab open Assert fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "profile tab not displayed");
		}
		driver.quit();
		
	}
}
