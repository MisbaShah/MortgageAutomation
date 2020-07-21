package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class IncomePagE {
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();

	
	@FindBy(xpath = "//input[@id='b1_ssndob_ssn_500']")
	private WebElement provideSSN ;
	
	@FindBy(xpath = "//input[@id='b1_ssndob_confirmssn_500']")
	private WebElement confirmSSN  ;
	
	@FindBy(xpath = "//input[@id='b2_ssndob_ssn_501']")
	private WebElement aliceSSN ;
	
	@FindBy(xpath = "//input[@id='b2_ssndob_confirmssn_501']")
	private WebElement aliceconfirmSSN ;
		
	@FindBy(xpath = "//input[@class='selection ng-valid invaliddate ng-dirty ng-touched']")
	private WebElement aliceDOB ;
	
	@FindBy(xpath = "//input[@id='chkNotHispanic']")
	private WebElement notHispanicCheckbox ;
	
	@FindBy(xpath = "//input[@id='chkRaceWhite']")
	private WebElement ethnicityWhite ;
	
	@FindBy(xpath = "//select[@id='b1_gender_hmda_gender_503']")
	private WebElement gender ;
	
	@FindBy(xpath = "//input[@id='b1_consent2']")
	private WebElement proceedwithcreditpullbutton ;
	
	@FindBy(xpath = "//label[@class='custom-checkbox']")
	private WebElement   authorizationcheckboxf;
	
	@FindBy(xpath = "//select[@id='b1_employmenttype_id']")
	private WebElement employmentType;
	
	@FindBy(xpath = "//button[@id='b1_addrsuincome_id_N']")
	private WebElement noRUSincome;
	
	@FindBy(xpath = "//button[@id='b1_addotherincome_id_N']")
	private WebElement noAdditionalIncome ;
	
	public IncomePagE() {
		PageFactory.initElements(driver, this);
	}
	
	public void IncomeInfo(String SSN, String ConfirmSSN) {
		Utils.waitForPresenceOfEelement(provideSSN, 20);
		provideSSN.sendKeys(SSN);
		Utils.waitForPresenceOfEelement(provideSSN, 20);
		confirmSSN.sendKeys(ConfirmSSN);
		Utils.waitForElementToBeclickable(notHispanicCheckbox);
		notHispanicCheckbox.click();
		Utils.waitForElementToBeclickable(ethnicityWhite);
		ethnicityWhite.click();
		Utils.selectFromDropdown(gender, "Male");
		Utils.waitForElementToBeclickable(authorizationcheckboxf);
		authorizationcheckboxf.click();
		Utils.waitForElementToBeclickable(proceedwithcreditpullbutton);
		proceedwithcreditpullbutton.click();
		
		
	}
	//optional
	public void EmploymentInfo() {
		Utils.selectFromDropdown(employmentType, "Salaried / Hourly");
		
	}
	
	public void AdditionalIncomeinfo() {
		noRUSincome.isSelected();
		noAdditionalIncome.click();
	}
	
}
