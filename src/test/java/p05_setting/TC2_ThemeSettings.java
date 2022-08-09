package p05_setting;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC2_ThemeSettings extends BaseClass{

	@Test
	public void themeSetting() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@title='Settings']")));
		objlogin.settings().click();
		
		
		driver.findElement(By.xpath("//div[@title='#28d79e']")).click();
		Thread.sleep(9000);
		WebElement E=driver.findElement(By.xpath("//*[@id=\"neo_general_content\"]/div[1]/span"));
		Thread.sleep(1000);
		String color =E.getCssValue("color");
		System.out.println(color);
		Thread.sleep(2000);
		String hexcolor=Color.fromString(color).asHex();
		Assert.assertEquals(hexcolor, "#28d79e");
		Thread.sleep(2000);
		System.out.println(hexcolor);
		driver.quit();
		
	}
}
