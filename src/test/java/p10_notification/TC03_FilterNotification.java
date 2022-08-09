package p10_notification;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC03_FilterNotification extends BaseClass{

	@Test
	public void filterNotification() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See All')]")));
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='filterDateDropdown']")));
		driver.findElement(By.xpath("//a[@id='filterDateDropdown']")).click();
		
        try{
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Sort By ')]")));
          boolean Filterassert = driver.findElement(By.xpath("//a[contains(text(),'Sort By ')]")).isDisplayed();
		  Assert.assertEquals(Filterassert, true, "Assert fail - Notification Filter window not visible");
        }
        catch(Exception e){
        	Assert.fail("Test case failed-Notification Filter window not visible");
        }
		driver.quit();
		
	}
}
