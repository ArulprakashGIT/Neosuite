package p04_delegate;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC11_DelegationByme extends BaseClass{

	@Test
	public void delegationByme() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'By Me')]")));
		driver.findElement(By.xpath("//span[contains(text(),'By Me')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Delegated To')]")));
			boolean validate = driver.findElement(By.xpath("//b[contains(text(),'Delegated To')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Dlegate Byme data not displayed");
		}
		catch(Exception e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Oops no delegation not displayed");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.quit();
	}
}
