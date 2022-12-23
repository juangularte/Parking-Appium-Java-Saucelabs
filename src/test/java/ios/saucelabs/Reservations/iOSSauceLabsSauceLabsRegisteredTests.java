package ios.saucelabs.Reservations;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.openqa.selenium.TimeoutException;
import ios.base.BaseMethodsSauceLabsiOS;
import ios.screens.AccountScreeniOS;
import ios.screens.DashboardScreeniOS;
import ios.screens.FindParkingListViewScreeniOS;
import ios.screens.FindParkingScreeniOS;
import ios.screens.GuestUserCheckoutScreeniOS;
import ios.screens.LoginScreeniOS;
import ios.screens.MyPaymentMethodsScreeniOS;
import ios.screens.MyProfileScreeniOS;
import ios.screens.MyVehiclesScreeniOS;
import ios.screens.RegisteredUserCheckoutScreeniOS;
import ios.screens.ReservationConfirmationScreeniOS;
import ios.screens.SearchScreeniOS;
import ios.screens.ViewLotDetailsScreeniOS;
import ios.screens.WelcomeScreeniOS;

public class iOSSauceLabsSauceLabsRegisteredTests extends BaseMethodsSauceLabsiOS{
	
	// @Test (dataProvider="saucelabsAndroidSimulators")
	@Test(dataProvider="saucelabsiOSRealDevices")
	// public void positiveLogin(String username, String password) throws MalformedURLException{
	public void guestUserReservation(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		SearchScreeniOS search = new SearchScreeniOS(driver, log);
		FindParkingScreeniOS find_parking = new FindParkingScreeniOS(driver, log);
		FindParkingListViewScreeniOS list_view = new FindParkingListViewScreeniOS(driver, log);
		GuestUserCheckoutScreeniOS checkout = new GuestUserCheckoutScreeniOS(driver, log);
		ReservationConfirmationScreeniOS reservation = new ReservationConfirmationScreeniOS(driver, log);

		String email = "gulartejuancarlos@gmail.com";
		String first_name = "Juan";
		String last_name = "Test";
		String phone = "(907)953-8998";
		String phone_country = "United States";
		String license_plate = "SL081314";
		String vehicle_country = "United States";
		String vehicle_size = "STANDARD";
		String state = "FL";
		String cc_number = "4111111111111111";
		String cc_exp_date = "042024";
		String cc_cvv = "468";
		String cc_postal_code = "01752";
		String location = "Trump Tower Chicago Garage";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address_price =list_view.clickBookParkingForTheLocationSearched(location);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, name_address_price[0], name_address_price[1], name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, name_address_price, purchase_price, dateTimeValues);
	
		Assert.assertTrue( true);

	}

	@Test(dataProvider="saucelabsiOSRealDevices")
	// public void positiveLogin(String username, String password) throws MalformedURLException{
	public void registeredUserReservationWithAccessCode(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		AccountScreeniOS account = new AccountScreeniOS(driver, log);
		LoginScreeniOS login = new LoginScreeniOS(driver, log);
		MyProfileScreeniOS profile = new MyProfileScreeniOS(driver, log);
		MyPaymentMethodsScreeniOS payment_methods = new MyPaymentMethodsScreeniOS(driver, log);
		MyVehiclesScreeniOS vehicles = new MyVehiclesScreeniOS(driver, log);
		SearchScreeniOS search = new SearchScreeniOS(driver, log);
		FindParkingScreeniOS find_parking = new FindParkingScreeniOS(driver, log);
		FindParkingListViewScreeniOS list_view = new FindParkingListViewScreeniOS(driver, log);
		ViewLotDetailsScreeniOS view_lot_details = new ViewLotDetailsScreeniOS(driver, log);
		RegisteredUserCheckoutScreeniOS checkout = new RegisteredUserCheckoutScreeniOS(driver, log);
		ReservationConfirmationScreeniOS reservation = new ReservationConfirmationScreeniOS(driver, log);

		// String email = "jcgularte@spplus.com";
		String email = "parkingtest2@mailinator.com";
		String password = "Helloworld10";
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
			welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
			dashboard.setConfigurationsAndGoToAccountScreen();
			account.goToLoginScreen();
			login.positiveLoginProcess(email, password);
		} catch (TimeoutException e) {
			log.info("Initial configurations have been set already.");
			try {
				dashboard.goToAccountScreen();
				account.goToLoginScreen();
				login.positiveLoginProcess(email, password);
			} catch (TimeoutException i) {
				log.info("User is already logged in.");
			}
		}

		dashboard.verifyUserIsLoggedInAndGoToAccountScreen();
		account.goToMyProfile(email);
		String[] profile_values = profile.getProfileDataFromUserAndGoBackToAccountScreen();
		account.goToMyPaymentMethods(email);
		String[][] all_cards = payment_methods.getCreditCardsDataFromUserAndGoBackToAccountScreen();
		account.goToMyVehicles(email);
		String[][] all_vehicles = vehicles.getVehiclesDataFromUserAndGoBackToAccountScreen();
		account.goBackToDashboardScreen();
		dashboard.goToSearchScreen();
		String[] dateTimeValues = search.searchExactAccessCodeLocation(location);
		// String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address_price =list_view.clickViewForTheLocationSearched(location);
		String new_price = view_lot_details.enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(location, name_address_price[2], dateTimeValues, access_code);
		String purchase_price = checkout.checkAllUserDataIsDisplayedWithAccessCodeAndCompletePurchase(vehicle_size, name_address_price[0],name_address_price[1], new_price, profile_values[0], profile_values[1], profile_values[2], profile_values[3], profile_values[4], all_vehicles[0][1], all_cards, all_cards[0][1], access_code);
		reservation.assertPrintedPassRequiredCheckoutInformationGetReservationNumberAndClose(vehicle_size, all_vehicles[0][1], name_address_price, purchase_price);
	
		Assert.assertTrue( true);

	}
}
