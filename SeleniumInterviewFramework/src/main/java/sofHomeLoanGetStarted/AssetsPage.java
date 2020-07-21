package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class AssetsPage {
	
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	@FindBy(xpath = "//button[@id='b1b2assetoptions_id_2']")
	private WebElement addAssetsManually ;
	
	@FindBy(xpath = "//select[@id='b1_newasset_id']")
	private WebElement selectAssetType ;
	
	@FindBy(xpath = "//select[@id='b1_csaccountsasset_accounttype_8']")
	private WebElement accountType;
	
	@FindBy(xpath = "//input[@id='b1_csaccountsasset_accountbalance_8']")
	private WebElement accountBalance;
	
	@FindBy(xpath = "//input[@id='b1_csaccountsasset_financialinstitutionname_8']")
	private WebElement financialInstitutionName ;
	
	@FindBy(xpath = "//input[@id='b1_csaccountsasset_accountnumber_8']")
	private WebElement accountNumber ;
	
	public AssetsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Assetsinfo (String givebalance ,String financialname, String giveAccountNumber) {
		addAssetsManually.click();
		Utils.selectFromDropdown(selectAssetType, "Checking and Saving Accounts");
		Utils.selectFromDropdown(accountType, "Checking");
		accountBalance.sendKeys(givebalance);
		financialInstitutionName.sendKeys(financialname);
		accountNumber.sendKeys(giveAccountNumber);
	}

}
