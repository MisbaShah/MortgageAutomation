package com.sofi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.sofi.driver.DriverManager;

public class GenericUtils {
	static WebDriver driver = DriverManager.GerDriver();

	public static void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
	}

	public void waitForElementToBeclickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitforvisibilityofelement(WebElement element ) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForPresenceOfEelement(String xpathExpression) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
		
	}

	public void waitForPresenceOfEelement(final WebElement element, long duration ) {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(duration, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
		@SuppressWarnings("unused")
		WebElement foo=wait.until(new Function<WebDriver, WebElement>() {
		@Override
		public WebElement apply(WebDriver driver) {
			return element;
		}
		});
	}

	public void takeScreenShot(String screenShotName, String result) throws IOException {
		File srcShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destShot = new File("./" +result+ "TestScreenshots/" + screenShotName + ".jpg");
		FileUtils.copyFile(srcShot, destShot);
	}

	public static String getProperty(String property) {
		InputStream input;
		String requiredProperty = null;
		try {
			input = new FileInputStream("./resources/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			requiredProperty = prop.getProperty(property);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return requiredProperty;
	}
	
	public void selectFromDropdown(WebElement element, String option) {
		Select select= new Select(element);
		select.selectByVisibleText(option);
	}

}
