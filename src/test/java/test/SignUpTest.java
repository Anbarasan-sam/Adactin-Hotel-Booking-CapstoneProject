package test;

import org.testng.annotations.Test;
import base.ProjectSpecificationMethods;
import pages.HomePage;
import utils.UtilsClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

 public class SignUpTest extends ProjectSpecificationMethods {

	private HomePage homePage;
	
	@BeforeMethod(groups="SignUp")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
        
	}
	@Test(groups="SignUp")
	public void testNewUserRegisterVisibility() {
		Assert.assertTrue(homePage.isNewUserRigisterVisible(), "New user rigister is not visible.");
	}
	
	@Test(groups="SignUp")
	public void testNewUserRegisterClickability() {
		Assert.assertTrue(homePage.isNewUserRigisterClickable(), "New user rigister is not Clickable.");
	}
	
	@Test(groups="SignUp")
	public void testRedirectToRigisterPage() {
		homePage.clickNewUserRegister();
		Assert.assertTrue(driver.getCurrentUrl().contains("Register.php"), "Redirects to wrong page.");
	}
}
