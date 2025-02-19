package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;

public class SelectHotelPage extends UtilsClass {

    @FindBy(id= "radiobutton_0")
    private WebElement firstHotel;

    @FindBy(id = "continue")
    private WebElement continueButton;
    
    @FindBy(id="radiobutton_span")
    private WebElement errorMessage;

    public SelectHotelPage(WebDriver driver) {
        UtilsClass.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public BookHotelPage clickContinue() {
        continueButton.click();
        return new BookHotelPage(driver);
    }
    
    public BookHotelPage selectFirstHotel() {
    	waitForElementVisible(firstHotel, 10);
        waitForElementClickable(firstHotel, 10);
    	firstHotel.click();
    	return new BookHotelPage(driver);
    }
    
    public boolean iserrorMessageDisplay() {
    	waitForElementVisible(errorMessage, 10);
    	return errorMessage.isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return continueButton.isEnabled();
    }
    
    
}
