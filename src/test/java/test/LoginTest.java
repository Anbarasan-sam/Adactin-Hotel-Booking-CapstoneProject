package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LoginPage;
import utils.UtilsClass;

public class LoginTest extends ProjectSpecificationMethods{

	private HomePage homePage;
	private LoginPage loginPage;
	
	@BeforeMethod(groups="Login")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
		loginPage = new LoginPage(UtilsClass.driver);
	}
	@Test(groups="Login")
	public void testLoginButtonVisibility() {
		Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible.");
	}
	@Test(groups="Login")
	public void testLoginButtonClickability() {
		Assert.assertTrue(homePage.isLoginButtonClickable(), "Login button is not clickable.");
	}
	@Test(priority=1,groups="Login")
	public void testLoginWithInValidCridentials(){
		homePage.userNameAndPassword("AnbarasanTest","12345");
		homePage.clickLoginButton();
		Assert.assertTrue(homePage.errorMessage(),"Invalid login error not displayed.");
	}
	
	@Test(priority=2,groups="Login")
	public void testLoginWithValidCridentials(){
		homePage.userNameAndPassword("AnbarasanTest","guvi123");
		homePage.clickLoginButton();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("SearchHotel.php"), "Redirects to wrong page.");
		Assert.assertTrue(loginPage.isWelcomeUesrTextVisible(), "Welecome user text not shows.");
	}
}
