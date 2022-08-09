package p08_widget_layout_option;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;
import ObjectRepositoryNeosuite.ExtentReport;

public class TC12_widget_window_close extends ExtentReport{

	@Test
	public void widgetWindowClose() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("widget_window_close");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
        driver.findElement(By.xpath("//span[@title='HELP']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='knowledgeBaseDisplayDiv disable-scrollbars']")));
        driver.findElement(By.xpath("//span[@title='Close Widget']")).click();
        try {
        String actual= driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).getText();
		String expected= "Welcome To NeeyamoWorks";
		Assert.assertEquals(actual, expected);
		System.out.println("Widget closed");
        }
        catch(Exception E) {
        	Assert.assertEquals(true, false, "Test case failed - Widget not closed");
        }
		driver.close();
		
	}
}
