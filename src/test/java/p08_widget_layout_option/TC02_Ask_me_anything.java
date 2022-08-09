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

public class TC02_Ask_me_anything extends ExtentReport{

	@Test
	public void askMeAnything() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Ask_me_anything");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='HELP']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='knowledgeBaseDisplayDiv disable-scrollbars']")));
        driver.findElement(By.xpath("//input[@placeholder='Ask me Anything']")).sendKeys("Which client neeyamo have");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),' Which client neeyamo have')]")));
        driver.findElement(By.xpath("//span[contains(text(),' Which client neeyamo have')]")).click();  
        try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Which client neeyamo have')]")).getText();
			String expected= "Which client neeyamo have";
			Assert.assertEquals(actual, expected, "Test case fail -Assert fails expected key not matching");
			System.out.println("Test case pass-questions displayed");
			}
		catch (Exception e)
            {
				Assert.assertEquals(true, false, "Test case failed-Help Ask me anything not displayed ");
			}
		Thread.sleep(5000);
		driver.close();
		
	}
}
