package p04_delegate;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC12_EndDelegation extends BaseClass{

	@BeforeMethod
	public void createDelegation() throws MalformedURLException, InterruptedException {
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		objfunction.createdelegate("KB Home");
		objfunction.validateDelegate();
		driver.quit();
	}

	@Test
	public void EndDelegation() throws InterruptedException, MalformedURLException {
		
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Delegate']")));
		objlogin.delegate().click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'By Me')]")));
		driver.findElement(By.xpath("//span[contains(text(),'By Me')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//i[@title='Remove Delegation']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i")));
		List<WebElement> initialList = driver.findElements(By.xpath("//i[@title='Remove Delegation']"));
		int initialcount = initialList.size();//list to check count before and after cancel delegation
		System.out.println("before cancel "+initialcount);
		if (initialcount == 0)
			objsoftassert.fail("Widget not delegated");
		else {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i")));
			WebElement element = driver.findElement(By.xpath(
					"//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'End Delegation')]")));
			WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'End Delegation')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@title='Remove Delegation']")));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOf(element));
			List<WebElement> currentList = driver.findElements(By.xpath("//i[@title='Remove Delegation']"));
			int currentcount = currentList.size();//list to check count before and after cancel delegation	
			System.out.println("After cancel "+currentcount);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'historygrid')]//div[@title='Knowledge Base']//parent::div//parent::div//div[6]//i")));
			if (currentcount< initialcount)
			{
				objsoftassert.assertTrue(true, "delegation not cancelled ");
			}
			
			else {
				objsoftassert.fail("delegation not cancelled ");
			}
			
			/*if (currentcount.size() < initialcount)

				//Assert.assertTrue(true, "delegation cancelled successfully");
				Assert.assertEquals(true, true);
			else {
				Assert.assertEquals(true, false);
			}*/
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		objsoftassert.assertAll();
		driver.quit();
	}
}
