package kiran.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Kiran.resources.ExtentReportsTEST;

public class Listerners extends BaseTest implements ITestListener
{
	ExtentReports extent=ExtentReportsTEST.GetReports();
	ExtentTest test;
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
    
		extenttest.get().log(Status.PASS, "Execution is success");	
	}

  
	@Override
	public void onTestFailure(ITestResult result) 
	{
    
		extenttest.get().fail(result.getThrowable());
		extenttest.get().log(Status.FAIL, result.getMethod().getMethodName()+" is got failed");
		
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String Filepath=null;
		try {
			Filepath=GetScreenshotHandles(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extenttest.get().addScreenCaptureFromPath(Filepath, result.getMethod().getMethodName());
		
 	}

  
	@Override
	public void onTestSkipped(ITestResult result) {
    // not implemented
  }

  /**
   * Invoked each time a method fails but has been annotated with successPercentage and this failure
   * still keeps it within the success percentage requested.
   *
   * @param result <code>ITestResult</code> containing information about the run test
   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
   */
	@Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    // not implemented
  }

  /**
   * Invoked each time a test fails due to a timeout.
   *
   * @param result <code>ITestResult</code> containing information about the run test
   */
	@Override
  public void onTestFailedWithTimeout(ITestResult result) {
    onTestFailure(result);
  }

  /**
   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
   * tag and calling all their Configuration methods.
   *
   * @param context The test context
   */
	@Override
  public void onStart(ITestContext context) {
    // not implemented
  }

  /**
   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
   * run and all their Configuration methods have been called.
   *
   * @param context The test context
   */
	@Override
  public void onFinish(ITestContext context) 
	{
    
		extent.flush();
  }
}
