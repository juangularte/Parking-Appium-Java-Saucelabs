package ios.local.Reservations;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import ios.base.BaseMethodsIOS;
import ios.screens.DashboardScreeniOS;
import ios.screens.FindParkingListViewScreeniOS;
import ios.screens.FindParkingScreeniOS;
import ios.screens.GuestUserCheckoutScreeniOS;
import ios.screens.ReservationConfirmationScreeniOS;
import ios.screens.SearchScreeniOS;
import ios.screens.ViewLotDetailsScreeniOS;
import ios.screens.WelcomeScreeniOS;

public class iOSReservationsGuestTests extends BaseMethodsIOS{

	@Test
	public void guestUserReservation() throws MalformedURLException{
		
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
	}

	@Test
	public void guestUserReservationWithPromoCode() throws MalformedURLException{
		
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
		String promo_code = "FREECODE";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address_price =list_view.clickBookParkingForTheLocationSearched(location);
		String purchase_price = checkout.completeMandatoryInformationAddPromoCodeAndCompletePurchase(vehicle_size, name_address_price[0], name_address_price[1], name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code, promo_code);
		reservation.assertCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, name_address_price, purchase_price, dateTimeValues);
	}

	@Test
	public void cancelGuestUserReservation() throws MalformedURLException{
		
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
		reservation.assertCheckoutInformationGetReservationNumberAndCancelReservation(vehicle_size, license_plate, name_address_price, purchase_price, dateTimeValues);
		dashboard.checkThatNoReservationCardIsDisplayedAfterCancellation();
	}

	@Test
	public void changeVehicleGuestUserReservation() throws MalformedURLException{
		
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
		String new_vehicle_country = "United States";
		String new_vehicle_state = "IL";
		String new_license_plate = "NEWCAR14";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address_price =list_view.clickBookParkingForTheLocationSearched(location);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, name_address_price[0], name_address_price[1], name_address_price[2], email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		reservation.assertCheckoutInformationGetReservationNumberAndChangeVehicle(vehicle_size, license_plate, name_address_price, purchase_price, dateTimeValues, new_vehicle_country, new_vehicle_state, new_license_plate);
	}

	@Test
	public void guestUserReservationWithAccessCode() throws MalformedURLException{
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		SearchScreeniOS search = new SearchScreeniOS(driver, log);
		FindParkingScreeniOS find_parking = new FindParkingScreeniOS(driver, log);
		FindParkingListViewScreeniOS list_view = new FindParkingListViewScreeniOS(driver, log);
		ViewLotDetailsScreeniOS view_lot_details = new ViewLotDetailsScreeniOS(driver, log);
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
		String location = "1800 Maple Avenue";
		String access_code = "ACSPACES";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactAccessCodeLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address_price =list_view.clickViewForTheLocationSearched(location);
		String new_price = view_lot_details.enterAccessCodeCheckDiscountWasAppliedAndClickOnBookParking(location, name_address_price[2], dateTimeValues, access_code);
		String purchase_price = checkout.completeMandatoryInformationCheckAccessCodeAndCompletePurchase(vehicle_size, name_address_price[0], name_address_price[1], new_price, email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code, access_code);
		reservation.assertPrintedPassRequiredCheckoutInformationGetReservationNumberAndClose(vehicle_size, license_plate, name_address_price, purchase_price);
	}

	@Test
	public void guestUserEventReservation() throws MalformedURLException{
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		SearchScreeniOS search = new SearchScreeniOS(driver, log);
		FindParkingScreeniOS find_parking = new FindParkingScreeniOS(driver, log);
		FindParkingListViewScreeniOS list_view = new FindParkingListViewScreeniOS(driver, log);
		ViewLotDetailsScreeniOS view_lot_details = new ViewLotDetailsScreeniOS(driver, log);
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
		String location = "KENMORE LOT";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactAccessCodeLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address =list_view.clickViewForTheEventLocationSearched(location);
		String upcoming_event_price = view_lot_details.assertUpcomingEventIsAvailableAndClickBookParking(location, name_address[1]);
		String purchase_price = checkout.completeMandatoryInformationAndCompletePurchase(vehicle_size, name_address[0], name_address[1], upcoming_event_price, email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code);
		reservation.assertEventCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, name_address, purchase_price);
	}

	@Test
	public void guestUserEventReservationWithPromoCode() throws MalformedURLException{
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		SearchScreeniOS search = new SearchScreeniOS(driver, log);
		FindParkingScreeniOS find_parking = new FindParkingScreeniOS(driver, log);
		FindParkingListViewScreeniOS list_view = new FindParkingListViewScreeniOS(driver, log);
		ViewLotDetailsScreeniOS view_lot_details = new ViewLotDetailsScreeniOS(driver, log);
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
		String location = "KENMORE LOT";
		String promo_code = "FREECODE";

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndClickOnSearchBox();
		String[] dateTimeValues = search.searchExactAccessCodeLocation(location);
		find_parking.clickOnListView(dateTimeValues[0], dateTimeValues[1]);
		String[] name_address =list_view.clickViewForTheEventLocationSearched(location);
		String upcoming_event_price = view_lot_details.assertUpcomingEventIsAvailableAndClickBookParking(location, name_address[1]);
		String purchase_price = checkout.completeMandatoryInformationAddPromoCodeAndCompletePurchase(vehicle_size, name_address[0], name_address[1], upcoming_event_price, email, first_name, last_name, phone, phone_country, license_plate, vehicle_country, state, cc_number, cc_exp_date, cc_cvv, cc_postal_code, promo_code);
		reservation.assertEventCheckoutInformationAndGetReservationNumber(vehicle_size, license_plate, name_address, purchase_price);
	}
}
