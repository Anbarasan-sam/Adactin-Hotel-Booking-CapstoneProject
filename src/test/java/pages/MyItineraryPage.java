package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;


public class MyItineraryPage extends UtilsClass {
	
	@FindBy(xpath="(//td[@class='welcome_menu']//a)[2]")
	private WebElement myItineraryButton;
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement pageName;
	
	@FindBy(id="(//tr//td)[28]")
	private WebElement cancleButtonInRow;
	
	@FindBy(xpath="(//input[@class='reg_button'])[1]")
	private WebElement cancleSelectedButton;

	@FindBy(xpath="(//tr//td)[26]")
	private WebElement firstCheckBox;
	
	@FindBy(id="search_result_error")
	private WebElement bookingCancleMessage;
	
	public MyItineraryPage(WebDriver driver) {
		UtilsClass.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MyItineraryPage clickMyItineraryButton() {
		waitForElementVisible(myItineraryButton, 10);
		myItineraryButton.isDisplayed();
		myItineraryButton.isEnabled();
		myItineraryButton.click();
		return new MyItineraryPage(driver);
	}
	
	public MyItineraryPage clickCancleButtonInRow() {
		waitForElementVisible(cancleButtonInRow, 10);
		cancleButtonInRow.isDisplayed();
		cancleButtonInRow.isEnabled();
		cancleButtonInRow.click();
		return new MyItineraryPage(driver);
	}
	
	public MyItineraryPage clickCancleSelected() {
		waitForElementVisible(cancleSelectedButton, 10);
		cancleSelectedButton.isDisplayed();
		cancleSelectedButton.isEnabled();
		cancleSelectedButton.click();
		return new MyItineraryPage(driver);
	}
	
	public MyItineraryPage clickFirstCeckBox() {
		waitForElementVisible(firstCheckBox, 10);
		firstCheckBox.isDisplayed();
		firstCheckBox.isEnabled();
		firstCheckBox.click();
		return new MyItineraryPage(driver);
	}
	
	public String getPageName() {
		waitForElementVisible(pageName, 10);
		return pageName.getText();
	}
	
	public boolean getBookingCancleMessage() {
		waitForElementVisible(bookingCancleMessage, 10);
		return bookingCancleMessage.isDisplayed();
	}
}
