package android.local.Reservations;
import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;

import org.openqa.selenium.TimeoutException;
// import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import android.base.BaseMethodsAndroid;
import android.screens.AccountScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.FindParkingScreenAndroid;
import android.screens.LoginScreenAndroid;
import android.screens.LotEventsScreenAndroid;
import android.screens.MyPaymentMethodsScreenAndroid;
import android.screens.MyProfileScreenAndroid;
import android.screens.MyVehiclesScreenAndroid;
import android.screens.RegisteredUserCheckoutScreenAndroid;
import android.screens.ReservationConfirmationScreenAndroid;
import android.screens.SearchScreenAndroid;
import android.screens.ViewLotDetailsScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidReservationsRegisteredTests extends BaseMethodsAndroid{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	// @Parameters({ "username", "password" })
	@Test
	public void registeredUserReservation() throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

		// String email = "gulartejuancarlos@gmail.com";
		// String first_name = "Juan";
		// String last_name = "Test";
		// String phone = "907-953-8998";
		// String phone_country = "United States";
		// String license_plate = "SL081314";
		// String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		// String state = "NY";
		// String cc_number = "4111 1111 1111 1111";
		// String cc_exp_date = "04/2024";
		// String cc_cvv = "468";
		// String cc_postal_code = "01752";

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
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.checkAllUserDataIsDisplayedAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1]);
		String reservation_number = reservation.assertCheckoutInformationAndGetReservationNumber(vehicle_size, all_vehicles[0][1], lot_name_address_price, purchase_price, dateTimeValues);

	}

	@Test
	public void registeredUserReservationWithPromoCode() throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

		// String email = "gulartejuancarlos@gmail.com";
		// String first_name = "Juan";
		// String last_name = "Test";
		// String phone = "907-953-8998";
		// String phone_country = "United States";
		// String license_plate = "SL081314";
		// String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String promo_code = "FREECODE";
		// String state = "NY";
		// String cc_number = "4111 1111 1111 1111";
		// String cc_exp_date = "04/2024";
		// String cc_cvv = "468";
		// String cc_postal_code = "01752";

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
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.checkAllUserDataIsDisplayedAddPromoCodeAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1], promo_code);
		String reservation_number = reservation.assertCheckoutInformationAndGetReservationNumber(vehicle_size, all_vehicles[0][1], lot_name_address_price, purchase_price, dateTimeValues);
	}

	@Test
	public void cancelRegisteredUserReservation() throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

		// String email = "gulartejuancarlos@gmail.com";
		// String first_name = "Juan";
		// String last_name = "Test";
		// String phone = "907-953-8998";
		// String phone_country = "United States";
		// String license_plate = "SL081314";
		// String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		// String state = "NY";
		// String cc_number = "4111 1111 1111 1111";
		// String cc_exp_date = "04/2024";
		// String cc_cvv = "468";
		// String cc_postal_code = "01752";

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
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.checkAllUserDataIsDisplayedAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1]);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndCancelReservation(vehicle_size, all_vehicles[0][1], lot_name_address_price, purchase_price, dateTimeValues);

	}

	@Test
	public void changeVehicleRegisteredUserReservation() throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

		// String email = "gulartejuancarlos@gmail.com";
		// String first_name = "Juan";
		// String last_name = "Test";
		// String phone = "907-953-8998";
		// String phone_country = "United States";
		// String license_plate = "SL081314";
		// String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		// String state = "NY";
		// String cc_number = "4111 1111 1111 1111";
		// String cc_exp_date = "04/2024";
		// String cc_cvv = "468";
		// String cc_postal_code = "01752";

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
		

		// dashboard.verifyUserIsLoggedIn();
		// dashboard.clickFindParkingOption();
		// dashboard.swipeToTheNextReservationCard();

		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile();
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods();
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles();
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.clickFindParkingOption();
		dashboard.goToSearchScreen();
		String locationToSearch = "Trump Tower Chicago Garage";
		String[] dateTimeValues = search.searchExactLocation(locationToSearch);
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.checkAllUserDataIsDisplayedAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1]);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, all_vehicles[0][1], lot_name_address_price, purchase_price, dateTimeValues);
		dashboard.changeVehicleBySelectingAnotherFromTheList(reservation_number, lot_name_address_price[0], lot_name_address_price[1], all_vehicles[0][1], all_vehicles);
	}

	@Test
	public void registeredUserReservationWithAccessCode() throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
		MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
		MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
		MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
		FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
		SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
		ViewLotDetailsScreenAndroid view_lot_details = new ViewLotDetailsScreenAndroid(driver, log);
		RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
		ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

		// String email = "gulartejuancarlos@gmail.com";
		// String first_name = "Juan";
		// String last_name = "Test";
		// String phone = "907-953-8998";
		// String phone_country = "United States";
		// String license_plate = "SL081314";
		// String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		// String state = "NY";
		// String cc_number = "4111 1111 1111 1111";
		// String cc_exp_date = "04/2024";
		// String cc_cvv = "468";
		// String cc_postal_code = "01752";
		String location = "1800 Maple Avenue";
		String access_code = "ACSPACES";

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

		// dashboard.verifyUserIsLoggedIn();
		// dashboard.clickFindParkingOption();
		// dashboard.swipeToTheNextReservationCard();

		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile();
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods();
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles();
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.clickFindParkingOption();
		dashboard.goToSearchScreen();
		
		String[] dateTimeValues = search.searchExactLocation(location);
		String[] lot_name_address_price = find_parking.findExactParkingLotSearchedAndClickOnViewDetails(dateTimeValues[0], dateTimeValues[1]);
		String new_price = view_lot_details.enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(location, lot_name_address_price[2], dateTimeValues, access_code);
		
		String purchase_price = checkout.checkAllUserDataIsDisplayedAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], new_price, profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1]);
		String reservation_number = reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, all_vehicles[0][1], lot_name_address_price, purchase_price, dateTimeValues);
		// dashboard.changeVehicleBySelectingAnotherFromTheList(reservation_number, lot_name_address_price[0], lot_name_address_price[1], all_vehicles[0][1], all_vehicles);
	}

	// @Test
	// public void registeredUserEventReservation() throws MalformedURLException{
		
	// 	WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
	// 	DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
	// 	AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
	// 	LoginScreenAndroid login = new LoginScreenAndroid(driver, log);
	// 	MyProfileScreenAndroid profile = new MyProfileScreenAndroid(driver, log);
	// 	MyPaymentMethodsScreenAndroid payment_methods = new MyPaymentMethodsScreenAndroid(driver, log);
	// 	MyVehiclesScreenAndroid vehicles = new MyVehiclesScreenAndroid(driver, log);
	// 	FindParkingScreenAndroid find_parking = new FindParkingScreenAndroid(driver, log);
	// 	SearchScreenAndroid search = new SearchScreenAndroid(driver, log);
	// 	ViewLotDetailsScreenAndroid view_lot_details = new ViewLotDetailsScreenAndroid(driver, log);
	// 	LotEventsScreenAndroid events = new LotEventsScreenAndroid(driver, log);
	// 	RegisteredUserCheckoutScreenAndroid checkout = new RegisteredUserCheckoutScreenAndroid(driver, log);
	// 	ReservationConfirmationScreenAndroid reservation = new ReservationConfirmationScreenAndroid(driver, log);

	// 	// String email = "gulartejuancarlos@gmail.com";
	// 	// String first_name = "Juan";
	// 	// String last_name = "Test";
	// 	// String phone = "907-953-8998";
	// 	// String phone_country = "United States";
	// 	// String license_plate = "SL081314";
	// 	// String vehicle_country = "United States";
	// 	String vehicle_size = "STANDARD";
	// 	// String state = "NY";
	// 	// String cc_number = "4111 1111 1111 1111";
	// 	// String cc_exp_date = "04/2024";
	// 	// String cc_cvv = "468";
	// 	// String cc_postal_code = "01752";
	// 	String location = "KENMORE LOT";

	// 	try {
	// 		welcome.clickOnLetsParkButton();
	// 		dashboard.setConfigurationsAndGoToAccountScreen();
	// 		account.goToLoginScreen();
	// 		login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
	// 	} catch (TimeoutException e) {
	// 		log.info("Initial configurations have been set already.");
	// 		try {
	// 			dashboard.goToAccountScreen();
	// 			account.goToLoginScreen();
	// 			login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
	// 		} catch (TimeoutException i) {
	// 			log.info("User is already logged in.");
	// 		}
	// 	}

	// 	// dashboard.verifyUserIsLoggedIn();
	// 	// dashboard.clickFindParkingOption();
	// 	// dashboard.swipeToTheNextReservationCard();

	// 	dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
	// 	account.goToMyProfile();
	// 	String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
	// 	account.goToMyPaymentMethods();
	// 	String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
	// 	account.goToMyVehicles();
	// 	String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
	// 	account.goBackToDashboardScreen();
	// 	dashboard.clickFindParkingOption();
	// 	dashboard.goToSearchScreen();
		
	// 	String[] dateTimeValues = search.searchExactLocation(location);
	// 	String[] lot_name_address = find_parking.findExactEventParkingLotSearchedAndClickOnViewDetails(dateTimeValues[0], dateTimeValues[1]);
	// 	// String new_price = view_lot_details.enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(location, lot_name_address_price[2], dateTimeValues, access_code);
	// 	view_lot_details.assertEventIsAvailableAndClickViewAll(location, lot_name_address[1]);
	// 	String[] event_details = events.getSelectedUpcomingEventDetailsAndClickBookParking(location, lot_name_address[1]);
		
	// 	String purchase_price = checkout.checkAllUserDataIsDisplayedAndCompletePurchase(vehicle_size, lot_name_address[0],lot_name_address[1], event_details[2], profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards[0][1]);
	// 	String reservation_number = reservation.assertEventCheckoutInformationGetReservationNumberAndClose(vehicle_size, all_vehicles[0][1], lot_name_address, purchase_price);
	// 	// dashboard.changeVehicleBySelectingAnotherFromTheList(reservation_number, lot_name_address_price[0], lot_name_address_price[1], all_vehicles[0][1], all_vehicles);
	// }
}
