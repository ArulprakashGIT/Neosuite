package p10_notification;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC06_NoNotifications extends BaseClass{

	@Test
	public void noNotifications() throws InterruptedException, MalformedURLException
	{

		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='notification_search']")));
		driver.findElement(By.xpath("//span[contains(text(),'All Notifications')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Unread')]")).click();
		
        try{
        	boolean nonotification = driver.findElement(By.xpath("//div[contains(text(),'Hurray! No notifications to display')]")).isDisplayed();
			Assert.assertEquals(nonotification, true, "Assert failed - No notification to display");
        }
        catch(Exception e){
        	Assert.fail("Test case failed - No notification to display");
        }
        driver.quit();
		
	}
}
