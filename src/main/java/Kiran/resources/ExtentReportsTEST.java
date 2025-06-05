package Kiran.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTEST 
{
	public static ExtentReports GetReports()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\Results.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Results");
		reporter.config().setDocumentTitle("Automation results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Name", "Dharaidhar");
		extent.setSystemInfo("Platform", "WEB");
		extent.createTest("Test");
		return extent;
		
	}

}
