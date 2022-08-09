package p04_delegate;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC10_DelegationOnme extends BaseClass{

	@Test
	public void delegationOnme() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'On Me')]")));
		driver.findElement(By.xpath("//span[contains(text(),'On Me')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Delegated By')]")));
			boolean validate = driver.findElement(By.xpath("//b[contains(text(),'Delegated By')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Dlegate Onme data not displayed");
		}
		catch(Exception e){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert fail - Oops no delegation not displayed");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		/*List<WebElement> onme= driver.findElements(By.xpath("//div[@id='historygrid']//child::div[@class='col s12 m12 l12 alignlist delegateSideSpace']//div"));
		int size =onme.size();
		System.out.println(size);
		if(size>0)
		{
			String actual1= driver.findElement(By.xpath("//b[contains(text(),'Delegated By')]")).getText();
			String expected1= "Delegated By";
			if(actual1.equals(expected1))
			{
				Assert.assertTrue(true,"Test case passed Delegated On me data visible");
			}
		    else {
					Assert.fail("Test case fail -delegation on me data not visible");
				 }
		}	
		else {
			String actual= driver.findElement(By.xpath("//div[contains(text(),'Oops!! No Delegations')]")).getText();
			String expected= "Oops!! No Delegations";
			Assert.assertEquals(actual, expected);
		}*/
		driver.quit();
		
	}
}
