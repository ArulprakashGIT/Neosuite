package submit_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class ClaimDateSubmitClaims extends Base{
	@Test
	public void claimsDateSubitClaims() throws IOException{
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objsubmitclaims.submitClaimsPageButton();
		objsubmitclaims.selectClaimsType();
		objsubmitclaims.claimsDateValidate();
		driver.close();
	}
}
