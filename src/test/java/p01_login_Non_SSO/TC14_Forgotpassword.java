
package p01_login_Non_SSO;

import java.net.MalformedURLException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC14_Forgotpassword extends BaseClass{

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Test
	public void forgotPassword() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]")).click();
		driver.findElement(By.id("username")).sendKeys("600001");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.get("https://outlook.office.com/mail/inbox");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0116']")));
	    driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("sdtest.manager@neeyamo.com");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Next']")));
	    driver.findElement(By.xpath("//input[@value='Next']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='i0118']")));
	    driver.findElement(By.xpath("//input[@id='i0118']")).sendKeys("Neeyamo@123");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Sign in']")));
	    driver.findElement(By.xpath("//input[@value='Sign in']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idBtn_Back']")));
	    driver.findElement(By.xpath("//input[@id='idBtn_Back']")).click();
	    
	    long start = System.currentTimeMillis();
		long end = start + 10 * 1000;
	    while(start<end) {
	    	try {
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
	    	    objactions.moveToElement(driver.findElement(By.xpath("//input[@placeholder='Search']"))).click().build().perform();
	    	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='filtersButtonId']")));
	    	    break;
	    	}
	    	catch(Exception e) {}
	    }
	    
	    driver.findElement(By.xpath("//button[@id='filtersButtonId']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Start date of search']")));
	    driver.findElement(By.xpath("//div[@aria-label='Start date of search']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@aria-current='date']")));
	    WebElement date = driver.findElement(By.xpath("//td[@aria-current='date']"));
	    date.click();    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='End date of search']")));
	    driver.findElement(By.xpath("//div[@aria-label='End date of search']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@aria-current='date']")));
	    driver.findElement(By.xpath("//td[@aria-current='date']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Search')]")));
	    driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Reset password')][1]")));
	    /*driver.findElement(By.xpath("//input[@placeholder='Search']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Link to reset credentials"+"\n");
	    driver.findElement(By.xpath("//div[contains(text(),'Filter')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Unread')]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Reset password')][1]")).click();
	    driver.findElement(By.xpath("//a[contains(@href,'https://onelogin')]")).click();
	    Thread.sleep(4000);
	    //driver.findElement(By.xpath("//*[@id=\"Pivot25-Tab1\"]/span/div/div/span/span")).click();*/
	    driver.findElement(By.xpath("//span[contains(text(),'Reset password')][1]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Link to reset credentials')]")));
	    long start1 = System.currentTimeMillis();
		long end1 = start1 + 10 * 1000;
	    while(start1<end1) {
	    driver.findElement(By.xpath("//a[contains(text(),'Link to reset credentials')]")).click();
	    String windowHandle = driver.getWindowHandle();
	    ArrayList tabs = new ArrayList (driver.getWindowHandles());
	    int TabSize = tabs.size();
	    System.out.println("size" +TabSize);
	    if(TabSize==2)
	    {
	    	
	    	driver.switchTo().window((String) tabs.get(1));
	    	break; 
	    }
	    }
	    String Newpassword = objfunction.resetpassword();
	    System.out.println(Newpassword);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='password-new']")));
	    driver.findElement(By.xpath("//input[@id='password-new']")).sendKeys(Newpassword);
	    driver.findElement(By.xpath("//input[@id='password-confirm']")).sendKeys(Newpassword);
	    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	    try {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean loginValidate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(loginValidate, true, "Assert fail-Password Reset failed");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Password Reset failed");
		}
		driver.quit();
	}
}
