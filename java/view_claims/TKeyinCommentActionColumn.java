package view_claims;

import java.io.IOException;

import org.testng.annotations.Test;

import base_claims.Base;

public class TKeyinCommentActionColumn extends Base{
	
	@Test
	public void commentActionColumn() throws IOException {
		driver=DriverInitialization();
		driver.get(prop.getProperty("url"));
		objlogin.claimsWidgetLogin();
		objviewclaims.commentActionButton();
		objviewclaims.commentInputBox();
		objviewclaims.sendCommentsButton();
		objviewclaims.validateKeyinComment();
		driver.close();
	}

}
