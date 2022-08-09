package p06_Profile_Tab;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC05_Profile_tab_close extends BaseClass
{

	@Test
	public void Profile_tab_close() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='collapsible-header']")));
		driver.findElement(By.xpath("//div[@class='sidenav-overlay']")).click();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='collapsible-header']")));
			boolean element = driver.findElement(By.xpath("//a[@class='collapsible-header']")).isDisplayed();
			Assert.assertEquals(element, false, "profile Tab close Assert fail");
		}
		catch(Exception e) {
			Assert.fail("profile Tab close fail");
		}
		driver.quit();
		
	}
}
