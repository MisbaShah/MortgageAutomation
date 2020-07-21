package sofHomeLoanGetStarted;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sofi.driver.DriverManager;
import com.sofi.utils.GenericUtils;

public class GetStartedPage {
	
	WebDriver driver = DriverManager.GerDriver();
	GenericUtils Utils= new GenericUtils();
	
	
	
	@FindBy(xpath = "//div[@href='https://www.sofi.com/b/landing/start/MORT?isNewApp=true']")
	private WebElement homeloantab ;
	
	@FindBy(xpath = "//button[text()='Start a new loan application instead']")
	private WebElement startNewAppicationButton ;
	
	@FindBy(xpath = "//input[@class='selection ng-untouched ng-pristine ng-valid']")
	private WebElement dobfield ;
	
	@FindBy(xpath = "//select[@id='citizenship']")
	private WebElement citizenshipfield ;
	
	@FindBy(xpath = "//*[@id='ownership']/div/div[1]/label/div[1]")
	private WebElement currentlivingArrangement ;
	
	@FindBy(xpath = "//input[@id='totalIncome']")
	private WebElement grossIncome;
	
	@FindBy(xpath = "//button[text()='Next']")
	private  WebElement nextbutton ;
	
	@FindBy(xpath = "//input[@id='apt']")
	public WebElement APT;
	
	@FindBy(xpath = "//a[@href=\"https://www.sofi.com/mortgage/sso/Prequal/Prequal/LD581259513\"]")
	private WebElement continueApplication ;
	
	
	public GetStartedPage () {
		PageFactory.initElements(driver, this);
		
	}
	public void HomeLoan() {
		System.out.println(" working @@@@@@@@@@");
		//Utils.waitForElementToBeclickable(homeloantab);
		//homeloantab.click();
		
		//startNewAppicationButton.click();
		
		 Utils.waitForElementToBeclickable(continueApplication);
		 continueApplication.click();
		 
			System.out.println("i clicked +++++++");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void DOB(String giveinput) {
		//driver.getCurrentUrl();
		//String expectedURL = "https://www.sofi.com/mortgage/sso/Prequal/Prequal";
		//Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
		//System.out.println("hello");
		
		//dobfield.isDisplayed();
	
		 //Utils.waitForPresenceOfEelement(dobfield, 50);
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver; js.
		 * executeScript("document.getElementByclass('selection ng-pristine ng-valid ng-touched').value='08/30/1996'"
		 * );
		 */
	driver.switchTo().frame("_STEARNS_FRAME");
		// driver.findElement(By.id("first_name")).click();
		   // driver.findElement(By.id("first_name")).sendKeys("test12311");
	
		 dobfield.click();
			dobfield.sendKeys(giveinput);
		 
		
		
	}
	
	public void SelectCitizenship(String inputIncome) {
		Utils.waitForPresenceOfEelement(citizenshipfield, 25);
		Utils.selectFromDropdown(citizenshipfield, "US Citizen ");
		Utils.waitForPresenceOfEelement(currentlivingArrangement, 20);
		currentlivingArrangement.click();
		Utils.waitForElementToBeclickable(grossIncome);
		grossIncome.sendKeys(inputIncome);
		Utils.waitForElementToBeclickable(nextbutton);
		
	}
	public void clicknext() {
		nextbutton.click();
}
}
