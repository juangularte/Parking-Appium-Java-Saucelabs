package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class FindParkingScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public FindParkingScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //MAP VIEW
    By menu_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"\"`][2]"));
    By location_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/currentLocationButton"));
    By list_view_button = (AppiumBy.xpath("//XCUIElementTypeButton[3]"));
    By filters_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/filterCount"));
    By vehicle_size_filter = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/vehicleSizeButton"));
    By map = (By.xpath("//android.view.View[@content-desc='Google Map']"));
    By parking_lots = (By.xpath("//android.view.View[@content-desc='Google Map']/android.view.View[@displayed='true']"));
    By parking_lot_preview = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/previewContainer"));
    By parking_lot_name = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/name"));
    By parking_lot_address = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/address"));
    By parking_lot_distance = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/distance"));
    By parking_lot_view_details_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/viewDetails"));
    By parking_lot_amenities = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/amenities"));
    By parking_lot_print_mobile_pass = (By.xpath("//android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/printedOrMobilePassLayout']/android.widget.TextView")); 
    By parking_lot_close_view = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/closeButton"));
    By parking_lot_rates = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/driveUpLabel"));
    By parking_lot_price = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/price"));
    By parking_lot_book_parking_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/bookNowButton"));
    By parking_lot_event_only = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/driveUpLabel"));

    //LIST VIEW
    //TODO Add all List View locators
    By back_button = (AppiumBy.accessibilityId("ic back"));

    //PARKING LOT DETAILS
    By parking_lot_details_back_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/backButton"));
    By parking_lot_details_name = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/lotName"));
    By parking_lot_details_current_price = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/currentPrice"));
    By parking_lot_details_entrance = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/entrance"));
    By parking_lot_details_book_parking_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/bookNowButton"));
    // By parking_lot_details_back_button = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/driveUpLabel"));

    //SEARCH BOX
    By find_parking_title = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/titleLabelTextView"));
    By search_location_field = (AppiumBy.iOSClassChain("com.spplus.parking.develop:id/searchEntry"));

    //MENU
    //TODO Add all menu locators
    By my_account_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/guestOption']/android.widget.TextView"));

    //SEARCH VIEW    
    By entrance_label = (AppiumBy.accessibilityId("ENTRANCE TIME"));
    By exit_label= (AppiumBy.accessibilityId("EXIT TIME"));
    By entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='ENTRANCE TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXIT TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));

    //TODO Check if assertTexts method is needed for this screen

    //MAP METHODS
    public void displayMenu(){
        click(menu_button);
        log.info("Menu button was clicked.");
    }

    public void clickOnListView(String entrance_date_time_value, String exit_date_time_value) {
        checkDatesRange(entrance_date_time_value, exit_date_time_value);
        click(list_view_button);
        log.info("List View button was clicked.");
    }
    
    public String getLocationSearched(){
        String textValue = text(search_location_field);
        log.info("Location displayed: "+textValue);
        return textValue;
    }

    public void checkDatesRange(String entrance_date_time_value, String exit_date_time_value){
        assert_text(entrance_date_time, entrance_date_time_value);
        log.info("Entrance date and time: "+text(entrance_date_time));
        assert_text(exit_date_time, exit_date_time_value);
        log.info("Exit date and time: "+text(exit_date_time));
        log.info("The entrance and exit dates and times are the selected ones.");
    }

    public void checkVehicleSizeFilterIsStandard(){
        assert_text(vehicle_size_filter, "VEHICLE SIZE: STANDARD");
        log.info("Vehicle Size filter is 'Standard' by default.");
    }

    public void checkNoFilterIsApplied(){
        assert_text(filters_button, "(0) FILTERS");
        log.info("No filter is being applied by default.");
    }

    public void checkParkingLotsAppear(){
        log.info("Parking Lots are loading.");
        while(check_if_element_is_present(parking_lots).equals(false)){
            if (check_if_element_is_present(parking_lots).equals(true)){
                log.info("Parking Lots are displayed.");
                break;
            }
        }
        assert_elements_list_bigger_than_number(parking_lots, 1);
        log.info("Parking lots found: "+amount_of_elements(parking_lots).toString());
    }

    public void clickOnViewDetails() {
        click(parking_lot_view_details_button);
        log.info("View Details button was clicked.");
    }

    public String[] findExactParkingLotSearched(String entrance_date_time_value, String exit_date_time_value){
        String location = getLocationSearched();
        String lot_name = new String();
        String lot_address = new String();
        String lot_price = new String();
        checkVehicleSizeFilterIsStandard();
        checkNoFilterIsApplied();
        checkDatesRange(entrance_date_time_value, exit_date_time_value);
        checkParkingLotsAppear();
        lots : for(WebElement lot : find_all(parking_lots)){
            lot.click();
            
            if(check_if_element_is_present(parking_lot_preview).equals(false)){
                sleep(750);
                if(check_if_element_is_present(back_button).equals(true)){
                    log.info("List View was open by mistake when trying to tap on a lot.");
                    click(back_button);
                    sleep(500);
                    log.info("Back to Map button was clicked.");
                    continue;
                }
                lot.click();
                sleep(500);
            }

            switch(check_if_element_is_present(parking_lot_preview).toString()){

                case "false": continue;
                case "true": if(text(parking_lot_name).equals(location)){
                                lot_name = text(parking_lot_name);
                                lot_address = text(parking_lot_address);
                                lot_price = text(parking_lot_price);
                                log.info("The parking lot for the exact location searched was found.");
                                break lots;
                            }else{
                                click(parking_lot_close_view);
                                continue;
                            }
            }
        }
        return new String[] {lot_name, lot_address, lot_price};
    }

    public String[] findExactEventParkingLotSearched(String entrance_date_time_value, String exit_date_time_value){
        String location = getLocationSearched();
        String lot_name = new String();
        String lot_address = new String();
        // String lot_price = new String();
        // checkVehicleSizeFilterIsStandard();
        sleep(2000);
        checkNoFilterIsApplied();
        checkDatesRange(entrance_date_time_value, exit_date_time_value);
        checkParkingLotsAppear();
        lots : for(WebElement lot : find_all(parking_lots)){
            lot.click();
            
            if(check_if_element_is_present(parking_lot_preview).equals(false)){
                sleep(2000);
                if(check_if_element_is_present(back_button).equals(true)){
                    log.info("List View was open by mistake when trying to tap on a lot.");
                    click(back_button);
                    sleep(500);
                    log.info("Back to Map button was clicked.");
                    continue;
                }
                lot.click();
                sleep(750);
            }

            switch(check_if_element_is_present(parking_lot_preview).toString()){

                case "false": continue;
                case "true": if(text(parking_lot_name).equals(location)){

                                lot_name = text(parking_lot_name);
                                lot_address = text(parking_lot_address);
                                assert_text(parking_lot_event_only, "EVENTS ONLY");
                                // lot_price = text(parking_lot_price);
                                log.info("The event parking lot for the exact location searched was found.");
                                break lots;
                            }else{
                                click(parking_lot_close_view);
                                continue;
                            }
            }
        }
        return new String[] {lot_name, lot_address};
    }

    public String[] findParkingLotAvailableNow(String entrance_date_time_value, String exit_date_time_value){
        // String location = getLocationSearched();
        checkVehicleSizeFilterIsStandard();
        checkNoFilterIsApplied();
        checkDatesRange(entrance_date_time_value, exit_date_time_value);
        checkParkingLotsAppear();
        String lot_name = new String();
        String lot_address = new String();
        String lot_price = new String();
        lots : for(WebElement lot : find_all(parking_lots)){
            
            lot.click();

            if(check_if_element_is_present(parking_lot_preview).equals(false)){
                sleep(750);
                if(check_if_element_is_present(back_button).equals(true)){
                    log.info("List View was open by mistake when trying to tap on a lot.");
                    click(back_button);
                    sleep(500);
                    log.info("Back to Map button was clicked.");
                    continue lots;
                }
                lot.click();
            }

            switch(check_if_element_is_present(parking_lot_preview).toString()){

                case "false": continue lots;
                case "true": if(check_if_element_is_present(parking_lot_book_parking_button).equals(true)){
                                lot_name = text(parking_lot_name);
                                lot_address = text(parking_lot_address);
                                lot_price = text(parking_lot_price);
                                log.info("An available parking lot was found: "+lot_name);
                                click(parking_lot_book_parking_button);
                                log.info("Book Parking button was clicked.");
                                break lots;
                            }else{
                                click(parking_lot_close_view);
                                continue lots;
                            }
            }
        }
        return new String[] {lot_name, lot_address, lot_price};
    }

    public String[] findExactParkingLotSearchedAndClickOnViewDetails(String entrance_date_time_value, String exit_date_time_value) {
        String [] name_address_price = findExactParkingLotSearched(entrance_date_time_value, exit_date_time_value);
        clickOnViewDetails();
        return name_address_price;
    }

    public String[] findExactEventParkingLotSearchedAndClickOnViewDetails(String entrance_date_time_value, String exit_date_time_value) {
        String [] name_address = findExactEventParkingLotSearched(entrance_date_time_value, exit_date_time_value);
        clickOnViewDetails();
        return name_address;
    }

}
