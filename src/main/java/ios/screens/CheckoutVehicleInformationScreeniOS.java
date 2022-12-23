package ios.screens;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class CheckoutVehicleInformationScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public CheckoutVehicleInformationScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By vehicle_information_title = (AppiumBy.accessibilityId("Add Vehicle"));

    //BODY
    By subtitle = (AppiumBy.accessibilityId("Make sure your license plate matches the vehicle you park to avoid a parking ticket or towing. If you drive a large vehicle, please refer to the height restriction of this location. "));
    // By car_image = (AppiumBy.accessibilityId("car"));
    By car_image = (AppiumBy.xpath("//XCUIElementTypeImage[1]"));


    //FIELDS
    By license_plate_label = (AppiumBy.accessibilityId("LICENSE PLATE*"));
    By license_plate_field = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"LICENSE PLATE*\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField"));
    By country_section = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/country_code_holder_rly"));
    By country_flag = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/flag_imv"));
    By state_dropdown = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"State  \"`]"));
    By state_selected = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"LICENSE PLATE*\"]/following-sibling::XCUIElementTypeOther/XCUIElementTypeTextField/following-sibling::XCUIElementTypeButton[2]/XCUIElementTypeStaticText"));
    By empty_license_plate_validation = (AppiumBy.accessibilityId("Please enter the license plate."));
    By license_plate_disclaimer = (AppiumBy.accessibilityId("Enter your full plate number to avoid citation.  Max of 8 characters. Do not include spaces or special characters."));
    
    //COUNTRIES LIST
    By select_country_title = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/title_tv"));
    By search_country = (AppiumBy.accessibilityId("com.spplus.parking.develop:id/search_edt"));
    By list_of_countries = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv']"));
    By usa = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv'][@text='United States']"));
    By canada = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/code_tv'][@text='Canada']"));

    //STATES LIST
    By states_list = (AppiumBy.xpath("//XCUIElementTypePopover//XCUIElementTypeTable"));
    By states_from_list = (AppiumBy.xpath(".//XCUIElementTypeCell/XCUIElementTypeStaticText"));
    By states = (By.xpath("//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable//XCUIElementTypeCell/XCUIElementTypeStaticText"));
    By visible_states = (By.xpath("//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable//XCUIElementTypeCell/XCUIElementTypeStaticText[@visible='true']"));
    By first_state = (AppiumBy.xpath("//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText"));
    By third_state = (AppiumBy.xpath("//XCUIElementTypePopover/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeStaticText"));

    //FOOTER
    By make_sure = (AppiumBy.accessibilityId("This vehicle will appear during Checkout. Make sure your license matches the vehicle you park to avoid towing."));
    By save_vehicle = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"SAVE VEHICLE\"]"));

    public void checkUserIsInVehicleInformationScreen() {
        assert_text(vehicle_information_title, "Add Vehicle");
        log.info("ADD VEHICLE SCREEN");
    }
    
    public void assertCommonElements(){
        checkUserIsInVehicleInformationScreen();
        assert_text(subtitle, "Make sure your license plate matches the vehicle you park to avoid a parking ticket or towing. If you drive a large vehicle, please refer to the height restriction of this location. ");
        // assert_element_is_displayed(car_image);
        assert_text(license_plate_label, "LICENSE PLATE*");
        assert_text(license_plate_field, "ex - ABC1234");
        assert_text(state_selected, "State  ");
        assert_text(license_plate_disclaimer, "Enter your full plate number to avoid citation.  Max of 8 characters. Do not include spaces or special characters.");
        assert_text(make_sure, "This vehicle will appear during Checkout. Make sure your license matches the vehicle you park to avoid towing.");
        assert_text(save_vehicle, "SAVE VEHICLE");
    }

    public void assertCommonElementsForVehicleChanging(String license_plate, String state){
        checkUserIsInVehicleInformationScreen();
        assert_text(subtitle, "Make sure your license plate matches the vehicle you park to avoid a parking ticket or towing. If you drive a large vehicle, please refer to the height restriction of this location.");
        assert_element_is_displayed(car_image);
        assert_text(license_plate_label, "LICENSE PLATE*");
        assert_text(license_plate_field, license_plate);
        assert_text(state_selected, state);
        assert_text(make_sure, "This vehicle will appear during Checkout. Make sure your license matches the vehicle you park to avoid towing.");
        assert_text(save_vehicle, "SAVE VEHICLE");
    }

    public void addLicensePlate(String license_plate){
        clear_and_type(license_plate_field, license_plate);
        log.info("License Plate added: "+license_plate);
        hideKeyboard();
    }

    public void selectCountry(String country){
        if(!country.equals("United States")){
            click(country_section);
            log.info("Countries list was open.");
            type(search_country, country);
            if(check_if_element_is_present(canada).equals(true)){
                assert_input_text(canada, country);
                click(canada);
            }
            log.info("Country selected: "+country);
        }
    }

    public void selectState(String state){
        click(state_dropdown);
        waitForElementToBeVisible(states_list, (long) 5);

        sleep(1500);        
        assert_elements_list_bigger_than_number(visible_states, 1);
        while_loop : while(check_if_element_is_present(states_list).equals(true)){

            // for(int i=1; i>7; i++){

            //     WebElement list = find(states_list);
            //     System.out.println(list.findElement(By.xpath(".//XCUIElementTypeCell/XCUIElementTypeStaticText["+i+"]")).getText());
            // }

            // states_loop : for (WebElement st : waitForElementsToBePresent(states, (long) 5)){
            states_loop : for (WebElement st : find_all(visible_states)){
                if (st.getText().equals(state)){
                    log.info("State selected: "+st.getText());
                    st.click();
                    break states_loop;
                    
                }else{
                    continue states_loop;
                }
            }

            if(check_if_element_is_present(states_list).equals(false)){
                break while_loop;
            }
            // scrollDownToText(state);
            swipeElementUp(states_list, 1000);
        }
        
        // switch (check_if_element_is_present(states_list).toString()) {
        //     case "true":    scrollDownToText(state);
        //                     states_loop : for (WebElement st : find_all(states)){
        //                         if (st.getText().equals(state)){
        //                             log.info("State selected: "+st.getText());
        //                             st.click();
        //                             break states_loop;
        //                         }else{
        //                             continue states_loop;
        //                         }
        //                     }
        //     case "false": break;
        // }
    }

    public void clickSaveVehicle(){
        // scrollToText("SAVE VEHICLE");
        // waitForElementToBeVisible(save_vehicle, (long) 5);
        if(check_if_element_is_present(save_vehicle).equals(false)){
            click_back_button();
        }
        click(save_vehicle);
        log.info("Save Vehicle button was clicked.");
    }

    public void assertFieldValidations(){
        click(save_vehicle);
        assert_text(empty_license_plate_validation, "Please enter the license plate.");
        click(license_plate_field);
        type(license_plate_field, "1234567890");
        Assert.assertTrue(text(license_plate_field).length() == 8);
        log.info("License Plate field allows only 8 characters.");
    }

    public void completeFields(String license_plate, String country, String state){
        assertCommonElements();
        selectCountry(country);
        selectState(state);
        assertFieldValidations();
        addLicensePlate(license_plate);
        // click_back_button();
        clickSaveVehicle();
    }

    public void changeVehicleData(String license_plate, String state, String country, String new_vehicle_state, String new_license_plate) {
        assertCommonElementsForVehicleChanging(license_plate, state);
        selectCountry(country);
        selectState(new_vehicle_state);
        addLicensePlate(new_license_plate);
        clickSaveVehicle();
    }
}
