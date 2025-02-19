package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilsClass;

public class LoginPage extends UtilsClass{
	
	@FindBy(id="username_show")
	private WebElement welcomeUserText;
	
	public LoginPage(WebDriver driver) {
		UtilsClass.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isWelcomeUesrTextVisible() {
		waitForElementVisible(welcomeUserText, 10);
		return welcomeUserText.isDisplayed();
	}
	

}
