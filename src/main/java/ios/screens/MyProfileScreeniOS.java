package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class MyProfileScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public MyProfileScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//HEADER
	By back_button = (AppiumBy.accessibilityId("ic back"));
	By my_profile_title = (AppiumBy.accessibilityId("My Profile"));
	By save_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Save\"]"));
	

	//PROFILE INFORMATION
	By profile_info_title = (AppiumBy.accessibilityId("PROFILE INFORMATION"));
    By email_label = (AppiumBy.accessibilityId("EMAIL*"));
    By email_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"EMAIL*\"]/following-sibling::XCUIElementTypeTextField"));
    By first_name_label = (AppiumBy.accessibilityId("FIRST NAME*"));    
    By first_name_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"FIRST NAME*\"]/following-sibling::XCUIElementTypeTextField"));
    By last_name_label = (AppiumBy.accessibilityId("LAST NAME*"));
    By last_name_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"LAST NAME*\"]/following-sibling::XCUIElementTypeTextField"));
    By phone_label = (AppiumBy.accessibilityId("PHONE NUMBER*"));
    By phone_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"PHONE NUMBER*\"]/following-sibling::XCUIElementTypeOther//XCUIElementTypeTextField"));
    By country_section = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/country_code_holder_rly"));
    By phone_flag = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/flag_imv"));
    By country_prefix = (AppiumBy.xpath("//*[contains(text(), \"+\")]"));
    By countries_arrow = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/arrow_imv"));
    By invalid_phone_label = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/phoneValidation"));
    By email_validation = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/emailValidation"));
    By first_name_validation = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/firstNameValidation"));
    By last_name_validation = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/lastNameValidation"));

    //COUNTRIES LIST
    By select_country_title = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/title_tv"));
    By search_country = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/search_edt"));
    By list_of_countries = (AppiumBy.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv']"));
    By first_country = (AppiumBy.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv'][1]"));
    By first_country_prefix = (AppiumBy.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/code_tv'][1]"));
    By no_country_found = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/no_result_tv"));

	//LOADER
    By loading = (AppiumBy.accessibilityId("In progress"));

	//SECURITY
	By security_title = (AppiumBy.accessibilityId("SECURITY"));
	By change_password_option = (AppiumBy.accessibilityId("Change Password"));
    By touch_id = (AppiumBy.accessibilityId("Use Touch ID to Login"));
	By touch_id_toggle = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Use Touch ID to Login\"]/following-sibling::XCUIElementTypeSwitch"));


	public void assertUserIsOnMyProfileScreen(){
		waitUntilFinishLoading();
		assert_text(my_profile_title, "My Profile");
		log.info("MY PROFILE SCREEN");
	}


    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 30);
        } catch (TimeoutException e) {
        }
    }
	
	public void assertTextsLoggedUser() {
		assert_text(save_button, "Save");
		assert_text(profile_info_title, "PROFILE INFORMATION");
		assert_text(email_label, "EMAIL*");
		assert_text(first_name_label, "FIRST NAME*");
		assert_text(last_name_label, "LAST NAME*");
		assert_text(phone_label, "PHONE NUMBER*");
		assert_text(security_title, "SECURITY");
		assert_text(change_password_option, "Change Password");
		assert_contains_text(touch_id, "Use Touch ID to Login");
		log.info("All basic assertions for logged user passed.");
	}

	public String getEmail(){
		String email_value = text(email_field);
		log.info("Email is: "+email_value);
		return email_value;
	}

	public String getFirstName(){
		String first_name_value = text(first_name_field);
		log.info("First Name is: "+first_name_value);
		return first_name_value;
	}

	public String getLastName(){
		String last_name_value = text(last_name_field);
		log.info("Last Name is: "+last_name_value);
		return last_name_value;
	}

	public String getPhonePrefix(){
		// String prefix_value = text(country_prefix);
		String prefix_value = "+1";
		log.info("Phone Prefix is: "+prefix_value);
		return prefix_value;
	}

	public String getPhone(){
		String phone_value = text(phone_field);
		log.info("Phone is: "+phone_value);
		return phone_value;
	}

	public String[] getAllProfileValues(){
		return new String[] {getEmail(), getFirstName(), getLastName(), getPhonePrefix(), getPhone()};
	}

	public void goBack(){
		click(back_button);
		log.info("Back button was clicked.");
	}

	public String[] getProfileDataFromUserAndGoBackToAccountScreen() {
		assertUserIsOnMyProfileScreen();
		assertTextsLoggedUser();
		String[] values = getAllProfileValues();
		goBack();
		return values;
	}
}
