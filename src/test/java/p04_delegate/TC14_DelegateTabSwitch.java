package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC14_DelegateTabSwitch extends BaseClass{

	@Test
	public void delegateHistoryTabSwitch() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delegations')]")));
		
		driver.findElement(By.xpath("//span[contains(text(),'History')]")).click();
		boolean History = driver.findElement(By.xpath("//div[text()='Delegation History']")).isDisplayed();
		objsoftassert.assertEquals(History, true, "History Tab switching Failed");
		
		driver.findElement(By.xpath("//span[contains(text(),'Delegations')]")).click();
		boolean Deligations = driver.findElement(By.xpath("//div[text()='Delegations']")).isDisplayed();
		objsoftassert.assertEquals(Deligations, true, "Deligations Tab switching Failed");
		
		driver.findElement(By.xpath("//span[contains(text(),' Create Delegation')]")).click();
		boolean CreateDelegation = driver.findElement(By.xpath("//div[text()='Select Widgets you want to Delegate']")).isDisplayed();
		objsoftassert.assertEquals(CreateDelegation, true, "CreateDelegation Tab switching Failed");
		
		objsoftassert.assertAll();
		driver.quit();
	}
}
