package com.servMe.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners implements ITestListener {
	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report" + timestamp + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports\\" + repName);
		reporter.config().setReportName("WebAutomation Results");
		reporter.config().setDocumentTitle("ServMe Test Automation");
		reporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "VDC");
		extent.setSystemInfo("Environment", "QA");
		

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		extentTest.get().fail(result.getThrowable());
		String screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + ".png";
		File file = new File(screenshotpath);
		if (file.exists()) {
			test.fail("Screenshot is below:" + extentTest.get().addScreenCaptureFromPath(screenshotpath));
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
