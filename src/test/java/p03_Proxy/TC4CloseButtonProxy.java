package p03_Proxy;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC4CloseButtonProxy extends BaseClass{

	
	@Test
	public void closeButtonProxy() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proxy Now ')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Proxy Now ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='right proxy_closeBtn']")));
		driver.findElement(By.xpath("//a[@class='right proxy_closeBtn']")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert failed - Proxy close fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Proxy Tab not closed");
		}
		driver.quit();
	    
	}
	
}
