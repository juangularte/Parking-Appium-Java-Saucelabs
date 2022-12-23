package android.screens;

import java.text.DecimalFormat;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class ReservationConfirmationScreenAndroid extends BaseActionsAndroid{

    protected Logger log;
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected CheckoutYourInformationScreenAndroid your_information;
    protected CheckoutVehicleInformationScreenAndroid vehicle_information;
    protected CheckoutPaymentInformationScreenAndroid payment_information;

    public ReservationConfirmationScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }
    //LOADER
    By loading = (By.xpath("//*[@resource-id='android:id/message'][@text='Loading…']"));

    //HEADER
    By close_button = (By.id("com.spplus.parking.develop:id/closeButton"));
    By reservation_title = (By.xpath("//android.widget.TextView[@text='Reservation']"));
    By mobile_pass = (By.id("com.spplus.parking.develop:id/vehicleHeaderTitle"));

    //RESERVATION MAIN INFO
    By header_subtitle = (By.id("com.spplus.parking.develop:id/headerSubtitle"));
    By reservation_number_label = (By.id("com.spplus.parking.develop:id/reservationNumberLabel"));
    By license_plate_label = (By.id("com.spplus.parking.develop:id/licensePlateNumberLabel"));
    By reservation_number_value = (By.id("com.spplus.parking.develop:id/reservationNumberField"));
    By license_plate_value = (By.id("com.spplus.parking.develop:id/licensePlateNumberField"));
    By purchased_on_label = (By.id("com.spplus.parking.develop:id/purchasedOnLabel"));
    By vehicle_size_label = (By.id("com.spplus.parking.develop:id/reservationVehicleSizeTextViewForLP"));

    //RESERVATION DETAILS
    By reservation_details_title = (By.id("com.spplus.parking.develop:id/reservationDetailsTextview"));
    By reservation_lot_name = (By.id("com.spplus.parking.develop:id/reservationLotNameTextView"));
    By reservation_lot_address1 = (By.id("com.spplus.parking.develop:id/reservationLotAddressTextView"));
    By reservation_lot_address2 = (By.id("com.spplus.parking.develop:id/reservationLotAddress2TextView"));
    By reservation_lot_price = (By.id("com.spplus.parking.develop:id/reservationLotPriceTextView"));
    By reservation_entrance_label = (By.id("com.spplus.parking.develop:id/reservationEntranceTitleTextView"));
    By reservation_entrance_address = (By.id("com.spplus.parking.develop:id/reservationEntranceTextView"));
    By reservation_get_directions = (By.id("com.spplus.parking.develop:id/reservationGetDirectionsTextView"));
    By reservation_product = (By.id("com.spplus.parking.develop:id/reservationProductNameTitleTextView"));
    By reservation_entrance_date_time_label = (By.id("com.spplus.parking.develop:id/entranceTimeLabel"));
    By reservation_exit_date_time_label= (By.id("com.spplus.parking.develop:id/exitTimeLabel"));
    By reservation_entrance_date_time = (By.id("com.spplus.parking.develop:id/entranceTime"));
    By reservation_exit_date_time = (By.id("com.spplus.parking.develop:id/exitTime"));

    //CANCEL RESERVATION
    By cancel_reservation_title = (By.id("com.spplus.parking.develop:id/cancelButton"));
    By cancel_reservation_message = (By.id("com.spplus.parking.develop:id/message"));
    By cancel_reservation_close_button = (By.id("com.spplus.parking.develop:id/cancelButton"));
    By cancel_reservation_confirm_button = (By.id("com.spplus.parking.develop:id/okButton"));
    By reservation_cancelled_success = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/title'][@text='Success!']"));
    By reservation_cancelled_succes_message = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/message'][@text='Your reservation has been cancelled']"));
    By reservation_cancelled_success_ok_button = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/button'][@text='OK']"));


    //PRINTED-MOBILE PASS
    By printed_mobile_title = (By.xpath("*[@resource-id='com.spplus.parking.develop:id/printedOrMobilePassLayout']/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));
    By printed_mobile_description = (By.xpath("*[@resource-id='com.spplus.parking.develop:id/printedOrMobilePassLayout']/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/description']"));
    By operated_By = (By.id("com.spplus.parking.develop:id/reservationOperatedByLabel"));

    //PRODUCT DESCRIPTION
    By product_description_title = (By.id("com.spplus.parking.develop:id/reservationProductDescriptionTitleTextView"));
    By product_description_item = (By.id("com.spplus.parking.develop:id/reservationProductDescriptionTextView"));

    //HOW TO USE YOUR PASS
    By how_to_use_your_pass_title = (By.id("com.spplus.parking.develop:id/reservationRedemptionInstructionsTitleTextView"));
    By how_to_use_your_pass_description = (By.id("com.spplus.parking.develop:id/reservationRedemptionInstructionsTextView"));
    
    //AMENITIES
    By amenities_title = (By.id("com.spplus.parking.develop:id/reservationAmenitiesTitleTextView"));
    //TODO Add remaining amenities locators

    //FOOTER
    By change_vehicle = (By.id("com.spplus.parking.develop:id/changeVehicleButton"));
    By cancel_reservation = (By.id("com.spplus.parking.develop:id/cancelOrderButton"));
    
    public void assertUserIsOnReservationScreen() {
        assert_text(reservation_title, "Reservation");
        log.info("RESERVATION SCREEN");
    }

    public void assertCommonElements(){
        
        if (check_if_element_is_present(loading).equals(true)){
            try {
                assert_text(loading, "Loading…");
            } catch (StaleElementReferenceException e) {}
            log.info("Loading...");
        }else{log.info("No 'loading' was displayed.");}
        
        while(check_if_element_is_present(loading).equals(true)){
            if (check_if_element_is_present(loading).equals(false)){
                log.info("Load completed.");
                break;
            }
        }
        assertUserIsOnReservationScreen();
        assert_text(header_subtitle, "Make sure your license plate matches the vehicle you park to avoid towing.");
        assert_text(reservation_number_label, "RESERVATION NUMBER");
        assert_text(license_plate_label, "LICENSE PLATE NUMBER");
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
        assert_text(reservation_lot_name, lotInfo[0]);
        assert_text(reservation_lot_address1, lotInfo[1].replace("ENTRANCE  ", ""));
        // assert_text(reservation_lot_address2, lotInfo[2]);
        assert_text(reservation_lot_price, "$ "+purchase_price.replace("$", ""));
        assert_text(reservation_entrance_address, lotInfo[1].replace("ENTRANCE  ", ""));
        assert_text(vehicle_size_label, vehicle_size+" SIZE VEHICLE");
        log.info("Purchase details values were correctly asserted.");
        return reservation_number;
    }

    public String assertEventInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        String reservation_number = text(reservation_number_value);
        assert_text(license_plate_value, license_plate);
        // DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
        // LocalDateTime current_date = LocalDateTime.now();
        // assert_text(purchased_on_label, "Purchased on "+date_formatter.format(current_date));
        assert_text(reservation_lot_name, lotInfo[0]);
        assert_text(reservation_lot_address1, lotInfo[1].replace("ENTRANCE  ", ""));
        // assert_text(reservation_lot_address2, lotInfo[2]);
        assert_text(reservation_lot_price, "$ "+purchase_price.replace("$", ""));
        assert_text(reservation_entrance_address, lotInfo[1].replace("ENTRANCE  ", ""));
        log.info("Purchase details values were correctly asserted.");
        return reservation_number;
    }

    public void assertEntranceExitDateTime(String[] dateTimeValues){
        scrollToText("ENTRANCE TIME");
        assert_text(reservation_entrance_date_time_label, "ENTRANCE TIME");
        assert_text(reservation_exit_date_time_label, "EXIT TIME");
        assert_text(reservation_entrance_date_time, dateTimeValues[0]);
        assert_text(reservation_exit_date_time, dateTimeValues[1]);
    }

    public void assertBottomElements(){
        scrollToText("AMENITIES");
        assert_text(operated_By, "OPERATED BY");
        assert_text(product_description_title, "PRODUCT DESCRIPTION");
        assert_text(how_to_use_your_pass_title, "HOW TO USE YOUR PASS");
        // assert_text(how_to_use_your_pass_description, "This is a test. Is this thing on What happens if the tag is broken Does is still accept emails");
        assert_text(amenities_title, "AMENITIES");
        //TODO check if both buttons should appear always
        assert_text(change_vehicle, "CHANGE VEHICLE");
        assert_text(cancel_reservation, "CANCEL RESERVATION");
        log.info("All basic assertions at the bottom passed.");
    }

    public void assertEventBottomElements(){
        scrollToText("AMENITIES");
        assert_text(operated_By, "OPERATED BY");
        assert_text(product_description_title, "PRODUCT DESCRIPTION");
        assert_text(how_to_use_your_pass_title, "HOW TO USE YOUR PASS");
        // assert_text(how_to_use_your_pass_description, "This is a test. Is this thing on What happens if the tag is broken Does is still accept emails");
        assert_text(amenities_title, "AMENITIES");
        //TODO check if both buttons should appear always
        // assert_text(change_vehicle, "CHANGE VEHICLE");
        // assert_text(cancel_reservation, "CANCEL RESERVATION");
        log.info("All basic assertions at the bottom passed.");
    }

    public void clickOnChangeVehicle(){
        click(change_vehicle);
        log.info("Change Vehicle button was clicked.");
    }

    public void clickOnCancelReservation(){
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
        assert_text(reservation_cancelled_success, "Success!");
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
        scrollToText("Reservation");
        click(close_button);
        log.info("Reservation screen was closed.");
    }

    public String assertCheckoutInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues){
        assertCommonElements();
        String reservation_number = assertInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        assertEntranceExitDateTime(dateTimeValues);
        assertBottomElements();
        log.info("Reservation number: "+reservation_number);
        return reservation_number;
    }

    public String assertEventCheckoutInformationAndGetReservationNumber(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price){
        assertCommonElements();
        String reservation_number = assertEventInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price);
        // assertEntranceExitDateTime(dateTimeValues);
        assertEventBottomElements();
        log.info("Reservation number: "+reservation_number);
        return reservation_number;
    }

    public String assertCheckoutInformationGetReservationNumberAndClose(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues){
        String reservation_number = assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price, dateTimeValues);
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
        scrollToText("Reservation");
        Boolean is_license_plate_present = check_if_element_is_present(license_plate_value);
        if(is_license_plate_present.equals(true)){
            assert_text(license_plate_value, new_license_plate);
            log.info("Vehicle was changed. New license plate is: "+new_license_plate);
        }
        closeReservationScreen();
        return is_license_plate_present;
    }

    public String assertCheckoutInformationGetReservationNumberAndChangeVehicle(String vehicle_size, String license_plate, String[] lotInfo, String purchase_price, String[] dateTimeValues, String state, String new_vehicle_country, String new_vehicle_state, String new_license_plate){
        String reservation_number = assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lotInfo, purchase_price, dateTimeValues);
        clickOnChangeVehicle();
        CheckoutVehicleInformationScreenAndroid vehicle_information = new CheckoutVehicleInformationScreenAndroid(driver, log);
        vehicle_information.changeVehicleData(license_plate, state, new_vehicle_country, new_vehicle_state, new_license_plate);
        // waitUntilFinishLoading();
        // Boolean is_license_plate_present = assertVehicleWasChanged(new_license_plate);
        assertVehicleWasChanged(new_license_plate);
        return reservation_number;
    }
}
