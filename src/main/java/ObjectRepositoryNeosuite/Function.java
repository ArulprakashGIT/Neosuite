package ObjectRepositoryNeosuite;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Function {
	public WebDriver driver;
	public WebDriverWait wait;
	public SoftAssert objsoftassert;

	public Function(WebDriver driver ,WebDriverWait wait,SoftAssert objsoftassert) {
		this.driver = driver;
		this.wait=wait;
		this.objsoftassert = objsoftassert;
	}

	public void createdelegate(String widgetname) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create Delegation')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create Delegation')]")).click();
		String Widgetnamestring = "//div[@id='delegateModal']//div[text()=' "+widgetname+" ']";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Widgetnamestring)));
		driver.findElement(By.xpath(Widgetnamestring)).click();
		driver.findElement(By.xpath("//button[@class='btn delegate-btn']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Start Date - End Date']")));
		driver.findElement(By.xpath("//input[@placeholder='Start Date - End Date']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("owl-dt-calendar-control-content")));
		String monthYearVal = driver.findElement(By.className("owl-dt-calendar-control-content")).getText();
		System.out.println(monthYearVal);
		String month = monthYearVal.split(" ")[0].trim();
		String year = monthYearVal.split(" ")[1].trim();
		while (!(month.equals("Dec") && year.equals("2023"))) {
			driver.findElement(By.xpath("//button[@aria-label='Next 21 years']")).click();
			monthYearVal = driver.findElement(By.className("owl-dt-calendar-control-content")).getText();
			System.out.println(monthYearVal);
			month = monthYearVal.split(" ")[0].trim();
			year = monthYearVal.split(" ")[1].trim();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@aria-label,'December 27, 2023')]")));
		driver.findElement(By.xpath("//td[contains(@aria-label,'December 27, 2023')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(@aria-label,'December 27, 2023')]")));
		driver.findElement(By.xpath("//td[contains(@aria-label,'December 27, 2023')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		long start = System.currentTimeMillis();
		long end = start + 30 * 1000;
	    while(start<end) {
		String val = "100005"; 
	    WebElement element = driver.findElement(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']"));
	    element.clear();
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        Thread.sleep(800);
	        element.sendKeys(s);
	    }
	    
	    try {
	    	WebElement click = driver.findElement(By.xpath("//span[contains(text(),'Samuel Isaac')]"));
		    wait.until(ExpectedConditions.visibilityOf(click));
	    	click.click();
	    	break;
	    }
	    catch(Exception e) {
	    	driver.findElement(By.xpath("//ng-select[@placeholder='Search to delegate..']//input[@aria-autocomplete='list']")).clear();
	    }
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	

	}
	

	public void validateDelegate() {
		
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']//div")));
			String actual= driver.findElement(By.xpath("//div[@id='toast-container']//div")).getText();
		    String expected= "Delegation saved successfully";
			objsoftassert.assertEquals(actual, expected, "Test case fail -Widget not delegated"); 
			System.out.println("Test case passed -Widget delegated pop up sucess");
			
		}
		catch(Exception e) {
			objsoftassert.assertEquals(true, false,"Test case failed-Widget not delegated");
		}	
	    
	    try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Widget Delegated')]")));
			boolean validate = driver.findElement(By.xpath("//span[contains(text(),'Widget Delegated')]")).isDisplayed();
			objsoftassert.assertEquals(validate, true, "Assert fail - Widget not delegated");
		}
		catch(Exception e) {
			objsoftassert.fail("Test case failed-Widget not delegated");
		}	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    objsoftassert.assertAll();
	}

	
	
	public String resetpassword() {
		// create a string of uppercase and lowercase characters and numbers
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String spChar = "!@#$%^&*-_=+|;:,<.>/?";
		// combine all strings
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers + spChar;
		// create random string builder
		// create an object of Random class
		Random random = new Random();
		// specify length of random string
		int length = 10;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			// generate random index number
			int index = random.nextInt(alphaNumeric.length());
			// get character specified by index
			// from the string
			char randomChar = alphaNumeric.charAt(index);
			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		String password = randomString+"Ab1!";
		return password;
	}

	
	public String selectdate() 
	{
	String[] arr={"1", "2", "3", "4", "5", "6" ,"7", "8" , "9" , "10" , "11" , "12" , "13" , "14" , "15" , "16" , "17" , "18" , "19" , "20" , "21" , "22" , "23" , "24" , "25" , "26" , "27" , "28" , "29" };
  	Random r=new Random();        
  	int randomNumber=r.nextInt(arr.length);
    System.out.println(arr[randomNumber]);
  	String date =arr[randomNumber];
  	return date;
	}
}
