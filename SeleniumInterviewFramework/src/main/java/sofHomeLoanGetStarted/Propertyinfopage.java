package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class Propertyinfopage {
	
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	@FindBy(xpath = "//input[@id='newpropertyaddressform_zip_14']")
	private WebElement zipcodeassertion;
	
	@FindBy(xpath = "//input[@id='newpropertyaddressform_city_14']")
	private WebElement assertcity ;
	
	@FindBy(xpath = "//input[@id='newpropertyaddressform_state_14']")
	private WebElement assertstate ;
	
	@FindBy(xpath = "//button[@id='propertyusage_id_1']")
	private WebElement primaryResidentButton ;
	
	@FindBy(xpath = "//button[@id='propertyduration_id_7']")
	private WebElement yearplanToStayButton;
	
	@FindBy(xpath = "//select[@id='propertytype_propertytype_17']")
	private WebElement assertTypeofProperty ;
	
	//take next button from get our rate page class
	
	//next step continue button take from above page
	
	@FindBy(xpath = "//input[@class='form-response-button selected']")
	private WebElement zip_codeassertion;
	
	public Propertyinfopage () {
		PageFactory.initElements(driver, this);
	}
	
	public void PropertyInfoForm() {
		System.out.println("it is selected  "+ primaryResidentButton.isSelected());
		yearplanToStayButton.click();
		
	}

}
