package p11_logout;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC01_Logout extends BaseClass
{

	@Test
	public void logout() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Logout']")));
		driver.findElement(By.xpath("//li[@title='Logout']")).click();
		try {
			String actual= driver.findElement(By.xpath("//h5[contains(text(),'You have been logged out..')]")).getText();
			String expected= "You have been logged out..";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass - Logout sucessfull");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(text(),'You have been logged out..')]")));
			boolean Notification = driver.findElement(By.xpath("//h5[contains(text(),'You have been logged out..')]")).isDisplayed();
			objsoftassert.assertEquals(Notification, true, "Assert fail - Logout fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed - Logout fail");
		}
		driver.quit();
		
		
		
	}
}
