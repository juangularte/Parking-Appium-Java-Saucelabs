package ios.screens;

import java.text.DecimalFormat;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class GuestUserCheckoutScreeniOS extends BaseActionsIOS{

    protected Logger log;
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected CheckoutYourInformationScreeniOS your_information;
    protected CheckoutVehicleInformationScreeniOS vehicle_information;
    protected CheckoutPaymentInformationScreeniOS payment_information;

    public GuestUserCheckoutScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By checkout_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@value='Checkout']"));

    //HAVE ACCOUNT
    By have_account_label = (AppiumBy.accessibilityId("Already have an account?"));
    By sign_in_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Sign In\"`]"));

    //BODY
    By scrollable = (AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeScrollView\""));

    //LOT DETAILS
    By purchase_time_label = (AppiumBy.accessibilityId("Time to purchase:"));
    By purchase_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Time to purchase:\"]/following-sibling::XCUIElementTypeStaticText"));
    By lot_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Time to purchase:\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText"));
    By lot_address = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Time to purchase:\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText"));
    By lot_header_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Time to purchase:\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText"));
    By entrance_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"]"));
    By exit_label= (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"]"));
    By entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ENTRANCE TIME\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeStaticText"));
    By exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXIT TIME\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeStaticText"));

    //YOUR INFORMATION
    By your_information_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"YOUR INFORMATION\"]"));
    By your_information_number = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"YOUR INFORMATION\"]/preceding-sibling::XCUIElementTypeStaticText[@name=\"1\"]"));
    By your_information_no_info_label = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"    Add Email, Name...\"]"));
    By your_information_no_info_arrow = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"    Add Email, Name...\"]/following-sibling::XCUIElementTypeButton"));
    By your_information_edit_info_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"YOUR INFORMATION\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[@name=\"Edit\"]"));
    // By your_information_edit_info_button = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/editLabel"));
    By your_information_first_last_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"YOUR INFORMATION\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[1]"));
    By your_information_email = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"YOUR INFORMATION\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[2]"));
    By your_information_phone = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"phone\"]/following-sibling::XCUIElementTypeStaticText"));

    //VEHICLE INFORMATION
    By vehicle_information_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"VEHICLE INFORMATION\"]"));
    By vehicle_information_number = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"VEHICLE INFORMATION\"]/preceding-sibling::XCUIElementTypeStaticText[@name=\"2\"]"));
    By vehicle_information_no_info_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\" Add Vehicle\"]"));
    By vehicle_information_no_info_arrow = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\" Add Vehicle\"]/parent::XCUIElementTypeButton[@name=\" Add Vehicle\"]/following-sibling::XCUIElementTypeButton[@name=\"ic prog action\"]"));
    By vehicle_information_edit_info_button = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeButton"));
    By vehicle_information_info_added = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeStaticText"));
    
    //PAYMENT INFORMATION
    By payment_information_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Payment Information\"]"));
    By payment_information_number = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Payment Information\"]/preceding-sibling::XCUIElementTypeStaticText[@name=\"3\"]"));
    By payment_information_no_info_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"    Add Payment\"]"));
    By payment_information_no_info_arrow = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"    Add Payment\"]/parent::XCUIElementTypeButton[@name=\"    Add Payment\"]/following-sibling::XCUIElementTypeButton[@name=\"ic prog action\"]"));
    By payment_information_edit_info_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Payment Information\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]//XCUIElementTypeStaticText[@name=\"Edit\"]"));
    By payment_information_info_added = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Payment Information\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeStaticText"));
    
    //PRINTED-MOBILE PASS
    By printed_mobile_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[last()]//XCUIElementTypeOther/XCUIElementTypeStaticText[1]"));
    By printed_mobile_description = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther[last()]//XCUIElementTypeOther/XCUIElementTypeStaticText[2]"));
    By license_plate_enforced_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"LICENSE PLATE ENFORCED\"]"));
    By license_plate_enforced_description = (AppiumBy.accessibilityId("Be sure your license plate matches the vehicle you park.  No parking pass required to enter or exit this location."));
    By printed_pass_required_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PRINTED PASS REQUIRED\"]"));
    By printed_pass_required_description = (AppiumBy.accessibilityId("A printed pass is required to enter and exit this location."));

    //PROMO CODE
    By have_promo_code_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]"));
    By promo_code_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]//following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField"));
    By apply_promo_code_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]//following-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText[@name=\"APPLY\"]"));
    By invalid_promo_code_message = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Error\"]/following-sibling::XCUIElementTypeStaticText"));
    By promo_code_applied_message = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeStaticText"));
    By promo_code_applied_remove_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Have a Promo or Access code? Enter it here.\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther[1]/XCUIElementTypeButton/XCUIElementTypeStaticText"));

    //PURCHASE DETAILS
    By parking_price_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Parking\"]"));
    By lot_original_price = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Parking\"]/following-sibling::XCUIElementTypeStaticText"));
    By oversize_label = (AppiumBy.xpath("com.spplus.parking.develop:id/oversizeLabel"));
    By oversize_price = (AppiumBy.xpath("com.spplus.parking.develop:id/oversizeField"));
    By discount_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Discount\"]"));
    By discount_value = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Discount\"]/following-sibling::XCUIElementTypeStaticText"));
    By service_fee_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Service Fee\"]"));
    By lot_service_fee = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Service Fee\"]/following-sibling::XCUIElementTypeStaticText"));
    By purchase_label = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Purchase Total*\"]"));
    By lot_price_with_fee = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Purchase Total*\"]/following-sibling::XCUIElementTypeStaticText"));
    By lot_taxes = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Purchase Total*\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeStaticText"));
    
    //BOTTOM CHECKBOXES
    By send_me_info_checkbox = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Yes, send me information about special offers near me.\"]/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeButton"));
    By send_me_info_message = (AppiumBy.accessibilityId("Yes, send me information about special offers near me."));
    By acknowledge_printed_pass_required_checkbox = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"I acknowledge that this parking pass must be printed and cannot be shown on my mobile device.\"]/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeOther/XCUIElementTypeButton"));
    By acknowledge_printed_pass_required_message = (AppiumBy.accessibilityId("I acknowledge that this parking pass must be printed and cannot be shown on my mobile device."));
    By acknowledge_printed_pass_required_validation = (AppiumBy.accessibilityId("You must acknowledge that you can print this pass before completing your purchase. "));
    By by_selecting_complete_purchase = (AppiumBy.accessibilityId("By selecting “Complete Purchase” you are agreeing"));
    By to_parking_com = (AppiumBy.accessibilityId(" to Parking.com"));
    By terms_of_use = (AppiumBy.accessibilityId("Terms of Use."));

    //FOOTER
    // By action_button = (AppiumBy.xpath("//XCUIElementTypeButton[last()]/XCUIElementTypeStaticText"));
    By action_button = (AppiumBy.xpath("//XCUIElementTypeScrollView/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText"));

    //AFTER CHECKOUT
    By loader = (AppiumBy.accessibilityId("In progress"));
    By success_title = (AppiumBy.accessibilityId("Payment Received!"));
    By success_message = (AppiumBy.accessibilityId("All your information has been saved. You can access your Reservation in 'My Parking Sessions' in the side menu"));
    By success_ok_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Ok\"]"));

     //ERROR
     By error_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'Error')]"));
     By error_message = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'unable to process')]"));

    public void checkUserIsInCheckoutScreen() {
            assert_text(checkout_title, "Checkout");
        log.info("CHECKOUT SCREEN");
    }
    
    public void assertCommonElements(){
        checkUserIsInCheckoutScreen();
        assert_text(have_account_label, "Already have an account?");
        assert_text(sign_in_button, "Sign In");
        assert_text(your_information_title, "YOUR INFORMATION");
        assert_text(vehicle_information_title, "VEHICLE INFORMATION");
        //  assert_text(payment_information_title, "PAYMENT INFORMATION");
        assert_text(payment_information_title, "Payment Information");
        assertGuestView();
    }

    public void assertBottomElements(String vehicle_size){

        assert_text(have_promo_code_label, "Have a Promo or Access code? Enter it here.");
        assert_text(promo_code_field, "EXAMPLE: PROMO50");
        assert_text(apply_promo_code_button, "APPLY");
        String size = (check_if_element_is_present(oversize_label).equals(false)) ? "STANDARD" : "OVERSIZE";
        Assert.assertEquals(size, vehicle_size);
        assert_text(send_me_info_message, "Yes, send me information about special offers near me.");
    //  assert_element_is_checked(send_me_info_message);
    //  log.info("The option '"+text(send_me_info_message)+"' is checked by default.");
        assert_text(terms_of_use, "Terms of Use.");
        log.info("All basic assertions passed.");
    }

    public String assertLotDetails(String lot_name_text, String lot_address_text, String lot_original_price_text){
    
    scrollUpToText(lot_name_text);
    assert_text(lot_name, lot_name_text);
    log.info("Lot is: "+text(lot_name));
    assert_text(lot_address, lot_address_text.replace("ENTRANCE  ", ""));
    log.info("Lot address is: "+text(lot_address));
    
    String total_price = new String();
    String header_price_obtained = text(lot_header_price);
    scrollDownToText("Purchase Total*");
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
        System.out.println(lot_original_price_text);
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

    public String checkIfTheLotHaveServiceFee(){
        // System.out.println("IN THE METHOD: "+text(lot_service_fee).replace("$",""));
        return !text(lot_service_fee).equals("$0.00") ? df.format(Double.parseDouble(text(lot_service_fee).replace("$",""))) : "0";
    }
 
    public void assertGuestView(){
        assert_text(your_information_number, "1");
        assert_text(vehicle_information_number, "2");
        assert_text(payment_information_number, "3");
        assert_text(your_information_no_info_label, "    Add Email, Name...");
        assert_text(vehicle_information_no_info_label, " Add Vehicle");
        // swipeElementUp(scrollable, 2000);
        if(check_if_element_is_present(payment_information_no_info_label).equals(false)) {
            swipeElementUp(scrollable, 2000);
        }
        assert_text(payment_information_no_info_label, "    Add Payment");
        log.info("No information is displayed for Guest user.");
    }
 
    public void clickActionButton(){
        String action_button_text = text(action_button);
        assert_text(action_button, action_button_text);
        click(action_button);
        log.info(action_button_text+" button was clicked.");
    }

    public void addUserInformation(String email, String first_name, String last_name, String phone, String country){
        clickActionButton();
        your_information = new CheckoutYourInformationScreeniOS(driver, log);
        your_information.completeFields(email, first_name, last_name, phone, country);
    }

    public void checkUserInformationAdded(String email, String first_name, String last_name, String phone){
        scrollUpToText("YOUR INFORMATION");
        assert_text(your_information_first_last_name, first_name+" "+last_name);
        assert_text(your_information_email, email);
        assert_text(your_information_phone, phone);
        assert_text(your_information_edit_info_button, "Edit");
        // Assert.assertFalse(check_if_element_is_present(your_information_number));
        assert_element_is_not_displayed(your_information_number);
        log.info("User information was added correctly.");
    }

    public void addVehicleInformation(String license_plate, String country, String state){
        // click(vehicle_information_no_info_label);
        // log.info("Vehicle information section was clicked.");
        // scrollDownToText("ADD VEHICLE");
        //TODO: Add if statement to check if main button says ADD VEHICLE or ADD PAYMENT
        if(check_if_element_is_present(vehicle_information_no_info_label).equals(true)){
            click(vehicle_information_no_info_label);
        }else{
            clickActionButton();
        }
        vehicle_information = new CheckoutVehicleInformationScreeniOS(driver, log);
        vehicle_information.completeFields(license_plate, country, state);
    }

    public void checkVehicleInformationAdded(String license_plate){
        scrollUpToText("VEHICLE INFORMATION");
        assert_text(vehicle_information_info_added, license_plate);
        assert_text(vehicle_information_edit_info_button, "Edit");
        assert_element_is_not_displayed(vehicle_information_number);
        log.info("Vehicle information was added correctly.");
    }

    public void addPaymentInformation(String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code){
        // click(vehicle_information_no_info_label);
        // log.info("Vehicle information section was clicked.");
        scrollDownToText("ADD PAYMENT");
        clickActionButton();
        payment_information = new CheckoutPaymentInformationScreeniOS(driver, log);
        payment_information.completeFields(cc_number, cc_exp_date, cc_cvv, cc_postal_code);
    }

    public void checkPaymentInformationAdded(String cc_number){

        scrollUpToText("Payment Information");
        assert_text(payment_information_info_added, "Visa*"+cc_number.substring(cc_number.length() - 4));
        assert_text(payment_information_edit_info_button, "Edit");
        assert_element_is_not_displayed(payment_information_number);
        log.info("Payment information was added correctly.");
    }

    public Boolean checkIfPrintedPassIsRequired() {
        if(check_if_element_is_present(printed_pass_required_title).equals(true)){
            if(text(printed_pass_required_title).contains("PRINTED PASS REQUIRED")){
                return true;
            }else{
                return false;
            }
        // }else if(check_if_element_is_present(printed_mobile_title).equals(false)){
        //     if(text(printed_mobile_title).contains("PRINTED PASS REQUIRED")){
        //         return true;
        //     }else{
        //         return false;
        //     }
        }else{
            return false;
        }

        // switch(check_if_element_is_present(printed_pass_required_title).toString()){

        //     case "true":    
        //                     if(text(printed_pass_required_title).contains("PRINTED PASS REQUIRED")){
        //                         return true;
        //                     }else{
        //                         return false;
        //                     }

        //     case "false":   
                            
        //                     if(text(printed_pass_required_title).contains("PRINTED PASS REQUIRED")){
        //                         return true;
        //                     }else{
        //                         return false;
        //                     }
                            
        //     default: return false;
        // }
    }

    public void addPromoCode(String promo_code){
        scrollDownToText("Have a Promo or Access code? Enter it here.");
        type(promo_code_field, promo_code);
        click(apply_promo_code_button);
        waitUntilFinishLoading();
        assert_text(promo_code_applied_message, "        "+promo_code+" - Discount Applied");
        assert_text(promo_code_applied_remove_button, "REMOVE");
        log.info("Promo code '"+promo_code+"' applied.");
    }

    public String checkPromoDiscountWasApplied(String total_price) {
        scrollDownToText("Discount");
        assert_text(discount_label, "Discount");
        String discount_applied = text(discount_value).replace("(", "").replace(")", "");
        double total_with_discount = Double.parseDouble(total_price.replace("$", "")) - Double.parseDouble(discount_applied.replace("$", ""));
        assert_text(lot_price_with_fee, "$"+df.format(total_with_discount));
        log.info("Discount applied: "+discount_applied);
        log.info("New total price is: $"+df.format(total_with_discount));
        return "$"+df.format(total_with_discount);
    }

    public void checkAccessCodeAppliedIsDisplayed(String access_code) {
        scrollDownToText("Have a Promo or Access code? Enter it here.");
        assert_text(promo_code_applied_message, "        "+access_code+" - Rate Unlocked");
    }

    public void clickOnCompletePurchase(){
        scrollDownToText("COMPLETE PURCHASE");
        clickActionButton();
        if(checkIfPrintedPassIsRequired().equals(true)){
            scrollDownToText("COMPLETE PURCHASE");
            assert_text(acknowledge_printed_pass_required_message, "I acknowledge that this parking pass must be printed and cannot be shown on my mobile device.");
            assert_text(acknowledge_printed_pass_required_validation, "You must acknowledge that you can print this pass before completing your purchase. ");
            log.info("Validation error appear because printed pass is required. Acknowledge this item before completing the purchase.");
            click(acknowledge_printed_pass_required_checkbox);
            log.info("'Acknowledge printed pass required' checkbox was selected.");
            scrollDownToText("COMPLETE PURCHASE");
            clickActionButton();
        }
    }

    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loader, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 20);
            try {
                WebElement loading_element2 = waitForElementToBeVisible(loader, (long) 5);
                waitForElementToDisappear(loading_element2, (long) 20);
            } catch (TimeoutException e) {
                // TODO: handle exception
            }
        } catch (TimeoutException e) {
            // TODO: handle exception
        }
    }
 
    // public void waitUntilFinishLoading(){
    //     assert_text(loading, "Loading…");
    //     log.info("Loading...");
    //     // int i = 0;
    //     while(check_if_element_is_present(loading).equals(true)){
    //         // i++;
    //         // System.out.println("Loop: "+i);
    //         if (check_if_element_is_present(loading).equals(false)){
    //             log.info("Load completed.");
    //             break;
    //         }
    //     }
    // }

    public void checkPurchaseWasSuccessful(){
        waitUntilFinishLoading();
        checkIfErrorAppears();
        assert_text(success_title, "Payment Received!");
        assert_text(success_message, "All your information has been saved. You can access your Reservation in 'My Parking Sessions' in the side menu");
        assert_text(success_ok_button, "Ok");
        click(success_ok_button);
        log.info("Purchase was successful!");
    }

    public void checkIfErrorAppears() {
        try {
            waitForElementToBeVisible(error_title, (long) 5);
            // throw new Error("An error ocurred: "+text(error_message));
            throw new Error("Purchase cannot be processed due to an error.");
        } catch (TimeoutException e) {
            //TODO: handle exception
        }
    }

    public String completeMandatoryInformationAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String phone, String phone_country, String license_plate, String vehicle_country, String state, String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code){
        assertCommonElements();
        // assertGuestView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertBottomElements(vehicle_size);
        addUserInformation(email, first_name, last_name, phone, phone_country);
        checkUserInformationAdded(email, first_name, last_name, phone);
        addVehicleInformation(license_plate, vehicle_country, state);
        checkVehicleInformationAdded(license_plate);
        addPaymentInformation(cc_number, cc_exp_date, cc_cvv, cc_postal_code);
        checkPaymentInformationAdded(cc_number);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String completeMandatoryInformationAndCompletePurchaseForEvent(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String phone, String phone_country, String license_plate, String vehicle_country, String state, String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code){
        assertCommonElements();
        // assertGuestView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertBottomElements(vehicle_size);
        addUserInformation(email, first_name, last_name, phone, phone_country);
        checkUserInformationAdded(email, first_name, last_name, phone);
        addPaymentInformation(cc_number, cc_exp_date, cc_cvv, cc_postal_code);
        checkPaymentInformationAdded(cc_number);
        addVehicleInformation(license_plate, vehicle_country, state);
        checkVehicleInformationAdded(license_plate);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String completeMandatoryInformationCheckAccessCodeAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String phone, String phone_country, String license_plate, String vehicle_country, String state, String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code, String access_code){
        assertCommonElements();
        // assertGuestView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertBottomElements(vehicle_size);
        addUserInformation(email, first_name, last_name, phone, phone_country);
        checkUserInformationAdded(email, first_name, last_name, phone);
        addVehicleInformation(license_plate, vehicle_country, state);
        checkVehicleInformationAdded(license_plate);
        addPaymentInformation(cc_number, cc_exp_date, cc_cvv, cc_postal_code);
        checkPaymentInformationAdded(cc_number);
        checkAccessCodeAppliedIsDisplayed(access_code);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String completeMandatoryInformationAddPromoCodeAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String phone, String phone_country, String license_plate, String vehicle_country, String state, String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code, String promo_code){
        assertCommonElements();
        assertGuestView();
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertBottomElements(vehicle_size);
        addUserInformation(email, first_name, last_name, phone, phone_country);
        checkUserInformationAdded(email, first_name, last_name, phone);
        addVehicleInformation(license_plate, vehicle_country, state);
        checkVehicleInformationAdded(license_plate);
        addPaymentInformation(cc_number, cc_exp_date, cc_cvv, cc_postal_code);
        checkPaymentInformationAdded(cc_number);
        addPromoCode(promo_code);
        String new_price_with_discount = checkPromoDiscountWasApplied(purchase_price);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return new_price_with_discount;
    }
}
