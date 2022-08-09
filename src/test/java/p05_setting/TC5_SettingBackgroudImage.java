package p05_setting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;
import ObjectRepositoryNeosuite.ExtentReport;
import ObjectRepositoryNeosuite.NeosuiteLoginPage;

public class TC5_SettingBackgroudImage  extends ExtentReport{

	@Test
	public void settingBackgroundImage() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("SettingBackgroudImage");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		NeosuiteLoginPage login =new NeosuiteLoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		login.menu().click();
		Thread.sleep(4000);
		login.settings().click();
		WebElement element1 = driver.findElement(By.id("headingSpan"));
		wait.until(ExpectedConditions.visibilityOf((element1)));
		Thread.sleep(3000);
		WebElement upload =driver.findElement(By.xpath("//input[@id='userBgImg']"));
		upload.sendKeys(System.getProperty("user.dir")+"\\Downloads\\Neeyamo.jpg");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@class='btn neosuiteBtn advActionBtn']")).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[contains(@style,'Neeyamo.jpg')]")).isDisplayed()) {
			Assert.assertEquals(true, true);
			System.out.println("Background image is Uploaded");
			}
		else {
				Assert.assertEquals(true, false, "Test case failed-Background image not Uploaded");
			}
		driver.close();
		
	}
}
