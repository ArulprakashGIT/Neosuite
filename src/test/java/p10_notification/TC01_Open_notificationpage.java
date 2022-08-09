package p10_notification;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC01_Open_notificationpage extends BaseClass{

	@Test
	public void openNotificationPage() throws InterruptedException, MalformedURLException
	{   
		driver=setupApplication();
		objlogin.neosuiteLogin();
		//wait.until(ExpectedConditions.visibilityOf(objlogin.notification()));
		objlogin.notification();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See All')]")));
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-notifications")));
			boolean Notificationpage = driver.findElement(By.xpath("//app-notifications")).isDisplayed();
			objsoftassert.assertEquals(Notificationpage, true, "Notification page container Assert fail");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-notifications//label[text()='Notifications']")));
			boolean Notification = driver.findElement(By.xpath("//app-notifications//label[text()='Notifications']")).isDisplayed();
			objsoftassert.assertEquals(Notification, true, "Notification page name Assert fail");
		}
		catch(Exception e) {
			objsoftassert.fail("Notification page open fail");
		}
		objsoftassert.assertAll();
		driver.quit();
	}
}
