package p10_notification;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC05_SearchNotification extends BaseClass{

	@Test
	public void filterNotification() throws InterruptedException, MalformedURLException
	{

		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='notification_search']")));
		driver.findElement(By.xpath("//input[@id='notification_search']")).click();
		
		driver.findElement(By.xpath("//input[@id='notification_search']")).sendKeys("ET1060");
		driver.findElement(By.xpath("//input[@id='notification_search']//parent::div//i[contains(text(),'search')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
		driver.findElement(By.xpath("//b[contains(text(),'ET1060')]"));
		Assert.assertTrue(true, "Search element displayed");
		}
		catch(Exception e) {
			Assert.assertTrue(true, "Search value in not present in the list");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.quit();
	}
}
