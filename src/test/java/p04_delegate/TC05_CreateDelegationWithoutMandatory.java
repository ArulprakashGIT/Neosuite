package p04_delegate;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC05_CreateDelegationWithoutMandatory extends BaseClass{

	@Test
	public void createDelegationWithoutMandatory() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create Delegation')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create Delegation')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='delegateModal']//div[text()=' KB Home ']")));
		driver.findElement(By.xpath("//div[@id='delegateModal']//div[text()=' KB Home ']")).click();
		driver.findElement(By.xpath("//button[@class='btn delegate-btn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")));
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		long start = System.currentTimeMillis();
		long end = start + 30 * 1000;
	    while(start<end) {
		String val = "100005"; 
	    WebElement element = driver.findElement(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']"));
	    element.clear();
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        Thread.sleep(800);
	        element.sendKeys(s);
	    }
	    
	    try {
	    	WebElement click = driver.findElement(By.xpath("//span[contains(text(),'Samuel Isaac')]"));
		    wait.until(ExpectedConditions.visibilityOf(click));
	    	click.click();
	    	break;
	    }
	    catch(Exception e) {
	    	driver.findElement(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")).clear();
	    }
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	    
	    
	    try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Please select delegation duration')]")).getText();
			String expected= "Please select delegation duration";
			Assert.assertEquals(actual, expected, "Test case passed - cant able to create delegation without keying in mandatory");
			System.out.println("Test case pass- delegation not allowed without keying in mandatory");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false,"Test case failed-create delegation is done without keying in mandatory");
		}
		driver.quit();	
	}
}
