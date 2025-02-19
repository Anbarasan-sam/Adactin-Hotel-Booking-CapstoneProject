package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.MyItineraryPage;
import utils.UtilsClass;

public class MyItineraryTest extends ProjectSpecificationMethods {

	private HomePage homePage;
	private MyItineraryPage itineraryPage;

	@BeforeMethod(groups="MyItinerary")
	public void setUp() {
		
		homePage = new HomePage(UtilsClass.driver);
		itineraryPage = new MyItineraryPage(UtilsClass.driver);

		homePage.userNameAndPassword("AnbarasanTest", "guvi123");
		homePage.clickLoginButton();
	}

	@Test(priority = 1,groups="MyItinerary")
	public void testRedirectsToBookedItineraryPage() {
		itineraryPage.clickMyItineraryButton();
		Assert.assertEquals(itineraryPage.getPageName(), "Booked Itinerary", "Redirects to wrong page.");
	}

	@Test(priority = 2,groups="MyItinerary")
	public void testCancleBookingByCheckBox() {
		itineraryPage.clickMyItineraryButton();
		itineraryPage.clickFirstCeckBox();
		itineraryPage.clickCancleSelected();
		driver.switchTo().alert().accept();

		Assert.assertTrue(itineraryPage.getBookingCancleMessage(), "Booking cancled message is not displayed.");
	}
}