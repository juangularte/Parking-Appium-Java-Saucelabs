package android.saucelabs.OnDemandGateless;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import android.base.BaseMethodsSauceLabsAndroid;
import android.screens.LoginScreenAndroid;
import android.screens.MyPaymentMethodsScreenAndroid;
import android.screens.MyProfileScreenAndroid;
import android.screens.MyVehiclesScreenAndroid;
import android.screens.OnDemandAddTimeScreenAndroid;
import android.screens.OnDemandEnterZoneScreenAndroid;
import android.screens.OnDemandZoneLocationScreenAndroid;
import android.screens.RegisteredUserCheckoutScreenAndroid;
import android.screens.AccountScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidSauceLabsOnDemandGatelessRegisteredTests extends BaseMethodsSauceLabsAndroid{
	
	// @Test (dataProvider="saucelabsAndroidSimulators")
	@Test(dataProvider="saucelabsAndroidRealDevices")
	// public void positiveLogin(String username, String password) throws MalformedURLException{
	public void registeredUserOnDemandGatelessReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);

		String vehicle_size = "STANDARD";
		String zone_code = "32899";

		try {
			welcome.clickOnLetsParkButton();
			dashboard.setConfigurationsAndGoToAccountScreen();
			account.goToLoginScreen();
			login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		} catch (TimeoutException e) {
			log.info("Initial configurations have been set already.");
			try {
				dashboard.goToAccountScreen();
				account.goToLoginScreen();
				login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
			} catch (TimeoutException i) {
				log.info("User is already logged in.");
			}
		}
		
		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile();
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods();
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles();
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.clickFindParkingOption();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkDefaultVehicleIsDisplayed(all_vehicles[0][1]);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.checkAllUserDataIsDisplayedAndCompletePurchaseOD(vehicle_size, zone_code, location_name, all_vehicles[0][1], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_cards[0][1]);
		dashboard.checkODRegisteredUserReservationCardDetails(zone_code, location_name, all_vehicles[0][1], profile_values[0]);

		Assert.assertTrue( true);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void registeredUserOnDemandGatelessReservationWithPromoCode(ITestContext ctx, String platform, String version, String device) throws IOException{
		
		List<String> tags = new ArrayList<String>();
		tags.add("ReservationsTest1");
		tags.add("ReservationsTest2");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		
		String vehicle_size = "STANDARD";
		String zone_code = "32899";
		String promo_code = "FREECODE";

		try {
			welcome.clickOnLetsParkButton();
			dashboard.setConfigurationsAndGoToAccountScreen();
			account.goToLoginScreen();
			login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		} catch (TimeoutException e) {
			log.info("Initial configurations have been set already.");
			try {
				dashboard.goToAccountScreen();
				account.goToLoginScreen();
				login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
			} catch (TimeoutException i) {
				log.info("User is already logged in.");
			}
		}
		
		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile();
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods();
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles();
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.clickFindParkingOption();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkDefaultVehicleIsDisplayed(all_vehicles[0][1]);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.checkAllUserDataIsDisplayedAddPromoCodeAndCompletePurchaseOD(vehicle_size, zone_code, location_name, all_vehicles[0][1], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_cards[0][1], promo_code);
		dashboard.checkODRegisteredUserReservationCardDetails(zone_code, location_name, all_vehicles[0][1], profile_values[0]);

		Assert.assertTrue( true);
	}
	
	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void registeredUserOnDemandGatelessReservationWithTimeExtension(ITestContext ctx, String platform, String version, String device) throws IOException{
		
		List<String> tags = new ArrayList<String>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		OnDemandAddTimeScreenAndroid add_time = new OnDemandAddTimeScreenAndroid(driver, log);

		String vehicle_size = "STANDARD";
		String zone_code = "32874";

		try {
			welcome.clickOnLetsParkButton();
			dashboard.setConfigurationsAndGoToAccountScreen();
			account.goToLoginScreen();
			login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		} catch (TimeoutException e) {
			log.info("Initial configurations have been set already.");
			try {
				dashboard.goToAccountScreen();
				account.goToLoginScreen();
				login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
			} catch (TimeoutException i) {
				log.info("User is already logged in.");
			}
		}
		
		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile();
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods();
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles();
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.clickFindParkingOption();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkDefaultVehicleIsDisplayed(all_vehicles[0][1]);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.checkAllUserDataIsDisplayedAndCompletePurchaseOD(vehicle_size, zone_code, location_name, all_vehicles[0][1], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_cards[0][1]);
		String reservation_number = dashboard.checkODRegisteredUserReservationCardDetails(zone_code, location_name, all_vehicles[0][1], profile_values[0]);
		dashboard.clickAddTime();
		add_time.addTime();
		checkout.checkAllUserDataIsDisplayedAndCompletePurchaseAfterAddingTimeOD(vehicle_size, zone_code, location_name, all_vehicles[0][1], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_cards[0][1]);
		dashboard.checkODRegisteredUserReservationCardDetailsAfterAddingTime(zone_code, location_name, all_vehicles[0][1], profile_values[0], reservation_number);

		Assert.assertTrue( true);
	}

}
