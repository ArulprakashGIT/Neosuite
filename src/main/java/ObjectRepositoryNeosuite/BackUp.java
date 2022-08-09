/*package ObjectRepositoryNeosuite;

import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackUp {

	public WebDriver setupApplication() throws InterruptedException, MalformedURLException
	{	
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
	    
		PMutableCapabilities dc; dc=new FirefoxOptions();
        String completeURL = 
        "http://NW-SDET-ALB-1412688782.eu-central-1.elb.amazonaws.com:4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);		
        
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://neosuiteuat.neeyamo.works/login");
		NeosuiteLoginPage login =new NeosuiteLoginPage(driver);
		//Function func =new Function(driver);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(4000);
		login.username().sendKeys("ET1101");
		login.password().sendKeys("Neeyamo$123");
		login.signin().click();
		Thread.sleep(5000);
		return driver;
	}
	
	
	
	public WebDriver setup() throws InterruptedException, MalformedURLException
	{	
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		
		//code to download the file in the dir folder download attachment class
		
		String downloadFilepath = System.getProperty("user.dir")+"\\Downloads";
		System.out.println(downloadFilepath);
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);
		// disable flash and the PDF viewer
		preferences.put("plugins.plugins_disabled", new String[]{
		"Adobe Flash Player", "Chrome PDF Viewer"});
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		@SuppressWarnings("deprecation")
		WebDriver driver =new ChromeDriver(capabilities);
		
		
		MutableCapabilities dc;                                //Remote execution jenkins
		dc = new ChromeOptions();
		String completeURL = "http://testi-selen-dp1hy32983um-1615990027.eu-central-1.elb.amazonaws.com:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(completeURL),dc);
		
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://neosuiteuat.neeyamo.works/login");
		NeosuiteLoginPage login =new NeosuiteLoginPage(driver);
		//Function func =new Function(driver);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(4000);
		login.username().sendKeys("ET1101");
		login.password().sendKeys("Neeyamo$123");
		login.signin().click();
		Thread.sleep(5000);
		return driver;
	}
	
	
}*/
