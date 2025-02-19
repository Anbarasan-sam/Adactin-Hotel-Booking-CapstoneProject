package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;
import pages.SearchHotelPage;
import utils.UtilsClass;

public class SearchHotelTest extends ProjectSpecificationMethods {

	private HomePage homePage;
    private SearchHotelPage searchHotelPage;

    @BeforeMethod(groups="Search Hotel")
    public void setUp() {
        homePage = new HomePage(UtilsClass.driver);
        searchHotelPage = new SearchHotelPage(UtilsClass.driver);

        homePage.userNameAndPassword("AnbarasanTest", "guvi123");
        homePage.clickLoginButton();
    }

    @Test(priority=4,groups="Search Hotel")
    public void testSearchWithAllFields() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.selectHotel("Hotel Creek");
        searchHotelPage.selectRoomType("Deluxe");
        searchHotelPage.selectNumberOfRooms("2");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.selectChildrenPerRoom("1");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"), "Search with all fields failed.");
    }

    @Test(priority=3,groups="Search Hotel")
    public void testSearchWithMandatoryFieldsOnly() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"), "Search with mandatory fields failed.");
    }

    @Test(priority=2)
    public void testInvalidDates() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-30");
        searchHotelPage.enterCheckOutDate("2025-01-25");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickSearch();

        Assert.assertTrue(driver.getPageSource().contains("Select Hotel"),
                "Expected to navigate to 'Select Hotel' page, but failed.");
    }

    @Test(priority=1,groups="Search Hotel")
    public void testResetButton() {
        searchHotelPage.selectLocation("Sydney");
        searchHotelPage.enterCheckInDate("2025-01-25");
        searchHotelPage.enterCheckOutDate("2025-01-30");
        searchHotelPage.selectAdultsPerRoom("2");
        searchHotelPage.clickReset();

        Assert.assertTrue(searchHotelPage.areFieldsCleared(), "Reset button failed to clear fields.");
    }
}
