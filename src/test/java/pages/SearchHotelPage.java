package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilsClass;

import java.util.List;

public class SearchHotelPage extends UtilsClass {

    @FindBy(id = "location")
    private WebElement locationDropdown;

    @FindBy(xpath = "//select[@id='location']/option")
    private List<WebElement> locationOptions;

    @FindBy(id = "hotels")
    private WebElement hotelsDropdown;

    @FindBy(xpath = "//select[@id='hotels']/option")
    private List<WebElement> hotelOptions;

    @FindBy(id = "room_type")
    private WebElement roomTypeDropdown;

    @FindBy(xpath = "//select[@id='room_type']/option")
    private List<WebElement> roomTypeOptions;

    @FindBy(id = "room_nos")
    private WebElement numberOfRoomsDropdown;

    @FindBy(id = "datepick_in")
    private WebElement checkInDateField;

    @FindBy(id = "datepick_out")
    private WebElement checkOutDateField;

    @FindBy(id = "adult_room")
    private WebElement adultsPerRoomDropdown;

    @FindBy(id = "child_room")
    private WebElement childrenPerRoomDropdown;

    @FindBy(id = "Submit")
    private WebElement searchButton;

    @FindBy(id = "Reset")
    private WebElement resetButton;

    public SearchHotelPage(WebDriver driver) {
        UtilsClass.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to select an option from a dropdown by text
    public SearchHotelPage selectDropdownOption(WebElement dropdown, List<WebElement> options, String value) {
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                break;
            }
        }
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectLocation(String location) {
    	waitForElementVisible(locationDropdown, 10);
        selectDropdownOption(locationDropdown, locationOptions, location);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectHotel(String hotel) {
        selectDropdownOption(hotelsDropdown, hotelOptions, hotel);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectRoomType(String roomType) {
        selectDropdownOption(roomTypeDropdown, roomTypeOptions, roomType);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectNumberOfRooms(String numberOfRooms) {
        numberOfRoomsDropdown.sendKeys(numberOfRooms);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage enterCheckInDate(String checkInDate) {
        checkInDateField.clear();
        checkInDateField.sendKeys(checkInDate);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage enterCheckOutDate(String checkOutDate) {
        checkOutDateField.clear();
        checkOutDateField.sendKeys(checkOutDate);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectAdultsPerRoom(String adults) {
        adultsPerRoomDropdown.sendKeys(adults);
        return new SearchHotelPage(driver);
    }

    public SearchHotelPage selectChildrenPerRoom(String children) {
        childrenPerRoomDropdown.sendKeys(children);
        return new SearchHotelPage(driver);
    }

    public SelectHotelPage clickSearch() {
        searchButton.click();
        return new SelectHotelPage(driver);
    }

    public SearchHotelPage clickReset() {
        resetButton.click();
        return new SearchHotelPage(driver);
    }

    public boolean areFieldsCleared() {
        return checkInDateField.getText().isEmpty() && checkOutDateField.getText().isEmpty();
    }
}
