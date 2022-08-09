package ObjectRepositoryNeosuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;
	public NeosuiteLoginPage objlogin;
	public Function objfunction;
    public SoftAssert objsoftassert;
    public Actions objactions;
	public WebDriver setupApplication() throws InterruptedException, MalformedURLException
	{	
		
        /*String Drivername = System.getProperty("Browser");
        
        if(Drivername.equals("Chrome")){
       	 WebDriverManager.chromedriver().setup();
       	MutableCapabilities dc; 
		dc=new ChromeOptions();
        String completeURL ="http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);
       	 
        }
        else if(Drivername.equals("Firefox")){
       	 WebDriverManager.firefoxdriver().setup();
       	MutableCapabilities dc; 
		dc=new FirefoxOptions();
        String completeURL ="http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);

        }*/
		  
        //code to download the file in the dir folder download attachment class
		
		
        WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		
        String downloadFilepath = System.getProperty("user.dir")+"\\Downloads";
      	System.out.println(downloadFilepath);
      	Map<String, Object> preferences = new Hashtable<String, Object>();
      	preferences.put("profile.default_content_settings.popups", 0);
      	preferences.put("download.prompt_for_download", "false");
      	preferences.put("download.default_directory", downloadFilepath);
        		
      	/*//disable flash and the PDF viewer
      	preferences.put("plugins.plugins_disabled", new String[]{
      	"Adobe Flash Player", "Chrome PDF Viewer"});
      	ChromeOptions options = new ChromeOptions();
      	options.setExperimentalOption("prefs", preferences);
      	DesiredCapabilities capabilities = new DesiredCapabilities();
      	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
      	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      	@SuppressWarnings("deprecation")
      	driver =new ChromeDriver(capabilities);*/
      		
        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    wait =new WebDriverWait(driver ,Duration.ofSeconds(30));
		driver.get("https://neosuiteuat.neeyamo.works/login");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='username']")));
		objsoftassert =new SoftAssert();
		objlogin =new NeosuiteLoginPage(driver ,wait);
		objfunction =new Function(driver ,wait ,objsoftassert);
		objactions =new Actions(driver);
		
		return driver;
	}
	
	    //Screenshot on failure - Method called by Listeners ontest failure 
	
		public String getScreenshotPath(String failmethordname,WebDriver driver) throws IOException {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String destinationfile = System.getProperty("user.dir")+"\\reports\\"+ failmethordname+".png";
			FileUtils.copyFile(source,new File(destinationfile));
			return destinationfile;
		}
		
		public void javaScriptClick(WebElement locator) {
		     ((JavascriptExecutor) driver).executeScript("arguments[0].click();",locator);
		}
		
}
