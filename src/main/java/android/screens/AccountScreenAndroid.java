package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class AccountScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public AccountScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//GENERAL LOCATORS
	By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
	By account_title_guest = (By.id("com.spplus.parking.develop:id/header"));
	By account_title_reg = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/backButton']/following-sibling::android.widget.TextView[@text='Account']"));

	//USER LOGGED IN LOCATORS
	By account_section_title = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/profileSection']/preceding-sibling::android.widget.TextView[@text='ACCOUNT']"));
	By my_profile_option = (By.id("com.spplus.parking.develop:id/profileSection"));
	By my_payments_methods_option = (By.id("com.spplus.parking.develop:id/paymentMethodsSection"));
	By my_vehicles_option = (By.id("com.spplus.parking.develop:id/vehiclesSection"));
	By parking_section_title = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/myReservationsSection']/preceding-sibling::android.widget.TextView[@text='PARKING SESSIONS']"));
	By my_parking_sessions_option = (By.id("com.spplus.parking.develop:id/myReservationsSection"));
	By monthly_parking_option = (By.id("com.spplus.parking.develop:id/my_monthly_parking"));

	//USER NOT LOGGED IN LOCATORS
	By login_button = (By.id("com.spplus.parking.develop:id/signInButton"));
	
	//USER GUEST METHODS
	public void assertUserIsOnAccountScreenAsGuest(){
		assert_text(account_title_guest, "Account");
		log.info("ACCOUNT SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertUserIsOnAccountScreenAsReg(){
		assert_text(account_title_reg, "Account");
		log.info("ACCOUNT SCREEN");
	}

	public void assertTextsLoggedUser() {
		assert_text(account_section_title, "ACCOUNT");
		assert_text(my_profile_option, "My Profile");
		assert_text(my_payments_methods_option, "My Payment Methods");
		assert_text(my_vehicles_option, "My Vehicles");
		assert_text(parking_section_title, "PARKING SESSIONS");
		assert_text(my_parking_sessions_option, "My Parking Sessions");
		assert_text(monthly_parking_option, "Monthly Parking");
		log.info("All basic assertions for logged in user passed.");
	}

	public void goBack(){
		click(back_button);
		log.info("Back button was clicked.");
	}

	public void goToMyProfile() {
		assertUserIsOnAccountScreenAsReg();
		assertTextsLoggedUser();
		click(my_profile_option);
		log.info("My Profile was clicked.");
	}

	public void goToMyPaymentMethods() {
		assertUserIsOnAccountScreenAsReg();
		assertTextsLoggedUser();
		click(my_payments_methods_option);
		log.info("My Payment Methods was clicked.");
	}

	public void goToMyVehicles() {
		assertUserIsOnAccountScreenAsReg();
		assertTextsLoggedUser();
		click(my_vehicles_option);
		log.info("My Vehicles was clicked.");
	}

	public void goBackToDashboardScreen(){
		goBack();
	}

	//USER NOT LOGGED IN
	public void assertTextsGuestUser() {
		//TODO Text assertion for user that is not logged in
	}

	public void goToLoginScreen(){
		assertUserIsOnAccountScreenAsGuest();
		click(login_button);
		log.info("Login button was clicked.");
	}

}
