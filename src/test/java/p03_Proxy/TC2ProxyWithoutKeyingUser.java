package p03_Proxy;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC2ProxyWithoutKeyingUser extends BaseClass{

	
	@Test
	public void proxyWithoutkeyinguser() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Proxy Now ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-autocomplete='list']")));
		driver.findElement(By.xpath("//button[contains(text(),'Proxy')]")).click();
		try {
	    	String actual= driver.findElement(By.xpath("//div[contains(text(),'Please select User')]")).getText();
			String expected= "Please select User";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass - Does not allow without keyingin user");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed- proxy without keying mandatory ");
		}
		driver.quit();
	    
	    
	}
	
}
