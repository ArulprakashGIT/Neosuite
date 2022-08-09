package p05_setting;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;
import ObjectRepositoryNeosuite.ExtentReport;
import ObjectRepositoryNeosuite.NeosuiteLoginPage;

public class TC4_SettingSecurityQuestion extends ExtentReport{

	@Test
	public void settingSecurityQuestion() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("SettingSecurityQuestion");
		
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		NeosuiteLoginPage login =new NeosuiteLoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		login.menu().click();
		Thread.sleep(4000);
		login.settings().click();
		WebElement element1 = driver.findElement(By.id("headingSpan"));
		wait.until(ExpectedConditions.visibilityOf((element1)));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='input-field securityQuestion col s11 m5 l5 selectAndInputbox settings_select']//input[@class='select-dropdown dropdown-trigger']")).click();
		List<WebElement> allDropDownValues=driver.findElements(By.xpath("//div[@class='input-field securityQuestion col s11 m5 l5 selectAndInputbox settings_select']//div//ul//li//span"));
		int dropDownCount= allDropDownValues.size();
		System.out.println("Total items present in the dropdown : "+dropDownCount);
		for(int i=0;i<dropDownCount;i++)
		{
		System.out.println(allDropDownValues.get(i).getText());
		if(allDropDownValues.get(i).getText().contains("Which phone number do you remember most from your childhood?"))
		{
		allDropDownValues.get(i).click();
		break;
		}
		}
		
		/*try {
			String actual= driver.findElement(By.xpath("//div[@class='input-field securityQuestion col s11 m5 l5 selectAndInputbox settings_select']//li[@class='selected']//span")).getAttribute("innerHTML");
			String expected= "Which phone number do you remember most from your childhood?";
			Assert.assertEquals(actual, expected, "Assert fail expected key dosen't match");
			System.out.println("Test case pass - Setting Language updated");
		}
		catch(Exception e) {
			Assert.assertEquals(true, false, "Test case failed - Setting language not updated");
		}*/
		
		driver.findElement(By.xpath("//input[@id='answerid']")).sendKeys("9442698234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn neosuiteBtn advActionBtn']")).click();
		Thread.sleep(5000);
		driver.close();
		
		
		
	}
}
