package p06_Profile_Tab;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;

public class TC02_Approle_open extends BaseClass{

	@Test
	public void Approle_open() throws InterruptedException, MalformedURLException
	{
		driver=setupApplication();
		objlogin.neosuiteLogin();
		objlogin.menu().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='neoAppRole_Collapsible']")));
        driver.findElement(By.xpath("//ul[@id='neoAppRole_Collapsible']")).click();   
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='appRole_Collapsible']")));
        try{
        	boolean App = driver.findElement(By.xpath("//ul[@id='appRole_Collapsible']//li")).isDisplayed();
        	Assert.assertEquals(App, true, "App role open assertion fail");
        }
        catch(Exception e){
        	Assert.fail("App role open fail");
        }
        
        /*int Applicationcount = driver.findElements(By.xpath("//ul[@id='appRole_Collapsible']//li")).size();
        System.out.println(Applicationcount);
        if(Applicationcount>0)
        {
        	Assert.assertEquals(true, true);
        }
        else {
        	Assert.fail("No application mapped");
        }*/
        driver.quit();
	}
}
