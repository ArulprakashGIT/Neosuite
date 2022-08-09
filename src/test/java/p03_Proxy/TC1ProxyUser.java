package p03_Proxy;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC1ProxyUser extends BaseClass{

	
	@Test
	public void proxyUser() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Proxy Now ')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Proxy Now ')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-autocomplete='list']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		long start = System.currentTimeMillis();
		long end = start + 30 * 1000;
		while (System.currentTimeMillis() < end)
		{
		try {
			for(;;){
		    String val = "600001"; 
		    WebElement element = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		    element.clear();
		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        Thread.sleep(800);
		        element.sendKeys(s); 
		    }
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")));
		    System.out.println("pass");
		    break;
		    }
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).clear();
		}
		break;
		}
		driver.findElement(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Proxy')]")));
			driver.findElement(By.xpath("//button[contains(text(),'Proxy')]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Samuel Isaac']/parent::span[@class='hide-on-med-and-down']")));
			objactions.moveToElement(objlogin.menu()).click().build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(text(),' 600001 Rohini Goyal K ')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail -Proxy widget failed");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Proxy widget failed");
		}
	    driver.quit(); 
	}
	
}
