package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentRep {
	static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		String path= System.getProperty("user.dir")+"\\reports\\"+repName;
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		//ExtentHtmlReporter reporter= new ExtentHtmlReporter(path);

		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
	    extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sayali");
		return extent;
	}

}
