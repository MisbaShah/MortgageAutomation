package com.sofi.test;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sofi.basetest.BaseTest;
import com.sofi.uimap.common.LoginPage;

import sofHomeLoanGetStarted.AssetsPage;
import sofHomeLoanGetStarted.GetStartedPage;
import sofHomeLoanGetStarted.GetYourRatesPage;
import sofHomeLoanGetStarted.IncomePagE;
import sofHomeLoanGetStarted.MortgageEligibilitypage;
import sofHomeLoanGetStarted.Propertyinfopage;
import sofHomeLoanGetStarted.RealEstatePage;

@Listeners(com.sofi.test.ListenerClass.class)

public class SofiLoginTest extends BaseTest {
	
	LoginPage loginObject = new LoginPage();
	GetStartedPage getpageobject = new GetStartedPage();
	MortgageEligibilitypage mortgageObject = new MortgageEligibilitypage();
	GetYourRatesPage ratesObject = new GetYourRatesPage();
	Propertyinfopage propertyObject = new Propertyinfopage() ;
	IncomePagE incomeObject = new IncomePagE ();
	AssetsPage assetObject = new AssetsPage();
	RealEstatePage estateObject = new RealEstatePage();
	
	@Test(priority = 1 )
	public void  logintest () {
		test = extent.createTest("logintest");
		
		loginObject.EnterCredentials("testing12@mailinator.com", "Demo@123");
		
	}
	@Test(priority = 2 )
	public void HomeLoanGetStarted() {
		test = extent.createTest("HomeLoanGetStarted");
		getpageobject.HomeLoan();
		
		//getpageobject.DOB("2/3/2000");
		//getpageobject.SelectCitizenship("550000");
		//getpageobject.clicknext();
		
		
	     
	}
	
	  @Test(priority = 3) 
	  public void MortgageEligibilityTest() {
		  test = extent.createTest("MortgageEligibilityTest"); 
		  mortgageObject.MortgageForm("91320", "250000");
		
		  
		  
	  }
	  
	 @Test(priority = 4)
	 public void GetYourRatesTest () {
		 test = extent.createTest("GetYourRatesTest"); 
		 ratesObject.ChooseLoanTearm();
		 ratesObject.NextButton();
		
	 }
	 
	 @Test(priority = 5)
	 public void PersonalInfoTest () {
		 test = extent.createTest("PersonalInfoTest");
		 ratesObject.Personalinfo("5");
	 }
	 
	 @Test(priority = 6)
	 public void PropertyInfoTest () {
		 test = extent.createTest("PropertyInfoTest");
		 propertyObject.PropertyInfoForm();
		 ratesObject.NextButton();
		 ratesObject.ContinueButton();
	
		 
	 }
	 
	 @Test(priority = 7)
	 public void IncomeInfoTest () {
		 test = extent.createTest("IncomeInfoTest");
		 incomeObject.IncomeInfo("991919991", "991919991");
		 //this is optional when u provide your ssn it will auto selected
		 incomeObject.EmploymentInfo();
		 ratesObject.NextButton();
		
		 incomeObject.AdditionalIncomeinfo();
		 ratesObject.ContinueButton();
	 }
	 
	 @Test(priority = 8)
	 public void assetinfotest() {
		 test = extent.createTest("assetinfotest");
		 assetObject.Assetsinfo("100000", "BOA","1234567");
		 ratesObject.NextButton();
	 }
	 
	 @Test(priority = 9)
	 public void RealEstateInfoTest() {
		 test = extent.createTest("RealEstateInfoTest");
		 estateObject.RealEstateInfo();
		 ratesObject.NextButton();
		 estateObject.SelectOwnedProperty();
		 ratesObject.ContinueButton();
		 estateObject.DeclarationsPageInfo();
		 
	 }
	 
	 
}
