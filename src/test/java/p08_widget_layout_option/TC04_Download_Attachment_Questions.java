package p08_widget_layout_option;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepositoryNeosuite.BaseClass;
import ObjectRepositoryNeosuite.ExtentReport;

public class TC04_Download_Attachment_Questions extends ExtentReport{

	@Test
	public void downloadAttachmentQuestions() throws InterruptedException, MalformedURLException
	{
		tests = extent.createTest("Download_Attachment_Questions");
		
        
		BaseClass setup = new BaseClass();
		WebDriver driver= setup.setupApplication();
		WebDriverWait wait = new WebDriverWait(driver,30);
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Knowledge Base')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@title='HELP']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='kbHomeComponent']/div[2]/div/div[2]//i[contains(text(),'keyboard_arrow_down')]")));
		driver.findElement(By.xpath("//div[@id='kbHomeComponent']/div[2]/div/div[2]//i[contains(text(),'keyboard_arrow_down')]")).click();
		driver.findElement(By.xpath("//span[@class='kbUpvoteImg left kbAttachmentIconSpan']")).click();
		Thread.sleep(3000);
		String downloadPath = System.getProperty("user.dir")+"\\Downloads"; //code to download the file in the dir folder download attachment class function setup base class
		
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < 3; i++) {
            if (dirContents[i].getName().contains("3 colors Defination")) {
            	dirContents[i].delete();
                break;
            }
            else 
            {
            	Assert.assertEquals(true, false, "Test case failed- Download attchment failed");
            }
        }
		driver.close();
		
	}
}
