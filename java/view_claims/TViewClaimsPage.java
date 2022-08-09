package view_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TViewClaimsPage extends Base{
@Test
	public void viewClaimsPage() throws IOException {
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objviewclaims.validateviewclaims();
		
		driver.close();
	}
}
