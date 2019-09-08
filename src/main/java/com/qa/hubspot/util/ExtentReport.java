package com.qa.hubspot.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		result.getMethod().getMethodName();
		String qualifiedName = result.getMethod().getQualifiedName();
		int last = qualifiedName.lastIndexOf(".");
		int mid = qualifiedName.substring(0, last).lastIndexOf(".");
		String className = qualifiedName.substring(mid + 1, last);

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(true);
		
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows8");
		extent.setSystemInfo("Tester", "John");
		extent.setSystemInfo("Browser", "Chrome");
	
		
		test = extent.createTest(result.getMethod().getMethodName() , result.getMethod().getDescription());
		test.assignCategory(result.getTestContext().getSuite().getName());
		test.assignCategory(className);
		
		
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Case PASSED is: " + result.getName());
		

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "Test Case Failed is: " + result.getName());
		test.log(Status.FAIL, "Test Case Failed is: " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, "Test Case Skipped is: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		extent.flush();

	}
	
/*	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}*/

}
