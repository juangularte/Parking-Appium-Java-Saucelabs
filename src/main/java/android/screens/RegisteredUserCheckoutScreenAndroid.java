package android.screens;

import java.text.DecimalFormat;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class RegisteredUserCheckoutScreenAndroid extends BaseActionsAndroid{

    protected Logger log;
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected CheckoutYourInformationScreenAndroid your_information;
    protected CheckoutVehicleInformationScreenAndroid vehicle_information;
    protected CheckoutPaymentInformationScreenAndroid payment_information;

    public RegisteredUserCheckoutScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //SCROLL
    By scrollable = (By.xpath("//android.widget.ScrollView"));

    //HEADER
    By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
    By checkout_title = (By.xpath("//android.widget.TextView[@text='Checkout']"));

    //HAVE ACCOUNT
    By have_account_label = (By.xpath("//android.widget.TextView[@text='Already have an account?']"));
    By sign_in_button = (By.id("com.spplus.parking.develop:id/buttonSignIn"));

    //LOT DETAILS
    By purchase_time_label = (By.id("com.spplus.parking.develop:id/timeToPurchaseLabel"));
    By purchase_time = (By.id("com.spplus.parking.develop:id/timeToPurchaseField"));
    By lot_name = (By.id("com.spplus.parking.develop:id/headerTitle"));
    By lot_address = (By.id("com.spplus.parking.develop:id/headerSubtitle"));
    By lot_header_price = (By.id("com.spplus.parking.develop:id/headerPrice"));
    By entrance_label = (By.id("com.spplus.parking.develop:id/entranceTimeLabel"));
    By exit_label= (By.id("com.spplus.parking.develop:id/exitTimeLabel"));
    By entrance_date_time = (By.id("com.spplus.parking.develop:id/entranceTime"));
    By exit_date_time = (By.id("com.spplus.parking.develop:id/exitTime"));

    //YOUR INFORMATION
    By personal_information_title = (By.xpath("//android.widget.TextView[@text='PERSONAL INFORMATION']"));
    By personal_information_name_email = (By.id("com.spplus.parking.develop:id/userData"));
    By personal_information_name_email_edit = (By.id("com.spplus.parking.develop:id/userEditLabel"));
    By personal_information_phone = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/userData']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/information']"));
    By personal_information_phone_edit = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/userData']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));
    // By your_information_edit_info_button = (By.id("com.spplus.parking.develop:id/editLabel"));

    //VEHICLE INFORMATION
    By vehicle_information_title = (By.xpath("//android.widget.TextView[@text='VEHICLE INFORMATION']"));
    By vehicle_information_license_plate = (By.xpath("//android.widget.TextView[@text='VEHICLE INFORMATION']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/information']"));
    By vehicle_information_edit = (By.xpath("//android.widget.TextView[@text='VEHICLE INFORMATION']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));
    
    //PAYMENT INFORMATION
    By payment_information_title = (By.xpath("//android.widget.TextView[@text='PAYMENT INFORMATION']"));
    By payment_information_cc = (By.xpath("//android.widget.TextView[@text='PAYMENT INFORMATION']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/information']"));
    By payment_information_edit = (By.xpath("//android.widget.TextView[@text='PAYMENT INFORMATION']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));
    
    //PRINTED-MOBILE PASS
    By printed_mobile_title = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/printedOrMobilePassLayout']/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));
    By printed_mobile_description = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/printedOrMobilePassLayout']/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/description']"));

    //PROMO CODE
    By have_promo_code_label = (By.id("com.spplus.parking.develop:id/promoTitle"));
    By promo_code_field = (By.id("com.spplus.parking.develop:id/promoCodeField"));
    By apply_promo_code_button = (By.id("com.spplus.parking.develop:id/promoCodeButton"));

    //PURCHASE DETAILS
    By parking_price_label = (By.id("com.spplus.parking.develop:id/parking_reservation_label"));
    By lot_original_price = (By.id("com.spplus.parking.develop:id/parkingReservation"));
    By oversize_label = (By.id("com.spplus.parking.develop:id/oversizeLabel"));
    By oversize_price = (By.id("com.spplus.parking.develop:id/oversizeField"));
    By discount_label = (By.id("com.spplus.parking.develop:id/discountLabel"));
    By discount_value = (By.id("com.spplus.parking.develop:id/discountField"));
    By service_fee_label = (By.id("com.spplus.parking.develop:id/service_fee_label"));
    By lot_service_fee = (By.id("com.spplus.parking.develop:id/serviceFee"));
    By purchase_label = (By.id("com.spplus.parking.develop:id/purchase_total_label"));
    By lot_price_with_fee = (By.id("com.spplus.parking.develop:id/purchaseTotal"));
    By lot_taxes = (By.id("com.spplus.parking.develop:id/taxes"));

    //BOTTOM CHECKBOXES
    By send_me_info = (By.id("com.spplus.parking.develop:id/promotionCheckbox"));
    By acknowledge_printed_pass_required = (By.id("com.spplus.parking.develop:id/printedAckCheckbox"));
    By acknowledge_printed_pass_required_validation = (By.id("com.spplus.parking.develop:id/printedAtValidation"));
    By terms_of_use = (By.id("com.spplus.parking.develop:id/disclaimerTextView"));

    //FOOTER
    By action_button = (By.id("com.spplus.parking.develop:id/actionButton"));
    By complete_purchase_button = (By.id("com.spplus.parking.develop:id/completePurchaseButton"));

    //AFTER CHECKOUT
    By loader = (By.id("android:id/progress"));
    By loading = (By.xpath("//*[@resource-id='android:id/message'][@text='Loading???']"));
    By success_title = (By.id("com.spplus.parking.develop:id/title"));
    By success_message = (By.id("com.spplus.parking.develop:id/message"));
    By success_ok_button = (By.id("com.spplus.parking.develop:id/button"));

    //ERROR
    By error_title = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/title'][@text='ERROR']"));
    By error_message = (By.id("com.spplus.parking.develop:id/message"));

    //ON DEMAND SCREEN
    By zone_label = (By.id("com.spplus.parking.develop:id/locationCodeLabel"));
    By zone_code = (By.id("com.spplus.parking.develop:id/locationCodeField"));
    By zone_location_name = (By.id("com.spplus.parking.develop:id/lotAddressField"));
    By zone_location_price = (By.id("com.spplus.parking.develop:id/headerPriceField"));
    By duration = (By.id("com.spplus.parking.develop:id/sessionDurationField"));
    By duration_expiration = (By.id("com.spplus.parking.develop:id/expirationTimeField"));
    By header_license_plate = (By.id("com.spplus.parking.develop:id/licensePlateField"));
    By parking_spots = (By.id("com.spplus.parking.develop:id/parkingSpotsField"));
    By personal_information_data_OD = (By.id("com.spplus.parking.develop:id/userData"));
    By personal_information_edit_OD = (By.id("com.spplus.parking.develop:id/userEditLabel"));
    By payment_information_data_OD = (By.id("com.spplus.parking.develop:id/information"));
    By payment_information_edit_OD = (By.id("com.spplus.parking.develop:id/editLabel"));
    By promo_code_applied = (By.id("com.spplus.parking.develop:id/tvPromoCode"));
    By discount_applied_label = (By.id("com.spplus.parking.develop:id/tvPromoCodeDesc"));
    By remove_promo_code_button = (By.id("com.spplus.parking.develop:id/tvRemovePromoCode"));

    
    public void assertRegisteredUserIsOnCheckoutScreen() {
        assert_text(checkout_title, "Checkout");
        log.info("CHECKOUT SCREEN");
    }

    public void assertRegisteredUserTopView(){
        assert_element_is_not_displayed(have_account_label);
        assert_element_is_not_displayed(sign_in_button);
        assert_text(personal_information_title, "PERSONAL INFORMATION");
        assert_text(vehicle_information_title, "VEHICLE INFORMATION");
        assert_text(payment_information_title, "PAYMENT INFORMATION");
    }

    public void assertRegisteredUserBottomView(String vehicle_size){

        assert_text(have_promo_code_label, "Have a Promotion Code? Enter it here.");
        assert_text(promo_code_field, "example: PROMO50");
        assert_text(apply_promo_code_button, "APPLY");
        String size = (check_if_element_is_present(oversize_label).equals(false)) ? "STANDARD" : "OVERSIZE";
        Assert.assertEquals(size, vehicle_size);
        assert_text(send_me_info, "Yes, send me information about special offers near me.");
        assert_element_is_checked(send_me_info);
        log.info("The option '"+text(send_me_info)+"' is checked by default.");
        assert_text(terms_of_use, "By selecting ???Complete Purchase??? you are agreeing to Parking.com Terms of Use.");
        log.info("All basic assertions for registered user passed.");
    }

    public void assertRegisteredUserBottomViewOD(String vehicle_size){

        assert_text(have_promo_code_label, "Have a Promo or Access Code? Enter it here.");
        assert_text(promo_code_field, "example: PROMO50");
        assert_text(apply_promo_code_button, "APPLY");
        String size = (check_if_element_is_present(oversize_label).equals(false)) ? "STANDARD" : "OVERSIZE";
        Assert.assertEquals(size, vehicle_size);
        assert_text(send_me_info, "Yes, send me information about special offers near me.");
        assert_element_is_checked(send_me_info);
        log.info("The option '"+text(send_me_info)+"' is checked by default.");
        assert_text(terms_of_use, "By selecting ???Complete Purchase??? you are agreeing to Parking.com Terms of Use.");
        log.info("All basic assertions for registered user passed.");
    }

    public void assertRegisteredUserBottomViewAfterAddingTimeOD(String vehicle_size){

        assert_text(have_promo_code_label, "Have a Promo or Access Code? Enter it here.");
        assert_text(promo_code_field, "example: PROMO50");
        assert_text(apply_promo_code_button, "APPLY");
        String size = (check_if_element_is_present(oversize_label).equals(false)) ? "STANDARD" : "OVERSIZE";
        Assert.assertEquals(size, vehicle_size);
        // assert_text(send_me_info, "Yes, send me information about special offers near me.");
        // assert_element_is_checked(send_me_info);
        // log.info("The option '"+text(send_me_info)+"' is checked by default.");
        assert_text(terms_of_use, "By selecting ???Complete Purchase??? you are agreeing to Parking.com Terms of Use.");
        log.info("All basic assertions for registered user passed.");
    }

    public String assertLotDetails(String lot_name_text, String lot_address_text, String lot_original_price_text){

        log.info("CHECKOUT SCREEN");
        assert_text(lot_name, lot_name_text);
        log.info("Lot is: "+text(lot_name));
        assert_text(lot_address, lot_address_text.replace("ENTRANCE  ", ""));
        log.info("Lot address is: "+text(lot_address));
        
        String total_price = new String();
        String header_price_obtained = text(lot_header_price);
        scrollToText("Purchase Total*");
        if(checkIfTheLotHaveServiceFee().equals("0")){
            // log.info("Service fee is: $"+df.format(Double.parseDouble(checkIfTheLotHaveServiceFee())));
            // assert_text(lot_header_price, lot_original_price_text);
            log.info("Service fee is: $"+df.format(Double.parseDouble(checkIfTheLotHaveServiceFee())));
            // assert_text(lot_header_price, lot_original_price_text);
            Assert.assertEquals(header_price_obtained, lot_original_price_text);
            assert_text(lot_original_price, lot_original_price_text);
            log.info("Original price is: "+text(lot_original_price));
            assert_text(lot_price_with_fee, lot_original_price_text);
            log.info("Purchase total is: $"+df.format(Double.parseDouble(text(lot_price_with_fee).replace("$",""))));
            total_price = "$"+df.format(Double.parseDouble(text(lot_price_with_fee).replace("$","")));
        }else{
            log.info("Service fee is: $"+checkIfTheLotHaveServiceFee());
            double lot_price_with_fee_value = Double.parseDouble(lot_original_price_text.replace("$", "")) + Double.parseDouble(checkIfTheLotHaveServiceFee());
            Assert.assertEquals(header_price_obtained, "$"+df.format(lot_price_with_fee_value));
            assert_text(lot_original_price, lot_original_price_text);
            log.info("Original price is: "+text(lot_original_price));
            assert_text(lot_price_with_fee, "$"+df.format(lot_price_with_fee_value));
            log.info("Purchase total is: $"+df.format(Double.parseDouble(text(lot_price_with_fee).replace("$",""))));
            total_price = "$"+df.format(Double.parseDouble(text(lot_price_with_fee).replace("$","")));
        }

        return total_price;
    }

    public String assertAndGetLotDetailsOD(String zone_code_entered, String lot_name, String license_plate_value, String duration_value) {

        assertRegisteredUserIsOnCheckoutScreen();
        assert_text(zone_label, "Zone #");
        String location_price = text(zone_location_price);
        assert_text(zone_code, zone_code_entered);
        log.info("Zone code is: "+zone_code_entered);
        // assert_text(zone_address, lot_name);
        // Assert.assertEquals(text(zone_location_name).toUpperCase(), lot_name);
        log.info("Location name is: "+lot_name);
        assert_text(header_license_plate, license_plate_value);
        log.info("License plate is: "+license_plate_value);
        assert_text(duration, duration_value);
        log.info("Session duration is: "+duration_value);
        scrollToText("COMPLETE PURCHASE");
        // swipeElementUp(scrollable, 300);
        assert_text(lot_price_with_fee, location_price);
        log.info("Price is: "+location_price);
        return location_price;
    }

    public String checkIfTheLotHaveServiceFee(){
        // System.out.println("IN THE METHOD: "+text(lot_service_fee).replace("$",""));
        return !text(lot_service_fee).equals("$0.00") ? df.format(Double.parseDouble(text(lot_service_fee).replace("$",""))) : "0";
    }

    public void clickActionButton(){
        // swipeElementUp(scrollable, 1000);
        String action_button_text = new String();

        if(check_if_element_is_present(action_button).equals(true)){
            action_button_text = text(action_button);
            assert_text(action_button, action_button_text);
            click(action_button);
        }else{
            action_button_text = text(complete_purchase_button);
            assert_text(complete_purchase_button, action_button_text);
            click(complete_purchase_button);
            System.out.println("COMPLETE PURCHASE BUTTON WAS CLICKED 1");
            if(check_if_element_is_present(complete_purchase_button).equals(true)){
                click(complete_purchase_button);
                System.out.println("COMPLETE PURCHASE BUTTON WAS CLICKED 2");
            }
        }
        log.info(action_button_text+" button was clicked.");
    }

    public void checkRegisteredUserPersonalInformation(String email, String first_name, String last_name, String prefix, String phone){
        scrollToText("PERSONAL INFORMATION");
        assert_text(personal_information_name_email, first_name+" "+last_name+"\n"+email);
        log.info("Email is: "+email);
        log.info("Name is: "+first_name+" "+last_name);
        assert_text(personal_information_name_email_edit, "Edit");
        assert_text(personal_information_phone, prefix+phone);
        log.info("Phone is: "+prefix+phone);
        assert_text(personal_information_phone_edit, "Edit");
        log.info("Personal information is correct.");
    }

    public void checkRegisteredUserPersonalInformationOD(String email, String first_name, String last_name, String prefix, String phone){
        // scrollToText("Zone #");
        swipeElementDown(scrollable, 300);
        assert_text(personal_information_data_OD, first_name+" "+last_name+"\n"+email+"\n "+prefix+phone);
        log.info("Email is: "+email);
        log.info("Name is: "+first_name+" "+last_name);
        log.info("Phone is: "+prefix+phone);
        assert_text(personal_information_edit_OD, "Edit");
        log.info("Personal information is correct.");
    }

    public void checkRegisteredUserVehicleInformation(String license_plate){
        scrollToText("VEHICLE INFORMATION");
        assert_text(vehicle_information_license_plate, license_plate);
        log.info("License plate is: "+license_plate);
        assert_text(vehicle_information_edit, "Edit");
        log.info("Vehicle information is correct.");
    }

    public void checkRegisteredUserPaymentInformation(String cc_type_number){
        scrollToText("APPLY");
        assert_text(payment_information_cc, cc_type_number.toUpperCase());
        log.info("Credit Card preselected is: "+cc_type_number.toUpperCase());
        assert_text(payment_information_edit, "Edit");
        log.info("Payment information is correct.");
    }

    public void checkRegisteredUserPaymentInformationOD(String cc_type_number){
        scrollToText("APPLY");
        assert_text(payment_information_data_OD, cc_type_number.toUpperCase());
        log.info("Credit Card preselected is: "+cc_type_number.toUpperCase());
        assert_text(payment_information_edit_OD, "Edit");
        log.info("Payment information is correct.");
    }

    public Boolean checkIfPrintedPassIsRequired() {
        if(check_if_element_is_present(printed_mobile_title).equals(true)){
            if(text(printed_mobile_title).equals("PRINTED PASS REQUIRED")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void addPromoCode(String promo_code){
        scrollToText("APPLY");
        type(promo_code_field, promo_code);
        click(apply_promo_code_button);
        waitUntilFinishLoading();
        assert_text(apply_promo_code_button, "REMOVE");
        log.info("Promo code '"+promo_code+"' applied.");
    }

    public void addPromoCodeOD(String promo_code){
        scrollToText("Have a Promo or Access Code? Enter it here.");
        type(promo_code_field, promo_code);
        click(apply_promo_code_button);
        waitUntilFinishLoading();
        assert_text(promo_code_applied, promo_code);
        assert_text(discount_applied_label, "-  Discount Applied");
        assert_text(remove_promo_code_button, "REMOVE");
        log.info("Promo code '"+promo_code+"' applied.");
    }

    public String checkPromoDiscountWasApplied(String total_price) {
        // scrollToText("Discount");
        swipeElementUp(scrollable, 300);
        assert_text(discount_label, "Discount");
        String discount_applied = text(discount_value).replace("(", "").replace(")", "");
        double total_with_discount = Double.parseDouble(total_price.replace("$", "")) - Double.parseDouble(discount_applied.replace("$", ""));
        assert_text(lot_price_with_fee, "$"+df.format(total_with_discount));
        log.info("Discount applied: "+discount_applied);
        log.info("New total price is: $"+df.format(total_with_discount));
        return "$"+df.format(total_with_discount);
    }

    public void clickOnCompletePurchase(){
        scrollToText("COMPLETE PURCHASE");
        clickActionButton();
        if(checkIfPrintedPassIsRequired().equals(true)){
            assert_text(acknowledge_printed_pass_required_validation, "You must acknowledge that you can print this pass before completing your purchase.");
            log.info("Validation error appear because printed pass is required. Acknowledge this item before completing the purchase.");
            click(acknowledge_printed_pass_required);
            log.info("'Acknowledge printed pass required' checkbox was selected.");
            scrollToText("COMPLETE PURCHASE");
            clickActionButton();
        }
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading???");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 20);
            try {
                WebElement loading_element2 = waitForElementToBeVisible(loading, (long) 5);
                waitForElementToDisappear(loading_element2, (long) 20);
            } catch (TimeoutException e) {
                // TODO: handle exception
            }
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
    }

    public void checkPurchaseWasSuccessful(){
        waitUntilFinishLoading();
        checkIfErrorAppears();
        assert_text(success_title, "Success!");
        assert_text(success_message, "All your information has been saved. You can access your Reservation in ???My Reservations??? in the side menu.");
        assert_text(success_ok_button, "OK");
        click(success_ok_button);
        log.info("Purchase was successful!");
    }

    public void checkIfErrorAppears() {
        try {
            waitForElementToBeVisible(error_title, (long) 5);
            throw new Error("An error ocurred: "+text(error_message));
        } catch (TimeoutException e) {
            //TODO: handle exception
        }
    }

    public String checkAllUserDataIsDisplayedAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String prefix, String phone, String license_plate, String cc_number){
        
        assertRegisteredUserIsOnCheckoutScreen();
        assertRegisteredUserTopView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertRegisteredUserBottomView(vehicle_size);
        checkRegisteredUserPersonalInformation(email, first_name, last_name, prefix, phone);
        checkRegisteredUserVehicleInformation(license_plate);
        checkRegisteredUserPaymentInformation(cc_number);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String checkAllUserDataIsDisplayedAddPromoCodeAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String prefix, String phone, String license_plate, String cc_number, String promo_code){
        
        assertRegisteredUserIsOnCheckoutScreen();
        assertRegisteredUserTopView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertRegisteredUserBottomView(vehicle_size);
        checkRegisteredUserPersonalInformation(email, first_name, last_name, prefix, phone);
        checkRegisteredUserVehicleInformation(license_plate);
        checkRegisteredUserPaymentInformation(cc_number);
        addPromoCode(promo_code);
        String new_price_with_discount = checkPromoDiscountWasApplied(purchase_price);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return new_price_with_discount;
    }

    public String checkAllUserDataIsDisplayedAndCompletePurchaseOD(String vehicle_size, String zone_code, String lot_name_text, String license_plate, String email, String first_name, String last_name, String prefix, String phone, String cc_number){
        
        String purchase_price = assertAndGetLotDetailsOD(zone_code, lot_name_text, license_plate, "2 HOURS  SESSION");
        assertRegisteredUserBottomViewOD(vehicle_size);
        checkRegisteredUserPersonalInformationOD(email, first_name, last_name, prefix, phone);
        checkRegisteredUserPaymentInformationOD(cc_number);
        clickOnCompletePurchase();
        waitUntilFinishLoading();
        return purchase_price;
    }

    public String checkAllUserDataIsDisplayedAddPromoCodeAndCompletePurchaseOD(String vehicle_size, String zone_code, String lot_name_text, String license_plate, String email, String first_name, String last_name, String prefix, String phone, String cc_number, String promo_code){
        
        String purchase_price = assertAndGetLotDetailsOD(zone_code, lot_name_text, license_plate, "2 HOURS  SESSION");
        assertRegisteredUserBottomViewOD(vehicle_size);
        checkRegisteredUserPersonalInformationOD(email, first_name, last_name, prefix, phone);
        checkRegisteredUserPaymentInformationOD(cc_number);
        addPromoCodeOD(promo_code);
        String new_price_with_discount = checkPromoDiscountWasApplied(purchase_price);
        clickOnCompletePurchase();
        waitUntilFinishLoading();
        return new_price_with_discount;
    }

    public String checkAllUserDataIsDisplayedAndCompletePurchaseAfterAddingTimeOD(String vehicle_size, String zone_code, String lot_name_text, String license_plate, String email, String first_name, String last_name, String prefix, String phone, String cc_number){
        
        String purchase_price = assertAndGetLotDetailsOD(zone_code, lot_name_text, license_plate, "1 HOUR  EXTENSION");
        assertRegisteredUserBottomViewAfterAddingTimeOD(vehicle_size);
        // checkRegisteredUserPersonalInformationOD(email, first_name, last_name, prefix, phone); //RAISE A BUG FOR THIS
        checkRegisteredUserPaymentInformationOD(cc_number);
        clickOnCompletePurchase();
        waitUntilFinishLoading();
        return purchase_price;
    }

}
