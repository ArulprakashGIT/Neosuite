package submit_claims;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_claims.Base;


public class T01_ViewClaimsTab extends Base{
	@Test
	public void viewClaimsTab() throws IOException {
		//driver initialization function call
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		
		//Login and open claims widget function call
		objlogin.claimsWidgetLogin();
		
		//View claims Button validation
		driver.findElement(By.xpath("//li[@id='view_claims']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='claimsUserViewListscrollId']")).isDisplayed());
		driver.close();
	}
}
