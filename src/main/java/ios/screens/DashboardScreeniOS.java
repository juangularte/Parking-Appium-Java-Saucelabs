package ios.screens;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class DashboardScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public DashboardScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }
    
    //TURN ON LOCATION MODAL
    By location_modal = (AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther"));
    By location_title = (AppiumBy.accessibilityId(" Turn on location services and discover more features."));
    By easily_find_subtext = (AppiumBy.accessibilityId("Easily find parking near you."));
    By use_your_phone_message = (AppiumBy.accessibilityId("Use your phone to bypass the gate and pay at certain garages."));
    By preferences = (AppiumBy.accessibilityId("Set your preferences"));
    By modal_ok_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"OK\"`]"));

    //ALLOW ACCESS TO DEVICE'S LOCATION
    By permission_icon = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_icon"));
    By permission_message = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_message"));
    By precise_location = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"));
    By approximate_location = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_location_accuracy_radio_coarse"));
    By while_using_app = (AppiumBy.accessibilityId("Allow While Using App"));
    By only_this_tme = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_allow_one_time_button"));
    By dont_allow = (AppiumBy.accessibilityId("com.android.permissioncontroller:id/permission_deny_button"));

    //ALLOW BLUETOOTH
    By bluetooth_popup_title = (AppiumBy.xpath("//*[contains(@value,'Would Like to Use Bluetooth')]"));
    By bluetooth_popup_message = (AppiumBy.accessibilityId("Parking.com would like to use bluetooth services to enter and exit garage."));
    By bluetooth_popup_ok_button = (AppiumBy.accessibilityId("OK"));
    By bluetooth_popup_dont_allow_button = (AppiumBy.accessibilityId("Don’t Allow"));

    //SAVE PASSWORD
    By save_password_modal = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Would you like to save this password in your Keychain to use with apps and websites?\"`]"));
    By not_now = (AppiumBy.accessibilityId("Not Now"));

    //URLSessionTask error
    By url_session_error = (AppiumBy.xpath("//*[contains(@value,'URLSessionTask')]"));
    By url_session_error_ok_button = (AppiumBy.xpath("//*[contains(@value,'URLSessionTask')]/*[@value='Ok']"));

    //DASHBOARD SCREEN
    By logo = (AppiumBy.accessibilityId("img_logo_splash_TM"));
    By login_error_popup = (AppiumBy.xpath("//*[@value='Error']"));
    By login_error_message = (AppiumBy.accessibilityId("Your email address and/or password are incorrect. Please try again."));
    By find_parking_near_me_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Find parking near me\"`]"));

    //REGISTERED USER
    By my_locations = (AppiumBy.accessibilityId("My Locations"));
   
    //SEARCH BOX SECTION
    By book_reservation = (AppiumBy.accessibilityId("Book a Reservation"));
    By choose_between = (AppiumBy.accessibilityId("Choose between "));
    By daily = (AppiumBy.accessibilityId("daily"));
    By or = (AppiumBy.accessibilityId(" or "));
    By monthly = (AppiumBy.accessibilityId("monthly"));
    By parking = (AppiumBy.accessibilityId(" parking"));
    By search_location_box = (AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Search for Location\"`]")); //TODO: Remove the additional characters

    //PAY FOR PARKING NOW
    //TODO Add locators

    //MENU
    By menu_button = (AppiumBy.xpath("//XCUIElementTypeImage[@name='dashboard_bg']/following-sibling::XCUIElementTypeButton"));
    By menu = (AppiumBy.xpath("//XCUIElementTypeImage[@name='logo_header_mobile_TM']/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther"));
    By menu_logo = (AppiumBy.accessibilityId("logo_header_mobile_TM"));
    By menu_scrollable = (AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"Vertical scroll bar, 2 pages\"`][1]"));
    By find_parking_option = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Find Parking\"`]"));
    By my_account_option = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"My Account\"`]"));
    By logout_option = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Sign Out\"`]"));

    //SEARCH VIEW
    By find_parking_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Find Parking\"`]"));
    By entrance_label = (AppiumBy.accessibilityId("ENTRANCE TIME"));
    By exit_label= (AppiumBy.accessibilityId("EXIT TIME"));
    By entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='ENTRANCE TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXIT TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By vehicle_size_title = (AppiumBy.accessibilityId("SELECT VEHICLE SIZE"));
    By vehicle_size_rates_message = (AppiumBy.accessibilityId("Show rates from standard size vehicles."));
    By standard_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"STANDARD\"`]"));
    By oversize_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"OVERSIZE\"`]"));
    By parking_near_me_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Parking near me\"`]"));
    By search_parking_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"SEARCH PARKING\"`]"));

    By recomendations_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"RECOMMENDATIONS\"`]"));
    By all_results = (AppiumBy.xpath("//XCUIElementTypeOther[@name='RECOMMENDATIONS']/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText"));
    By first_result = (AppiumBy.xpath("//XCUIElementTypeOther[@name='RECOMMENDATIONS']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText"));
    By dates_wheel = (AppiumBy.xpath("//XCUIElementTypePickerWheel[1]"));
    By hours_wheel = (AppiumBy.xpath("//XCUIElementTypePickerWheel[2]"));
    By minutes_wheel = (AppiumBy.xpath("//XCUIElementTypePickerWheel[3]"));


    //RESERVATIONS
    By reservation_cards = (AppiumBy.xpath("//XCUIElementTypeCollectionView"));
    By reservation_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"RESERVATION\"]"));
    By reservation_date = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"RESERVATION\"]/following-sibling::XCUIElementTypeStaticText[1]"));
    By reservation_number = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"RESERVATION\"]/following-sibling::XCUIElementTypeStaticText[2]"));
    By reservation_show_more = (AppiumBy.accessibilityId("btn show more"));
    By reservation_entrance_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE\"]"));
    By reservation_address = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE\"]/following-sibling::XCUIElementTypeStaticText"));
    By reservation_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeStaticText"));
    By reservation_license_plate = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeStaticText"));
    By reservation_parking_pass_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING PASS\"]"));
    By reservations_slider = (AppiumBy.xpath("//XCUIElementTypePageIndicator"));
    By reservations_slider_dots_section = (AppiumBy.xpath("//XCUIElementTypePageIndicator"));
    By reservations_slider_dots = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/activeReservationsDotsIndicator']/android.view.View"));

    //TODO By reservation_entrance_exit_time = (AppiumBy.accessibilityId(""));
    By reservation_change_vehicle_option = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Change Vehicle\"]"));
    By reservation_cancel_reservation_option = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cancel Reservation\"]"));
    By reservation_get_directions_option = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Get Directions\"]"));
    By reservation_call_facility_option = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Call Facility\"]"));
    By show_more_close_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CANCEL\"]"));

    By reservation_success_modal = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/title'][@text='Success!']"));
    By reservation_success_modal_ok_button = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/button'][@text='OK']"));
    
    //LOADER
    By loading = (AppiumBy.accessibilityId("In progress"));

    //CANCELLATION
    By cancel_reservation_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cancel Reservation?\"]"));
    By cancel_reservation_message = (AppiumBy.accessibilityId("Transaction will be refunded and Parking Pass will be no longer valid once you cancel this reservation."));
    By cancel_reservation_close_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Close\"]"));
    By cancel_reservation_confirm_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Confirm\"]"));
    By reservation_cancelled_succes_message = (AppiumBy.accessibilityId("Your reservation has been cancelled"));
    //CHANGE VEHICLE
    By reservation_select_vehicle_title = (AppiumBy.xpath("//android.widget.TextView[@text='SELECT VEHICLE']"));
    By reservation_add_vehicle_option = (AppiumBy.xpath("//android.widget.TextView[@text='Add Vehicle']"));
    By reservation_vehicles_list = (AppiumBy.xpath("//android.widget.TextView[@text='Add Vehicle']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView"));
    By reservation_change_vehicle_succes_message = (AppiumBy.xpath("//*[@resource-id='com.spplus.parking.develop:id/message'][@text='All your information has been saved!']"));
    

    //GOOGLE'S LOCATION POPUP
    // By google_location_service_popup = (AppiumBy.xpath("//*[contains(text(), 'For a better experience')]"));
    By google_location_service_popup = (AppiumBy.xpath("//*[text()[contains(.,'For a better experience')]]"));
    By google_location_service_no_thanks_button = (AppiumBy.xpath("//*[@text='No, thanks']"));
    


    //INITIAL CONFIGURATIONS METHODS
    public void assertTurnOnLocationModalTexts(){
        log.info("DASHBOARD SCREEN");
        assert_text(location_title, " Turn on location services and discover more features.");
        assert_text(easily_find_subtext, "Easily find parking near you.");
        assert_text(use_your_phone_message, "Use your phone to bypass the gate and pay at certain garages.");
        assert_text(preferences, "Set your preferences");
    }

    public void clickOkButtonInTurnOnLocationModal(){
        assertTurnOnLocationModalTexts();
        click(modal_ok_button);
    }

    public void clickWhileUsingApp(){
        click(while_using_app);
    }

    public void setInitialConfigurations(){
        clickOkButtonInTurnOnLocationModal();
        clickWhileUsingApp();
    }

    //MENU METHODS
    public void displayMenuIfItsNotDisplayed(){
        if (check_if_element_is_present(menu).equals(true)){
            log.info("Menu is already displayed.");
        }else{
            clickMenu();
        }
    }

    public void clickMenu(){
        click(menu_button);
        log.info("Menu button was clicked. Menu is displayed.");
    }

    public void hideMenu(){
        //TODO Add steps to click outside the menu to hide it
    }

    public void clickAccountOption(){
        if(check_if_element_is_present(my_account_option).equals(false)){
            swipeElementUp(menu_scrollable, 400);
        }
        click(my_account_option);
        log.info("My Account option was clicked.");
    }

    public void clickFindParkingOption(){
        click(find_parking_option);
        log.info("Find Parking option was clicked.");
        checkIfGoogleLocationPopupAppears();
        waitUntilFinishLoading();
    }

    //GOOGLE'S LOCATION SERVICE
    public void checkIfGoogleLocationPopupAppears() {
        try {
            waitForElementToBeVisible(google_location_service_popup, (long) 5);
            click(google_location_service_no_thanks_button);
            log.info("Google's Location Service popup was displayed. No Thanks button was clicked.");
        } catch (TimeoutException e) {
            //TODO: handle exception
        }
       
    }
    
    //USER NOT LOGGED IN

    public void goToAccountScreen() {
        displayMenuIfItsNotDisplayed();
        clickAccountOption();
    }

    public void setConfigurationsAndGoToAccountScreen(){
        setInitialConfigurations();
        goToAccountScreen();
    }

    public void setConfigurationsAndClickOnSearchBox(){
        setInitialConfigurations();
        goToSearchScreen();
    }



    //USER LOGGED IN
    public void waitUntilSignInProcessIsCompleted(){

        // try {
        //     WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
        //     log.info("Loading...");
        //     waitForElementToDisappear(loading_element, (long) 5);
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        // WebElement loading_element = waitForElementToBeVisible(loading, (long) 3);
        // log.info("Loading...");
        // waitForElementToDisappear(loading_element, (long) 20);
        // try {
        //     WebElement loading_element2 = waitForElementToBeVisible(loading, (long) 5);
        //     waitForElementToDisappear(loading_element2, (long) 20);
        // } catch (TimeoutException e) {
        //     // TODO: handle exception
        // }
        
        while(check_if_element_is_present(find_parking_near_me_button).equals(false)){
            if(check_if_element_is_present(login_error_popup).equals(true)){
                // assert_text(login_error_popup, "ERROR");
                throw new Error("Error message found: "+text(login_error_message));
            }

            if (check_if_element_is_present(find_parking_near_me_button).equals(true)){
                log.info("Load completed.");
                break;
            }

            checkIfSavePasswordModalAppears();
        }
    }

    public void checkIfSavePasswordModalAppears() {

        try{
            waitForElementToBeVisible(save_password_modal, (long) 3);
            click(not_now);
            log.info("Save Password modal was displayed. Not Now button was clicked.");
        }catch (TimeoutException e) {
            log.info("Save Password modal was not displayed.");
        }
        
    }

    public void verifyUserIsLoggedIn(){     
        waitUntilSignInProcessIsCompleted();
        checkIfSavePasswordModalAppears();
        displayMenuIfItsNotDisplayed();
        assert_text(logout_option, "Sign Out");
        log.info("User is logged in.");
	}

    //
    public void verifyUserIsLoggedInAndGoToAccountScreen() {
        verifyUserIsLoggedIn();
        clickAccountOption();
    }

    //DASHBOARD METHODS
    public void tapOnSearchBox(){
        click(search_location_box);
        log.info("Ready to search a location.");
    }

    public void goToSearchScreen(){
        tapOnSearchBox();
    }
 
   //AFTER GUEST RESERVATION
    public void checkThatNoReservationCardIsDisplayedAfterCancellation() {
        Assert.assertFalse(check_if_element_is_present(reservation_cards));
        log.info("Reservation card doesn't appear in the Dashboard.");
    }

    public void assertGuestUserReservationDetails(String reservation_number_value, String lot_name, String lot_address, String license_plate) {
        assert_text(reservation_label, "RESERVATION");
        assert_text(reservation_number, "Order #: "+reservation_number_value);
        assert_text(reservation_entrance_label, "ENTRANCE");
        assert_text(reservation_address, lot_address.replace("ENTRANCE  ", ""));
        assert_text(reservation_name, lot_name);
        assert_text(reservation_license_plate, license_plate);
        log.info("Reservation details were asserted correctly.");
    }

    public int checkIfTheUserHasMultipleActiveReservations() {
        if(check_if_element_is_present(reservations_slider_dots_section).equals(false)){
            log.info("There is only one active reservation.");
            return 0;
        }else{
            int active_reservations = amount_of_elements(reservations_slider_dots_section);
            log.info("There are "+active_reservations+" active reservations.");
            return active_reservations;
        }
    }

    public void swipeToTheNextReservationCard() {
        // swipeElementToLeft(reservations_slider);
        // System.out.println("SWIPED");
        click(reservation_show_more);
    }

    public void assertRegisteredUserReservationDetails(String reservation_number_value, String lot_name, String lot_address, String license_plate) {
        int active_reservations = checkIfTheUserHasMultipleActiveReservations();
        if(active_reservations == 0){
            assertGuestUserReservationDetails(reservation_number_value, lot_name, lot_address, license_plate);
        }else{

            // System.out.println("INSIDE THE ELSE STATEMENT");
            // dots_loop : for (WebElement dot : find_all(reservations_slider_dots)){
            for (int i=1; i <= active_reservations; i++){
                try {
                    // System.out.println("INSIDE THE FOR LOOP: "+i);
                    // System.out.println("Reservation displayed: "+text(reservation_number));
                    // assertGuestUserReservationDetails(reservation_number_value, lot_name, lot_address, license_plate);
                    assert_text(reservation_number, "Order #: "+reservation_number_value);
                    break;
                } catch (StaleElementReferenceException | AssertionError e) {
                    log.info("The reservation displayed doesn't match the booked reservation details. The next one will be selected.");
                    if(i == active_reservations){
                        throw new Error("All the reservations were displayed and no one met the booked reservation details.");
                    }else{
                        // swipeElementToLeft(reservations_slider); //TODO: Fix the swipe function
                        log.info("Next active reservation is displayed.");
                    }
                }
            }
            // System.out.println("END OF ELSE STATEMENT");
        }
    }

    public void clickShowMoreOption() {
        click(reservation_show_more);
        log.info("Show More button was clicked.");
    }

    public void assertShowMoreOptions() {
        assert_text(reservation_change_vehicle_option, "Change Vehicle");
        assert_text(reservation_cancel_reservation_option, "Cancel Reservation");
        assert_text(reservation_get_directions_option, "Get Directions");
        assert_text(reservation_call_facility_option, "Call Facility");
        assert_text(show_more_close_button, "CANCEL");
    }

    public void clickOnCancelReservation() {
        click(reservation_cancel_reservation_option);
        log.info("Cancel Reservation option was clicked.");
    }

    public void clickOnChangeVehicle() {
        click(reservation_change_vehicle_option);
        log.info("Change Vehicle option was clicked.");
    }

    public void checkChangeVehicleModal() {
        assert_text(reservation_select_vehicle_title, "SELECT VEHICLE");
        assert_text(reservation_add_vehicle_option, "Add Vehicle");
        log.info("Cancel Reservation popup displayed.");
    }

    public void assertListOfVehiclesForRegisteredUser(String[][] vehicles_list) {
        assert_elements_list_amount(reservation_vehicles_list, vehicles_list.length);
        int i = 0;
        String[] vehicles_list_license_plates = new String[amount_of_elements(reservation_vehicles_list)];
        for(WebElement vehicle : find_all(reservation_vehicles_list)){
            vehicles_list_license_plates[i] = vehicle.getText();
            i++;
        }
        for(String[] vehicle_name_license_plate : vehicles_list){
            // Assert.assertTrue(Arrays.stream(vehicles_list_license_plates).anyMatch(license_plate[1]::equals));
            if(vehicle_name_license_plate[0].equals("EMPTY")){
                Assert.assertTrue(Arrays.asList(vehicles_list_license_plates).contains(vehicle_name_license_plate[1]));    
            }else{
                Assert.assertTrue(Arrays.asList(vehicles_list_license_plates).contains(vehicle_name_license_plate[0]+"\n"+vehicle_name_license_plate[1]));
            }
        }
        log.info("All the user's vehicles were displayed.");
    }

    public void clickOnChangeVehicleAndAssertAllVehiclesForRegistereduser(String[][] vehicles_list) {
        clickOnChangeVehicle();
        checkChangeVehicleModal();
        assertListOfVehiclesForRegisteredUser(vehicles_list);
    }

    public String selectNewVehicleFromTheList(String[][] vehicles_list, String license_plate) {
        clickOnChangeVehicleAndAssertAllVehiclesForRegistereduser(vehicles_list);
        String random_vehicle_name_license_plate = new String();
        while(true){
            WebElement random_vehicle = select_random_element_from_list_of_elements(find_all(reservation_vehicles_list));
            random_vehicle_name_license_plate = random_vehicle.getText();
            if(!random_vehicle_name_license_plate.contains(license_plate)){
                log.info("New vehicle selected: "+random_vehicle_name_license_plate);
                random_vehicle.click();
                break;
            }
        }
        return random_vehicle_name_license_plate;
    }

    public void assertChangeVehicleSuccessMessageAndClickOk() {
        waitUntilFinishLoading();
        assert_text(reservation_success_modal, "Success!");
        assert_text(reservation_change_vehicle_succes_message, "All your information has been saved!");
        click(reservation_success_modal_ok_button);
        log.info("Change Vehicle 'success' message was displayed. OK button was clicked.");
    }

    public void assertReservationWasUpdatedWithNewVehicle(String new_vehicle) {
        // waitUntilFinishLoading();
        Assert.assertTrue(new_vehicle.contains(text(reservation_license_plate)));
        log.info("Reservation was updated correctly with new vehicle.");
    }

    public void checkCancelReservationPopup() {
        assert_text(cancel_reservation_title, "Cancel Reservation?");
        assert_text(cancel_reservation_message, "Transaction will be refunded and Parking Pass will be no longer valid once you cancel this reservation.");
        assert_text(show_more_close_button, "Close");
        assert_text(cancel_reservation_confirm_button, "Confirm");
        log.info("Cancel Reservation popup displayed.");
    }

    public void clickOnConfirmCancelReservation() {
        click(cancel_reservation_confirm_button);
        log.info("Confirm button was clicked. Reservation should be cancelled.");
    }

    public void waitUntilFinishLoading2(){
        log.info("Loading...");
        // int i = 0;
        while(check_if_element_is_present(loading).equals(true)){
            // i++;
            // System.out.println("Loop: "+i);
            if (check_if_element_is_present(loading).equals(false)){
                log.info("Load completed.");
                break;
            }
        }
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 20);
            try {
                WebElement loading_element2 = waitForElementToBeVisible(loading, (long) 5);
                waitForElementToDisappear(loading_element2, (long) 20);
            } catch (TimeoutException e) {
            }
        } catch (TimeoutException e) {
        }
    }

    public void assertCancellationSuccessMessageAndClickOk() {
        assert_text(reservation_success_modal, "Success!");
        assert_text(reservation_cancelled_succes_message, "Your reservation has been cancelled");
        click(reservation_success_modal_ok_button);
        log.info("Cancellation 'success' message was displayed. OK button was clicked.");
    }

    public void goToDashboardAfterClosingReservationScreen() {
        displayMenuIfItsNotDisplayed();
        clickFindParkingOption();
    }

    public void assertGuestReservationWasCancelled() {
        waitUntilFinishLoading();
        assertCancellationSuccessMessageAndClickOk();
        checkThatNoReservationCardIsDisplayedAfterCancellation();
    }

    public void basicAssertionsAndClickOnShowMoreButton(String reservation_number_value, String lot_name, String lot_address, String license_plate) {
        goToDashboardAfterClosingReservationScreen();
        assertGuestUserReservationDetails(reservation_number_value, lot_name, lot_address, license_plate);
        clickShowMoreOption();
        assertShowMoreOptions();
    }

    public void basicAssertionsForRegisteredUserAndClickOnShowMoreButton(String reservation_number_value, String lot_name, String lot_address, String license_plate) {
        goToDashboardAfterClosingReservationScreen();
        assertRegisteredUserReservationDetails(reservation_number_value, lot_name, lot_address, license_plate);
        clickShowMoreOption();
        assertShowMoreOptions();
    }

    public void cancelReservation(String reservation_number_value, String lot_name, String lot_address, String license_plate) {
        basicAssertionsAndClickOnShowMoreButton(reservation_number_value, lot_name, lot_address, license_plate);
        clickOnCancelReservation();
        clickOnConfirmCancelReservation();
        assertGuestReservationWasCancelled();
    }

    public void changeAndAddNewVehicle(String reservation_number_value, String lot_name, String lot_address, String license_plate, String state, String new_vehicle_country, String new_vehicle_state, String new_license_plate) {
        basicAssertionsAndClickOnShowMoreButton(reservation_number_value, lot_name, lot_address, license_plate);
        clickOnChangeVehicle();
        // vehicle_information.changeVehicleData(license_plate, state ,new_vehicle_country, new_vehicle_state, new_license_plate);

    }

    public void changeVehicleBySelectingAnotherFromTheList(String reservation_number_value, String lot_name, String lot_address, String license_plate, String[][] vehicles_list) {
        basicAssertionsForRegisteredUserAndClickOnShowMoreButton(reservation_number_value, lot_name, lot_address, license_plate);
        String new_vehicle = selectNewVehicleFromTheList(vehicles_list, license_plate);
        assertChangeVehicleSuccessMessageAndClickOk();
        assertReservationWasUpdatedWithNewVehicle(new_vehicle);
    }

    public void assertNewVehicleAndReservationData(String reservation_number_value, String lot_name, String lot_address, String new_license_plate){
        goToDashboardAfterClosingReservationScreen();
        assertGuestUserReservationDetails(reservation_number_value, lot_name, lot_address, new_license_plate);
    }

}
