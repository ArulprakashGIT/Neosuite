package p07_widgetview;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC2_SwitchAllApplicationRecent extends BaseClass{

	@Test
	public void switchAllApplicationRecent() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")).click();
		String actual= driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")).getText();
		String expected= "Recent Applications";
		System.out.println(actual);
		objsoftassert.assertEquals(actual, expected,"Recent Applications tab switch fail");
		
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label[text()='Recent Applications']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")));
		driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")));
		String actual2= driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[4]//div[1]//label")).getText();
		String expected2= "All Applications";
		objsoftassert.assertEquals(actual2, expected2,"All Application tab switch fail");
		objsoftassert.assertAll();
		driver.quit();
		
	}
}
