package p04_delegate;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC16DelegatePageClose extends BaseClass{

	@Test
	public void delegatePageClose() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='right closeBtn']")));
        driver.findElement(By.xpath("//a[@class='right closeBtn']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class='right closeBtn']")));
        boolean close = driver.findElement(By.xpath("//a[@class='right closeBtn']")).isDisplayed();
        Assert.assertEquals(close, false, "delegate page not closed");
		driver.quit();
	}
}
