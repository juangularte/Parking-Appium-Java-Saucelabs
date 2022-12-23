package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class CheckoutYourInformationScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public CheckoutYourInformationScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
    By your_information_title = (By.xpath("//android.widget.TextView[@text='YOUR INFORMATION']"));

    //BODY
    By subtitle = (By.id("com.spplus.parking.develop:id/subtitle"));

    //FIELDS
    By email_label = (By.id("com.spplus.parking.develop:id/emailLabel"));
    By email_field = (By.id("com.spplus.parking.develop:id/emailField"));
    By first_name_label = (By.id("com.spplus.parking.develop:id/firstNameLabel"));    
    By first_name_field = (By.id("com.spplus.parking.develop:id/firstNameField"));
    By last_name_label = (By.id("com.spplus.parking.develop:id/lastNameLabel"));
    By last_name_field = (By.id("com.spplus.parking.develop:id/lastNameField"));
    By phone_label = (By.id("com.spplus.parking.develop:id/phoneLabel"));
    By phone_field = (By.id("com.spplus.parking.develop:id/phoneEditFeild"));
    By country_section = (By.id("com.spplus.parking.develop:id/country_code_holder_rly"));
    By phone_flag = (By.id("com.spplus.parking.develop:id/flag_imv"));
    By country_prefix = (By.id("com.spplus.parking.develop:id/selected_country_tv"));
    By countries_arrow = (By.id("com.spplus.parking.develop:id/arrow_imv"));
    By invalid_phone_label = (By.id("com.spplus.parking.develop:id/phoneValidation"));
    By email_validation = (By.id("com.spplus.parking.develop:id/emailValidation"));
    By first_name_validation = (By.id("com.spplus.parking.develop:id/firstNameValidation"));
    By last_name_validation = (By.id("com.spplus.parking.develop:id/lastNameValidation"));

    //COUNTRIES LIST
    By select_country_title = (By.id("com.spplus.parking.develop:id/title_tv"));
    By search_country = (By.id("com.spplus.parking.develop:id/search_edt"));
    By list_of_countries = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv']"));
    By first_country = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv'][1]"));
    By first_country_prefix = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/code_tv'][1]"));
    By no_country_found = (By.id("com.spplus.parking.develop:id/no_result_tv"));

    //FOOTER
    By update_button = (By.id("com.spplus.parking.develop:id/updateButton"));

    //ONDEMAND LOCATORS
    By od_phone_field = (By.id("com.spplus.parking.develop:id/phoneEditText"));
    

    public void chekcUserIsInYourInformationScreen() {
        assert_text(your_information_title, "YOUR INFORMATION");
        log.info("YOUR INFORMATION SCREEN");
    }
    public void assertCommonElements(){
        chekcUserIsInYourInformationScreen();
        assert_text(subtitle, "We will email your parking pass to the email address you provide.");
        // assert_text(email_label, "EMAIL*");
        assert_text(first_name_label, "FIRST NAME*");
        assert_text(last_name_label, "LAST NAME*");
        assert_text(phone_label, "PHONE NUMBER*");
        assert_text(email_field, "enter email address");
        assert_text(first_name_field, "ex - John");
        assert_text(last_name_field, "ex- Doe");
        // assert_text(phone_field, "(201) 555-0123");
        assert_element_is_displayed(phone_flag);
        assert_element_is_displayed(country_prefix);
        assert_element_is_displayed(countries_arrow);
        assert_text(country_prefix, "+1");
        assert_text(update_button, "UPDATE");
    }

    public void addEmail(String email){
        clear_and_type(email_field, email);
        log.info("Email added: "+email);
    }

    public void addFirstLastName(String first, String last){
        clear_and_type(first_name_field, first);
        log.info("First name added: "+first);
        clear_and_type(last_name_field, last);
        log.info("Last name added: "+last);
    }

    public void addPhone(String phone){
        clear_and_type(phone_field, phone);
        log.info("Phone added: "+phone);
    }

    public void addPhoneOD(String phone){
        clear_and_type(od_phone_field, phone);
        log.info("Phone added: "+phone);
    }

    public void clickUpdate(){
        click(update_button);
        log.info("Update button was clicked.");
    }

    public void selectCountry(String country){
        if(!country.equals("United States") && !country.equals("USA")){
            click(country_section);
            log.info("Countries list was open.");
            type(search_country, country);
            String country_value = new String();
            String prefix_value = new String();
            if(check_if_element_is_present(first_country).equals(true)){
                assert_input_text(first_country, country);
                country_value = text(first_country);
                prefix_value = text(first_country_prefix);
                click(first_country);
            }else if(check_if_element_is_present(no_country_found).equals(true)){
                throw new Error("No country matches the value entered: "+country);
            }
            assert_text(country_prefix, prefix_value);
            log.info("Country selected: "+country_value);
        }
    }

    public void assertFieldValidations(){
        click(email_field);
        type(email_field, "juan@spp");
        click(first_name_field);
        type(first_name_field, "Juan.");
        click(last_name_field);
        type(last_name_field, "Test/+");
        click(phone_field);
        type(phone_field, "1010101010");
        assert_text(email_validation, "Invalid email address.");
        assert_text(first_name_validation, "Character Not Allowed");
        assert_text(last_name_validation, "Character Not Allowed");
        assert_text(invalid_phone_label, "This isn't a valid phone number. Please try again.");
        log.info("All validations were displayed.");
    }

    public void assertFieldValidationsOD(){
        click(email_field);
        type(email_field, "juan@spp");
        click(first_name_field);
        type(first_name_field, "Juan.");
        click(last_name_field);
        type(last_name_field, "Test/+");
        click_back_button();
        click(od_phone_field);
        type(od_phone_field, "1010101010");
        click_back_button();
        assert_text(email_validation, "Invalid email address.");
        assert_text(first_name_validation, "Character Not Allowed");
        assert_text(last_name_validation, "Character Not Allowed");
        assert_text(invalid_phone_label, "This isn't a valid phone number. Please try again.");
        log.info("All validations were displayed.");
    }

    public void completeFields(String email, String first_name, String last_name, String phone, String country){
        assertCommonElements();
        assertFieldValidations();
        addEmail(email);
        addFirstLastName(first_name, last_name);
        selectCountry(country);
        addPhone(phone);
        clickUpdate();
    }

    public void completeFieldsOD(String email, String first_name, String last_name, String phone, String country){
        assertCommonElements();
        assertFieldValidationsOD();
        addEmail(email);
        addFirstLastName(first_name, last_name);
        selectCountry(country);
        addPhoneOD(phone);
        clickUpdate();
    }
}
