package submit_claims;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_claims.Base;


public class T03_ClaimsType extends Base{
	@Test
	public void claimsType() throws IOException{
		
	driver=DriverInitialization();	
	driver.get(prop.getProperty("url"));
	objlogin.claimsWidgetLogin();
	
	//Submit claims button
	objsubmitclaims.submitClaimsPageButton();

	//Claims type select
	objsubmitclaims.selectClaimsType();
	
	//Claims type select validation
	Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ng-value']//span[2]")).isDisplayed());
	
	driver.close();
	}
}
