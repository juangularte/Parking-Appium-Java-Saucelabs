package android.screens;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class OnDemandZoneLocationScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public OnDemandZoneLocationScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By close_button = (By.id("com.spplus.parking.develop:id/closeButton"));
    By zone_label = (By.id("com.spplus.parking.develop:id/locationLabel"));
    By edit_button = (By.id("com.spplus.parking.develop:id/editLocationLabel"));
    By zone_code_label = (By.id("com.spplus.parking.develop:id/locationCode"));
    By zone_location_address = (By.id("com.spplus.parking.develop:id/locationAddress"));

    //VEHICLE GUEST
    By license_plate_label = (By.id("com.spplus.parking.develop:id/addVehicleLabel"));
    By license_plate_field = (By.id("com.spplus.parking.develop:id/licensePlateField"));
    By country_arrow = (By.id("com.spplus.parking.develop:id/arrow_imv"));
    By state_label = (By.id("com.spplus.parking.develop:id/state"));
    By state_selected = (By.id("android:id/text1"));
    By state_arrow = (By.id("com.spplus.parking.develop:id/stateArrow"));
    By max_characters_label = (By.id("com.spplus.parking.develop:id/licensePlateDisclaimer"));
    By next_button = (By.id("com.spplus.parking.develop:id/addVehicleButton"));
    By empty_license_plate_validation = (By.id("com.spplus.parking.develop:id/licensePlateValidation"));

    //COUNTRIES LIST
    By select_country_title = (By.id("com.spplus.parking.develop:id/title_tv"));
    By search_country = (By.id("com.spplus.parking.develop:id/search_edt"));
    By list_of_countries = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv']"));
    By usa = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv'][@text='United States']"));
    By canada = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/code_tv'][@text='Canada']"));
    By no_country_found = (By.id("com.spplus.parking.develop:id/no_result_tv"));

    //STATES LIST
    By states_list = (By.xpath("//android.widget.ListView"));
    By states = (By.id("android:id/text1"));

    //VEHICLE ADDED
    By vehicle_section_title = (By.id("com.spplus.parking.develop:id/vehicleLabel"));
    By vehicle_section_edit = (By.id("com.spplus.parking.develop:id/addEditVehicleLabel"));
    By license_plate_added = (By.id("com.spplus.parking.develop:id/vehiclePlate"));

    //RTD STATUS
    By rtd_status = (By.id("com.spplus.parking.develop:id/rtdStatus"));

    //SCROLL SECTION
    By scrollable = (By.id("com.spplus.parking.develop:id/hourScrollContainer"));

    //SELECT EVENT
    By select_event_title = (By.id("com.spplus.parking.develop:id/eventsHeader"));
    By events_section = (By.id("com.spplus.parking.develop:id/events"));
    By events_displayed = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/events']/android.view.ViewGroup"));
    By event_selected_name = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemName']"));
    By event_selected_price = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemPriceTextView']"));
    By event_selected_exit = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDistance']"));

    //SELECT TIME
    By select_time_title = (By.id("com.spplus.parking.develop:id/selectionHeader"));
    By select_time_button = (By.id("com.spplus.parking.develop:id/selectHoursButton"));
    By hours_of_operation_label = (By.id("com.spplus.parking.develop:id/operationHoursTitle"));

    //SELECT TIME MODAL
    By select_time_cancel_button = (By.id("com.spplus.parking.develop:id/cancelButton"));
    By select_time_select_button = (By.id("com.spplus.parking.develop:id/selectButton"));
    By days_wheel = (By.xpath("//android.widget.NumberPicker[1]"));
    By days_value = (By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][1]"));
    By hours_wheel = (By.xpath("//android.widget.NumberPicker[2]"));
    By hours_value = (By.xpath("//android.widget.NumberPicker[2]/android.widget.EditText"));
    By minutes_wheel = (By.xpath("//android.widget.NumberPicker[3]"));
    By minutes_hour = (By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][3]"));

    //FOOTER
    By parking_instructions_title = (By.xpath("//android.widget.TextView[@text='Parking Instructions']"));
    By parking_instructions_info = (By.id("com.spplus.parking.develop:id/instructionsHeaderDetailB"));

    

    //LOADER
    By loading = (By.id("com.spplus.parking.develop:id/tv_msg"));
    
    
    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 25);
        } catch (TimeoutException e) {
        }
    }

    public void checkUserIsInZoneCodeLocationScreen(String zone_code) {

        try {
            assert_text(zone_code_label, zone_code);
            log.info("ONDEMAND ZONE LOCATION SCREEN");
        } catch (Exception | Error e) {
            throw new Error("Zone Code displayed is not the same as the one entered before.");
        }
    }

     /*
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * GUEST USER METHODS
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */


    //VEHICLE SECTION METHODS

    public void assertBasicElements() {
        try {
            
            assert_text(zone_label, "Zone #");
            assert_element_is_displayed(close_button);
            assert_text(edit_button, "EDIT");
            if(check_if_element_is_present(scrollable).equals(true)){
                swipeElementUp(scrollable, 300);
            }
            assert_text(parking_instructions_title, "Parking Instructions");
            if(check_if_element_is_present(scrollable).equals(true)){
                swipeElementDown(scrollable, 300);
            }
            log.info("All elements in OnDemand Zone Location screen were displayed correctly.");
        } catch (Exception | Error e) {
            throw new Error("All the elements in OnDemand Zone Location screen were not displayed correctly. \n"+e);
        }
    }

    public void assertGuestUserBasicElementsForVechileSection() {

        try {
            
            assert_text(zone_label, "Zone #");
            assert_element_is_displayed(close_button);
            assert_text(edit_button, "EDIT");
            assert_text(license_plate_label, "First we need your license plate");
            assert_text(max_characters_label, "Max of 8 characters, no spaces, no special characters.");
            assert_text(next_button, "Next");
            assert_text(parking_instructions_title, "Parking Instructions");
            log.info("All elements in OnDemand Zone Location screen were displayed correctly.");
        } catch (Exception | Error e) {
            throw new Error("All the elements in OnDemand Zone Location screen were not displayed correctly.");
        }
    }

    public void assertGuestUserBasicElementsForRTDZoneVechileSection() {

        try {
            
            assert_text(zone_label, "Zone #");
            assert_element_is_displayed(close_button);
            assert_text(edit_button, "EDIT");
            assert_text(license_plate_label, "First we need your license plate");
            assert_text(max_characters_label, "Max of 8 characters, no spaces, no special characters.");
            assert_text(next_button, "Next");
            log.info("All elements in OnDemand Zone Location screen were displayed correctly.");
        } catch (Exception | Error e) {
            throw new Error("All the elements in OnDemand Zone Location screen were not displayed correctly.");
        }
    }

    public String getLocationAddress() {
        String location_address_value = (text(zone_location_address));
        log.info("Address displayed: "+location_address_value);
        return location_address_value;
    }

    public void selectCountry(String country){
        if(!country.equals("United States")){
            click(country_arrow);
            log.info("Countries list was open.");
            type(search_country, country);
            if(check_if_element_is_present(canada).equals(true)){
                assert_input_text(canada, country);
                click(canada);
            }else if(check_if_element_is_present(no_country_found).equals(true)){
                throw new Error("No country matches the value entered: '"+country+"'. The only options available are 'United States' and 'Canada'.");
            }
        }
        log.info("Country selected: "+country);
    }

    public void selectState(String state){
        if(state.equals("AL")){
            log.info("State selected: "+state);
        }else{
            click(state_arrow);
            waitForElementToBeVisible(states_list, (long) 5);
            assert_elements_list_bigger_than_number(states, 1);
            states_loop : for (WebElement st : find_all(states)){
                String state_value = st.getText();
                if (state_value.equals(state)){
                    log.info("State selected: "+state_value);
                    st.click();
                    break states_loop;
                }else{
                    continue states_loop;
                }
            }

            switch (check_if_element_is_present(states_list).toString()) {
                case "true":    scrollToText(state);
                                states_loop : for (WebElement st : find_all(states)){
                                    String state_value = st.getText();
                                    if (state_value.equals(state)){
                                        log.info("State selected: "+state_value);
                                        st.click();
                                        break states_loop;
                                    }else{
                                        continue states_loop;
                                    }
                                }
                case "false": break;
            }
        }
    }

    public void assertFieldValidations(){
        clickNext();
        assert_text(empty_license_plate_validation, "A valid license plate is required");
        click(license_plate_field);
        type(license_plate_field, "1234567890");
        Assert.assertTrue(text(license_plate_field).length() == 8);
        log.info("License Plate field allows only 8 characters.");
    }

    public void enterLicensePlate(String license_plate){
        clear_and_type(license_plate_field, license_plate);
        log.info("License Plate added: "+license_plate);
    }

    public void clickNext() {
        click(next_button);
        log.info("Next button was clicked.");
    }

    public String checkVehicleSectionAndAddLicensePlate(String license_plate, String country, String state){
        assertGuestUserBasicElementsForVechileSection();
        String location_address = getLocationAddress();
        selectCountry(country);
        selectState(state);
        assertFieldValidations();
        enterLicensePlate(license_plate);
        click_back_button();
        clickNext();
        return location_address;
    }

    public String checkVehicleSectionAndAddOutRTDLicensePlate(String license_plate, String country, String state){
        assertGuestUserBasicElementsForRTDZoneVechileSection();
        String location_address = getLocationAddress();
        selectCountry(country);
        selectState(state);
        assertFieldValidations();
        enterLicensePlate(license_plate);
        click_back_button();
        clickNext();
        return location_address;
    }

    //VEHICLE ADDED

    public void assertVehicleIsDisplayed(String license_plate) {
        assert_text(vehicle_section_title, "VEHICLE");
        assert_text(vehicle_section_edit, "EDIT");
        assert_text(license_plate_added, license_plate);
        log.info("Vehicle displayed correctly.");
    }

    public String checkDefaultVehicleIsDisplayed(String default_license_plate){
        assertBasicElements();
        String location_address = getLocationAddress();
        assertVehicleIsDisplayed(default_license_plate);
        return location_address;
    }

    public void checkRTDStatus(Boolean in_distric_pricing) {
        if(in_distric_pricing.equals(false)){
            assert_text(rtd_status, "RTD out of district pricing");
        }else{
            assert_text(rtd_status, "RTD in district pricing");
        }
    }

    //SELECT AN EVENT

    public Boolean checkIfThereAreEventsDisplayed(){

        if(check_if_element_is_present(events_section).equals(true)){

            assert_text(select_event_title, "Select an Event");
            return true;
        }else{
            return false;
        }
    }

    public Boolean assertThereIsAtLeastOneEventDisplayed() {
        try {
            Assert.assertTrue(checkIfThereAreEventsDisplayed());
            return true;
        } catch (AssertionError e) {
            throw new Error("There is no event displayed.");
        }
    }

    public String[] selectEventAndGetInfo() {
        assertThereIsAtLeastOneEventDisplayed();
        int amount_of_events = amount_of_elements(events_displayed);
        String event_name = new String();
        String event_price = new String();
        String event_exit = new String();
        int count = 0;
        List<WebElement> events = find_all(events_displayed);
        String[][] events_info = new String[amount_of_events][];
        for (WebElement event : events){

            event_name = event.findElement(event_selected_name).getText();
            event_price = event.findElement(event_selected_price).getText();
            event_exit = event.findElement(event_selected_exit).getText();

            events_info[count] = new String[] {event_name, event_price, event_exit};
			count++;

            if(count == 5){
                break;
            }
        }

        if(amount_of_events > 5){
            amount_of_events = 5;
        }

        int random_number = (int) (Math.random()*(amount_of_events));
        System.out.println("AMOUNT OF EVENTS: "+amount_of_events);
        System.out.println("RANDOM NUMBER: "+random_number);
        String event_name_selected_randomly = events_info[random_number][0];

        for (WebElement event : events){

            if(event.findElement(event_selected_name).getText().equals(event_name_selected_randomly)){
                event.click();
                log.info("Event was selected.");
                break;
            }
        }
        waitUntilFinishLoading();
        return events_info[random_number];
    }


    //SELECT TIME METHODS

    public void basicAssertionsForSelectTimeSection(Boolean isEventSectionPresent){
        if(isEventSectionPresent.equals(true)){
            assert_text(select_time_title, "Or tell us how long you're staying");
        }else{
            assert_text(select_time_title, "Set Your Own Time");
        }
        
        assert_text(select_time_button, "SELECT TIME NEEDED");
        assert_text(hours_of_operation_label, "HOURS OF OPERATION");
    }

    public void openSelectTimeModal() {
        click(select_time_button);
        log.info("Select Time Needed button was clicked.");
    }

    public void selectTime(Boolean more_than_24_hrs) {
        openSelectTimeModal();
        if(more_than_24_hrs.equals(true)){
            click(days_value);
            clear_and_type(days_value, "1 DAY");
            click(days_value);
        }
        click(hours_value);
        clear_and_type(hours_value, "2 HOURS");
        click(hours_value);
        if(check_if_element_is_present(select_time_select_button).equals(true)){
            click_back_button();
            click(select_time_select_button);
        }
        log.info("Time was selected.");
    }

    public void checkTimeSectionAndSelectTime(Boolean areThereEventsDisplayed, Boolean more_than_24_hrs) {

        basicAssertionsForSelectTimeSection(areThereEventsDisplayed);
        selectTime(more_than_24_hrs);
        waitUntilFinishLoading();
    }













    /*
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     * REGISTERED USER METHODS
     * ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     */


    public void checkVehicleInformationIsDisplayed(String default_license_plate) {
        assert_text(vehicle_section_title, "VEHICLE");
        assert_text(vehicle_section_edit, "EDIT");
        assert_text(license_plate_added, default_license_plate);
        log.info("Vehicle information displayed correctly.");
    }

    public void checkAllVehiclesAredDisplayed() {
        
    }
}
