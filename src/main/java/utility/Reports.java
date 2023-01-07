package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports getReports() {
		
		ExtentReports reports = new ExtentReports();
		ExtentSparkReporter html = new ExtentSparkReporter("extentreport.html");
		reports.attachReporter(html);
		reports.setSystemInfo("test", "Regression");
		reports.setSystemInfo("doneBy", "Sonali Patel");
		
		return reports;
		
	}

}
