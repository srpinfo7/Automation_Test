package GlobalProp;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import data.ExtentReporterNG;		

public class Listener extends GlobalProp implements ITestListener						
{		
	ExtentReports extent=ExtentReporterNG.getExtendReport();
	ExtentTest test;
	WebDriver driver=null;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

    @Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
    	extent.flush();	
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    	extentTest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		String path = null;
		try {
			path = takeScreeShot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub			
    	test=extent.createTest(result.getMethod().getMethodName());
    	extentTest.set(test);
        		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
}		