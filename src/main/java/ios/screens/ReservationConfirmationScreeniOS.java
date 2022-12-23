package ios.screens;

import java.text.DecimalFormat;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class ReservationConfirmationScreeniOS extends BaseActionsIOS{

    protected Logger log;
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected CheckoutYourInformationScreeniOS your_information;
    protected CheckoutVehicleInformationScreeniOS vehicle_information;
    protected CheckoutPaymentInformationScreeniOS payment_information;

    public ReservationConfirmationScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }
    //LOADER
    By loading = (AppiumBy.accessibilityId("In progress"));

    //RATE APP
    By rate_modal_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[starts-with(@name,'Enjoying')]"));
    By rate_modal_subtitle = (AppiumBy.accessibilityId("Tap a star to rate it on the App Store."));
    By not_now = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Not Now\"]"));

    //HEADER
    // By close_button = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/closeButton"));
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By reservation_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Parking Pass\"]"));
    By mobile_pass = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle_white\"]/following-sibling::XCUIElementTypeStaticText"));

    //RESERVATION MAIN INFO
    By header_subtitle = (AppiumBy.accessibilityId("Make sure your license plate matches the vehicle you park to avoid towing."));
    By printed_pass_warning = (AppiumBy.accessibilityId("Requires printed parking pass"));
    By reservation_number_label = (AppiumBy.accessibilityId("ORDER #"));
    By reservation_number_value = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ORDER #\"]/following-sibling::XCUIElementTypeStaticText"));
    By license_plate_label = (AppiumBy.accessibilityId("LICENSE PLATE NUMBER"));
    By license_plate_value = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeStaticText"));
    By purchased_on_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(text(),\"Purchased on\")]"));
    By vehicle_size_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(text(),\"Purchased on\")]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]"));
    By note_parking_voucher = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(text(),\"Purchased on\")]/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]"));

    //RESERVATION DETAILS
    By reservation_details_title = (AppiumBy.accessibilityId("RESERVATION DETAILS"));
    By reservation_lot_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[1]"));
    By reservation_lot_address1 = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/following-sibling::XCUIElementTypeStaticText"));
    // By reservation_lot_address2 = (AppiumBy.xpath("com.spplus.parking.develop:id/reservationLotAddress2TextView"));
    By reservation_lot_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText[2]"));
    By reservation_entrance_label = (AppiumBy.accessibilityId("PARKING ENTRANCE"));
    By reservation_entrance_address = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PARKING ENTRANCE\"]/following-sibling::XCUIElementTypeStaticText"));
    By reservation_get_directions = (AppiumBy.accessibilityId("GET DIRECTIONS"));
    // By reservation_product = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationProductNameTitleTextView"));
    By reservation_entrance_date_time_label = (AppiumBy.accessibilityId("ENTRANCE TIME"));
    By reservation_exit_date_time_label= (AppiumBy.accessibilityId("EXIT TIME"));
    By reservation_entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By reservation_exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));

    //CANCEL RESERVATION
    By cancel_reservation_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Cancel Reservation?\"]"));
    By cancel_reservation_message = (AppiumBy.accessibilityId("Transaction will be refunded and Parking Pass will be no longer valid once you cancel this reservation."));
    By cancel_reservation_close_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Close\"]"));
    By cancel_reservation_confirm_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Confirm\"]"));
    By reservation_cancelled_success = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Success\"]"));
    By reservation_cancelled_succes_message = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Your reservation has been cancelled\"]"));
    By reservation_cancelled_success_ok_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]"));

    //PRINTED-MOBILE PASS
    By printed_mobile_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/XCUIElementTypeStaticText[1]"));
    By printed_mobile_description = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/XCUIElementTypeStaticText[2]"));
    // By operated_By = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationOperatedByLabel"));

    //PRODUCT DESCRIPTION
    By product_description_title = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationProductDescriptionTitleTextView"));
    By product_description_item = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationProductDescriptionTextView"));

    //HOW TO USE YOUR PASS
    By how_to_use_your_pass_title = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationRedemptionInstructionsTitleTextView"));
    By how_to_use_your_pass_description = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationRedemptionInstructionsTextView"));
    
    //AMENITIES
    By amenities_title = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/reservationAmenitiesTitleTextView"));
    //TODO Add remaining amenities locators

    //FOOTER
    By change_vehicle = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CHANGE VEHICLE\"]"));
    By cancel_reservation = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CANCEL RESERVATION\"]"));
    
    public void assertUserIsOnReservationScreen() {
        waitUntilFinishLoading();
        checkIfRateModalAppears();
        assert_text(reservation_title, "Parking Pass");
        log.info("RESERVATION SCREEN");
    }

    public void checkIfRateModalAppears() {
        try {
            waitForElementToBeVisible(rate_modal_title, (long) 10);
            log.info("Rate modal is displayed.");
            assert_text(rate_modal_subtitle, "Tap a star to rate it on the App Store.");
            click(not_now);
            log.info("Rate App modal was displayed. Not Now button was clicked.");
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
    }

    public void assertCommonElements(){
        
        // if (check_if_element_is_present(loading).equals(true)){
        //     try {
        //         assert_text(loading, "Loading…");
        //     } catch (StaleElementReferenceException e) {}
        //     log.info("Loading...");
        // }else{log.info("No 'loading' was displayed.");}
        
        // while(check_if_element_is_present(loading).equals(true)){
        //     if (check_if_element_is_present(loading).equals(false)){
        //         log.info("Load completed.");
        //         break;
        //     }
        // }
        assertUserIsOnReservationScreen();
        assert_text(header_subtitle, "Make sure your license plate matches the vehicle you park to avoid towing.");
        assert_text(reservation_number_label, "ORDER #");
        assert_text(license_plate_label, "LICENSE PLATE NUMBER");
        assert_text(reservation_details_title, "RESERVATION DETAILS");
        assert_text(reservation_entrance_label, "PARKING ENTRANCE");
        assert_text(reservation_get_directions, "GET DIRECTIONS");
        //TODO Add PRINTED/MOBILE assertion
        log.info("All basic assertions passed.");
    }

    public void assertCommonElementsForPrintedPassRequired(){
        
        // if (check_if_element_is_present(loading).equals(true)){
        //     try {
        //         assert_text(loading, "Loading…");
        //     } catch (StaleElementReferenceException e) {}
        //     log.info("Loading...");
        // }else{log.info("No 'loading' was displayed.");}
        
        // while(check_if_element_is_present(loading).equals(true)){
        //     if (check_if_element_is_present(loading).equals(false)){
        //         log.info("Load completed.");
        //         break;
        //     }
        // }
        assertUserIsOnReservationScreen();
        assert_text(printed_pass_warning, "Requires printed parking pass");
        assert_text(reservation_number_label, "ORDER #");
        // assert_text(license_plate_label, "LICENSE PLATE NUMBER");
        assert_text(reservation_details_title, "RESERVATION DETAILS");
        assert_text(reservation_entrance_label, "PARKING ENTRANCE");
        assert_text(reservation_get_directions, "GET DIRECTIONS");
        //TODO Add PRINTED/MOBILE assertion
        log.info("All basic assertions passed.");
    }

    public String assertInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        String reservation_number = text(reservation_number_value);
        assert_text(license_plate_value, license_plate);
        // DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        // LocalDateTime current_date = LocalDateTime.now();
        // assert_text(purchased_on_label, "Purchased on "+date_formatter.format(current_date));
        assert_text(reservation_lot_name, lotInfo[0].toUpperCase());
        // assert_text(reservation_lot_address1, lotInfo[1].replace("ENTRANCE  ", ""));
        // assert_text(reservation_lot_address2, lotInfo[2]);
        // assert_text(reservation_lot_price, "$ "+purchase_price.replace("$", ""));
        assert_text(reservation_lot_price, purchase_price);
        assert_contains_text(reservation_entrance_address, lotInfo[1].replace("ENTRANCE  ", ""));
        // assert_text(vehicle_size_label, vehicle_size+" SIZE VEHICLE");
        log.info("Purchase details values were correctly asserted.");
        return reservation_number;
    }

    // public String assertPrintedPassRequiredInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
    //     String reservation_number = text(reservation_number_value);
    //     // assert_text(license_plate_value, license_plate);
    //     // DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
    //     // LocalDateTime current_date = LocalDateTime.now();
    //     // assert_text(purchased_on_label, "Purchased on "+date_formatter.format(current_date));
    //     assert_text(reservation_lot_name, lotInfo[0].toUpperCase());
    //     // assert_text(reservation_lot_address1, lotInfo[1].replace("ENTRANCE  ", ""));
    //     // assert_text(reservation_lot_address2, lotInfo[2]);
    //     // assert_text(reservation_lot_price, "$ "+purchase_price.replace("$", ""));
    //     assert_text(reservation_lot_price, purchase_price);
    //     assert_contains_text(reservation_entrance_address, lotInfo[1].replace("ENTRANCE  ", ""));
    //     // assert_text(vehicle_size_label, vehicle_size+" SIZE VEHICLE");
    //     log.info("Purchase details values were correctly asserted.");
    //     return reservation_number;
    // }

    public String assertEventAccessCodeInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        assertUserIsOnReservationScreen();
        String reservation_number = text(reservation_number_value);
        // assert_text(license_plate_value, license_plate);
        // DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        // LocalDateTime current_date = LocalDateTime.now();
        // assert_text(purchased_on_label, "Purchased on "+date_formatter.format(current_date));
        assert_text(reservation_lot_name, lotInfo[0].toUpperCase());
        // assert_contains_text(reservation_lot_address1, lotInfo[1].replace("ENTRANCE  ", ""));
        // assert_text(reservation_lot_address2, lotInfo[2]);
        assert_text(reservation_lot_price, purchase_price);
        assert_contains_text(reservation_entrance_address, lotInfo[1].replace("ENTRANCE  ", ""));
        log.info("Purchase details values were correctly asserted.");
        return reservation_number;
    }

    public void assertEntranceExitDateTime(String[] dateTimeValues){
        scrollDownToText("ENTRANCE TIME");
        assert_text(reservation_entrance_date_time_label, "ENTRANCE TIME");
        assert_text(reservation_exit_date_time_label, "EXIT TIME");
        assert_text(reservation_entrance_date_time, dateTimeValues[0]);
        assert_text(reservation_exit_date_time, dateTimeValues[1]);
    }

    public void assertBottomElements(){
        scrollDownToText("CHANGE VEHICLE");
        // assert_text(operated_By, "OPERATED BY");
        // assert_text(product_description_title, "PRODUCT DESCRIPTION");
        // assert_text(how_to_use_your_pass_title, "HOW TO USE YOUR PASS");
        // assert_text(how_to_use_your_pass_description, "This is a test. Is this thing on What happens if the tag is broken Does is still accept emails");
        // assert_text(amenities_title, "AMENITIES");
        //TODO check if both buttons should appear always
        assert_text(change_vehicle, "CHANGE VEHICLE");
        assert_text(cancel_reservation, "CANCEL RESERVATION");
        log.info("All basic assertions at the bottom passed.");
    }

    public void assertEventBottomElements(){
        scrollDownToText("AMENITIES");
        // assert_text(operated_By, "OPERATED BY");
        // assert_text(product_description_title, "PRODUCT DESCRIPTION");
        // assert_text(how_to_use_your_pass_title, "HOW TO USE YOUR PASS");
        // assert_text(how_to_use_your_pass_description, "This is a test. Is this thing on What happens if the tag is broken Does is still accept emails");
        // assert_text(amenities_title, "AMENITIES");
        //TODO check if both buttons should appear always
        assert_text(change_vehicle, "CHANGE VEHICLE");
        assert_text(cancel_reservation, "CANCEL RESERVATION");
        log.info("All basic assertions at the bottom passed.");
    }

    public void clickOnChangeVehicle(){
        scrollDownToText("CHANGE VEHICLE");
        click(change_vehicle);
        log.info("Change Vehicle button was clicked.");
    }

    public void clickOnCancelReservation(){
        scrollDownToText("CANCEL RESERVATION");
        click(cancel_reservation);
        log.info("Cancel Reservation button was clicked.");
    }

    public void checkCancelReservationPopup() {
        assert_text(cancel_reservation_title, "Cancel Reservation?");
        assert_text(cancel_reservation_message, "Transaction will be refunded and Parking Pass will be no longer valid once you cancel this reservation.");
        assert_text(cancel_reservation_close_button, "Close");
        assert_text(cancel_reservation_confirm_button, "Confirm");
        log.info("Cancel Reservation popup displayed.");
    }

    public void clickOnConfirmCancelReservation() {
        click(cancel_reservation_confirm_button);
        log.info("Confirm button was clicked. Reservation should be cancelled.");
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
        log.info("Loading...");
        waitForElementToDisappear(loading_element, (long) 20);
        try {
            WebElement loading_element2 = waitForElementToBeVisible(loading, (long) 5);
            waitForElementToDisappear(loading_element2, (long) 20);
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
        
            //         log.info("Load completed.");
            //         break;
            //     }
        // int i = 0;
        // while(check_if_element_is_present(loading).equals(true)){
        //     // i++;
        //     // System.out.println("Loop: "+i);
        //     if (check_if_element_is_present(loading).equals(false)){
        //         log.info("Load completed.");
        //         break;
        //     }
        // }
    }

    public void assertCancellationSuccessMessageAndClickOk() {
        assert_text(reservation_cancelled_success, "Success");
        assert_text(reservation_cancelled_succes_message, "Your reservation has been cancelled");
        click(reservation_cancelled_success_ok_button);
        log.info("Cancellation 'success' message was displayed. OK button was clicked.");
    }

    public void assertReservationWasCancelled() {
        //TODO Wait for confirmation popup
        waitUntilFinishLoading();
        assertCancellationSuccessMessageAndClickOk();
        // Assert.assertFalse(check_if_element_is_present(reservation_cards));
        log.info("Reservation was cancelled.");
    }

    public void closeReservationScreen() {
        scrollUpToText("ORDER #");
        click(back_button);
        log.info("Reservation screen was closed.");
    }

    public String assertCheckoutInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues){
        assertCommonElements();
        String reservation_number = assertInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        // assertEntranceExitDateTime(dateTimeValues);
        assertBottomElements();
        log.info("Reservation number: "+reservation_number);
        return reservation_number;
    }

    public String assertPrintedPassRequiredCheckoutInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        assertCommonElementsForPrintedPassRequired();
        String reservation_number = assertEventAccessCodeInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        // assertEntranceExitDateTime(dateTimeValues);
        assertBottomElements();
        log.info("Reservation number: "+reservation_number);
        return reservation_number;
    }

    public String assertEventCheckoutInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        // assertCommonElements();
        String reservation_number = assertEventAccessCodeInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        // assertEntranceExitDateTime(dateTimeValues);
        // assertEventBottomElements();
        log.info("Reservation number: "+reservation_number);
        return reservation_number;
    }

    public String assertCheckoutInformationGetReservationNumberAndClose(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues){
        String reservation_number = assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price, dateTimeValues);
        closeReservationScreen();
        return reservation_number;
    }

    public String assertPrintedPassRequiredCheckoutInformationGetReservationNumberAndClose(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        String reservation_number = assertPrintedPassRequiredCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        closeReservationScreen();
        return reservation_number;
    }

    public String assertEventCheckoutInformationGetReservationNumberAndClose(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        String reservation_number = assertEventCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        closeReservationScreen();
        return reservation_number;
    }

    public String assertCheckoutInformationGetReservationNumberAndCancelReservation(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues){
        String reservation_number = assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price, dateTimeValues);
        clickOnCancelReservation();
        clickOnConfirmCancelReservation();
        assertReservationWasCancelled();
        return reservation_number;
    }

    public Boolean assertVehicleWasChanged(String new_license_plate) {
        waitUntilFinishLoading();
        checkIfRateModalAppears();
        scrollUpToText("ORDER #");
        Boolean is_license_plate_present = check_if_element_is_present(license_plate_value);
        if(is_license_plate_present.equals(true)){
            assert_text(license_plate_value, new_license_plate);
            log.info("Vehicle was changed. New license plate is: "+new_license_plate);
        }
        closeReservationScreen();
        return is_license_plate_present;
    }

    public String assertCheckoutInformationGetReservationNumberAndChangeVehicle(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues, String new_vehicle_country, String new_vehicle_state, String new_license_plate){
        String reservation_number = assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price, dateTimeValues);
        clickOnChangeVehicle();
        CheckoutVehicleInformationScreeniOS vehicle_information = new CheckoutVehicleInformationScreeniOS(driver, log);
        vehicle_information.completeFields(new_license_plate, new_vehicle_country, new_vehicle_state);
        // waitUntilFinishLoading();
        // Boolean is_license_plate_present = assertVehicleWasChanged(new_license_plate);
        assertVehicleWasChanged(new_license_plate);
        return reservation_number;
    }
}
