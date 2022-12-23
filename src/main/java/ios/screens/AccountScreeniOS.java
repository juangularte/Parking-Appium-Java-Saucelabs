package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class AccountScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public AccountScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//GENERAL LOCATORS
	By close_button = (AppiumBy.accessibilityId("ic close card action"));
	By logo = (AppiumBy.accessibilityId("img_logo_splash"));
	By slogan = (AppiumBy.accessibilityId("M A K E.  P A R K I N G.  E A S I E R."));
	By keep_all = (AppiumBy.accessibilityId("Keep all your reservations, purchases, and vehicle information in one place for an easy checkout"));
	By account_title_guest = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/header"));

	//USER LOGGED IN LOCATORS
	By account_title_reg = (AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"ACCOUNT\"])[1]"));
	By menu = (AppiumBy.accessibilityId("ic btn menu"));
	By signed_as = (AppiumBy.accessibilityId("You are signed in as:"));
	By signed_as_email = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"You are signed in as:\"]/following-sibling::XCUIElementTypeStaticText"));

	By account_section_title = (AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"ACCOUNT\"])[2]"));
	By my_profile_option = (AppiumBy.accessibilityId("My Profile"));
	By my_profile_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"My Profile\"]/preceding-sibling::XCUIElementTypeButton"));
	By my_payments_methods_option = (AppiumBy.accessibilityId("My Payment Methods"));
	By my_payment_methods_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"My Payment Methods\"]/preceding-sibling::XCUIElementTypeButton"));
	By my_vehicles_option = (AppiumBy.accessibilityId("My Vehicles"));
	By my_vehicles_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"My Vehicles\"]/preceding-sibling::XCUIElementTypeButton"));
	By parking_section_title = (AppiumBy.accessibilityId("PARKING SESSIONS"));
	By my_parking_sessions_option = (AppiumBy.accessibilityId("My Parking Sessions"));
	By monthly_section_title = (AppiumBy.accessibilityId("MONTHLY"));
	By monthly_account_option = (AppiumBy.accessibilityId("Access Monthly Account"));

	By sign_out_option = (AppiumBy.accessibilityId("Sign Out"));

	//MENU
	By menu_scrollable = (AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`label == \"Vertical scroll bar, 2 pages\"`]"));
	By find_parking_option = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Find Parking\"`]"));

	//USER NOT LOGGED IN LOCATORS
	By signup_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"SIGNUP\"`]"));
	By login_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"LOGIN\"`]"));
	By monthly_account_message = (AppiumBy.accessibilityId("Looking for your Monthly Parking Account?"));
	By access_monthly = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"ACCESS MONTHLY\"`]"));
	
	//USER GUEST METHODS
	public void assertUserIsOnAccountScreenAsGuest(){
		assert_text(login_button, "LOGIN");
		log.info("ACCOUNT SCREEN");
	}

	public void assertTextsGuestUser() {
		assert_text(slogan, "M A K E.  P A R K I N G.  E A S I E R.");
		assert_text(keep_all, "Keep all your reservations, purchases, and vehicle information in one place for an easy checkout");
		assert_text(monthly_account_message, "Looking for your Monthly Parking Account?");
		assert_text(access_monthly, "ACCESS MONTHLY");
		log.info("All basic assertions for Guest User passed.");
	}

	public void goToLoginScreen(){
		assertUserIsOnAccountScreenAsGuest();
		assertTextsGuestUser();
		click(login_button);
		log.info("Login button was clicked.");
	}


	//USER LOGGED IN METHODS
	public void assertUserIsOnAccountScreenAsReg(String email){
		assert_text(account_title_reg, "ACCOUNT");
		assert_text(signed_as, "You are signed in as:");
		assert_text(signed_as_email, email);
		log.info("ACCOUNT SCREEN");
	}

	public void assertTextsRegUser() {
		assert_text(account_section_title, "ACCOUNT");
		assert_text(my_profile_option, "My Profile");
		assert_text(my_payments_methods_option, "My Payment Methods");
		assert_text(my_vehicles_option, "My Vehicles");
		assert_text(parking_section_title, "PARKING SESSIONS");
		assert_text(my_parking_sessions_option, "My Parking Sessions");
		assert_text(monthly_section_title, "MONTHLY");
		assert_text(monthly_account_option, "Access Monthly Account");
		assert_text(sign_out_option, "Sign Out");
		log.info("All basic assertions for logged in user passed.");
	}

	public void clickMenu(){
		click(menu);
		log.info("Menu button was clicked.");
	}

	public void goToMyProfile(String email) {
		assertUserIsOnAccountScreenAsReg(email);
		assertTextsRegUser();
		click(my_profile_button);
		log.info("My Profile was clicked.");
	}

	public void goToMyPaymentMethods(String email) {
		assertUserIsOnAccountScreenAsReg(email);
		assertTextsRegUser();
		click(my_payment_methods_button);
		log.info("My Payment Methods was clicked.");
	}

	public void goToMyVehicles(String email) {
		assertUserIsOnAccountScreenAsReg(email);
		assertTextsRegUser();
		click(my_vehicles_button);
		log.info("My Vehicles was clicked.");
	}

	public void goBackToDashboardScreen(){
		clickMenu();
		if(check_if_element_is_present(find_parking_option).equals(false)){
            swipeElementDown(menu_scrollable, 400);
        }
		click(find_parking_option);
		log.info("Find Parking option was clicked. Should be redirected to Dasboard screen.");
	}

}
