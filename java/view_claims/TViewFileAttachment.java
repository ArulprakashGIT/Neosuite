package view_claims;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base_claims.Base;

public class TViewFileAttachment extends Base {
	
	@Test
	public void viewFileAttachment() throws IOException {
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objviewclaims.openViewClaims();
		objviewclaims.validateViewAttachment();
	}
}
