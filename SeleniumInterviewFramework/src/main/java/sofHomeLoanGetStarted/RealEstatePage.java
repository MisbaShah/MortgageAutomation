package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class RealEstatePage {
	
	

	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	
	@FindBy(xpath = "//select[@id='b1_addreopropertydetails_propertytype_5']")
	private WebElement selectPropertyType;
	
	@FindBy(xpath = "//button[@id='b1_reo_ownotherproperty_id_N']")
	private WebElement ownAnyProperty ;
	
	@FindBy(xpath = "//button[@id='b1_judgement_id_N']")
	private WebElement anyJudgmentAgainstU ;
	
	@FindBy(xpath = "//button[@id='b1_bankruptcydeclaration_id_N']")
	private WebElement noToBankrupt  ;
	
	@FindBy(xpath = "//button[@id='b1_propertyforeclosed_id_N']")
	private WebElement propertyForeclosed ;
	
	@FindBy(xpath = "//button[@id='b1_partyinlawsuit_id_N']")
	private WebElement lawSuitPartyno ;
	
	@FindBy(xpath = "//button[@id='b1_obligationonloan_id_N']")
	private WebElement NoobligationOnLoan ;
	
	@FindBy(xpath = "//button[@id='b1_statusofdelinquent_id_N']")
	private WebElement statusofdelinquentno ;
	
	@FindBy(xpath = "//button[@id='b1_obligationtopay_id_N']")
	private WebElement obligationtoPayAlimony ;
	
	@FindBy(xpath = "//button[@id='b1_downpaymentborrowing_id_N']")
	private WebElement downpaymentborrowing ;
	
	@FindBy(xpath = "//button[@id='b1_comakeronnote_id_N']")
	private WebElement comakeronnote ;
	
	@FindBy(xpath = "//button[@id='b1_occupancy_id_Y']")
	private WebElement  occupencyOfProperty;
	
	@FindBy(xpath = "//button[@id='b1_ownershipinterest_id_N']")
	private WebElement ownershipinterestno ;
	
	@FindBy(xpath = "//button[text()=' Go to Loan Summary ']")
     private WebElement gotoLoanSummaryButton;
	
	@FindBy(xpath = "//p[text()=' You do not have any pending items in your checklist! ']")
	private WebElement assertMSG ;
	
	
	public RealEstatePage () {
		PageFactory.initElements(driver, this);
	}
	
	public void RealEstateInfo () {
		Utils.selectFromDropdown(selectPropertyType,  "Condominium");
		//next click next button from get your rates page
		
	}
	
	public void SelectOwnedProperty() {
		Utils.waitForElementToBeclickable(ownAnyProperty);
		ownAnyProperty.click();
		//next click continue button from get your rates page
	}
	
	public void DeclarationsPageInfo () {
		Utils.waitForElementToBeclickable(anyJudgmentAgainstU);
		anyJudgmentAgainstU.click();
		Utils.waitForElementToBeclickable(noToBankrupt);
		noToBankrupt.click();
		Utils.waitForElementToBeclickable(propertyForeclosed);
		propertyForeclosed.click();
		Utils.waitForElementToBeclickable(lawSuitPartyno);
		lawSuitPartyno.click();
		Utils.waitForElementToBeclickable(NoobligationOnLoan);
		NoobligationOnLoan.click();
		Utils.waitForElementToBeclickable(statusofdelinquentno);
		statusofdelinquentno.click();
		Utils.waitForElementToBeclickable(obligationtoPayAlimony);
		obligationtoPayAlimony.click();
		Utils.waitForElementToBeclickable(downpaymentborrowing);
		downpaymentborrowing.click();
		Utils.waitForElementToBeclickable(comakeronnote);
		comakeronnote.click();
		Utils.waitForElementToBeclickable(occupencyOfProperty);
		occupencyOfProperty.click();
		Utils.waitForElementToBeclickable(ownershipinterestno);
		ownershipinterestno.click();
		//next clicl on continue button from get your rates page 
	}

}
