package p06_Profile_Tab;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC03_Switch_Role extends BaseClass {

	@Test
	public void Switch_Role() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='collapsible-header']")));
	    driver.findElement(By.xpath("//a[@class='collapsible-header']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Absence']")));
        driver.findElement(By.xpath("//span[text()='Absence']")).click();
        driver.findElement(By.xpath("//span[text()='Absence']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//span[@title='Admin']//parent::div//parent::div//div[2]//span")).click();
        driver.findElement(By.xpath("//span[text()='Absence']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//span[@title='Manager']//parent::div//parent::div//div[2]//span")).click();
        driver.findElement(By.xpath("//span[text()='Absence']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//span[@title='Employee']//parent::div//parent::div//div[2]//span")).click();
        boolean tabswitch = driver.findElement(By.xpath("//span[text()='Absence']//parent::div//parent::div//parent::li//child::div[@class='collapsible-body']//span[@title='Employee']//parent::div//parent::div//div[2]//span")).isEnabled();
        objsoftassert.assertEquals(tabswitch, true, "Approle swait fail");
        
        WebElement element = driver.findElement(By.xpath("//a[@title='SAVE APP ROLE']//parent::div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        
        long start = System.currentTimeMillis();
		long end = start + 10 * 1000;
	    while(start<end) {
        	try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@title='Absence']//parent::div[@class='advancedUI_recentWidget_container']")));
            driver.findElement(By.xpath("//div[@title='Absence']//parent::div[@class='advancedUI_recentWidget_container']")).click();
            break;
        	}
        	catch(Exception e) {}
        }
        try {
        	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-panel advanceAppBottomTray hide-on-small-only']//div[@title='Home Page']")));
			boolean widget =driver.findElement(By.xpath("//div[@class='card-panel advanceAppBottomTray hide-on-small-only']//div[@title='Home Page']")).isDisplayed();
			objsoftassert.assertEquals(widget, true, "App role switch Assert fail");
		}
		catch(Exception e) {
			objsoftassert.fail("App role fail");
		}
        objsoftassert.assertAll();
        driver.quit();

	}
}
