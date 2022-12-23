package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class MyVehiclesScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public MyVehiclesScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//HEADER
	By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
	By my_vehicles_title = (By.id("com.spplus.parking.develop:id/lotName"));
	
	//DEFAULT
	By default_vehicle_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT VEHICLE']"));
	By default_vehicle_name = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT VEHICLE']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));
	By default_vehicle_license_plate = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT VEHICLE']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By default_vehicle_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT VEHICLE']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));

	//ADDTIONAL
	By additional_vehicles_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL VEHICLES']"));
	By additional_vehicles = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL VEHICLES']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']"));

	//FOOTER
	By add_payment_button = (By.id("com.spplus.parking.develop:id/addVehicleButton"));


	public void assertUserIsOnMyVehiclesScreen(){
		assert_text(my_vehicles_title, "My Vehicles");
		log.info("MY VEHICLES SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertTextsLoggedUser() {
		assert_text(default_vehicle_title, "DEFAULT VEHICLE");
		assert_text(additional_vehicles_title, "ADDITIONAL VEHICLES");
		log.info("All basic assertions for logged user passed.");
	}

	public String[] getDefaultVehicleValues(){
		String vehicle_name = text(default_vehicle_name);
		log.info("Default vehicle name: "+vehicle_name);
		//TODO Solve the issue with the locators
		String vehicle_license_plate = text(default_vehicle_license_plate);
		log.info("Default vehicle license plate: "+vehicle_license_plate);
		return new String[] {vehicle_name, vehicle_license_plate};
	}

	public Integer calculateAmountOfAdditionalVehicles() {
		int amount_of_additional_vehicles = amount_of_elements(additional_vehicles);
		log.info("There are "+amount_of_additional_vehicles+" additional vehicles added.");
		return amount_of_additional_vehicles;
	}

	public String[][] getAdditionalVehiclesValues(){
		int additional_vehicles_number = calculateAmountOfAdditionalVehicles();
		String[][] vehicles = new String[additional_vehicles_number][];
		String vehicle_name;
		if(additional_vehicles_number == 0){
			log.info("There are no addtional vehicles added.");
		}else {
			for (int i = 0; i < additional_vehicles_number; i++) {
				
				if(check_if_element_is_present(By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL VEHICLES']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']")).equals(true)){
					vehicle_name = text((By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL VEHICLES']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']")));
					log.info("Additional vehicle nº"+(i+1)+" name: "+vehicle_name);
				}else{
					vehicle_name = "EMPTY";
					log.info("Additional vehicle nº"+(i+1)+" doesn't have a name.");
				}
				
				String vehicle_license_plate = text((By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL VEHICLES']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']")));
				log.info("Additional vehicle nº"+(i+1)+" license plate: "+vehicle_license_plate);
				vehicles[i] = new String[] {vehicle_name, vehicle_license_plate};
			}
		}
		// System.out.println("ADDITIONAL CARDS: "+cards[3][0]);
		return vehicles;
	}

	// public String getFirstName(){
	// 	String first_name_value = text(first_name_field);
	// 	log.info("First Name is: "+first_name_value);
	// 	return first_name_value;
	// }

	// public String getLastName(){
	// 	String last_name_value = text(last_name_field);
	// 	log.info("Last Name is: "+last_name_value);
	// 	return last_name_value;
	// }

	public String[][] getAllVehiclesValues(){
		String [][] all_vehicles = getAdditionalVehiclesValues();
		String[][] vehicles = new String[all_vehicles.length+1][];
		vehicles[0] = getDefaultVehicleValues();
		for (int i = 0; i <= all_vehicles.length-1; i++) {
			vehicles[i+1] = all_vehicles[i];
		}
		return vehicles;
	}

	public void goBack(){
		click(back_button);
		log.info("Back button was clicked.");
	}

	public String[][] getVehiclesDataFromUserAndGoBackToAccountScreen() {
		assertUserIsOnMyVehiclesScreen();
		assertTextsLoggedUser();
		String[][] vehicles = getAllVehiclesValues();
		goBack();
		return vehicles;
	}
}
