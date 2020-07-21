package sofHomeLoanGetStarted;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class MortgageEligibilitypage {
	
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	Actions actions = new Actions(driver);
	
	@FindBy(xpath = "//div[@id='mortgagetype']/div/div[1]/label[1]/div[@class='control__indicator']")
	private WebElement purchaseRadioButton ;
	
	@FindBy(xpath = "//div[@id='purchase_timeframe']/div/div[3]/label/div")
	private WebElement stillLookingRadioButton ;
	
	@FindBy(xpath = "//select[@id='occupancy']")
	private WebElement occupancyDropDown ;  ;
	
	@FindBy(xpath = "//select[@id='propertytype']")
	private WebElement propertytypeDropDown ;
	
	@FindBy(xpath = "//input[@id='homeprice']")
	private WebElement purchasePrice  ;
	
	@FindBy(xpath = "//input[@id='downpayment']")
	private WebElement downpayment ;
	
	@FindBy(xpath = "//input[@id='loanAmount']")
	private WebElement loanAmount  ;
	
	@FindBy(xpath = "//div[@id='primaryres']/div/div[2]/label[1]/div")
	private WebElement  currentPropertyInfo;
	
	@FindBy(xpath = "//div[@id='maritalstatus']/div/div[1]/label/div[@class='control__indicator']")
	private WebElement maritualStatus ;
	
	@FindBy(xpath = "//input[@id='subpropaddzip']")
	private WebElement zipCode ;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li[1]/div")
	private WebElement zipcodeList;
	
	@FindBy(xpath = "//input[@id='homeassociation']")
	private WebElement associationFee ;
	
	@FindBy(xpath = "//div[@id='consent']/div/div[1]/label[1]/div")
	private WebElement consentCheckbox;
	
	@FindBy(xpath = "//button[@id='submit-btn' and text()='Next']")
	private WebElement nextbutton ;
	
	public MortgageEligibilitypage() {
		PageFactory.initElements(driver, this);
	}
	
	public void MortgageForm (String EnterZipcode, String EnterPurchasePrice ) {
		driver.switchTo().frame("_STEARNS_FRAME");
		Utils.waitForElementToBeclickable(purchaseRadioButton);
		purchaseRadioButton.click();
		Utils.waitForElementToBeclickable(stillLookingRadioButton);
		stillLookingRadioButton.click();
		Utils.selectFromDropdown(occupancyDropDown, "Primary Residence");
		Utils.selectFromDropdown(propertytypeDropDown, "Single Family Residence Detached");
		
		Utils.waitForPresenceOfEelement(zipCode, 35);
		zipCode.click();
		zipCode.sendKeys(EnterZipcode);
		
		zipcodeList.click();
		
		Utils.waitForPresenceOfEelement(purchasePrice, 35);
	//	purchasePrice.click();
		purchasePrice.sendKeys(EnterPurchasePrice);
		
		Utils.waitForElementToBeclickable(currentPropertyInfo);
		currentPropertyInfo.click();
		Utils.waitForPresenceOfEelement(associationFee, 20);
		associationFee.sendKeys("100");
		//GenericUtils.waitForPageLoad();
		
		// jse.executeScript("window.scrollBy(0,950)");
	
		//actions.moveToElement(maritualStatus).perform();
		//Utils.waitforvisibilityofelement(maritualStatus);
		//GenericUtils.waitForPageLoad();
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("it is enables $$$$$$ " +maritualStatus.isSelected());
		
		//  jse.executeScript("window.scrollTo(0", maritualStatus.getLocation().x+")");
		 
		  Utils.waitforvisibilityofelement(maritualStatus);
		
		maritualStatus.click();
		
		consentCheckbox.click();;
		Utils.waitForElementToBeclickable(nextbutton);
		nextbutton.click();
		
		
	}
	
	

}
