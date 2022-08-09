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

public class TC10_Remove_Favourite extends ExtentReport
{

	@Test
	public void addWidgetFavourite() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Remove_Favourite");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='knowledgeBaseDisplayDiv disable-scrollbars']")));
		driver.findElement(By.xpath("//span[@title='Add to Favourites']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@title='Favourites']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@title='Remove Favourites']")).click();
		try {
			
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Removed from favourites')]")).getText();
			String expected= "Removed from favourites";
			Assert.assertEquals(actual, expected, "Test case fail -Assert fails expected key not matching");
			System.out.println("Test case pass- Widget removed from favourite sucessfully");
			
		}
		catch (Exception e) {
			Assert.assertEquals(true, false, "Test case failed -not removed from favourites");
		}
	    driver.close();
		
	}
}
