package android.screens;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class DashboardScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public DashboardScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }
    
    //TURN ON LOCATION MODAL
    By location_modal = (By.id("com.spplus.parking.develop:id/titleLayout"));
    By location_title = (By.id("com.spplus.parking.develop:id/title"));
    By easily_find_subtext = (By.id("com.spplus.parking.develop:id/subtext"));
    By use_your_phone_message = (By.id("com.spplus.parking.develop:id/message"));
    By preferences = (By.id("com.spplus.parking.develop:id/preferenceText"));
    By modal_ok_button = (By.id("com.spplus.parking.develop:id/okButton"));

    //ALLOW ACCESS TO DEVICE'S LOCATION
    By permission_icon = (By.id("com.android.permissioncontroller:id/permission_icon"));
    By permission_message = (By.id("com.android.permissioncontroller:id/permission_message"));
    By precise_location = (By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_fine"));
    By approximate_location = (By.id("com.android.permissioncontroller:id/permission_location_accuracy_radio_coarse"));
    By while_using_app = (By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    By only_this_tme = (By.id("com.android.permissioncontroller:id/permission_allow_one_time_button"));
    By dont_allow = (By.id("com.android.permissioncontroller:id/permission_deny_button"));

    //DASHBOARD SCREEN
    By logo = (By.id("com.spplus.parking.develop:id/logoView"));
    By popup_error = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/title'][@text='ERROR']"));
    By popup_message = (By.id("com.spplus.parking.develop:id/message"));
    By find_parking_near_me_button = (By.id("com.spplus.parking.develop:id/findParkingNearMeButton"));
   
    //SEARCH BOX SECTION
    By book_reservation = (By.id("com.spplus.parking.develop:id/bookReservationTitle"));
    By daily_monthly_parking = (By.id("com.spplus.parking.develop:id/bookReservationSubtitle"));
    By search_location_box = (By.id("com.spplus.parking.develop:id/searchEntry"));

    //MENU
    By menu_button = (By.id("com.spplus.parking.develop:id/hamburger"));
    By menu = (By.id("com.spplus.parking.develop:id/drawerFragment"));
    By find_parking_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/itemFindParking']/android.widget.TextView"));
    By my_account_option_guest = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/guestOption']/android.widget.TextView"));
    By my_account_option_reg = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/accountOption']/android.widget.TextView"));
    By logout_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/logoutOption']/android.widget.TextView"));

    //SEARCH VIEW
    By find_parking_title = (By.id("com.spplus.parking.develop:id/titleLabelTextView"));
    By recomendations_title = (By.id("com.spplus.parking.develop:id/listTitleTextView"));
    By results_list = (By.id("com.spplus.parking.develop:id/resultsRecyclerView"));
    By first_result = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/resultsRecyclerView']/android.widget.TextView[1]"));
    By all_results = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/resultsRecyclerView']/android.widget.TextView"));
    By date_time_box = (By.id("com.spplus.parking.develop:id/periodSelectorView"));
    By entrance_label = (By.id("com.spplus.parking.develop:id/entranceTimeLabel"));
    By exit_label= (By.id("com.spplus.parking.develop:id/exitTimeLabel"));
    By entrance_date_time = (By.id("com.spplus.parking.develop:id/entranceTime"));
    By exit_date_time = (By.id("com.spplus.parking.develop:id/exitTime"));

    //RESERVATIONS
    By reservation_cards = (By.xpath("//androidx.viewpager.widget.ViewPager[@resource-id='com.spplus.parking.develop:id/activeReservationsViewPager']//android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/container']"));
    By reservation_label = (By.id("com.spplus.parking.develop:id/reservationLabel"));
    By reservation_date = (By.id("com.spplus.parking.develop:id/reservationDateField"));
    By reservation_number = (By.id("com.spplus.parking.develop:id/orderNumber"));
    By reservation_show_more = (By.id("com.spplus.parking.develop:id/showMoreButton"));
    By reservation_entrance_label = (By.id("com.spplus.parking.develop:id/entranceLabel"));
    By reservation_address = (By.id("com.spplus.parking.develop:id/entranceField"));
    By reservation_name = (By.id("com.spplus.parking.develop:id/lotNameField"));
    By reservation_license_plate = (By.id("com.spplus.parking.develop:id/vehiclePlate"));
    By reservation_parking_pass_button = (By.id("com.spplus.parking.develop:id/parkingPassButton"));
    By reservations_slider = (By.id("com.spplus.parking.develop:id/activeReservationsViewPager"));
    By reservations_slider_dots_section = (By.id("com.spplus.parking.develop:id/activeReservationsDotsIndicator"));
    By reservations_slider_dots = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/activeReservationsDotsIndicator']/android.view.View"));

    //TODO By reservation_entrance_exit_time = (By.id(""));
    By reservation_change_vehicle_option = (By.id("com.spplus.parking.develop:id/changeVehicleTextView"));
    By reservation_cancel_reservation_option = (By.id("com.spplus.parking.develop:id/cancelTextView"));
    By reservation_get_directions_option = (By.id("com.spplus.parking.develop:id/getDirectionsTextView"));
    By reservation_call_facility_option = (By.id("com.spplus.parking.develop:id/callFacilityTextView"));
    By show_more_close_button = (By.id("com.spplus.parking.develop:id/cancelButton"));

    By reservation_success_modal = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/title'][@text='Success!']"));
    By reservation_success_modal_ok_button = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/button'][@text='OK']"));
    
    By loading = (By.xpath("//*[@resource-id='android:id/message'][@text='Loading…']"));

    //CANCELLATION
    By cancel_reservation_title = (By.id("com.spplus.parking.develop:id/cancelButton"));
    By cancel_reservation_message = (By.id("com.spplus.parking.develop:id/message"));
    By cancel_reservation_confirm_button = (By.id("com.spplus.parking.develop:id/okButton"));
    By reservation_cancelled_succes_message = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/message'][@text='Your reservation has been cancelled']"));
    //CHANGE VEHICLE
    By reservation_select_vehicle_title = (By.xpath("//android.widget.TextView[@text='SELECT VEHICLE']"));
    By reservation_add_vehicle_option = (By.xpath("//android.widget.TextView[@text='Add Vehicle']"));
    By reservation_vehicles_list = (By.xpath("//android.widget.TextView[@text='Add Vehicle']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView"));
    By reservation_change_vehicle_succes_message = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/message'][@text='All your information has been saved!']"));
    
    //ONDEMAND SECTION
    By ondemand_box = (By.id("com.spplus.parking.develop:id/payParkingNowContainer"));
    By ondemand_box_title = (By.id("com.spplus.parking.develop:id/payNowTitle"));
    By ondemand_box_subtitle = (By.id("com.spplus.parking.develop:id/payNowSubtitle"));
    By ondemand_box_enter_zone_button = (By.id("com.spplus.parking.develop:id/codeContainer"));
    By ondemand_box_enter_zone_hash = (By.id("com.spplus.parking.develop:id/hashIcon"));
    By ondemand_box_enter_zone_text = (By.id("com.spplus.parking.develop:id/enterCodeField"));
    By ondemand_box_or_label = (By.id("com.spplus.parking.develop:id/orLabel"));
    By ondemand_box_scan_button = (By.id("com.spplus.parking.develop:id/qrButton"));

    //GOOGLE'S LOCATION POPUP
    // By google_location_service_popup = (By.xpath("//*[contains(text(), 'For a better experience')]"));
    By google_location_service_popup = (By.xpath("//*[contains(@text,'For a better experience')]"));
    By google_location_service_no_thanks_button = (By.xpath("//*[@text='No, thanks']"));



    //ONDEMAND - RESERVATION SUCCESS
    By od_success_title = (By.id("com.spplus.parking.develop:id/title"));
    By od_success_message = (By.id("com.spplus.parking.develop:id/message"));
    By od_ok_button = (By.id("com.spplus.parking.develop:id/button"));

    //OD - WHY NOT CREATE AND ACCOUNT
    By od_why_not_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][contains(@text, 'Why Not Create')]"));
    By od_extend_session = (By.id("com.spplus.parking.develop:id/line1Text"));
    By od_save_your_info = (By.id("com.spplus.parking.develop:id/line2Text"));
    By od_all_parking_passes = (By.id("com.spplus.parking.develop:id/line3Text"));
    By create_account_button = (By.xpath("//android.widget.FrameLayout[@resource-id='com.spplus.parking.develop:id/signUpButton']/android.widget.TextView"));
    By create_account_terms = (By.id("com.spplus.parking.develop:id/termsAndConditions"));
    By continue_as_guest_button = (By.xpath("//android.widget.FrameLayout[@resource-id='com.spplus.parking.develop:id/continueAsGuestButton']/android.widget.TextView"));
    By dont_show_again_checkbox = (By.id("com.spplus.parking.develop:id/notShowAgainCheckbox"));

    //ONDEMAND - RESERVATION CARD
    By od_reservation_card = (By.id("com.spplus.parking.develop:id/sessionsRecyclerView"));
    By od_reservation_card_title = (By.id("com.spplus.parking.develop:id/title"));
    By od_reservation_card_order_number = (By.id("com.spplus.parking.develop:id/orderNumber"));
    By od_reservation_card_zone_code = (By.id("com.spplus.parking.develop:id/locationCodeField"));
    By od_reservation_card_time_left_label = (By.id("com.spplus.parking.develop:id/timeLeftLabel"));
    By od_reservation_card_lot_name = (By.id("com.spplus.parking.develop:id/lotName"));
    By od_reservation_card_time_left_value = (By.id("com.spplus.parking.develop:id/timeLeft"));
    By od_reservation_card_time_left_to_add_time = (By.xpath("//android.widget.FrameLayout[@resource-id='com.spplus.parking.develop:id/timeLeft'] and @text='1 HOUR 57 MINS']"));
    By od_reservation_card_license_plate = (By.id("com.spplus.parking.develop:id/vehiclePlate"));
    By od_reservation_expiration = (By.id("com.spplus.parking.develop:id/expiration"));
    By od_reservation_card_add_time_button = (By.id("com.spplus.parking.develop:id/addTimeButton"));



    //INITIAL CONFIGURATIONS METHODS
    public void assertTurnOnLocationModalTexts(){
        log.info("DASHBOARD SCREEN");
        assert_text(location_title, "Turn on location services and discover more features.");
        assert_text(easily_find_subtext, "Easily find parking near you.");
        assert_text(use_your_phone_message, "Use your phone to bypass the\ngate and pay at certain garages.");
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

    public void clickAccountGuestOption(){
        click(my_account_option_guest);
        log.info("My Account option was clicked.");
    }

    public void clickFindParkingOption(){
        click(find_parking_option);
        log.info("Find Parking option was clicked.");
        checkIfGoogleLocationPopupAppears();
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
    public void setConfigurationsAndGoToAccountScreen(){
        setInitialConfigurations();
        displayMenuIfItsNotDisplayed();
        clickAccountGuestOption();
    }

    public void goToAccountScreen() {
        displayMenuIfItsNotDisplayed();
        clickAccountGuestOption();
    }

    //USER LOGGED IN
    public void waitUntilSignInProcessIsCompleted(){
        
        while(check_if_element_is_present(logo).equals(false)){
            if(check_if_element_is_present(popup_error).equals(true)){
                // assert_text(popup_error, "ERROR");
                throw new Error("Error message found: "+text(popup_message));
            }
            if (check_if_element_is_present(logo).equals(true)){
                log.info("Load completed.");
                break;
            }
        }
    }

    public void verifyUserIsLoggedIn(){     
        waitUntilSignInProcessIsCompleted();   
        displayMenuIfItsNotDisplayed();
        assert_text(logout_option, "Sign Out");
        log.info("User is logged in.");
	}

    public void clickAccountRegOption(){
        click(my_account_option_reg);
        log.info("My Account option was clicked.");
    }

    //
    public void verifyUserIsLoggedInAndGoToAccountScreen() {
        verifyUserIsLoggedIn();
        clickAccountRegOption();
    }

    //DASHBOARD METHODS
    public void tapOnSearchBox(){
        click(search_location_box);
        assert_text(find_parking_title, "Find Parking");
        log.info("Ready to search a location.");
    }

    public void goToSearchScreen(){
        tapOnSearchBox();
    }
 
   //AFTER GUEST RESERVATION
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
            int active_reservations = amount_of_elements(reservations_slider_dots);
            log.info("There are "+active_reservations+" active reservations.");
            return active_reservations;
        }
    }

    public void swipeToTheNextReservationCard() {
        swipeElementToLeft(reservations_slider);
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
                        swipeElementToLeft(reservations_slider); //TODO: Fix the swipe function
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
        Assert.assertFalse(check_if_element_is_present(reservation_cards));
        log.info("Reservation was cancelled.");
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

    //ONDEMAND

    public void checkOnDemandSectionsIsDisplayed() {

        try {
            assert_element_is_displayed(ondemand_box);
        log.info("OnDemand section is displayed.");
        } catch (Exception | Error e) {
            throw new Error("OnDemand was not displayed correctly.");
        }
    }

    public void assertOnDemandSection() {
        try {
            assert_text(ondemand_box_title, "Pay for Parking Now");
            assert_text(ondemand_box_subtitle, "Find the 5-digit Zone # or QR Code on the sign nearest your vehicle.");
            assert_element_is_displayed(ondemand_box_enter_zone_button);
            assert_element_is_displayed(ondemand_box_enter_zone_hash);
            assert_text(ondemand_box_enter_zone_text, "Enter Zone");
            assert_text(ondemand_box_or_label, "OR");
            assert_text(ondemand_box_scan_button, "SCAN");
            log.info("All elements in OnDemand section were displayed correctly.");
        } catch (Exception | Error e) {
            throw new Error("All the elements in OnDemand were not displayed correctly.");
        }
    }

    public void clickEnterZoneButton() {
        click(ondemand_box_enter_zone_button);
        log.info("Enter Zone button was clicked.");
    }

    public void goToOnDemandEnterZoneScreen() {
        checkOnDemandSectionsIsDisplayed();
        assertOnDemandSection();
        clickEnterZoneButton();
    }

    //ONDEMAND SUCCESS RESERVATION

    public void checkODPurchaseWasSuccessful(String email){
        waitUntilFinishLoading();
        assert_text(od_success_title, "Payment Received!");
        assert_text(od_success_message, "We’ve just sent a receipt to\n"+email);
        assert_text(od_ok_button, "OK");
        click(od_ok_button);
        log.info("OD reservation was successful!");
    }

    public void checkWhyNotCreateAccountModalAppears() {
        // waitUntilFinishLoading();
        assert_text(od_why_not_title, "Why Not Create\nan Account?");
        assert_text(od_extend_session, "Extend your session with ease!");
        assert_text(od_save_your_info, "Save your info for seamless time extensions and checkout!");
        assert_text(od_all_parking_passes, "All parking passes in one place.");
        assert_text(create_account_button, "CREATE ACCOUNT");
        assert_text(create_account_terms, "By creating an Account you agree to Parking.com’s Terms & Conditions");
        assert_text(continue_as_guest_button, "No Thanks - Continue as Guest");
        assert_text(dont_show_again_checkbox, "Don’t show this again");
        log.info("Why Not Create an Account modal is displayed.");
    }

    public void clickOnContinueAsGuest() {
        click(continue_as_guest_button);
        log.info("Continue as Guest button was clicked.");
    }

    public String checkODReservationCardDetails(String zone_code, String lot_name, String license_plate, String email) {

        checkODPurchaseWasSuccessful(email);
        checkWhyNotCreateAccountModalAppears();
        clickOnContinueAsGuest();
        assert_element_is_displayed(od_reservation_card);
        assert_text(od_reservation_card_title, "ACTIVE SESSION");
        String reservation_number = text(od_reservation_card_order_number);
        Assert.assertTrue(reservation_number.contains("Order #:"));
        assert_text(od_reservation_card_time_left_label, "TIME LEFT");
        // assert_text(od_reservation_card_add_time_button, "ADD TIME");
        assert_text(od_reservation_card_zone_code, zone_code);
        assert_text(od_reservation_card_lot_name, lot_name);
        assert_text(od_reservation_card_license_plate, license_plate);
        log.info("OnDemand reservation card contains the correct data.");
        return reservation_number.replace("Order #: ", "");
    }

    public void checkODReservationCardDetailsAfterAddingTime(String zone_code, String lot_name, String license_plate, String email, String reservation_number) {

        checkODPurchaseWasSuccessful(email);
        checkWhyNotCreateAccountModalAppears();
        clickOnContinueAsGuest();
        assert_element_is_displayed(od_reservation_card);
        assert_text(od_reservation_card_title, "ACTIVE SESSION");
        assert_text(od_reservation_card_order_number, "Order #: "+reservation_number);
        assert_text(od_reservation_card_time_left_label, "TIME LEFT");
        // assert_text(od_reservation_card_add_time_button, "ADD TIME");
        assert_text(od_reservation_card_zone_code, zone_code);
        assert_text(od_reservation_card_lot_name, lot_name);
        assert_text(od_reservation_card_license_plate, license_plate);
        log.info("OnDemand reservation card contains the correct data.");
    }

    public String checkODRegisteredUserReservationCardDetails(String zone_code, String lot_name, String license_plate, String email) {

        checkODPurchaseWasSuccessful(email);
        assert_element_is_displayed(od_reservation_card);
        assert_text(od_reservation_card_title, "ACTIVE SESSION");
        String reservation_number = text(od_reservation_card_order_number);
        Assert.assertTrue(reservation_number.contains("Order #:"));
        assert_text(od_reservation_card_time_left_label, "TIME LEFT");
        // assert_text(od_reservation_card_add_time_button, "ADD TIME");
        assert_text(od_reservation_card_zone_code, zone_code);
        assert_text(od_reservation_card_lot_name, lot_name);
        assert_text(od_reservation_card_license_plate, license_plate);
        log.info("OnDemand reservation card contains the correct data.");
        return reservation_number.replace("Order #: ", "");
    }

    public void checkODRegisteredUserReservationCardDetailsAfterAddingTime(String zone_code, String lot_name, String license_plate, String email, String reservation_number) {

        checkODPurchaseWasSuccessful(email);
        assert_element_is_displayed(od_reservation_card);
        assert_text(od_reservation_card_title, "ACTIVE SESSION");
        assert_text(od_reservation_card_order_number, "Order #: "+reservation_number);
        assert_text(od_reservation_card_time_left_label, "TIME LEFT");
        // assert_text(od_reservation_card_add_time_button, "ADD TIME");
        assert_text(od_reservation_card_zone_code, zone_code);
        assert_text(od_reservation_card_lot_name, lot_name);
        assert_text(od_reservation_card_license_plate, license_plate);
        log.info("OnDemand reservation card contains the correct data.");
    }

    public Boolean checkIfAddTimeButtonIsPresent() {
        return check_if_element_is_present(od_reservation_card_add_time_button).equals(true) ? true : false;
    }

    public void clickAddTime() {
        
        // while (checkIfAddTimeButtonIsPresent().equals(false)){
        //     log.info("Add Time button is not present.");
        // }
        try {
            waitForElementToBeLocated(od_reservation_card_add_time_button, (long) 120);
            log.info("Add Time button is present.");
            click(od_reservation_card_add_time_button);
            log.info("Add Time button was clicked.");
        } catch (TimeoutException e) {
            throw new Error("Add Time button was not present.");
        }
        waitUntilFinishLoading();
    }
}
