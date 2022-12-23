package android.local.Others;
import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;

// import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import android.base.BaseMethodsAndroid;
import android.screens.GuestUserCheckoutScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.FindParkingScreenAndroid;
import android.screens.ReservationConfirmationScreenAndroid;
import android.screens.SearchScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidOtherTests extends BaseMethodsAndroid{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	// @Parameters({ "username", "password" })
	@Test
	public void guestCheckout() throws MalformedURLException{
		
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
		// find_parking.findExactParkingLotSearched();
		String[] lot_name_address_price = find_parking.findParkingLotAvailableNow(dateTimeValues[0], dateTimeValues[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, lot_name_address_price[0],lot_name_address_price[1], lot_name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		String reservation_number = reservation.assertCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, lot_name_address_price, purchase_price, dateTimeValues);
	}
	
//	@Test(dataProvider = "csvReader")//, dataProviderClass = CsvDataProviders.class)
//	public void negativeLoginErrors(Map<String, String> testData) throws MalformedURLException{
//		
//		String username = testData.get("username");
//		String password = testData.get("password");
//		String expected_error_msg = testData.get("errorMessage");
//		
//		WelcomeScreenAndroid welcome_screen = new WelcomeScreenAndroid(driver, log);
//		
//		welcome_screen.goToLoginScreen();
//		
//	}
//	
//	@Test(dataProvider = "jsonReader")//, dataProviderClass = CsvDataProviders.class)
//	public void negativeLoginErrorsJson(HashMap<String, String> testData) throws MalformedURLException{
//		
//		String username = testData.get("username");
//		String password = testData.get("password");
//		String expected_error_msg = testData.get("errorMessage");
//		
//		WelcomeScreenAndroid welcome_screen = new WelcomeScreenAndroid(driver, log);
//		
//		welcome_screen.goToLoginScreen();
//		
//	}
}
