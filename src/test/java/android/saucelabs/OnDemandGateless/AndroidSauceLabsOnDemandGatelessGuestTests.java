package android.saucelabs.OnDemandGateless;
import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.ITestContext;
// import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import android.base.BaseMethodsSauceLabsAndroid;
import android.screens.GuestUserCheckoutScreenAndroid;
import android.screens.LotEventsScreenAndroid;
import android.screens.OnDemandAddTimeScreenAndroid;
import android.screens.OnDemandZoneLocationScreenAndroid;
import android.screens.OnDemandEnterZoneScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.FindParkingScreenAndroid;
import android.screens.ReservationConfirmationScreenAndroid;
import android.screens.SearchScreenAndroid;
import android.screens.ViewLotDetailsScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidSauceLabsOnDemandGatelessGuestTests extends BaseMethodsSauceLabsAndroid{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	// @Parameters({ "username", "password" })
	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserOnDemandGatelessReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{

		List<String> tags = new ArrayList<>();
		tags.add("OnDemand Gateless");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);

		// SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		// FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		// ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
		// AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		// LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		String email = "gulartejuancarlos@gmail.com";
		String first_name = "Juan";
		String last_name = "Test";
		String phone = "907-953-8998";
		String phone_country = "United States";
		String license_plate = "SL081314";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "NY";
		String cc_number = "4111 1111 1111 1111";
		String cc_exp_date = "04/2024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String zone_code = "32899";
		Boolean isEvent = false;

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkVehicleSectionAndAddLicensePlate(license_plate, vehicle_country, state);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.completeMandatoryInformationAndCompletePurchaseOD(isEvent, vehicle_size, zone_code, "", location_name, license_plate, email, first_name, last_name, phone, phone_country, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		dashboard.checkODReservationCardDetails(zone_code, location_name, license_plate, email);

		Assert.assertTrue(true);
		
		// dashboard.goToSearchScreen();
		// String locationToSearch = "Trump Tower Chicago Garage";
		// String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		// // find_parking.findExactParkingLotSearched();
		// String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		// String reservation_number = reservation.assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserOnDemandGatelessReservationWithPromoCode(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("OnDemand Gateless");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);

		// SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		// FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		// ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
		// AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		// LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		String email = "gulartejuancarlos@gmail.com";
		String first_name = "Juan";
		String last_name = "Test";
		String phone = "907-953-8998";
		String phone_country = "United States";
		String license_plate = "SL081314";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "NY";
		String cc_number = "4111 1111 1111 1111";
		String cc_exp_date = "04/2024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String zone_code = "32899";
		String promo_code = "FREECODE";

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkVehicleSectionAndAddLicensePlate(license_plate, vehicle_country, state);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.completeMandatoryInformationAddPromoCodeAndCompletePurchaseOD(vehicle_size, zone_code, location_name, license_plate, email, first_name, last_name, phone, phone_country, cc_number, cc_exp_date, cc_cvv, cc_postal_code, promo_code);
		dashboard.checkODReservationCardDetails(zone_code, location_name, license_plate, email);

		Assert.assertTrue(true);
		
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserOnDemandGatelessEventReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("OnDemand Gateless");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);

		String email = "gulartejuancarlos@gmail.com";
		String first_name = "Juan";
		String last_name = "Test";
		String phone = "907-953-8998";
		String phone_country = "United States";
		String license_plate = "SL081314";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "NY";
		String cc_number = "4111 1111 1111 1111";
		String cc_exp_date = "04/2024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String zone_code = "71230";
		Boolean isEvent = true;

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkVehicleSectionAndAddLicensePlate(license_plate, vehicle_country, state);
		// Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		String[] event_info = zone_location.selectEventAndGetInfo();
		// zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed);
		checkout.completeMandatoryInformationAndCompletePurchaseOD(isEvent, vehicle_size, zone_code, event_info[1], location_name, license_plate, email, first_name, last_name, phone, phone_country, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		dashboard.checkODReservationCardDetails(zone_code, location_name, license_plate, email);

		Assert.assertTrue(true);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserOnDemandGatelessReservationWithTimeExtension(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{

		List<String> tags = new ArrayList<>();
		tags.add("OnDemand Gateless");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		OnDemandEnterZoneScreenAndroid enter_zone = new OnDemandEnterZoneScreenAndroid(driver, log);
		OnDemandZoneLocationScreenAndroid zone_location = new OnDemandZoneLocationScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		OnDemandAddTimeScreenAndroid add_time = new OnDemandAddTimeScreenAndroid(driver, log);

		String email = "gulartejuancarlos@gmail.com";
		String first_name = "Juan";
		String last_name = "Test";
		String phone = "907-953-8998";
		String phone_country = "United States";
		String license_plate = "SL081314";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "NY";
		String cc_number = "4111 1111 1111 1111";
		String cc_exp_date = "04/2024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String zone_code = "32874";
		Boolean isEvent = false;

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkVehicleSectionAndAddLicensePlate(license_plate, vehicle_country, state);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		checkout.completeMandatoryInformationAndCompletePurchaseOD(isEvent, vehicle_size, zone_code, "", location_name, license_plate, email, first_name, last_name, phone, phone_country, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = dashboard.checkODReservationCardDetails(zone_code, location_name, license_plate, email);
		dashboard.clickAddTime();
		add_time.addTime();
		checkout.completeMandatoryInformationForAddTimePurchaseOD(isEvent, vehicle_size, zone_code, "", location_name, license_plate, email, first_name, last_name, phone, phone_country, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		dashboard.checkODReservationCardDetailsAfterAddingTime(zone_code, location_name, license_plate, email, reservation_number);

		Assert.assertTrue(true);
	}

}