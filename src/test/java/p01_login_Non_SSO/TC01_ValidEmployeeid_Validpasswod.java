package p01_login_Non_SSO;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC01_ValidEmployeeid_Validpasswod extends BaseClass
{

	@Test
	public void validEmployeeid_Validpasswod() throws InterruptedException, MalformedURLException 
	{	
		
		driver=setupApplication();
		objlogin.neosuiteLogin();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean validate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(validate, true, "Assert failed Employee ID-Login fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed Employee ID -Login fail");
		}
		driver.quit();
	}
}
