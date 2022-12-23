package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class WelcomeScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public WelcomeScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}
	
	By allow_notifications = (AppiumBy.accessibilityId("Allow"));
	By logo = (AppiumBy.accessibilityId("img_logo_splash_TM"));
	By slogan = (AppiumBy.accessibilityId("P A R K.  B E T T E R.  P E R I O D."));
	By easily_book = (AppiumBy.accessibilityId("Easily book daily and monthly parking when you need it"));
	By monthly_parking = (AppiumBy.accessibilityId("Manage your monthly parking account and payment"));
	By event_parking = (AppiumBy.accessibilityId("Find event parking on the go"));
	By let_us_help = (AppiumBy.accessibilityId("Let us help you find parking!"));
	By location_permission_warning = (AppiumBy.accessibilityId("The Parking.com App will need location permission to identify parking near you. Please grant access."));
	By lets_park_button = (AppiumBy.xpath("//XCUIElementTypeButton[@name=\"LET'S PARK\"]"));
	By powered_by = (AppiumBy.accessibilityId("Powered by"));
	By powered_by_logo = (AppiumBy.accessibilityId("SP+ParkingLogo_splash"));
	
	public void allowNotifications() {
		click(allow_notifications);
	}

	public void assertBasicElements() {
		waitForElementToBeLocated(slogan, (long) 5);
		assert_text(slogan, "P A R K.  B E T T E R.  P E R I O D.");
		assert_text(easily_book, "Easily book daily and monthly parking when you need it");
		assert_text(monthly_parking, "Manage your monthly parking account and payment");
		assert_text(event_parking, "Find event parking on the go");
		assert_text(let_us_help, "Let us help you find parking!");
		assert_text(location_permission_warning, "The Parking.com App will need location permission to identify parking near you. Please grant access.");
		assert_text(powered_by, "Powered by");
	}

	public void clickOnLetsParkButton(){
		waitForElementToBeClickable(lets_park_button, (long) 30);
		click(lets_park_button);
		log.info("Let's Park button was clicked.");
	}

	public void checkFirstTimeOpeningAppAndClickOnLetsParkButton(){
		allowNotifications();
		assertBasicElements();
		clickOnLetsParkButton();
	}

}
