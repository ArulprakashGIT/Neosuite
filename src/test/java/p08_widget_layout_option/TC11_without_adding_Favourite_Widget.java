package p08_widget_layout_option;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;
import ObjectRepositoryNeosuite.ExtentReport;

public class TC11_without_adding_Favourite_Widget extends ExtentReport
{

	@Test
	public void noFavourite() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("without_adding_Favourite_Widget");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//li[@title='Favourites']")).click();
		try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'No favourite widget found')]")).getText();
			String expected= "No favourite widget found";
			Assert.assertEquals(actual, expected, "Test case fail -Assert fails expected key not matching");
			System.out.println("Test case pass- Widget removed from favourite sucessfully");
		}
		catch (Exception e) {
			driver.findElement(By.xpath("//span[@title='Remove Favourites']")).click();
		}
	    driver.close();
		
	}
}
