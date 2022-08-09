package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC07_ClosebuttonDelegateTo extends BaseClass{

	@Test
	public void closeButtonDelegateTo() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create Delegation')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create Delegation')]")).click();
		String Widgetnamestring = "//div[@id='delegateModal']//div[text()=' KB Home ']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Widgetnamestring)));
		driver.findElement(By.xpath(Widgetnamestring)).click();
		driver.findElement(By.xpath("//button[@class='btn delegate-btn']")).click();
		String close = "//a[@class='right closeBtn']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(close)));
	    driver.findElement(By.xpath(close)).click();
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(close)));
	    boolean Test = driver.findElement(By.xpath(close)).isDisplayed();
	    objsoftassert.assertEquals(Test, false);
	    driver.quit();
	}
}
