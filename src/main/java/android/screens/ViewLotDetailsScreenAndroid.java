package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class ViewLotDetailsScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public ViewLotDetailsScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //LOADER
    By loading_lot_details = (By.xpath("//*[@resource-id='android:id/message'][@text='Loading Lot Details…']"));

    //HEADER
    By back_arrow = (By.id("com.spplus.parking.develop:id/backButton"));
    By title = (By.id("com.spplus.parking.develop:id/lotName"));

    //LOT DETAILS
    By parking_entrance_label = (By.id("com.spplus.parking.develop:id/entranceLabel"));
    By parking_entrance_address = (By.id("com.spplus.parking.develop:id/entrance"));
    By parking_distance = (By.id("com.spplus.parking.develop:id/distance"));
    By parking_get_directions = (By.id("com.spplus.parking.develop:id/getDirectionsLabel"));
    By parking_current_price = (By.id("com.spplus.parking.develop:id/currentPrice"));

    //PRINTED/MOBILE PASS
    By printed_pass_required_icon = (By.xpath("//*[@text='PRINTED PASS REQUIRED']/preceding-sibling::android.widget.ImageView[@resource-id='com.spplus.parking.develop:id/icon']"));
    By printed_pass_required_label = (By.xpath("//*[@text='PRINTED PASS REQUIRED']"));
    By printed_pass_required_desc = (By.xpath("//*[@text='PRINTED PASS REQUIRED']/following-sibling::android.widget.TextView"));
    By mobile_pass_accepted_icon = (By.xpath("//*[@text='MOBILE PASS ACCEPTED']/preceding-sibling::android.widget.ImageView[@resource-id='com.spplus.parking.develop:id/icon']"));
    By mobile_pass_accepted_label = (By.xpath("//*[@text='MOBILE PASS ACCEPTED']"));
    By mobile_pass_accepted_desc = (By.xpath("//*[@text='MOBILE PASS ACCEPTED']/following-sibling::android.widget.TextView"));

    //UPCOMING EVENT PARKING
    //TODO: Add event locators
    By upcoming_event_parking = (By.id("com.spplus.parking.develop:id/eventsTitle"));
    By view_all_upcoming_event_parking = (By.id("com.spplus.parking.develop:id/viewAll"));
    By calendar_icon = (By.id("com.spplus.parking.develop:id/date"));
    By calendar_icon_month = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemMonthTextView"));
    By calendar_icon_day_number = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemDayTextView"));
    By calendar_icon_day_name = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemDayStrTextView"));
    By upcoming_event_name = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemName"));
    By upcoming_event_location = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemSubname"));
    By upcoming_event_date = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemDateTextView"));
    By upcoming_event_time = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemTimeTextView"));
    By upcoming_event_price = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemPriceTextView"));
    By upcoming_event_book_parking = (By.id("com.spplus.parking.develop:id/garageDetailEventModalItemBookNowButton"));


    //SELECT RATE
    By select_rate_section = (By.id("com.spplus.parking.develop:id/quotesTitle"));
    By drive_up_rates_apply_label = (By.id("com.spplus.parking.develop:id/driveUpRatesApplyLabel"));
    By time_rates_box = (By.id("com.spplus.parking.develop:id/quotesRecyclerView"));
    By select_rate_time = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/quotesRecyclerView']//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));
    By select_rate_price = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/quotesRecyclerView']//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/price']"));

    //DATE AND TIME
    By entrance_label = (By.id("com.spplus.parking.develop:id/entranceTimeLabel"));
    By exit_label= (By.id("com.spplus.parking.develop:id/exitTimeLabel"));
    By entrance_date_time = (By.id("com.spplus.parking.develop:id/entranceTime"));
    By exit_date_time = (By.id("com.spplus.parking.develop:id/exitTime"));

    //BOOK PARKING
    By book_parking_button = (By.id("com.spplus.parking.develop:id/bookNowButton"));

    //SPECIAL RATES AND ACCESS CODE
    By special_rates_section = (By.id("com.spplus.parking.develop:id/lookingForSpecialRatesLayout"));
    By special_rates_access_code_clickable_area = (By.id("com.spplus.parking.develop:id/specialRatesBackground"));
    By special_rates_label = (By.id("com.spplus.parking.develop:id/specialRatesLabel"));
    By access_code_label = (By.id("com.spplus.parking.develop:id/accessCodeLabel"));
    By remove_access_code = (By.id("com.spplus.parking.develop:id/removeAccessCodeLabel"));

    //ACCESS CODE MODAL
    By enter_access_code_title = (By.xpath("//android.widget.TextView[@text='Enter Access Code']"));
    By enter_access_code_desc = (By.id("android:id/message"));
    By enter_access_code_input = (By.id("com.spplus.parking.develop:id/access_code_edit_text"));
    By enter_access_code_cancel = (By.id("android:id/button2"));
    By enter_access_code_enter = (By.id("android:id/button1"));

    //DAILY DRIVE UP RATES
    By daily_drive_up_rates_label = (By.id("com.spplus.parking.develop:id/driveUpEventRatesTitle"));
    By drive_up_rates_time = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/driveUpEventRates']//*[@resource-id='com.spplus.parking.develop:id/time']"));
    By drive_up_rates_price = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/driveUpEventRates']//*[@resource-id='com.spplus.parking.develop:id/price']"));

    //MONTHLY PARKING
    By monthly_parking_section = (By.xpath("//*[@text='MONTHLY PARKING']"));
    By monthly_parking_description = (By.id("com.spplus.parking.develop:id/monthlyParkingDescTextView"));
    By monthly_rate_name = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/monthlyRates']//*[@resource-id='com.spplus.parking.develop:id/monthlyRateName']"));
    By monthly_rate_price = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/monthlyRates']//*[@resource-id='com.spplus.parking.develop:id/monthlyRatePrice']"));
    By monthly_parking_view_more_details_button = (By.id("com.spplus.parking.develop:id/monthlyParkingActionButton"));
    By monthly_parking_view_more_details_desc = (By.id("com.spplus.parking.develop:id/monthlyParkingActionDescTextView"));

    //AMENITIES
    By amenities_section = (By.xpath("//*[@text='AMENITIES']"));
    By marked_as_parked = (By.id("com.spplus.parking.develop:id/parkLabel"));

    //HOURS OF OPERATION
    By clock_icon = (By.id("com.spplus.parking.develop:id/hourOfOperationIcon"));
    By hours_of_operation_label = (By.id("com.spplus.parking.develop:id/hourOfOperationTitle"));
    By hours_of_operation_desc = (By.id("com.spplus.parking.develop:id/hourOfOperationSubtitle"));

    //PAYMENT ACCEPTED
    By cc_icon = (By.id("com.spplus.parking.develop:id/paymentIcon"));
    By payment_accepted_label = (By.id("com.spplus.parking.develop:id/paymentIcon"));

    //SERVICES
    By valet_icon = (By.id("com.spplus.parking.develop:id/valetIcon"));
    By service_type_label = (By.id("com.spplus.parking.develop:id/valetTitle"));

    //ADDITIONAL AMENITIES
    By additional_amenities = (By.id("com.spplus.parking.develop:id/additionalAmenitiesTitle"));
    By accessible_label = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Accessible']"));
    By accessible_icon = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Accessible']/preceding-sibling::android.widget.ImageView"));
    By hours24_label = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='24 Hours']"));
    By hours24_icon = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='24 Hours']/preceding-sibling::android.widget.ImageView"));
    By height_restriction_label = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Height Restriction: 6'8\"']"));
    By height_restriction_icon = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Height Restriction: 6'8\"']/preceding-sibling::android.widget.ImageView"));
    By vehicle_Service_label = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Vehicle Escort Service,Battery Jump/Tire Inflation']"));
    By vehicle_Service_icon = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/text'][@text='Vehicle Escort Service,Battery Jump/Tire Inflation']/preceding-sibling::android.widget.ImageView"));

    //MORE INFORMATION
    By looking_for_more_info = (By.id("com.spplus.parking.develop:id/lookingForMoreInformationTextView"));
    By talk_to_garage = (By.id("com.spplus.parking.develop:id/talkToGarageButton"));

    //ABOUT LOCATION
    By about_location_label = (By.id("com.spplus.parking.develop:id/aboutLocationTitle"));
    By operated_by = (By.id("com.spplus.parking.develop:id/aboutLocationEmpty"));


    public void assertUserIsOnViewDetailsScreen(String lot_name_value) {
        waitUntilFinishLoading();
        assert_text(title, lot_name_value);
        log.info("LOT DETAILS SCREEN");
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading_lot_details, (long) 5);
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
        scrollToText("ENTRANCE TIME");
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
            assert_text(special_rates_label, "Looking for special rates?");
            assert_text(access_code_label, "Have an access code?");
            return true;
        }else{
            return false;
        }
    }

    public void clickOnAccessCodeArea() {
        click(special_rates_access_code_clickable_area);
        log.info("Access Code area was clicked.");
    }

    public void checkAccessCodeModalIsDisplayed() {
        assert_element_is_displayed(enter_access_code_title);
        assert_text(enter_access_code_title, "Enter Access Code");
        assert_text(enter_access_code_desc, "Enter your access code to see your special rates.");
        assert_text(enter_access_code_input, "Enter Access Code");
        assert_text(enter_access_code_cancel, "CANCEL");
        assert_text(enter_access_code_enter, "ENTER CODE");
        log.info("Access Code modal is displayed.");
    }

    public void enterAccessCode(String access_code) {
        checkAccessCodeModalIsDisplayed();
        type(enter_access_code_input, access_code);
        log.info("Access code entered: "+access_code);
        click(enter_access_code_enter);
        log.info("ENTER CODE button was clicked.");
    }

    public String checkDiscountWasApplied() {
        assert_text(remove_access_code, "X REMOVE");
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
            new_price = checkDiscountWasApplied();
            clickOnBookParking();
        }
        return new_price;
    }

    public void assertEventParkingIsAvailable(String location) {
        
        try {
            assert_element_is_displayed(calendar_icon);
            log.info("Event parking is available for the lot selected.");
        } catch (TimeoutException e) {
            throw new Error("No event was displayed for the location: "+location);
        }
        
    }

    public String[] getUpcomingEventParkingDetails() {
        
        String event_name = text(upcoming_event_name);
        log.info("Event name: "+event_name);
        String event_location = text(upcoming_event_location);
        log.info("Event location: "+event_location);
        String event_price = text(upcoming_event_price);
        log.info("Event price: "+event_price);
        String event_date = text(upcoming_event_date);
        log.info("Event date: "+event_date);
        String event_time = text(upcoming_event_time);
        log.info("Event time: "+event_time);

        log.info("All the event information was gather correctly.");

        return new String[] {event_name, event_location, event_price, event_date, event_time};
    }

    public void clickOnBookParkingForEvent() {
        click(upcoming_event_book_parking);
        log.info("Book Parking button for upcoming event was clicked.");
    }

    public void clickOnViewAll() {
        click(view_all_upcoming_event_parking);
        log.info("View All button for upcoming events was clicked.");
    }

    public void assertEventIsAvailableAndClickViewAll(String location, String lot_address) {
        basicAssertionsForEventParking(location, lot_address.replace("ENTRANCE  ", ""));
        assertEventParkingIsAvailable(location);
        // String[] event_details = getUpcomingEventParkingDetails();
        clickOnViewAll();
    }

    public String[] assertEventIsAvailableAndClickBookParking(String location, String price, String[] dateTimeValues) {
        basicAssertions(location, location, price, dateTimeValues);
        assertEventParkingIsAvailable(location);
        String[] event_details = getUpcomingEventParkingDetails();
        clickOnBookParkingForEvent();
        return event_details;
    }

}