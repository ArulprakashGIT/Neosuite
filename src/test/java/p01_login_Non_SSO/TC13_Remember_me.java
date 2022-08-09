package p01_login_Non_SSO;

import java.net.MalformedURLException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC13_Remember_me extends BaseClass{

	@Test
	public void remember_Me() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.username().sendKeys("ET1101");
		objlogin.password().sendKeys("Neeyamo$123");
		driver.findElement(By.xpath(" //input[@name='rememberMe']")).click();
		objlogin.signin().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='nav-mobile-right']")));
	    ((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.switchTo().window(tabs.get(0));
	    driver.close();
	    driver.switchTo().window(tabs.get(1));
	    driver.get("https://neosuiteuat.neeyamo.works/login");
	    try {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")));
			boolean loginValidate = driver.findElement(By.xpath("//div[contains(text(),'Welcome To NeeyamoWorks')]")).isDisplayed();
			Assert.assertEquals(loginValidate, true, "Assert failed-Remember me functionality fail");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed-Remember me functionality fail");
		}
		driver.quit();
	}
}
