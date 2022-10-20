package data;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getExtendReport()
	{
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Test Report");
		report.config().setReportName("Automation Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Sameer Ranjan Panda");
		return extent;
	}

}
