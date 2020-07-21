package com.sofi.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class ListenerClass  implements ITestListener {
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils = new GenericUtils();
	
	@Override
	public void onTestStart(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			Utils.takeScreenShot(result.getName(), "Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			Utils.takeScreenShot(result.getName(), "Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
