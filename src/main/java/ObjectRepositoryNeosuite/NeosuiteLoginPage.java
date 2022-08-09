package ObjectRepositoryNeosuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NeosuiteLoginPage {
   
	WebDriver driver;
	WebDriverWait wait;
	public  NeosuiteLoginPage (WebDriver driver ,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
	}
	By username=By.id("username");
	By password=By.id("password");
	By signin=By.name("login");
	By notification=By.xpath("//li[@id='alertBox']");
	By menu=By.xpath("//*[@id=\"nav-mobile-right\"]/li/a");
	By settings=By.xpath("//li[@title='Settings']");
	By delegate=By.xpath("//li[@title='Delegate']");
	
	public WebElement username()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement signin()
	{
		return driver.findElement(signin);
	}
	
	public void notification()
	{
		for(;;){
			try {
			    driver.findElement(notification).click();
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'See All')]")));
			    break;
			    
			}
			catch(Exception e)
			{}
		}
	}
	
	public WebElement menu() {
		return driver.findElement(menu);
	}
	
	public WebElement settings()
	{
		return driver.findElement(settings);
	}
	
	public WebElement delegate()
	{
		return driver.findElement(delegate);
	}
	
	 public void neosuiteLogin() {
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='username']")));
			username().sendKeys("ET1101");
			password().sendKeys("Neeyamo$123");
			signin().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='nav-mobile-right']")));
		}
	
}

