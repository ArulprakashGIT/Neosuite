package view_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TWithoutKeyinCommentActionColumn extends Base{

	@Test
	public void withoutCommentActionColumn() throws IOException {
		driver= DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objviewclaims.commentActionButton();
		objviewclaims.sendCommentsButton();
		objviewclaims.validateWithoutkeyinComment();
		driver.close();
		
	}
}
