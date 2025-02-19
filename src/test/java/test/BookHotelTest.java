package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.BookHotelPage;
import pages.HomePage;
import pages.SearchHotelPage;
import pages.SelectHotelPage;
import utils.UtilsClass;

public class BookHotelTest extends ProjectSpecificationMethods{

    private HomePage homePage;
    private SearchHotelPage searchHotelPage;
    private SelectHotelPage selectHotelPage;
    private BookHotelPage bookHotelPage;

    @BeforeMethod(groups="Book Hotel")
    public void setUp() {
        homePage = new HomePage(UtilsClass.driver);
        searchHotelPage = new SearchHotelPage(UtilsClass.driver);
        selectHotelPage = new SelectHotelPage(UtilsClass.driver);
        bookHotelPage = new BookHotelPage(UtilsClass.driver);

        homePage.userNameAndPassword("AnbarasanTest", "guvi123");
        homePage.clickLoginButton();

        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.selectHotel("Hotel Creek");
        searchHotelPage.selectRoomType("Deluxe");
        searchHotelPage.selectNumberOfRooms("2");
        searchHotelPage.enterCheckInDate("25/03/2025");
        searchHotelPage.enterCheckOutDate("25/03/2025");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();

        selectHotelPage.selectFirstHotel();
        selectHotelPage.clickContinue();
    }

    @Test(priority = 1,groups="Book Hotel")
    public void testBookingWithoutMandatoryFields() {
        bookHotelPage.clickBookNow();

        Assert.assertTrue(bookHotelPage.isFirstNameErrorDisplayed(), "First Name error should be displayed.");
        Assert.assertTrue(bookHotelPage.isCreditCardErrorDisplayed(), "Credit Card error should be displayed.");
    }

    @Test(priority = 2,groups="Book Hotel")
    public void testBookingWithValidData() throws InterruptedException {
    	
    	 bookHotelPage.clickBookNow();
    	
        String hotelName = bookHotelPage.getHotelName();
        String roomType = bookHotelPage.getRoomType();
        String pricePerNight = bookHotelPage.getPricePerNight();

        Assert.assertEquals(hotelName, "Hotel Creek", "Hotel name mismatch!");
        Assert.assertEquals(roomType, "Deluxe", "Room type mismatch!");
        Assert.assertTrue(pricePerNight.startsWith("AUD"), "Price mismatch! Expected AUD currency but found: " + pricePerNight);

        bookHotelPage.enterFirstName("John");
        bookHotelPage.enterLastName("Doe");
        bookHotelPage.enterAddress("123 Test Street, Sydney");
        bookHotelPage.enterCreditCardDetails("6598325698745612", "VISA", "March", "2030", "123");
        bookHotelPage.clickBookNow();
        
        Thread.sleep(6000);
        Assert.assertEquals(bookHotelPage.getConfirmationMessage(), "Booking Confirmation", "Incorrect confirmation message.");
    }
}
