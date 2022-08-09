package p08_widget_layout_option;

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

public class TC07_Reset_Contribute extends ExtentReport{

	@Test
	public void resetContribute() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Reset_Contribute");
		
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
        driver.findElement(By.xpath(" //textarea[@id='contributionDescriptionTextArea']")).sendKeys("siemens");
        driver.findElement(By.xpath("//a[contains(text(),'Reset')]")).click();
        WebElement inputBox = driver.findElement(By.xpath("//textarea[@id='contributionInput']"));
	    String textInsideInputBox = inputBox.getAttribute("value");
	    if(textInsideInputBox.isEmpty())
	    {
	       System.out.println("Contribution field reset");
	    }
	    else {
	    	Assert.assertEquals(true, false, "Test case failed -Contribution field not RESET");
	    }
		driver.close();
		
	}
}
