package p10_notification;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC02_Switch_Application_notification extends BaseClass{

	@Test
	public void switchApplicationNotification() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See All')]")));
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-notifications//li[1]//span")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-notifications//li[1]//span")));
			int notificationapp = driver.findElements(By.xpath("//span[contains(@class,'notification__text')]")).size();
			System.out.println(notificationapp);
			for(int i=1;i<=notificationapp;i++) 
			{
				String Notify = "//app-notifications//li["+i+"]//span";
				System.out.println(Notify);
				try {
				driver.findElement(By.xpath(Notify)).click();	
				boolean Switch = driver.findElement(By.xpath(Notify)).isDisplayed();
				objsoftassert.assertEquals(Switch, true, "Application Notification Switch Assert fail");
				}
				catch(Exception e) {
					objsoftassert.fail("Application Notification Switch fail");
				}
			}
		}
		catch (Exception e)
		{
			objsoftassert.fail("Application Notification Switch fail");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		objsoftassert.assertAll();
		driver.quit();
	}
}
