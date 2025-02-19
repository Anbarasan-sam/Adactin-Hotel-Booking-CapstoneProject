package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.LogoutPage;

public class LogoutTest extends ProjectSpecificationMethods {
	
	private HomePage homePage;
	private LogoutPage logoutPage;
	
	@BeforeMethod(groups="Logout")
	public void setUp() {

		homePage = new HomePage(driver);
		logoutPage = new LogoutPage(driver);

		homePage.userNameAndPassword("AnbarasanTest", "guvi123");
		homePage.clickLoginButton();
	}
	@Test(groups="Logout")
	public void testVisibilityOfLogoutButton() {
		logoutPage.isLogoutButtonVisible();
		Assert.assertTrue(logoutPage.isLogoutButtonVisible(), "Logout button is not visible.");
    }

    @Test(priority = 2,groups="Logout")
    public void testLogoutRedirectsToLoginPage() {
    	
        logoutPage.clickLogoutButton();
        Assert.assertTrue(logoutPage.logoutMessageDisplay(), "Logout did not redirect to the login page.");
    }
}
