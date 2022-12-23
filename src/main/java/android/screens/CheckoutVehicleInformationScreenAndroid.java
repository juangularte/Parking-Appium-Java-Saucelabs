package android.screens;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class CheckoutVehicleInformationScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public CheckoutVehicleInformationScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
    By vehicle_information_title = (By.xpath("//android.widget.TextView[@text='Add Vehicle']"));

    //BODY
    By subtitle = (By.id("com.spplus.parking.develop:id/subtitleTextView"));
    By car_image = (By.id("com.spplus.parking.develop:id/carImage"));


    //FIELDS
    By license_plate_label = (By.xpath("//android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/header']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView"));
    By license_plate_field = (By.id("com.spplus.parking.develop:id/licensePlateField"));
    By state_label = (By.xpath("//android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/header']/parent::android.view.ViewGroup/following-sibling::android.widget.TextView[2]"));
    By country_section = (By.id("com.spplus.parking.develop:id/country_code_holder_rly"));
    By country_flag = (By.id("com.spplus.parking.develop:id/flag_imv"));
    By countries_arrow = (By.id("com.spplus.parking.develop:id/arrow_imv"));
    By state_dropdown = (By.id("com.spplus.parking.develop:id/licensePlateState"));
    By state_selected = (By.id("android:id/text1"));
    By empty_license_plate_validation = (By.id("com.spplus.parking.develop:id/licensePlateValidation"));
    By disclaimer = (By.id("com.spplus.parking.develop:id/licensePlateDisclaimer"));
    
    //COUNTRIES LIST
    By select_country_title = (By.id("com.spplus.parking.develop:id/title_tv"));
    By search_country = (By.id("com.spplus.parking.develop:id/search_edt"));
    By list_of_countries = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv']"));
    By usa = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/country_name_tv'][@text='United States']"));
    By canada = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/code_tv'][@text='Canada']"));
    By no_country_found = (By.id("com.spplus.parking.develop:id/no_result_tv"));

    //STATES LIST
    By states_list = (By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][1]/parent::android.widget.ListView"));
    By states = (By.id("android:id/text1"));

    //FOOTER
    By make_sure = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/licensePlateDisclaimer']/following-sibling::android.widget.TextView"));
    By save_vehicle = (By.id("com.spplus.parking.develop:id/saveButton"));
    
    public void assertCommonElements(){
        log.info("ADD VEHICLE SCREEN");
        assert_text(vehicle_information_title, "Add Vehicle");
        assert_text(subtitle, "Make sure your license plate matches the vehicle you park to avoid a parking ticket or towing. If you drive a large vehicle, please refer to the height restriction of this location.");
        assert_element_is_displayed(car_image);
        assert_text(license_plate_label, "LICENSE PLATE*");
        assert_text(license_plate_field, "ex - ABC123");
        assert_text(state_label, "STATE*");
        assert_text(state_selected, "AL");
        // assert_contains_text(disclaimer, "Enter your full plate number to avoid");
        //S21 and S22 text = Enter your full plate number to avoid citation. Max of 8 characters. Do not include spaces or special characters. 
        //S9 and S10 text = Enter you full plate number to avoid a citation. Max of 8 characters. Do not include spaces, special characters or the state.
        assert_text(make_sure, "This vehicle will appear during Checkout. Make sure your license matches the vehicle you park to avoid towing.");
        assert_text(save_vehicle, "SAVE VEHICLE");
    }

    public void assertCommonElementsForVehicleChanging(String license_plate, String state){
        log.info("ADD VEHICLE SCREEN");
        assert_text(vehicle_information_title, "Add Vehicle");
        assert_text(subtitle, "Make sure your license plate matches the vehicle you park to avoid a parking ticket or towing. If you drive a large vehicle, please refer to the height restriction of this location.");
        assert_element_is_displayed(car_image);
        assert_text(license_plate_label, "LICENSE PLATE*");
        assert_text(license_plate_field, license_plate);
        assert_text(state_label, "STATE*");
        // assert_text(state_selected, state);
        // assert_contains_text(disclaimer, "Enter your full plate number to avoid");
        //S21 and S22 text = Enter your full plate number to avoid citation. Max of 8 characters. Do not include spaces or special characters. 
        //S9 and S10 text = Enter you full plate number to avoid a citation. Max of 8 characters. Do not include spaces, special characters or the state.
        assert_text(make_sure, "This vehicle will appear during Checkout. Make sure your license matches the vehicle you park to avoid towing.");
        assert_text(save_vehicle, "SAVE VEHICLE");
    }

    public void addLicensePlate(String license_plate){
        clear_and_type(license_plate_field, license_plate);
        log.info("License Plate added: "+license_plate);
    }

    public void selectCountry(String country){
        if(!country.equals("United States")){
            click(country_section);
            log.info("Countries list was open.");
            type(search_country, country);
            if(check_if_element_is_present(canada).equals(true)){
                assert_input_text(canada, country);
                click(canada);
            }else if(check_if_element_is_present(no_country_found).equals(true)){
                throw new Error("No country matches the value entered: '"+country+"'. The only options available are 'United States' and 'Canada'.");
            }
        }
        log.info("Country selected: "+country);
    }

    public void selectState(String state){
        if(state.equals("AL")){
            log.info("State selected: "+state);
        }else{
            click(state_dropdown);
            waitForElementToBeVisible(states_list, (long) 5);
            assert_elements_list_bigger_than_number(states, 1);
            states_loop : for (WebElement st : find_all(states)){
                if (st.getText().equals(state)){
                    log.info("State selected: "+st.getText());
                    st.click();
                    break states_loop;
                }else{
                    continue states_loop;
                }
            }

            switch (check_if_element_is_present(states_list).toString()) {
                case "true":    scrollToText(state);
                                states_loop : for (WebElement st : find_all(states)){
                                    if (st.getText().equals(state)){
                                        log.info("State selected: "+st.getText());
                                        st.click();
                                        break states_loop;
                                    }else{
                                        continue states_loop;
                                    }
                                }
                case "false": break;
            }
        }

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
        assert_text(empty_license_plate_validation, "A valid license plate is required");
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
