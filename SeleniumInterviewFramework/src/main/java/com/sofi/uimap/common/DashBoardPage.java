package com.sofi.uimap.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sofi.driver.DriverManager;

public class DashBoardPage {
	WebDriver driver = DriverManager.GerDriver();
	public static final String Welcome_Heading_XPATH = "//h2[text()='Hello, test123!']";
	
	@FindBy(xpath = Welcome_Heading_XPATH)
	public static WebElement dashboardHeading;
	
	@FindBy(xpath = "//button[@class='sc-fzqNJr iceCuH']")
	public static WebElement LogoutButtonOption ;
	
	@FindBy(xpath = "//div[@id='user-dropdown']//a[text()='Logout']")
	public static WebElement LogoutButton; 
	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void logout() {
		LogoutButtonOption.click();
		LogoutButton.click();
	}

}
