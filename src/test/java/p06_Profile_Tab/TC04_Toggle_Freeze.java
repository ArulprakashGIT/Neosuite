package p06_Profile_Tab;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC04_Toggle_Freeze extends BaseClass{

	@Test
	public void Toggle_Freeze() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='collapsible-header']")));
	    driver.findElement(By.xpath("//a[@class='collapsible-header']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Absence']")));
        driver.findElement(By.xpath("//span[contains(text(),'Knowledge Base')]")).click();
        driver.findElement(By.xpath("//span[@title='Knowledge Base']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//child::span[@title='User']//parent::div//parent::div//child::div[2]//span")).click();      
        WebElement Toggle = driver.findElement(By.xpath("//span[@title='Knowledge Base']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//child::span[@title='User']//parent::div//parent::div//child::div[2]//span"));
        Toggle.click();
        Boolean a= Toggle.isEnabled();
        Toggle.click();
        Boolean b= Toggle.isEnabled();
        if(a==b) {
        	Assert.assertEquals(true, true, "Test case fail toggle button not frozen");
        }
        else {
        	Assert.fail("Test case fail toggle button not frozen");
        }
        driver.quit();
		
	}
}
