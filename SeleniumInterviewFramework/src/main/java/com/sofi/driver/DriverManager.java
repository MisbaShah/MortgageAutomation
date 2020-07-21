package com.sofi.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private DriverManager() {
		
	}
	
	private static WebDriver driver = null;
	private static Properties prop = null;
	
   synchronized public static WebDriver GerDriver() {
		try {
			InputStream input = new FileInputStream("./resources/config.properties");
			prop = new Properties();
			prop.load(input);
			String browser = prop.getProperty("browser");
			switch (browser) {

			case "chrome":
				if (driver == null) {

					WebDriverManager.chromedriver().setup();

					ChromeOptions options = new ChromeOptions();
					options.setPageLoadStrategy(PageLoadStrategy.NONE);
					options.addArguments("--no-sandbox", "--disable-infobars", "--disable-dev-shm-usage",
							"--disable-browser-side-navigation", "--disable-gpu", "enable-automation"); // options.addex

					driver = new ChromeDriver(options);
				}
				return driver;

			case "firefox":
				if (driver == null) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				return driver;

			case "headless":
				if (driver == null) {

					driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
				}
				return driver;

			default:
				System.out.print(browser + "is not supported please try other");
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.print("Check config.properties file having some issues");
			e.printStackTrace();
			return null;
		}
   }
}