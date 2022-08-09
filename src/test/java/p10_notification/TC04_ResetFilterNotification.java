package p10_notification;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC04_ResetFilterNotification extends BaseClass{

	@Test
	public void filterNotification() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='filterDateDropdown']")));
		long start = System.currentTimeMillis();
		long end = start + 10 * 1000;
		while (start < end)
		{
			try {
		        driver.findElement(By.xpath("//a[@id='filterDateDropdown']")).click();
		        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@title='Today']")));
		        break;
			}
			catch(Exception e)
			{}
		}
		
		driver.findElement(By.xpath("//a[@title='Today']")).click();
		driver.findElement(By.xpath("//ul[@id='filterDropDown']//button[contains(text(),'Reset')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		int ResetFilter = driver.findElements(By.xpath("//a[contains(@class,'secondary-border secondary-class white-text')]")).size();
		if(ResetFilter==0)
		{
        Assert.assertTrue(true, "Test case failed-Filter reset not done");
		}
		else
		{
			Assert.fail("Test case failed-Filter reset not done");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.quit();
	}
}
