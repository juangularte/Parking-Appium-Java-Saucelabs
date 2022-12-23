package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class CheckoutYourInformationScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public CheckoutYourInformationScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By your_information_title = (By.xpath("//XCUIElementTypeStaticText[@name=\"Your Information\"]"));

    //BODY
    By subtitle = (AppiumBy.accessibilityId("We will email your parking pass to the email address you provide."));

    //FIELDS
    By email_label = (AppiumBy.accessibilityId("EMAIL ADDRESS*"));
    By email_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EMAIL ADDRESS*\"]/following-sibling::XCUIElementTypeTextField"));
    By first_name_label = (AppiumBy.accessibilityId("FIRST NAME*"));    
    By first_name_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"FIRST NAME*\"]/following-sibling::XCUIElementTypeTextField"));
    By last_name_label = (AppiumBy.accessibilityId("LAST NAME*"));
    By last_name_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"LAST NAME*\"]/following-sibling::XCUIElementTypeTextField"));
    By phone_label = (AppiumBy.accessibilityId("PHONE NUMBER*"));
    By phone_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PHONE NUMBER*\"]/following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField"));
    By country_prefix = (AppiumBy.xpath("//XCUIElementTypeTextField[@value='enter phone number']/preceding-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText")); //TODO: Add the preceding-sibling

    //VALIDATIONS
    By invalid_phone_label = (AppiumBy.accessibilityId("This isn't a valid phone number. Please try again."));
    By email_validation = (AppiumBy.accessibilityId("Invalid email address"));
    By first_name_validation = (AppiumBy.accessibilityId("Character not allowed"));
    By last_name_validation = (AppiumBy.accessibilityId("Character not allowed"));

    //COUNTRIES LIST
    By country_codes_title = (AppiumBy.accessibilityId("Country Codes"));
    By close_countries_list = (AppiumBy.accessibilityId("ic close card action"));
    By select_country_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Select a country\"`]"));
    By list_of_countries = (AppiumBy.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"));
    By first_country = (By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[1]"));

    //FOOTER
    By update_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"UPDATE\"]"));

    public void checkUserIsInYourInformationScreen() {
        assert_text(your_information_title, "Your Information");
        log.info("YOUR INFORMATION SCREEN");
    }
    
    public void assertCommonElements(){
        checkUserIsInYourInformationScreen();
        assert_text(subtitle, "We will email your parking pass to the email address you provide.");
        assert_text(email_label, "EMAIL ADDRESS*");
        assert_text(first_name_label, "FIRST NAME*");
        assert_text(last_name_label, "LAST NAME*");
        assert_text(phone_label, "PHONE NUMBER*");
        assert_text(email_field, "enter email address");
        assert_text(first_name_field, "ex - Jon");
        assert_text(last_name_field, "ex - Doe");
        assert_text(phone_field, "enter phone number");
        assert_element_is_displayed(country_prefix);
        assert_contains_text(country_prefix, "(+1)");
        assert_text(update_button, "UPDATE");
        log.info("All common elements were correclty asserted.");
    }

    public void addEmail(String email){
        clear_and_type(email_field, email);
        log.info("Email added: "+email);
        hideKeyboard();
    }

    public void addFirstLastName(String first, String last){
        clear_and_type(first_name_field, first);
        log.info("First name added: "+first);
        hideKeyboard();
        clear_and_type(last_name_field, last);
        log.info("Last name added: "+last);
        hideKeyboard();
    }

    public void addPhone(String phone){
        clear_and_type(phone_field, phone);
        log.info("Phone added: "+phone);
        hideKeyboard();
    }

    public void clickUpdate(){
        click(update_button);
        log.info("Update button was clicked.");
    }

    public void selectCountry(String country){
        clear(phone_field);
        if(!country.equals("United States") && !country.equals("USA")){
            click(country_prefix);
            assert_text(country_codes_title, "Country Codes");
            log.info("Countries list was open.");
            // type(search_country, country);
            String country_value = new String();
            String prefix_value = new String();
            if(check_if_element_is_present(first_country).equals(true)){
                assert_input_text(first_country, country);
                country_value = text(first_country);
                // prefix_value = text(first_country_prefix);
                click(first_country);
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
        assert_text(first_name_validation, "Character not allowed");
        click(last_name_field);
        type(last_name_field, "Test/+");
        assert_text(last_name_validation, "Character not allowed");
        click(phone_field);
        type(phone_field, "1010101010");
        hideKeyboard();
        click(update_button);
        assert_text(email_validation, "Invalid email address");
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
}
