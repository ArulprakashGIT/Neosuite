package p04_delegate;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC04_PastDateCreateDelegation extends BaseClass{

	@Test
	public void pastDateCreateDelegation() throws InterruptedException, MalformedURLException
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Start Date - End Date']")));
		driver.findElement(By.xpath("//input[@placeholder='Start Date - End Date']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //button[@aria-label='Previous month']")));
		
		
		//select previoud date by using current date
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMMM d, YYYY");
	    Calendar c = Calendar.getInstance();
	    c.setTime(new Date()); // Using today's date
	    c.add(Calendar.DATE, -1); // decreasing 1 day
	    String yesterday = sdf.format(c.getTime());
	    
	    String previousdatestring = "//td[@aria-label='"+yesterday+"']";
		WebElement previousdate = driver.findElement(By.xpath(previousdatestring));
		previousdate.click();
	    boolean previousvalidate = previousdate.isSelected();
		
	    try {
	        Assert.assertEquals(previousvalidate, false, "Assert fail - past date create delegation");
	    }
		catch(Exception e) {
			Assert.fail("Test case fail - past date create delegation");
		}
		driver.close();
	}
	
}
