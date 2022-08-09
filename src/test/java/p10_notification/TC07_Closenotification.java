package p10_notification;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC07_Closenotification  extends BaseClass{

	@Test
	public void closeNotification() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.notification();
		driver.findElement(By.xpath("//a[contains(text(),'See All')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-advanced-header/div[@id='settingsModal']/a[1]/img[1]")));
		driver.findElement(By.xpath("//app-advanced-header/div[@id='settingsModal']/a[1]/img[1]")).click();
		 try{
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//app-advanced-header/div[@id='settingsModal']/a[1]/img[1]")));
			    boolean close = driver.findElement(By.xpath("//app-advanced-header/div[@id='settingsModal']/a[1]/img[1]")).isDisplayed();
	    		Assert.assertEquals(close, false, "Assert fail  -Notification window not closed");
	        }
	     catch(Exception e){
	        	Assert.assertEquals(true, false, "Test case Failed -Notification window not closed");
	        }
		 driver.quit();
		
		

       
	}
}
