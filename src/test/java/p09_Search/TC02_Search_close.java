package p09_Search;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC02_Search_close extends BaseClass 
{

	@Test
	public void searchClose() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adv_homeParentContainer']//div[3]//input")));
		long start = System.currentTimeMillis();
		long end = start + 10 * 1000;
	    while(start<end) {
			try {
				driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//div[3]//input")).click();
				driver.findElement(By.xpath("//input[@id='adv_bottomLine']")).click();
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adv_homeParentContainer']//div[@class='row adv_searchContent zeroMargin scrollOnHover']")));
		        break;
			}
			catch(Exception e) {
				WebElement close = driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//a[@title='Close']"));
				wait.until(ExpectedConditions.visibilityOf(close));
				objactions.moveToElement(close).click().build().perform();
			}		        
		}
	    long start1 = System.currentTimeMillis();
		long end1 = start1 + 20 * 1000;
	    while(start1<end1) {
		String val = "Home Page";
		WebElement element = driver.findElement(By.xpath("//input[@id='adv_bottomLine']"));
		element.clear();
		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			Thread.sleep(500);
			element.sendKeys(s);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Home Page')]")));
		WebElement close = driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//a[@title='Close']"));
		wait.until(ExpectedConditions.visibilityOf(close));
		objactions.moveToElement(close).click().build().perform();
		break;
	    }
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='adv_homeParentContainer']//a[@title='Close']")));
			boolean close = driver.findElement(By.xpath("//div[@class='adv_homeParentContainer']//a[@title='Close']")).isDisplayed();
			Assert.assertEquals(close, false, "Search close Assert fail");
		}
		catch (Exception e) {
			Assert.fail("Search close fail");
		}
		driver.quit();
		
	}
}
