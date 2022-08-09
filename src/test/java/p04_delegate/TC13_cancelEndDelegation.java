package p04_delegate;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC13_cancelEndDelegation extends BaseClass{
	
	@BeforeMethod
	public void createDelegation() throws MalformedURLException, InterruptedException {
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		objfunction.createdelegate("KB Home");
		objfunction.validateDelegate();
		driver.quit();
	}

	@Test
	public void cancelEndDelegation() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'By Me')]")));
		driver.findElement(By.xpath("//span[contains(text(),'By Me')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'listpanel')]")));
		List<WebElement> initialList = driver.findElements(By.xpath("//div[contains(@class,'listpanel')]"));
		int initialcount = initialList.size();//list to check count before and after cancel delegation
		System.out.println(initialcount);
		if (initialcount == 0)
			objsoftassert.fail("Widget not delegated");
		else {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i")));
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cancel')]")));
		    driver.findElement(By.xpath("//div[contains(text(),'Cancel')]")).click();
		}
		boolean cancel = driver.findElement(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i")).isDisplayed();
	    objsoftassert.assertEquals(cancel, true, "Cancel button not working");
	    driver.quit();
	}
	
	@AfterMethod
	public void cancel() throws InterruptedException, MalformedURLException {
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Delegations')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Delegations')]"));
		driver.findElement(By.xpath("//span[contains(text(),'By Me')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i[@title='Remove Delegation']")));
		WebElement element = driver.findElement(By.xpath(
				"//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i[@title='Remove Delegation']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		//xpath particularly cancel 27 december date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'End Delegation')]")));
		WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'End Delegation')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
        wait.until(ExpectedConditions.invisibilityOf(element1));
		driver.quit();
	}
}
