package com.sofi.basetest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class BaseTest extends GenericUtils {
	
	
	WebDriver driver = DriverManager.GerDriver();
	// create a object of this logger class
	private static Logger logger = Logger.getLogger(BaseTest.class.getName());

	@BeforeSuite
	public void setUp() {
		// configure log4j properties file
		PropertyConfigurator.configure("./resources/log4j.properties");

		// URL also comes from properties file
		driver.manage().window().maximize();
		logger.info("Browser Opened");
		// System.out.println("Browser Opened");

		driver.get(getProperty("url"));
		logger.info("Browser Opened");

		// Set implicit wait
		waitForPageLoad();
		logger.info("Implicit wait given");

	}
	// Code for Extend report
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	

	@BeforeSuite
	public void ReportsetUp() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "./report/MyOwnReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Host Name", "Vista");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Misba Shah");

		// htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in TestRun Report");
		htmlReporter.config().setReportName("My Own Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
					ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
	public void takeScreenShot(String screenShotName, String result) throws IOException {
		File srcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destShot = new File("./" +result+ "TestScreenshots/" + screenShotName + ".jpg");
		FileUtils.copyFile(srcShot, destShot);
	}

	@AfterSuite
	public void tearDown() throws IOException {
	//	CommonFunctions.logout();
		//driver.quit();

		// for focefully close chromedriver, can use command in command line as
		// "taskkill /F /IM chromedriver.exe"
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");

		extent.flush();
	}
	

	
}
