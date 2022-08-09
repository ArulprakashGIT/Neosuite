package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC02_CreateDelegation extends BaseClass{

	@Test
	public void createDelegation() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		objfunction.createdelegate("KB Home");
		objfunction.validateDelegate();
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
