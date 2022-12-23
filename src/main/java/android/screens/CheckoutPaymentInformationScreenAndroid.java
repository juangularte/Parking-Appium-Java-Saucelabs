package android.screens;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class CheckoutPaymentInformationScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public CheckoutPaymentInformationScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
    By payment_information_title = (By.xpath("//android.widget.TextView[@text='Payment Information']"));

    //BODY
    By disclaimer = (By.id("com.spplus.parking.develop:id/cvvDisclaimer"));

    //FIELDS
    By cc_number_label = (By.id("com.spplus.parking.develop:id/numberLabel"));
    By cc_number_field = (By.id("com.spplus.parking.develop:id/numberField"));
    By invalid_cc_number = (By.id("com.spplus.parking.develop:id/numberValidation"));
    By cc_exp_date_label = (By.id("com.spplus.parking.develop:id/expirationLabel"));
    By cc_exp_date_field = (By.id("com.spplus.parking.develop:id/expirationField"));
    By invalid_exp_date = (By.id("com.spplus.parking.develop:id/expirationValidation"));
    By cc_cvv_label = (By.id("com.spplus.parking.develop:id/cvvLabel"));
    By cc_cvv_field = (By.id("com.spplus.parking.develop:id/cvvField"));
    By invalid_cvv = (By.id("com.spplus.parking.develop:id/cvvValidation"));
    By cc_postal_code_label = (By.id("com.spplus.parking.develop:id/zipcodeLabel"));
    By cc_postal_code_field = (By.id("com.spplus.parking.develop:id/zipcodeField"));
    By invalid_postal_code = (By.id("com.spplus.parking.develop:id/zipcodeValidation"));


    //FOOTER
    By add_payment = (By.id("com.spplus.parking.develop:id/addPaymentButton"));
    
    public void assertCommonElements(){
        log.info("PAYMENT INFORMATION SCREEN");
        assert_text(payment_information_title, "Payment Information");
        assert_text(cc_number_label, "CREDIT CARD*");
        assert_text(cc_number_field, "enter card number");
        assert_text(cc_exp_date_label, "EXP DATE*");
        assert_text(cc_exp_date_field, "MM/YYYY");
        assert_text(cc_cvv_label, "CVV*");
        assert_text(cc_cvv_field, "ex - 123");
        assert_text(cc_postal_code_label, "POSTAL CODE*");
        assert_text(cc_postal_code_field, "Enter Postal Code");
        // assert_text(disclaimer, "*This payment method applies for [US|CANADIAN] locations only.");
    }

    public void addCCnumber(String cc_number){
        clear_and_type(cc_number_field, cc_number);
        log.info("CC Number added: "+cc_number);
    }

    public void addCCexpDate(String cc_exp_date){
        clear_and_type(cc_exp_date_field, cc_exp_date);
        log.info("CC Expiration Date added: "+cc_exp_date);
    }

    public void addCCcvv(String cc_cvv){
        clear_and_type(cc_cvv_field, cc_cvv);
        log.info("CC CVV added: "+cc_cvv);
    }

    public void addCCpostalCode(String postal_code){
        clear_and_type(cc_postal_code_field, postal_code);
        log.info("Postal Code added: "+postal_code);
    }

    public void clickAddPayment(){
        click(add_payment);
        log.info("Add Payment button was clicked.");
    }

    public void assertFieldValidations(){
        type(cc_number_field, "3333333333333333");
        type(cc_exp_date_field, "072022");
        type(cc_cvv_field, "12345");
        click(add_payment);
        assert_text(invalid_cc_number, "Invalid credit card number");
        assert_text(invalid_exp_date, "Invalid expiration");
        assert_text(invalid_cvv, "Invalid CVV");
        assert_text(invalid_postal_code, "Invalid postal code");
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
