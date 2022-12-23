package android.saucelabs.Reservations;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import android.base.BaseMethodsSauceLabsAndroid;
import android.screens.GuestUserCheckoutScreenAndroid;
import android.screens.LotEventsScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.FindParkingScreenAndroid;
import android.screens.ReservationConfirmationScreenAndroid;
import android.screens.SearchScreenAndroid;
import android.screens.ViewLotDetailsScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidSauceLabsReservationsGuestTests extends BaseMethodsSauceLabsAndroid{
	
	// @Test (dataProvider="saucelabsAndroidSimulators")
	@Test(dataProvider="saucelabsAndroidRealDevices")
	// public void positiveLogin(String username, String password) throws MalformedURLException{
	public void guestUserReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

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

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		// find_parking.findExactParkingLotSearched();
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
	
		Assert.assertTrue( true);

	}
	
	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserReservationWithPromoCode(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
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
		String promo_code = "FREECODE";

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.completeMandatoryInformationAddPromoCodeAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code, promo_code);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
		
		Assert.assertTrue( true);

	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void cancelGuestUserReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{

		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
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

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
		dashboard.cancelReservation(reservation_number, lot_name_address_price[0], lot_name_address_price[1], license_plate);

		Assert.assertTrue( true);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void changeVehicleGuestUserReservation(ITestContext ctx, String platform, String version, String device) throws Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
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
		String new_vehicle_country = "United States";
		String new_vehicle_state = "IL";
		String new_license_plate = "NEWCAR14";

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndChangeVehicle(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues, state, new_vehicle_country, new_vehicle_state, new_license_plate);
		dashboard.assertNewVehicleAndReservationData(reservation_number, lot_name_address_price[0], lot_name_address_price[1], new_license_plate);
		
		Assert.assertTrue( true);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserReservationWithAccessCode(ITestContext ctx, String platform, String version, String device) throws Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		ViewLotDetailsScreenAndroid view_lot_details = new ViewLotDetailsScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);
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

		String location = "1800 Maple Avenue";
		String access_code = "ACSPACES";

		welcome.clickOnLetsParkButton();
		dashboard.setInitialConfigurations();
		dashboard.goToSearchScreen();
		
		String[] dateTimeValues = search.searchExactLocation(location);
		String[] lot_name_address_price = find_parking.findExactParkingLotSearchedAndClickOnViewDetails(dateTimeValues[0], dateTimeValues[1]);
		String new_price = view_lot_details.enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(location, lot_name_address_price[2], dateTimeValues, access_code);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], new_price, email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
		// dashboard.assertNewVehicleAndReservationData(reservation_number, lot_name_address_price[0], lot_name_address_price[1], new_license_plate);
		
		Assert.assertTrue( true);
	}

	@Test(dataProvider="saucelabsAndroidRealDevices")
	public void guestUserEventReservation(ITestContext ctx, String platform, String version, String device) throws Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);

		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		ViewLotDetailsScreenAndroid view_lot_details = new ViewLotDetailsScreenAndroid(driver, log);
		LotEventsScreenAndroid events = new LotEventsScreenAndroid(driver, log);
		GuestUserCheckoutScreenAndroid checkout = new GuestUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

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

		// String location = "GWCC - BLUE LOT";
		String location = "KENMORE LOT";

		
		try {
			welcome.clickOnLetsParkButton();
			dashboard.setInitialConfigurations();
		} catch (TimeoutException e) {
			log.info("Initial configurations have been set already.");
		}
		
		dashboard.goToSearchScreen();
		
		String[] dateTimeValues = search.searchExactLocation(location);
		String[] lot_name_address = find_parking.findExactEventParkingLotSearchedAndClickOnViewDetails(dateTimeValues[0], dateTimeValues[1]);
		view_lot_details.assertEventIsAvailableAndClickViewAll(location, lot_name_address[1]);
		String[] event_details = events.getSelectedUpcomingEventDetailsAndClickBookParking(location, lot_name_address[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address[0],lot_name_address[1], event_details[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertEventCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, lot_name_address, purchase_price);

		Assert.assertTrue( true);
	}
}
