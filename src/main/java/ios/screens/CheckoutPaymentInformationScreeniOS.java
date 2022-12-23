package ios.screens;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class CheckoutPaymentInformationScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public CheckoutPaymentInformationScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By payment_information_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Payment Information\"]"));

    //BODY
    By disclaimer = (AppiumBy.accessibilityId("*This payment method applies for [US|CANADIAN] locations only."));

    //FIELDS
    By cc_number_label = (AppiumBy.accessibilityId("CREDIT CARD*"));
    By cc_number_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CREDIT CARD*\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"));
    By invalid_cc_number = (AppiumBy.accessibilityId("Please enter the credit card numbers"));

    By cc_exp_date_label = (AppiumBy.accessibilityId("EXP DATE*"));
    By cc_exp_date_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EXP DATE*\"]/following-sibling::XCUIElementTypeTextField"));
    By invalid_exp_date = (AppiumBy.accessibilityId("Please enter expiration date"));

    By cc_cvv_label = (AppiumBy.accessibilityId("CVV*"));
    By cc_cvv_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"CVV*\"]/following-sibling::XCUIElementTypeTextField"));
    By invalid_cvv = (AppiumBy.accessibilityId("Please enter the card CVV"));

    By cc_postal_code_label = (AppiumBy.accessibilityId("POSTAL CODE*"));
    By cc_postal_code_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"POSTAL CODE*\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"));
    By invalid_postal_code = (AppiumBy.accessibilityId("Please enter your postal code"));


    //FOOTER
    By add_payment = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ADD PAYMENT\"]"));

    public void checkUserIsInPaymentInformationScreen() {
        assert_text(payment_information_title, "Payment Information");
        log.info("PAYMENT INFORMATION SCREEN");
    }

    public void assertCommonElements(){
        checkUserIsInPaymentInformationScreen();
        assert_text(cc_number_label, "CREDIT CARD*");
        // assert_text(cc_number_field, "enter card number");
        assert_text(cc_exp_date_label, "EXP DATE*");
        assert_text(cc_exp_date_field, "MM/YYYY");
        assert_text(cc_cvv_label, "CVV*");
        assert_text(cc_cvv_field, "ex - 123");
        assert_text(cc_postal_code_label, "POSTAL CODE*");
        assert_text(cc_postal_code_field, "Enter Postal Code");
        if(check_if_element_is_present(disclaimer).equals(true)){
            assert_text(disclaimer, "*This payment method applies for [US|CANADIAN] locations only.");
        }else{
            log.info("Message not displayed: *This payment method applies for [US|CANADIAN] locations only.");
        }
        
    }

    public void addCCnumber(String cc_number){
        clear_and_type(cc_number_field, cc_number);
        log.info("CC Number added: "+cc_number);
        hideKeyboard();
    }

    public void addCCexpDate(String cc_exp_date){
        clear_and_type(cc_exp_date_field, cc_exp_date);
        log.info("CC Expiration Date added: "+cc_exp_date);
        hideKeyboard();
    }

    public void addCCcvv(String cc_cvv){
        clear_and_type(cc_cvv_field, cc_cvv);
        log.info("CC CVV added: "+cc_cvv);
        hideKeyboard();
    }

    public void addCCpostalCode(String postal_code){
        clear_and_type(cc_postal_code_field, postal_code);
        log.info("Postal Code added: "+postal_code);
        hideKeyboard();
    }

    public void clickAddPayment(){
        click(add_payment);
        log.info("Add Payment button was clicked.");
    }

    public void assertFieldValidations(){
        type(cc_number_field, "3334");
        type(cc_exp_date_field, "072022");
        type(cc_cvv_field, "12");
        hideKeyboard();
        click(add_payment);
        assert_text(invalid_cc_number, "Please enter the credit card numbers");
        assert_text(invalid_exp_date, "Please enter expiration date");
        assert_text(invalid_cvv, "Please enter the card CVV");
        assert_text(invalid_postal_code, "Please enter your postal code");
        log.info("All validations were displayed.");
    }

    public void completeFields(String cc_number, String cc_exp_date, String cc_cvv, String cc_postal_code){
        assertCommonElements();
        assertFieldValidations();
        addCCnumber(cc_number);
        addCCexpDate(cc_exp_date);
        addCCcvv(cc_cvv);
        addCCpostalCode(cc_postal_code);
        clickAddPayment();
    }
}
