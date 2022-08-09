package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC03_MailTriggerDelegation extends BaseClass{

	@Test
	public void mailTriggerDelegation() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		objfunction.createdelegate("KB Home");
		objfunction.validateDelegate();
		
	  
		//Mail check
		driver.get("https://outlook.office.com/mail/inbox");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0116']")));
	    driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("sdtest.manager@neeyamo.com");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Next']")));
	    driver.findElement(By.xpath("//input[@value='Next']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0118']")));
	    driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Neeyamo@123");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Sign in']")));
	    WebElement we2 = driver.findElement(By.xpath("//input[@value='Sign in']"));
	    we2.click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idBtn_Back']")));
	    driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
	    driver.findElement(By.xpath("//button[@id='filtersButtonId']")).click();
	    driver.findElement(By.xpath("//div[@aria-label='Start date of search']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@aria-current='date']")));
	    WebElement currentdate = driver.findElement(By.xpath("//td[@aria-current='date']"));
	    currentdate.click();    
	    driver.findElement(By.xpath("//div[@aria-label='End date of search']")).click();
	    driver.findElement(By.xpath("//td[@aria-current='date']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
	    try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Widget Delegation')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(text(),'Widget Delegation')]")).isDisplayed();
			objsoftassert.assertEquals(validate, true, "Assert fail - Delegation mail not triggred");
			
		}
		catch(Exception e) {
			objsoftassert.fail("Test case failed-mail not triggred");
		}
	    
	    //Logout manager
	    try {
	     driver.findElement(By.xpath("//*[@id=\"fluent-default-layer-host\"]/div[2]/div/div/div[1]/button")).click();
	     driver.findElement(By.xpath("//div[@id='O365_HeaderRightRegion']")).click();
	     driver.findElement(By.xpath("//a[@id='mectrl_body_signOut']")).click();
	    }
	    catch(Exception e) {
	    	 driver.findElement(By.xpath("//div[@id='O365_HeaderRightRegion']")).click();
		     driver.findElement(By.xpath("//a[@id='mectrl_body_signOut']")).click();
	    }
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@id='mectrl_body_signOut']")));
	 
	    //Mail
	    driver.get("https://outlook.office.com/mail/inbox");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Use another account')]")));
	    driver.findElement(By.xpath("//div[contains(text(),'Use another account')]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0116']")));
	    driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("sdtest.user@neeyamo.com ");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Next']")));
	    driver.findElement(By.xpath("//input[@value='Next']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0118']")));
	    driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Testmail@123");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Sign in']")));
	    WebElement we = driver.findElement(By.xpath("//input[@value='Sign in']"));
	    we.click();
	    //driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
	    driver.findElement(By.xpath("//button[@id='filtersButtonId']")).click();
	    driver.findElement(By.xpath("//div[@aria-label='Start date of search']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@aria-current='date']")));
	    WebElement currentdate1 = driver.findElement(By.xpath("//td[@aria-current='date']"));
	    currentdate1.click();    
	    driver.findElement(By.xpath("//div[@aria-label='End date of search']")).click();
	    driver.findElement(By.xpath("//td[@aria-current='date']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
	    Thread.sleep(3000);
	    try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Widget Delegation Notifications')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(text(),'Widget Delegation Notifications')]")).isDisplayed();
			objsoftassert.assertEquals(validate, true, "Assert fail - Delegation mail not triggred");
		}
		catch(Exception e) {
			objsoftassert.fail("Test case failed-mail not triggred");
		}
	
	    objsoftassert.assertAll();
		driver.close();
	} 
	
	@AfterMethod
	public void cancel() throws InterruptedException, MalformedURLException {
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		driver.findElement(By.xpath("//span[contains(text(),'Delegations')]"));
		driver.findElement(By.xpath("//span[contains(text(),'By Me')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i[@title='Remove Delegation']")));
		WebElement element = driver.findElement(By.xpath(
				"//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i[@title='Remove Delegation']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		//xpath particularly cancel 28 december date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'End Delegation')]")));
		WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'End Delegation')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'End Delegation')]")));
		driver.quit();
	}
}
