package com.customListeners;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utilities.BaseClass;
import com.utilities.extentRep;


public class listeners extends BaseClass implements ITestListener {
   
	ExtentTest test;
	//@Override
	ExtentReports extent=extentRep.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>(); //for parallel execution
	public void onTestStart(ITestResult result) {
		
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	
	public void onTestFailure(ITestResult result) {
	     extentTest.get().fail(result.getThrowable());
		 WebDriver driver=null;
		 //String methodName=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png"
         String methodName=result.getMethod().getMethodName();		
         try
         {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	     }
         catch(Exception e)
         {
        	 
         }
         try 
         {
        	 extentTest.get().addScreenCaptureFromPath(getScreenshotPath(methodName, driver), result.getMethod().getMethodName());
			//getScreenshotPath(methodName, driver); //this is to generate ss in directory
		 } 
         catch (IOException e) 
         {
			e.printStackTrace();
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
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	

}
