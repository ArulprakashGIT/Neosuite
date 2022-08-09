package p04_delegate;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC15OopsNoDelegations extends BaseClass{

	
	@Test
	public void opsNoDelegations() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Delegated By')]")));
				boolean validate = driver.findElement(By.xpath("//b[contains(text(),'Delegated By')]")).isDisplayed();
				Assert.assertEquals(validate, true, "Assert fail - Dlegate Byme data not displayed");
			}
			catch(Exception e) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")));
				boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")).isDisplayed();
				Assert.assertEquals(validate, true, "Assert fail - Oops no delegation not displayed");
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.quit();   
	    
	   
	}
	
}
