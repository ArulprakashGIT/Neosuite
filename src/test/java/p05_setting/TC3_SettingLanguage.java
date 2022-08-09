package p05_setting;

import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import ObjectRepositoryNeosuite.BaseClass;

public class TC3_SettingLanguage extends BaseClass{
	@Test
	public void settingLanguage() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOf(objlogin.settings()));
		objlogin.settings().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]")));
		long start = System.currentTimeMillis();
		long end = start + 10 * 1000;
	    while(start<end) {
		try {
		    Actions action = new Actions(driver);
		    action.moveToElement(driver.findElement(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//div//input"))).build().perform();
		    driver.findElement(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//div//input")).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//div//ul")));
		    break;
			}
		catch(Exception e)
			{}
		}
		List<WebElement> allDropDownValues=driver.findElements(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//ul//li//span"));
		int dropDownCount= allDropDownValues.size();
		System.out.println("Total items present in the dropdown : "+dropDownCount);
		for(int i=0;i<dropDownCount;i++)
		{
		System.out.println(allDropDownValues.get(i).getAttribute("innerHTML"));
		if(allDropDownValues.get(i).getText().contains("English"))
		{
		wait.until(ExpectedConditions.visibilityOf(allDropDownValues.get(i)));	
		allDropDownValues.get(i).click();
		break;
		}
		}
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		try {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(objlogin.menu())));
			objlogin.menu().click();
		}
		catch(Exception e) {
			wait.until(ExpectedConditions.visibilityOf(objlogin.menu()));
			objlogin.menu().click();
		}

		wait.until(ExpectedConditions.visibilityOf(objlogin.settings()));
		objlogin.settings().click();
		long start1 = System.currentTimeMillis();
		long end1 = start1 + 10 * 1000;
		while (start1 < end1)
		{
			try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//input")));
			break;
			}
			catch(Exception e)
			{}
		}
		
		try {
			String languageselected = driver.findElement(By.xpath("//div[@id='neo_general_content']//div[contains(@class,'settings_select language_select')]//li[@class='selected']//span")).getAttribute("innerHTML");
			objsoftassert.assertEquals(languageselected, "English", "Test case failed Assert fail expected key dosen't match");
		}
		catch(Exception e) {
			objsoftassert.assertEquals(true, false, "Test case failed - Setting language not updated");
		}
		
		objsoftassert.assertAll();
		driver.quit();
		
	}
}
