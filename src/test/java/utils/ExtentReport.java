package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getReport() {
		String path="C:\\Users\\Anbarasan_SAM\\eclipse-workspace\\CapstoneProject\\reports\\CapstoneProject.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Adactin Hotel Booking App");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}