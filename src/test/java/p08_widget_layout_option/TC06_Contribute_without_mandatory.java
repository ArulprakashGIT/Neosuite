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

public class TC06_Contribute_without_mandatory extends ExtentReport{

	@Test
	public void contributeWithoutMandatory() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Contribute_without_mandatory");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
		
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='HELP']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(text(),'add')]")));
        driver.findElement(By.xpath("//i[contains(text(),'add')]")).click();
        driver.findElement(By.xpath("//textarea[@id='contributionInput']")).sendKeys("Neeyamo client"); 
        Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
		try {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Enter Contribution Description')]")).getText();
			String expected= "Enter Contribution Description";
			Assert.assertEquals(actual, expected, "Test case fail -Assert fails expected key not matching");
			System.out.println("Test case pass- system should not allow to contribute without keyingin mandatory fields");

		}
		catch (Exception e){
			Assert.assertEquals(true, false, "Test case failed -Contribution not added");
		}
        driver.close();
		
	}
}
