package submit_claims;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_claims.Base;


public class T02_SubmitClaimsButton extends Base{
    @Test
	public void submitClaimsButton() throws IOException {
		//driver initialization
		driver=DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		
		//Submit claims button
		objsubmitclaims.submitClaimsPageButton();
		
		//validation of submit claims
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='claims_save_btn']")).isDisplayed());
		driver.close();
	}
}
