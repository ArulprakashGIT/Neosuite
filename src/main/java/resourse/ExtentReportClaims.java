package resourse;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportClaims {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		String path =System.getProperty("user.dir")+"\\reports\\extentReportclaims.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Claims Automation Result");
		reporter.config().setDocumentTitle("Claims Test");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Arul Prakash");
		return extent;	
	}
}
