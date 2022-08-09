package submit_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TResetSubmitClaims extends Base{
    @Test
	public void restSubmitClaims() throws IOException {
		driver = DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objsubmitclaims.submitClaimsPageButton();
		objsubmitclaims.selectClaimsType();
		//objsubmitclaims.claimsDateValidate();
		objsubmitclaims.validateClaimAmount();
		objsubmitclaims.billNumberValidate();
		objsubmitclaims.noOfBills();
		objsubmitclaims.attachFile();
		objsubmitclaims.descriptionValidation();
		objsubmitclaims.resetValidation();
		driver.close();
	}
}
