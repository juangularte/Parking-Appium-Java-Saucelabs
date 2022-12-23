package ios.screens;

import java.text.DecimalFormat;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class RegisteredUserCheckoutScreeniOS extends BaseActionsIOS{

    protected Logger log;
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected CheckoutYourInformationScreeniOS your_information;
    protected CheckoutVehicleInformationScreeniOS vehicle_information;
    protected CheckoutPaymentInformationScreeniOS payment_information;

    public RegisteredUserCheckoutScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
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
    // By personal_information_title = (AppiumBy.xpath("//android.widget.TextView[@text='PERSONAL INFORMATION']"));
    By personal_information_name = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'@')]/preceding-sibling::XCUIElementTypeStaticText"));
    By personal_information_email = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'@')]"));
    By personal_information_name_email_edit = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'@')]/parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeStaticText[@name=\"Edit\"]"));
    By personal_information_phone = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"phone\"]/following-sibling::XCUIElementTypeStaticText"));
    By personal_information_phone_edit = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"phone\"]/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name=\"Edit\"]"));
    // By your_information_edit_info_button = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/editLabel"));

    //VEHICLE INFORMATION
    // By vehicle_information_title = (AppiumBy.xpath("//android.widget.TextView[@text='VEHICLE INFORMATION']"));
    By vehicle_information_license_plate = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeStaticText"));
    By vehicle_information_edit = (AppiumBy.xpath("//XCUIElementTypeImage[@name=\"ic_vehicle\"]/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText[@name=\"Edit\"]"));
    
    //PAYMENT INFORMATION
    // By payment_information_title = (AppiumBy.xpath("//android.widget.TextView[@text='PAYMENT INFORMATION']"));
    By add_payment_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"    Add Payment\"]"));
    By payment_information_cc = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'*')][not(contains(@value,'Purchase'))][not(contains(@value,'taxes'))]"));
    By payment_information_edit = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,'*')][not(contains(@value,'Purchase'))][not(contains(@value,'taxes'))]/preceding-sibling::XCUIElementTypeButton[@name=\"Edit\"]"));

    //SELECT PAYMENT METHOD
    By select_payment_method_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"SELECT PAYMENT METHOD\"]"));
    By add_credit_card = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Add Credit Card\"]"));
    By cards_displayed = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Add Credit Card\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeOther/XCUIElementTypeOther[1]"));
    By cards_displayed_title = (AppiumBy.xpath(".//XCUIElementTypeStaticText[not(contains(@value,'*'))]"));
    By cards_displayed_number = (AppiumBy.xpath(".//XCUIElementTypeStaticText[contains(@value,'*')]"));
    By select_payment_method_cancel_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CANCEL\"]"));
    
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
    By action_button = (AppiumBy.xpath("//XCUIElementTypeScrollView/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText"));

    //AFTER CHECKOUT
    By loader = (AppiumBy.accessibilityId("In progress"));
    By success_title = (AppiumBy.accessibilityId("Payment Received!"));
    By success_message = (AppiumBy.accessibilityId("All your information has been saved. You can access your Reservation in 'My Parking Sessions' in the side menu"));
    By success_ok_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Ok\"]"));

    //ERROR
    By error_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'Error')]"));
    By error_message = (AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@value,'unable to process')]"));
    
    public void assertRegisteredUserIsOnCheckoutScreen() {
        assert_text(checkout_title, "Checkout");
        log.info("CHECKOUT SCREEN");
    }

    public void assertRegisteredUserTopView(){
        assert_element_is_not_displayed(have_account_label);
        assert_element_is_not_displayed(sign_in_button);
        // assert_text(personal_information_title, "PERSONAL INFORMATION");
        // assert_text(vehicle_information_title, "VEHICLE INFORMATION");
        // assert_text(payment_information_title, "PAYMENT INFORMATION");
    }

    public void assertRegisteredUserBottomView(String vehicle_size){

        assert_text(have_promo_code_label, "Have a Promo or Access code? Enter it here.");
        assert_text(promo_code_field, "EXAMPLE: PROMO50");
        assert_text(apply_promo_code_button, "APPLY");
        String size = (check_if_element_is_present(oversize_label).equals(false)) ? "STANDARD" : "OVERSIZE";
        Assert.assertEquals(size, vehicle_size);
        assert_text(send_me_info_message, "Yes, send me information about special offers near me.");
        // assert_element_is_checked(send_me_info);
        // log.info("The option '"+text(send_me_info)+"' is checked by default.");
        assert_text(terms_of_use, "Terms of Use.");
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

    public void clickActionButton(){
        String action_button_text = text(action_button);
        // assert_text(action_button, action_button_text);
        click(action_button);
        log.info(action_button_text+" button was clicked.");
    }

    public void checkRegisteredUserPersonalInformation(String email, String first_name, String last_name, String prefix, String phone){
        // scrollUpToText("PERSONAL INFORMATION");
        assert_text(personal_information_name, first_name+" "+last_name);
        assert_text(personal_information_email, email);
        log.info("Name is: "+first_name+" "+last_name);
        log.info("Email is: "+email);
        assert_text(personal_information_name_email_edit, "Edit");
        // assert_text(personal_information_phone, phone);
        log.info("Phone is: "+phone);
        assert_text(personal_information_phone_edit, "Edit");
        log.info("Personal information is correct.");
    }

    public void checkRegisteredUserVehicleInformation(String default_license_plate){
        // scrollDownToText("VEHICLE INFORMATION");
        assert_text(vehicle_information_license_plate, default_license_plate);
        log.info("License plate is: "+default_license_plate);
        assert_text(vehicle_information_edit, "Edit");
        log.info("Vehicle information is correct.");
    }

    public void checkRegisteredUserPaymentInformation(String[][] cards, String default_card, String license_plate){
        if(check_if_element_is_present(add_payment_button).equals(false)){
            scrollUpToText(license_plate);
            // swipeElementDown(scrollable, 1000);
        }
        click(add_payment_button);
        log.info("Add Payment button was clicked.");
        selectDefaultPaymentMethod(cards, default_card);

        // assert_text(payment_information_cc, default_card.toUpperCase());
        Assert.assertEquals(text(payment_information_cc).toUpperCase(), default_card.toUpperCase());
        log.info("Credit Card displayed as selected is: "+default_card.toUpperCase());
        assert_text(payment_information_edit, "Edit");
        log.info("Payment information is correct.");
    }

    public Integer calculateAmountOfCardsDisplayed() {
		try {
			int amount_of_additional_cards = amount_of_elements(cards_displayed);
			log.info("There are "+amount_of_additional_cards+" additional cards added.");
			return amount_of_additional_cards;
		} catch (TimeoutException e) {
			return 0;
		}
	}

    public String[][] getAllCreditCardsDisplayed() {

        int additional_cards_number = calculateAmountOfCardsDisplayed();
		String[][] cards = new String[additional_cards_number][];
		String card_title;
		int i = 0;

        for(WebElement card : find_all(cards_displayed)){

            Boolean have_title;

				try {
					have_title = card.findElement(cards_displayed_title).isDisplayed();
				}catch (NoSuchElementException | StaleElementReferenceException e){
					have_title =  false;
				}

				if (have_title.equals(true)) {
					card_title = card.findElement(cards_displayed_title).getText();
					log.info("Additional card nº"+(i+1)+" title: "+card_title);
				} else {
					card_title = "EMPTY";
					log.info("Additional card nº"+(i+1)+" doesn't have a title.");
				}

				String card_type_number = card.findElement(cards_displayed_number).getText();
				log.info("Additional card nº"+(i+1)+" type and number: "+card_type_number);
				cards[i] = new String[] {card_title, card_type_number};
				i++;
        }

        return cards;
    }

    public void checkThatAllCreditCardsAreDisplayed(String[][] cards) {
        //[i][0] title
        //[i][1] number
        //TODO: Fix the comparation of credit cards arrays
        String[][] checkout_cards = getAllCreditCardsDisplayed();
        int additional_cards_amount = calculateAmountOfCardsDisplayed();
        String[] cards_titles = new String[additional_cards_amount];
        String[] cards_numbers = new String[additional_cards_amount];

        String[] profile_cards_titles = new String[additional_cards_amount];
        String[] profile_cards_numbers = new String[additional_cards_amount];

        for (int i = 0; i < additional_cards_amount; i++) {

            cards_titles[i] = checkout_cards[i][0].toUpperCase();
            cards_numbers[i] = checkout_cards[i][1].toUpperCase();
            profile_cards_titles[i] = cards[i][0].toUpperCase();
            profile_cards_numbers[i] = cards[i][1].toUpperCase();
        }
        System.out.println("BEFORE SORT");
        System.out.println("CHECKOUT CARDS TITLES: "+cards_titles[0]);
        System.out.println("CHECKOUT CARDS NUMBERS: "+cards_numbers[0]);
        System.out.println("PROFILE CARDS TITLES: "+profile_cards_titles[0]);
        System.out.println("PROFILE CARDS NUMBERS: "+profile_cards_numbers[0]);
        System.out.println("CHECKOUT CARDS TITLES: "+cards_titles[1]);
        System.out.println("CHECKOUT CARDS NUMBERS: "+cards_numbers[1]);
        System.out.println("PROFILE CARDS TITLES: "+profile_cards_titles[1]);
        System.out.println("PROFILE CARDS NUMBERS: "+profile_cards_numbers[1]);
        Arrays.sort(cards_titles);
        Arrays.sort(cards_numbers);
        Arrays.sort(profile_cards_titles);
        Arrays.sort(profile_cards_numbers);
        System.out.println("AFTER SORT");
        System.out.println("CHECKOUT CARDS TITLES: "+cards_titles[0]);
        System.out.println("CHECKOUT CARDS NUMBERS: "+cards_numbers[0]);
        System.out.println("PROFILE CARDS TITLES: "+profile_cards_titles[0]);
        System.out.println("PROFILE CARDS NUMBERS: "+profile_cards_numbers[0]);
        System.out.println("CHECKOUT CARDS TITLES: "+cards_titles[1]);
        System.out.println("CHECKOUT CARDS NUMBERS: "+cards_numbers[1]);
        System.out.println("PROFILE CARDS TITLES: "+profile_cards_titles[1]);
        System.out.println("PROFILE CARDS NUMBERS: "+profile_cards_numbers[1]);
        Assert.assertTrue(Arrays.equals(cards_titles, profile_cards_titles));
        Assert.assertTrue(Arrays.equals(cards_numbers, profile_cards_numbers));
        log.info("All the cards obtained from user profile were displayed correclty in Checkout screen.");
    }

    public String selectDefaultPaymentMethod(String[][] cards, String default_card) {
        assert_element_is_displayed(select_payment_method_title);
        assert_text(select_payment_method_title, "SELECT PAYMENT METHOD");
        assert_text(add_credit_card, "Add Credit Card");
        checkThatAllCreditCardsAreDisplayed(cards);

        String card_type_number = new String();

        for(WebElement card : find_all(cards_displayed)){

            card_type_number = card.findElement(cards_displayed_number).getText().toUpperCase();
            if(card_type_number.equals(default_card.toUpperCase())){
                card.findElement(cards_displayed_number).click();
                log.info("Default card found: "+card_type_number);
                break;
            }
        }

        assert_element_is_not_displayed(select_payment_method_title);

        log.info("Defauld card was selected.");
        return card_type_number;
    }

    public Boolean checkIfPrintedPassIsRequired() {
        if(check_if_element_is_present(printed_pass_required_title).equals(true)){
            if(text(printed_pass_required_title).equals("PRINTED PASS REQUIRED")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
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

    public String checkAllUserDataIsDisplayedAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String prefix, String phone, String license_plate, String[][] cards, String cc_number){
        
        assertRegisteredUserIsOnCheckoutScreen();
        assertRegisteredUserTopView();
        checkRegisteredUserPersonalInformation(email, first_name, last_name, prefix, phone);
        checkRegisteredUserVehicleInformation(license_plate);
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertRegisteredUserBottomView(vehicle_size);
        checkRegisteredUserPaymentInformation(cards, cc_number, license_plate);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String checkAllUserDataIsDisplayedWithAccessCodeAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String prefix, String phone, String license_plate, String[][] cards, String cc_number, String access_code){
        
        assertRegisteredUserIsOnCheckoutScreen();
        assertRegisteredUserTopView();
        checkRegisteredUserPersonalInformation(email, first_name, last_name, prefix, phone);
        checkRegisteredUserVehicleInformation(license_plate);
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertRegisteredUserBottomView(vehicle_size);
        checkRegisteredUserPaymentInformation(cards, cc_number, license_plate);
        checkAccessCodeAppliedIsDisplayed(access_code);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return purchase_price;
    }

    public String checkAllUserDataIsDisplayedAddPromoCodeAndCompletePurchase(String vehicle_size, String lot_name_text, String lot_address_text, String lot_original_price_text, String email, String first_name, String last_name, String prefix, String phone, String license_plate, String[][] cards, String cc_number, String promo_code){
        
        assertRegisteredUserIsOnCheckoutScreen();
        assertRegisteredUserTopView();
        checkRegisteredUserPersonalInformation(email, first_name, last_name, prefix, phone);
        checkRegisteredUserVehicleInformation(license_plate);
        String purchase_price = assertLotDetails(lot_name_text, lot_address_text, lot_original_price_text);
        assertRegisteredUserBottomView(vehicle_size);
        checkRegisteredUserPaymentInformation(cards, cc_number, license_plate);
        addPromoCode(promo_code);
        String new_price_with_discount = checkPromoDiscountWasApplied(purchase_price);
        clickOnCompletePurchase();
        checkPurchaseWasSuccessful();
        return new_price_with_discount;
    }

}
