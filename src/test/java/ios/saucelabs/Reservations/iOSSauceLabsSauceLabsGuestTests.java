package ios.saucelabs.Reservations;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import ios.base.BaseMethodsSauceLabsiOS;
import ios.screens.DashboardScreeniOS;
import ios.screens.FindParkingListViewScreeniOS;
import ios.screens.FindParkingScreeniOS;
import ios.screens.GuestUserCheckoutScreeniOS;
import ios.screens.ReservationConfirmationScreeniOS;
import ios.screens.SearchScreeniOS;
import ios.screens.WelcomeScreeniOS;

public class iOSSauceLabsSauceLabsGuestTests extends BaseMethodsSauceLabsiOS{
	
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
}
