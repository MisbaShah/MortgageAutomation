package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class GetYourRatesPage {
	
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	@FindBy(xpath = "//div[text()='Just saving your work before we move on to the next step.']")
	private WebElement nextpop_upmessage ;
	
	@FindBy(xpath = "//div[@class='year-fixed-text' and text()=' 15 Year Fixed']")
	private WebElement chooseLoanPlan ;
	
	@FindBy(xpath = "//button[@id='submit-btn' and text()='Continue to Loan Application']")
	private WebElement continueloanbutton ;
	
	//personal details
	//it is in personal info page after get your page form 
	@FindBy(xpath = "//input[@id='b1_currentaddressform_yearslivedatthisaddress_1']")
	private WebElement livedAtThisAddressField ;
	
	@FindBy(xpath = "//input[@class='form-response-button selected']")
	private WebElement nestButton ;
	
	@FindBy(xpath = "//button[@id='b1_ownorrent_id_1']")
	private WebElement homeownerButton ;
	
	@FindBy(xpath = "//button[@id='addcoborrower_id_1']")
	private WebElement notApplyingWithHusbandButton ;
	
	@FindBy(xpath = "//input[@id='b2_personaldetails_firstname_6']")
	private WebElement husbandfirstname  ;
	
	@FindBy(xpath = "//input[@id='b2_personaldetails_lastname_6']")
	private WebElement husbandlastname  ;
	
	@FindBy(xpath = "//input[@id='b2_personaldetails_emailaddress_6']")
	private WebElement husbandeamiladdress ;
	
	@FindBy(xpath = "//input[@id='b2_personaldetails_confirmemailaddress_6']")
	private WebElement husbandeamiladdressConfirm ;
	
	//after phone number u have to use same next button again to continue 
	@FindBy(xpath = "//input[@id='b2_personaldetails_phonenumber_6']")
	private WebElement husbandphone ;
	
	//after next button have to click on home owner button n xpath is same 
	
	@FindBy(xpath = "//button[@id='b1_usmilitaryservice_id_1']")
	private WebElement noButtonformilitory ;
	
	@FindBy(xpath = "//button[@id='addcoapplicant_id_N']")
	private WebElement noButtonforCo_applicant ;
	
	@FindBy(xpath = "//input[@id='continue_btn']")
	private WebElement confirmButton ;
	
	public GetYourRatesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ChooseLoanTearm() {
		chooseLoanPlan.click();
		continueloanbutton.click();
	}
	
	public void Personalinfo(String NumberFoYears) {
		livedAtThisAddressField.sendKeys(NumberFoYears);
		nestButton.click();
		System.out.println("yes it is selected  " +homeownerButton.isSelected());
		notApplyingWithHusbandButton.click();
		noButtonformilitory.click();
		noButtonforCo_applicant.click();
		confirmButton.click();
	}
	
	public void NextButton() {
		nestButton.click();
	}
	
	public void ContinueButton() {
		confirmButton.click();
	}
	
	
	
	
	
	
	

}
