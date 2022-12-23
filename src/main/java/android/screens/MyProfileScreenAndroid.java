package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class MyProfileScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public MyProfileScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
	By my_profile_title = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/backButton']/following-sibling::android.widget.TextView[@text='My Profile']"));
	By save_button = (By.id("com.spplus.parking.develop:id/saveButton"));
	By profile_info_title = (By.id("com.spplus.parking.develop:id/profileInformationHeader"));

	//PROFILE INFORMATION
    By email_label = (By.id("com.spplus.parking.develop:id/emailLabel"));
    By email_field = (By.id("com.spplus.parking.develop:id/emailField"));
    By first_name_label = (By.id("com.spplus.parking.develop:id/firstNameLabel"));    
    By first_name_field = (By.id("com.spplus.parking.develop:id/firstNameField"));
    By last_name_label = (By.id("com.spplus.parking.develop:id/lastNameLabel"));
    By last_name_field = (By.id("com.spplus.parking.develop:id/lastNameField"));
    By phone_label = (By.id("com.spplus.parking.develop:id/phoneLabel"));
    By phone_field = (By.id("com.spplus.parking.develop:id/phoneEditText"));
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

	//SECURITY
	By security_title = (By.id("com.spplus.parking.develop:id/securityHeader"));
	By change_password = (By.id("com.spplus.parking.develop:id/changePasswordSection"));
    By smartlock = (By.id("com.spplus.parking.develop:id/smartLockToggle"));


	public void assertUserIsOnMyProfileScreen(){
		assert_text(my_profile_title, "My Profile");
		log.info("MY PROFILE SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertTextsLoggedUser() {
		assert_text(save_button, "Save");
		assert_text(profile_info_title, "PROFILE INFORMATION");
		assert_text(email_label, "EMAIL");
		assert_text(first_name_label, "FIRST NAME");
		assert_text(last_name_label, "LAST NAME");
		assert_text(phone_label, "PHONE NUMBER*");
		assert_text(security_title, "SECURITY");
		assert_text(change_password, "Change Password");
		assert_contains_text(smartlock, "SmartLock");
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
		String prefix_value = text(country_prefix);
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
