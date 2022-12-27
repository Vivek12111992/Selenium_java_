package com.servMe.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGen {
public static ExtentReports extent;
	public static ExtentReports ExtentReportGen1() {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String repName="Test-Report"+timestamp+".html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+repName);
	reporter.config().setReportName("WebAutomation Results");
	reporter.config().setDocumentTitle("ServMe Test Automation");
	extent=new ExtentReports();
	extent.attachReporter();
	extent.setSystemInfo("Tester", "VDC");
	return extent;
	
	
}
}
