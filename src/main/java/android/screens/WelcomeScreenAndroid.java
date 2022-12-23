package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class WelcomeScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public WelcomeScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}
	
//	String[] login_button=new String[] {"id", "Login"};
//	@AndroidFindBy(id ="com.spplus.parking.develop:id/letsParkButton")
//	public WebElement lets_park_button;
	
	By logo = (By.id("com.spplus.parking.develop:id/logo"));
	By slogan_1 = (By.xpath("//android.widget.LinearLayout[@resource-id='com.spplus.parking.develop:id/subtitleLinearLayout']//android.widget.TextView[1]"));
	By slogan_2 = (By.xpath("//android.widget.LinearLayout[@resource-id='com.spplus.parking.develop:id/subtitleLinearLayout']//android.widget.TextView[2]"));
	By slogan_3 = (By.xpath("//android.widget.LinearLayout[@resource-id='com.spplus.parking.develop:id/subtitleLinearLayout']//android.widget.TextView[3]"));
	By easily_book = (By.id("com.spplus.parking.develop:id/text1"));
	By monthly_parking = (By.id("com.spplus.parking.develop:id/text2"));
	By event_parking = (By.id("com.spplus.parking.develop:id/text3"));
	By help_us = (By.id("com.spplus.parking.develop:id/helpUsTextView"));
	By location_permission_warning = (By.id("com.spplus.parking.develop:id/locationAwareTextView"));
	By lets_park_button = (By.id("com.spplus.parking.develop:id/letsParkButton"));
	By powered_by = (By.xpath("//android.widget.TextView[@text='Powered by']"));
	
	public void assertTexts() {
		assert_text(slogan_1, "PARK");
		assert_text(slogan_2, "BETTER");
		assert_text(slogan_3, "PERIOD");
		assert_text(easily_book, "Easily book daily and monthly parking when you need it.");
		assert_text(monthly_parking, "Manage your monthly parking account and payment.");
		assert_text(event_parking, "Find event parking for your favorite locations.");
		assert_text(help_us, "Help us find you parking!");
		assert_text(location_permission_warning, "Parking.com will ask you to grant location permission to assist in finding parking near you.");
		assert_text(powered_by, "Powered by");
	}

	public void clickOnLetsParkButton(){
		click(lets_park_button);
		log.info("Let's Park button was clicked.");
	}

	public void checkFirstTimeOpeningApp(){
		assertTexts();
		clickOnLetsParkButton();
	}

	public void checkNotFirstTimeOpeningApp() {
		
	}

}
