package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class ViewLotDetailsScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public ViewLotDetailsScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //LOADER
    By loader = (AppiumBy.accessibilityId("In progress"));

    //SCROLLABLE
    By scrollable = (AppiumBy.xpath("//XCUIElementTypeScrollView"));

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By title = (AppiumBy.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText"));

    //LOT DETAILS
    By parking_entrance_label = (AppiumBy.accessibilityId("PARKING ENTRANCE"));
    By parking_entrance_address = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/following-sibling::XCUIElementTypeStaticText[1]"));
    By parking_distance = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'less than')]"));
    By parking_get_directions = (AppiumBy.accessibilityId("GET DIRECTIONS"));
    By parking_current_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'$')][1]"));

    //PRINTED/MOBILE PASS
    // By printed_pass_required_icon = (AppiumBy.xpath("//*[@text='PRINTED PASS REQUIRED']/preceding-sibling::android.widget.ImageView[@resource-id='com.spplus.parking.develop:id/icon']"));
    By printed_pass_required_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[1]"));
    By printed_pass_required_desc = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[2]"));
    By mobile_pass_accepted_icon = (AppiumBy.xpath("//*[@text='MOBILE PASS ACCEPTED']/preceding-sibling::android.widget.ImageView[@resource-id='com.spplus.parking.develop:id/icon']"));
    By mobile_pass_accepted_label = (AppiumBy.xpath("//*[@text='MOBILE PASS ACCEPTED']"));
    By mobile_pass_accepted_desc = (AppiumBy.xpath("//*[@text='MOBILE PASS ACCEPTED']/following-sibling::android.widget.TextView"));

    //UPCOMING EVENT PARKING
    By upcoming_event_parking = (AppiumBy.accessibilityId("UPCOMING EVENT PARKING"));
    By view_all_upcoming_event_parking = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"View All\"]"));
    // By calendar_icon = (AppiumBy.xpath("com.spplus.parking.develop:id/date"));
    By calendar_icon_month = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[1]"));
    By calendar_icon_day_number = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[2]"));
    By calendar_icon_day_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[3]"));
    By upcoming_event_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[5]"));
    By upcoming_event_location = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[4]"));
    By upcoming_event_date = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[7]"));
    // By upcoming_event_time = (AppiumBy.xpath("com.spplus.parking.develop:id/garageDetailEventModalItemTimeTextView"));
    By upcoming_event_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[6]"));
    By upcoming_event_book_parking = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPCOMING EVENT PARKING\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTable/XCUIElementTypeCell//XCUIElementTypeStaticText[@name=\"BOOK PARKING\"]"));


    //SELECT RATE
    By select_rate_section = (AppiumBy.accessibilityId("SELECT RATE"));
    By drive_up_rates_apply_label = (AppiumBy.accessibilityId("Drive-up Rates Apply"));
    //TODO
    By time_rates_box = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='SELECT RATE']/following-sibling::XCUIElementTypeCell"));
    By select_rate_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='SELECT RATE']/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[1]"));
    By select_rate_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='SELECT RATE']/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText[contains(@name,'$')]"));

    //DATE AND TIME
    By entrance_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"][1]"));
    By exit_label= (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"][1]"));
    By entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"][1]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"][1]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));

    //BOOK PARKING
    By book_parking_button = (AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"BOOK PARKING\"])[1]"));

    //SPECIAL RATES AND ACCESS CODE
    By special_rates_section = (AppiumBy.accessibilityId("Looking for special rates?"));
    By special_rates_access_code_clickable_area = (AppiumBy.accessibilityId("Have an access code?"));
    // By special_rates_label = (AppiumBy.xpath("com.spplus.parking.develop:id/specialRatesLabel"));
    // By access_code_label = (AppiumBy.xpath("com.spplus.parking.develop:id/accessCodeLabel"));
    By remove_access_code = (AppiumBy.accessibilityId("X Remove"));

    //ACCESS CODE MODAL
    By enter_access_code_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Enter Access Code\"]"));
    By enter_access_code_desc = (AppiumBy.accessibilityId("Enter your access code to see your special rates."));
    By enter_access_code_input = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Enter your access code to see your special rates.']/following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField"));
    By enter_access_code_skip = (AppiumBy.accessibilityId("Skip"));
    By enter_access_code_enter = (AppiumBy.accessibilityId("Enter Code"));

    //RATE APP
    By rate_modal_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[starts-with(@name,'Enjoying')]"));
    By rate_modal_subtitle = (AppiumBy.accessibilityId("Tap a star to rate it on the App Store."));
    By not_now = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Not Now\"]"));

    //DAILY DRIVE UP RATES
    By daily_drive_up_rates_label = (AppiumBy.xpath("com.spplus.parking.develop:id/driveUpEventRatesTitle"));
    By drive_up_rates_time = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/driveUpEventRates']//*[@resource-id='com.spplus.parking.develop:id/time']"));
    By drive_up_rates_price = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/driveUpEventRates']//*[@resource-id='com.spplus.parking.develop:id/price']"));

    //MONTHLY PARKING
    By monthly_parking_section = (AppiumBy.accessibilityId("MONTHLY PARKING"));
    By monthly_parking_description = (AppiumBy.xpath("com.spplus.parking.develop:id/monthlyParkingDescTextView"));
    By monthly_rate_name = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/monthlyRates']//*[@resource-id='com.spplus.parking.develop:id/monthlyRateName']"));
    By monthly_rate_price = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/monthlyRates']//*[@resource-id='com.spplus.parking.develop:id/monthlyRatePrice']"));
    By monthly_parking_view_more_details_button = (AppiumBy.xpath("com.spplus.parking.develop:id/monthlyParkingActionButton"));
    By monthly_parking_view_more_details_desc = (AppiumBy.xpath("com.spplus.parking.develop:id/monthlyParkingActionDescTextView"));

    //AMENITIES
    By amenities_section = (AppiumBy.xpath("//*[@text='AMENITIES']"));
    By marked_as_parked = (AppiumBy.xpath("com.spplus.parking.develop:id/parkLabel"));

    //HOURS OF OPERATION
    By clock_icon = (AppiumBy.xpath("com.spplus.parking.develop:id/hourOfOperationIcon"));
    By hours_of_operation_label = (AppiumBy.xpath("com.spplus.parking.develop:id/hourOfOperationTitle"));
    By hours_of_operation_desc = (AppiumBy.xpath("com.spplus.parking.develop:id/hourOfOperationSubtitle"));

    //PAYMENT ACCEPTED
    By cc_icon = (AppiumBy.xpath("com.spplus.parking.develop:id/paymentIcon"));
    By payment_accepted_label = (AppiumBy.xpath("com.spplus.parking.develop:id/paymentIcon"));

    //SERVICES
    By valet_icon = (AppiumBy.xpath("com.spplus.parking.develop:id/valetIcon"));
    By service_type_label = (AppiumBy.xpath("com.spplus.parking.develop:id/valetTitle"));

    //ADDITIONAL AMENITIES
    By additional_amenities = (AppiumBy.xpath("com.spplus.parking.develop:id/additionalAmenitiesTitle"));
    By accessible_label = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Accessible']"));
    By accessible_icon = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Accessible']/preceding-sibling::android.widget.ImageView"));
    By hours24_label = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='24 Hours']"));
    By hours24_icon = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='24 Hours']/preceding-sibling::android.widget.ImageView"));
    By height_restriction_label = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Height Restriction: 6'8\"']"));
    By height_restriction_icon = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Height Restriction: 6'8\"']/preceding-sibling::android.widget.ImageView"));
    By vehicle_Service_label = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Vehicle Escort Service,Battery Jump/Tire Inflation']"));
    By vehicle_Service_icon = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Vehicle Escort Service,Battery Jump/Tire Inflation']/preceding-sibling::android.widget.ImageView"));

    //MORE INFORMATION
    By looking_for_more_info = (AppiumBy.xpath("com.spplus.parking.develop:id/lookingForMoreInformationTextView"));
    By talk_to_garage = (AppiumBy.xpath("com.spplus.parking.develop:id/talkToGarageButton"));

    //ABOUT LOCATION
    By about_location_label = (AppiumBy.xpath("com.spplus.parking.develop:id/aboutLocationTitle"));
    By operated_by = (AppiumBy.xpath("com.spplus.parking.develop:id/aboutLocationEmpty"));


    public void assertUserIsOnViewDetailsScreen(String lot_name_value) {
        waitUntilFinishLoading();
        assert_text(title, lot_name_value);
        log.info("LOT DETAILS SCREEN");
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loader, (long) 5);
            log.info("Loading Lot Details…");
            waitForElementToDisappear(loading_element, (long) 20);
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
    }

    public void assertLotDetails(String location, String price) {
        assert_text(parking_entrance_label, "PARKING ENTRANCE");
        assert_contains_text(parking_entrance_address, location);   
        assert_text(parking_current_price, price);
        assert_text(parking_get_directions, "GET DIRECTIONS");
        log.info("Lot details were asserted correctly.");
    }

    public void assertEventLotDetails(String location) {
        assert_text(parking_entrance_label, "PARKING ENTRANCE");
        assert_contains_text(parking_entrance_address, location);
        assert_text(parking_get_directions, "GET DIRECTIONS");
        log.info("Lot details were asserted correctly.");
    }

    public void assertEntranceExitDateTime(String[] dateTimeValues){
        // scrollDownToText("ENTRANCE TIME");
        assert_text(entrance_label, "ENTRANCE TIME");
        assert_text(exit_label, "EXIT TIME");
        assert_text(entrance_date_time, dateTimeValues[0]);
        assert_text(exit_date_time, dateTimeValues[1]);
        log.info("Entrance and exit dates and times are correct.");
    }

    public void basicAssertions(String lot_name_value, String location, String price, String[] dateTimeValues) {
        assertUserIsOnViewDetailsScreen(lot_name_value);
        assertLotDetails(location, price);
        assertEntranceExitDateTime(dateTimeValues);
    }

    public void basicAssertionsForEventParking(String lot_name_value, String location) {
        assertUserIsOnViewDetailsScreen(lot_name_value);
        assertEventLotDetails(location);
    }

    public void checkIfParkingLotHasRates(String price){

        if(check_if_element_is_present(select_rate_section).equals(false)){
            assert_element_is_displayed(select_rate_time);
            assert_text(select_rate_price, price);
            log.info("Rates: "+text(select_rate_time)+" - "+select_rate_price);
        }
    }

    public Boolean checkIfTheParkingLotHasSpecialRates() {
        
        if(check_if_element_is_present(special_rates_section).equals(true)){
            assert_text(special_rates_section, "Looking for special rates?");
            assert_text(special_rates_access_code_clickable_area, "Have an access code?");
            return true;
        }else{
            return false;
        }
    }

    public void clickOnAccessCodeArea() {
        // scrollDownToText("Have an access code?");
        if(check_if_element_is_present(special_rates_access_code_clickable_area).equals(false)){
            swipeElementUp(scrollable, 1500);
        }
        click(special_rates_access_code_clickable_area);
        log.info("Access Code area was clicked.");
    }

    public void checkAccessCodeModalIsDisplayed() {
        assert_element_is_displayed(enter_access_code_title);
        assert_text(enter_access_code_title, "Enter Access Code");
        assert_text(enter_access_code_desc, "Enter your access code to see your special rates.");
        assert_text(enter_access_code_input, "Enter Access Code");
        assert_text(enter_access_code_skip, "Skip");
        assert_text(enter_access_code_enter, "Enter Code");
        log.info("Access Code modal is displayed.");
    }

    public void enterAccessCode(String access_code) {
        checkAccessCodeModalIsDisplayed();
        type(enter_access_code_input, access_code);
        log.info("Access code entered: "+access_code);
        click(enter_access_code_enter);
        log.info("ENTER CODE button was clicked.");
    }

    public void checkIfRateModalAppears() {
        try {
            waitForElementToBeVisible(rate_modal_title, (long) 5);
            log.info("Rate modal is displayed.");
            assert_text(rate_modal_subtitle, "Tap a star to rate it on the App Store.");
            click(not_now);
            log.info("Rate App modal was displayed. Not Now button was clicked.");
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
    }

    public String checkDiscountWasApplied() {
        assert_text(remove_access_code, "X Remove");
        scrollUpToText("PARKING ENTRANCE");
        assert_text(parking_current_price, "$0.00");
        assert_text(select_rate_price, "$0.00");
        String new_price = text(parking_current_price);
        log.info("Access code discount was applied.");
        return new_price;
    }

    public void clickOnBookParking() {
        click(book_parking_button);
        log.info("Book Parking was clicked.");
    }

    public String enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(String location, String price, String[] dateTimeValues, String access_code){

        String new_price = new String();
        basicAssertions(location, location, price, dateTimeValues);
        checkIfParkingLotHasRates(price);
        if(checkIfTheParkingLotHasSpecialRates().equals(true)){
            clickOnAccessCodeArea();
            enterAccessCode(access_code);
            checkIfRateModalAppears();
            new_price = checkDiscountWasApplied();
            clickOnBookParking();
        }
        return new_price;
    }


    //EVENT METHODS

    public void assertEventParkingIsAvailable() {
        //TODO: Add event assertions
        assert_element_is_displayed(upcoming_event_book_parking);
        log.info("Event parking is available for the lot selected.");
    }

    public String[] getUpcomingEventParkingDetails() {
        
        String event_name = text(upcoming_event_name);
        log.info("Event name: "+event_name);
        String event_location = text(upcoming_event_location);
        log.info("Event location: "+event_location);
        String event_price = text(upcoming_event_price);
        log.info("Event price: "+event_price);
        String event_date_time = text(upcoming_event_date);
        log.info("Event date: "+event_date_time);
        // String event_time = text(upcoming_event_time);
        // log.info("Event time: "+event_time);

        log.info("All the event information was gather correctly.");

        return new String[] {event_name, event_location, event_price, event_date_time};
    }

    public void clickOnBookParkingForUpcomingEvent() {
        click(upcoming_event_book_parking);
        log.info("Book Parking button for upcoming event was clicked.");
    }

    public void clickOnViewAll() {
        click(view_all_upcoming_event_parking);
        log.info("View All button for upcoming events was clicked.");
    }

    public void assertEventIsAvailableAndClickViewAll(String location, String lot_address) {
        basicAssertionsForEventParking(location, lot_address.replace("ENTRANCE  ", ""));
        assertEventParkingIsAvailable();
        // String[] event_details = getUpcomingEventParkingDetails();
        clickOnViewAll();
    }

    public String assertUpcomingEventIsAvailableAndClickBookParking(String location, String address) {
        basicAssertionsForEventParking(location, address);
        assertEventParkingIsAvailable();
        String[] event_details = getUpcomingEventParkingDetails();
        clickOnBookParkingForUpcomingEvent();
        return event_details[2];
    }

}