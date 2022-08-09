package view_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TCancelComment extends Base{

	@Test
	public void cancelComment() throws IOException {
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objviewclaims.commentActionButton();
		objviewclaims.cancelClaimsValidate();
		driver.close();
	}
}
