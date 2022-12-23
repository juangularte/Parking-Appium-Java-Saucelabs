package android.local.OnDemandGateless;
import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;

import org.openqa.selenium.TimeoutException;
// import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import android.base.BaseMethodsAndroid;
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

public class AndroidOnDemandGatelessGuestTests extends BaseMethodsAndroid{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	// @Parameters({ "username", "password" })
	@Test
	public void guestUserOnDemandGatelessReservation() throws MalformedURLException{
		
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
	}

	@Test
	public void guestUserOnDemandGatelessReservationWithPromoCode() throws MalformedURLException{
		
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
	}

	@Test
	public void guestUserOnDemandGatelessEventReservation() throws MalformedURLException{
		
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
	}

	@Test
	public void guestUserOnDemandGatelessReservationWithTimeExtension() throws MalformedURLException{
		
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
	}

	@Test
	public void guestUserOnDemandGatelessRTD() throws MalformedURLException{
		
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
		String license_plate_out_of_district_pricing = "SL130814";
		String license_plate_in_district_pricing = "001AUB";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "NY";
		String cc_number = "4111 1111 1111 1111";
		String cc_exp_date = "04/2024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String zone_code = "61211";
		Boolean isEvent = false;

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToOnDemandEnterZoneScreen();
		enter_zone.enterZoneCodeAndSubmit(zone_code);
		String location_name = zone_location.checkVehicleSectionAndAddOutRTDLicensePlate(license_plate_out_of_district_pricing, vehicle_country, state);
		zone_location.checkRTDStatus(false);
		Boolean areThereEventsDisplayed = zone_location.checkIfThereAreEventsDisplayed();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, false);
		String out_RTD_less_than_24_hrs_price = checkout.getPriceForOutRTDLessThan24Hrs(zone_code,location_name, license_plate_out_of_district_pricing);
		checkout.goBack();
		zone_location.checkTimeSectionAndSelectTime(areThereEventsDisplayed, true);
		String out_RTD_more_than_24_hrs_price = checkout.getPriceForOutRTDMoreThan24Hrs(zone_code,location_name, license_plate_out_of_district_pricing);
		checkout.assertMoreThan24HrsPriceIsBigger(out_RTD_more_than_24_hrs_price, out_RTD_less_than_24_hrs_price);
		checkout.goBack();
		// dashboard.checkODReservationCardDetails(zone_code, location_name, license_plate, email);
	}
}