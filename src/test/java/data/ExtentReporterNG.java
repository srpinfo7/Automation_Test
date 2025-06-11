package data;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentReports getExtendReport()
	{
		    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	        String reportPath = System.getProperty("user.dir") + "/reports/TestReport_index.html";
	        //String reportPath = System.getProperty("user.dir") + "/reports/TestReport_" + timeStamp + ".html";

	        // ✅ Setting up SparkReporter
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	        sparkReporter.config().setDocumentTitle("Automation Execution Report");
	        sparkReporter.config().setReportName("Functional Test Report");
	        sparkReporter.config().setTheme(Theme.DARK); // Theme.STANDARD is also available
	        sparkReporter.config().setEncoding("utf-8");
	        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


	        // ✅ Attaching Spark Reporter to ExtentReports
	        ExtentReports extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);

	        // ✅ Setting System Info (good for Jenkins/CI/CD context)
	        extent.setSystemInfo("Tester", "Sameer Ranjan Panda");
	        extent.setSystemInfo("Organization", "Your Company Name");
	        extent.setSystemInfo("Platform", System.getProperty("os.name"));
	        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	        extent.setSystemInfo("Environment", "QA");
		return extent;
	}

}
