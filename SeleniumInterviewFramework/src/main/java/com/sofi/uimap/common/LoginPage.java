package com.sofi.uimap.common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class LoginPage {
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	private static final String LOGIN_PAGE_HEADER="//h1[text()='Log in to your account.']";
	
	@FindBy(xpath = "//input[@id='input-1']")
	private WebElement emailtext ;
	
	@FindBy(xpath = "//input[@id='input-5']")
	private WebElement passwordtext;
	
	@FindBy(xpath = "//button[text()='Log in']")
	private WebElement loginbutton ;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterCredentials (String Username ,String Password) {
		GenericUtils.waitForPageLoad();
		emailtext.sendKeys(Username);
		passwordtext.sendKeys(Password);
		
		loginbutton.click();
		
	}
	
	

}
