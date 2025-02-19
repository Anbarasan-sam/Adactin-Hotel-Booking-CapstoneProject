package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;
import pages.SelectHotelPage;

public class SelectHotelTest extends ProjectSpecificationMethods {
    private HomePage homePage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;

    @BeforeMethod(groups="Select Hotel")
    public void setUp() {
       

        homePage = new HomePage(driver);
        searchHotelPage = new SearchHotelPage(driver);
        selectHotelPage = new SelectHotelPage(driver);

        homePage.userNameAndPassword("AnbarasanTest", "guvi123");
        homePage.clickLoginButton();

        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.selectHotel("Hotel Creek");
        searchHotelPage.selectRoomType("Deluxe");
        searchHotelPage.selectNumberOfRooms("2");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();
    }
    @Test(priority = 1,groups="Select Hotel")
    public void verifyInvalidHotelSelection() {
        selectHotelPage.clickContinue();
        Assert.assertTrue(selectHotelPage.iserrorMessageDisplay(), "Error message is not displayed");
    }
    @Test(priority = 2,groups="Select Hotel")
    public void testRedirectsToBookingPage() {
    	 selectHotelPage.clickContinue();
    	selectHotelPage.selectFirstHotel();
    	selectHotelPage.clickContinue();
    	
    	Assert.assertTrue(driver.getCurrentUrl().contains("BookHotel.php"), "Redirects to wrong page.");
    }
}