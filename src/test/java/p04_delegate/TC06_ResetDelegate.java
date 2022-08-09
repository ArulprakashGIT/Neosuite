package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC06_ResetDelegate extends BaseClass{

	@Test
	public void resetDelegate() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		objfunction.createdelegate("KB Home");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn secondary-class right delegate-btn']")));
	    driver.findElement(By.xpath("//button[@class='btn secondary-class right delegate-btn']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")));
	    String datereset = driver.findElement(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")).getAttribute("value");
	    boolean DateReset = datereset.isEmpty();
	    objsoftassert.assertEquals(DateReset, true);
	    String delegatename = driver.findElement(By.xpath("//input[@placeholder='Start Date - End Date']")).getAttribute("value");
	    boolean DelegateName = delegatename.isEmpty();
	    objsoftassert.assertEquals(DelegateName, true);
		driver.quit();
	}
	
}
