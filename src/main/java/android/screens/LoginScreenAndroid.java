package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class LoginScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public LoginScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}
	
//	String[] login_button=new String[] {"id", "Login"};
//	@AndroidFindBy(id ="com.spplus.parking.develop:id/letsParkButton")
//	public WebElement lets_park_button;
	
	By login_title = (By.id("com.spplus.parking.develop:id/title"));	
	By email_field = (By.id("com.spplus.parking.develop:id/emailField"));
	By pwd_field = (By.id("com.spplus.parking.develop:id/passwordField"));
	By next_button = (By.id("com.spplus.parking.develop:id/signInButton"));
	By error_modal = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ERROR']"));
	By error_message = (By.id("com.spplus.parking.develop:id/message"));
	By signing_in = (By.xpath("//*[@resource-id='android:id/message'][@text='Signing In…']"));

	By none_button = (By.xpath("//*[@text='NONE OF THE ABOVE']"));
	By smart_lock_never_button = (By.xpath("//*[@text='NEVER']"));

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
			log.info("List of users wasn't displayed.");
		}
	}
	
	public void checkIfSmartLockPopupAppears() {
		try {
			waitForElementToBeVisible(smart_lock_never_button, (long) 3);
			click(smart_lock_never_button);
			log.info("Smart Lock popup appeared, but Never was clicked.");
		} catch (TimeoutException e) {
			log.info("Smart Lock popup wasn't displayed.");
		}
	}
	
	public void loginProcess(String username, String password){
		checkIfSystemAccountsListAppears();
		checkUserIsOnLoginScreen();
		type(email_field, username);
		log.info("User: "+username);
		type(pwd_field, password);
		log.info("Password: "+password);
		assert_text(next_button, "NEXT");
		click(next_button);
		log.info("Next button was clicked.");
		try {
			waitForElementToBeVisible(email_field, (long) 5);
				// click(next_button);
				// log.info("Next button was clicked.");
				throw new Error("Next button was clicked but the app wasn't redirected to Dashboard screen.");
		} catch (TimeoutException e) {}
		
		// checkIfSmartLockPopupAppears();
	}

	public void positiveLoginProcess(String username, String password){
		loginProcess(username, password);
		checkIsSigningIn();
		checkIfSmartLockPopupAppears();
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
				log.info("User is signing in...");
            } catch (StaleElementReferenceException e) {}
        }else{log.info("User is signed in.");}
	}

}
