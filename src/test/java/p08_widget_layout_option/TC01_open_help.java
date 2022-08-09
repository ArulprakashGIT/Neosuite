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

public class TC01_open_help extends ExtentReport{

	@Test
	public void openHelp() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("open_help");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title='Delete']")));
        driver.findElement(By.xpath("//span[@title='HELP']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='knowledgeBaseDisplayDiv disable-scrollbars']")));
        try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),' Additional Support-')]")).getText();
			String expected= "Additional Support-";
			Assert.assertEquals(actual, expected, "Test case fail -Assert fails expected key not matching");
			System.out.println("Test case pass- Additional support displayed");
			}
		catch (Exception e)
            {
				Assert.assertEquals(true, false, "Test case failed-Help Ask me anything not displayed ");
			}
		
		driver.close();
		
	}
}
