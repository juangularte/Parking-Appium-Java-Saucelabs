package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class MyVehiclesScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public MyVehiclesScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//HEADER
	By back_button = (AppiumBy.accessibilityId("ic back"));
	By my_vehicles_title = (AppiumBy.accessibilityId("My Vehicles"));
	
	//DEFAULT
	By default_vehicle_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"DEFAULT VEHICLE\"]"));
	By default_vehicle_name = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT VEHICLE\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[2]"));
	By default_vehicle_license_plate = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT VEHICLE\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]"));
	By default_vehicle_edit_button = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT VEHICLE\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeImage[@name=\"ic_prog_action\"]"));

	//ADDTIONAL
	By additional_vehicles_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ADDITIONAL VEHICLES\"]"));
	By additional_vehicles = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"ADDITIONAL VEHICLES\"]/following-sibling::XCUIElementTypeCell"));
	By additional_vehicles_license_plate = (AppiumBy.xpath(".//XCUIElementTypeStaticText[1]"));
	By additional_vehicles_name = (AppiumBy.xpath(".//XCUIElementTypeStaticText[2]"));
	By additional_vehicles_edit_button = (AppiumBy.xpath(".//XCUIElementTypeImage[@name=\"ic_prog_action\"]"));

	//FOOTER
	By add_payment_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ADD VEHICLE\"]"));


	public void assertUserIsOnMyVehiclesScreen(){
		assert_text(my_vehicles_title, "My Vehicles");
		log.info("MY VEHICLES SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertTextsLoggedUser(){
		assert_text(default_vehicle_title, "DEFAULT VEHICLE");
		if(check_if_element_is_present(additional_vehicles_title)){
			assert_text(additional_vehicles_title, "ADDITIONAL VEHICLES");
		}
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

	public Integer calculateAmountOfAdditionalVehicles(){
		try {
			int amount_of_additional_vehicles = amount_of_elements(additional_vehicles);
			log.info("There are "+amount_of_additional_vehicles+" additional vehicles added.");
			return amount_of_additional_vehicles;
		} catch (Exception e) {
			return 0;
		}
	}

	public String[][] getAdditionalVehiclesValues(){
		int additional_vehicles_number = calculateAmountOfAdditionalVehicles();
		String[][] vehicles = new String[additional_vehicles_number][];
		String vehicle_name;
		int i = 0;
		if(additional_vehicles_number == 0){
			log.info("There are no addtional vehicles added.");
		}else {

			for (WebElement vehicle : find_all(additional_vehicles)){

				Boolean have_title;

				try {
					have_title = vehicle.findElement(additional_vehicles_name).isDisplayed();
				}catch (NoSuchElementException | StaleElementReferenceException e){
					have_title =  false;
				}

				if (have_title.equals(true)) {
					vehicle_name = vehicle.findElement(additional_vehicles_name).getText();
					log.info("Additional vehicle nº"+(i+1)+" title: "+vehicle_name);
				} else {
					vehicle_name = "EMPTY";
					log.info("Additional vehicle nº"+(i+1)+" doesn't have a title.");
				}

				String license_plate = vehicle.findElement(additional_vehicles_license_plate).getText();
				log.info("Additional card nº"+(i+1)+" type and number: "+license_plate);
				vehicles[i] = new String[] {vehicle_name, license_plate};
				i++;
			}
		}
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
