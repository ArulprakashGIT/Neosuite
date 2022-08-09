package submit_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TAttachFile extends Base{

	@Test
	public void attchFile() throws IOException {
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objsubmitclaims.submitClaimsPageButton();
		objsubmitclaims.selectClaimsType();
		objsubmitclaims.attachFileValidation();
		driver.close();
	}
}
