package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class LoginScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public LoginScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}
	
	//HEADER
	By login_title = (AppiumBy.accessibilityId("LOGIN"));
	By close_button = (AppiumBy.accessibilityId("ic close card action"));
	By welcome_back = (AppiumBy.accessibilityId("Welcome back!"));

	//BODY
	By email_label = (AppiumBy.accessibilityId("EMAIL*"));
	By email_field = (AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"enter email address\"`]"));
	By pwd_label = (AppiumBy.accessibilityId("Password*"));
	By pwd_field = (AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"enter password\"`]"));
	By hide_password = (AppiumBy.accessibilityId("hidePassword"));
	By show_password = (AppiumBy.accessibilityId("showPassword"));
	By forgot_password = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Forgot password?\"`]"));

	//FIELDS VALIDATIONS
	By invalid_email_validation = (AppiumBy.accessibilityId("Invalid email address"));
	By empty_password_validation = (AppiumBy.accessibilityId("Please enter your password"));
	By error_popup = (AppiumBy.accessibilityId("Error"));
	By pwd_format_validation = (AppiumBy.accessibilityId("Password must be between 8-64 characters."));
	By incorrect_pwd_validation = (AppiumBy.accessibilityId("Your email address and/or password are incorrect. Please try again."));
	By error_popup_ok_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"OK\"`]"));

	//FOOTER
	By next_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"NEXT\"`]"));

	//POPUP
	By error_modal = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ERROR']"));
	By error_message = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/message"));

	//SIGNING PROCESS
	By signing_in = (AppiumBy.accessibilityId("android:id/message"));

	By none_button = (By.xpath("//*[@value='NONE OF THE ABOVE']"));
	By smart_lock_never_button = (By.xpath("//*[@value='NEVER']"));

	public void checkUserIsOnLoginScreen() {
		assert_text(login_title, "LOGIN");
		log.info("LOGIN SCREEN");
	}

	public void checkIfSystemAccountsListAppears() {
		try {
			waitForElementToBeVisible(none_button, (long) 3);
			click(none_button);
			log.info("List of users appeared, but none was selected.");
		} catch (TimeoutException e) {
			//TODO: handle exception
		}
	}
	
	public void checkIfSmartLockPopupAppears() {
		try {
			waitForElementToBeVisible(smart_lock_never_button, (long) 3);
			click(smart_lock_never_button);
			log.info("Smart Lock popup appeared, but Never was clicked.");
		} catch (TimeoutException e) {
			//TODO: add handle exception
		}
	}
	
	public void loginProcess(String username, String password){
		checkIfSystemAccountsListAppears();
		checkUserIsOnLoginScreen();
		type(email_field, username);
		log.info("User: "+username);
		click(hide_password);
		type(pwd_field, password);
		log.info("Password: "+password);
		hideKeyboard();
		click(next_button);
		log.info("Next button was clicked.");
		checkIfSmartLockPopupAppears();
	}

	public void positiveLoginProcess(String username, String password){
		loginProcess(username, password);
		// checkIsSigningIn();
	}

	public void checkErrorMessageAppears(String errorMsg){
		assert_element_is_displayed(error_modal);
		assert_text(error_message, errorMsg);
	}

	public void negativeLoginProcess(String username, String password){
		loginProcess(username, password);
		checkErrorMessageAppears("Your email address and/or password are incorrect. Please try again.");
	}

	public void checkIsSigningIn(){

		if (check_if_element_is_present(signing_in).equals(true)){
            try {
                assert_text(signing_in, "Signing In…");
				log.info("User is signing in...");
            } catch (StaleElementReferenceException e) {}
        }else{log.info("User is signed in.");}
	}

}
