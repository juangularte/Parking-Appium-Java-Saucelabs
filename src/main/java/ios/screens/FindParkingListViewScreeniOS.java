package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class FindParkingListViewScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public FindParkingListViewScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //LOADER
    By loader = (AppiumBy.accessibilityId("In progress"));
    
    //LIST VIEW
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By list_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"List View\"`]"));
    By list_scrollable = (AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
    By list_entrance_time_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"][1]"));
    By list_exit_time_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"][1]"));
    By list_entrance_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"][1]/parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeTextField"));
    By list_exit_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"][1]/parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeTextField"));
    By list_select_vehicle_size_label = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"SELECT VEHICLE SIZE\"`][1]"));
    By list_vehicle_size_info_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"i\"`][1]"));
    By list_show_rates = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Show rates from standard size vehicles.\"`][1]"));
    By list_standard_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"STANDARD\"`][1]"));
    By list_oversize_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"OVERSIZE\"`][1]"));
    By list_parking_lots_cards = (AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
    By list_first_parking_lot = (AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]"));
    // By list_parking_lot_name = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"ENTRANCE: \"]/preceding-sibling::XCUIElementTypeStaticText[not(contains(@value,'BOOK PARKING'))]"));
    By list_parking_lot_name = (AppiumBy.xpath(".//XCUIElementTypeStaticText[not(contains(@value,'BOOK PARKING'))][1]"));
    By list_parking_lot_price = (AppiumBy.xpath(".//XCUIElementTypeStaticText[starts-with(@name,'$')]"));
    By list_parking_lot_entrance_label = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"ENTRANCE: \"]"));
    By list_parking_lot_address = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"ENTRANCE: \"]/following-sibling::XCUIElementTypeStaticText"));
    By list_parking_lot_view_button = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"VIEW\"]"));
    By list_parking_lot_book_parking_button = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"BOOK PARKING\"]"));


    //LIST METHODS

    public void checkUserIsInListView() {
        
        assert_element_is_displayed(back_button);
        assert_text(list_title, "List View");
        log.info("LIST VIEW SCREEN");
    }

    public void assertBasicElements() {
        checkUserIsInListView();
        assert_element_is_displayed(list_entrance_time_label);
        assert_element_is_displayed(list_exit_time_label);
        assert_text(list_select_vehicle_size_label, "SELECT VEHICLE SIZE");
        assert_text(list_vehicle_size_info_button, "i");
        // assert_element_is_displayed(list_vehicle_size_info_button);
        assert_text(list_show_rates, "Show rates from standard size vehicles.");
        assert_text(list_standard_button, "STANDARD");
        assert_text(list_oversize_button, "OVERSIZE");
        log.info("Basic elements are displayed.");
    }

    public WebElement checkLocationSearchedIsTheFirstResult(String location) {
        assertBasicElements();
        WebElement first_result = find(list_first_parking_lot);
        String first_result_name = first_result.findElement(list_parking_lot_name).getText();
        Assert.assertEquals(first_result_name, location);
        // swipeElementUp(list_scrollable, 1500);
        log.info("Location searched is the first result of the list.");
        return first_result;
    }

    public String[] clickBookParkingForTheLocationSearched(String location) {
        WebElement first_result = checkLocationSearchedIsTheFirstResult(location);
        String name = first_result.findElement(list_parking_lot_name).getText();
        String address = first_result.findElement(list_parking_lot_address).getText();
        String price = first_result.findElement(list_parking_lot_price).getText();
        first_result.findElement(list_parking_lot_book_parking_button).click();
        log.info("Book Parking button of the location searched was clicked.");
        return new String[] {name, address, price};
    }

    public String[] clickViewForTheLocationSearched(String location) {
        WebElement first_result = checkLocationSearchedIsTheFirstResult(location);
        String name = first_result.findElement(list_parking_lot_name).getText();
        String address = first_result.findElement(list_parking_lot_address).getText();
        String price = first_result.findElement(list_parking_lot_price).getText();
        first_result.findElement(list_parking_lot_view_button).click();
        log.info("View button of the location searched was clicked.");
        return new String[] {name, address, price};
    }

    public String[] clickViewForTheEventLocationSearched(String location) {
        WebElement first_result = checkLocationSearchedIsTheFirstResult(location);
        String name = first_result.findElement(list_parking_lot_name).getText();
        String address = first_result.findElement(list_parking_lot_address).getText();
        first_result.findElement(list_parking_lot_view_button).click();
        waitForElementToBeVisible(loader,(long)5);
        log.info("View button of the location searched was clicked.");
        return new String[] {name, address};
    }
}
