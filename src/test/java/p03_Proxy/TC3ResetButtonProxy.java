package p03_Proxy;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC3ResetButtonProxy extends BaseClass{

	
	@Test
	public void resetButtonProxy() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proxy Now ')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Proxy Now ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-autocomplete='list']")));
		 String val = "600001"; 
		    WebElement element = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		    element.clear();
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        Thread.sleep(500);
		        element.sendKeys(s);
		    }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")));
		driver.findElement(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Reset')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();	
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert failed-Proxy reset fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Proxy reset fail");
		}
		driver.quit();
	}
	
}
