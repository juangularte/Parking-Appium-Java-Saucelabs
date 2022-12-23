package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class OnDemandAddTimeScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public OnDemandAddTimeScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By close_button = (By.id("com.spplus.parking.develop:id/closeButton"));
    By title = (By.id("com.spplus.parking.develop:id/addTimeTitle"));

    //BODY
    By current_order_card = (By.id("com.spplus.parking.develop:id/currentOrderHeaderContainer"));
    By session_ends_label = (By.id("com.spplus.parking.develop:id/sessionEndsLabel"));
    By time_left_label = (By.id("com.spplus.parking.develop:id/timeLeftLabel"));
    By select_time_button = (By.id("com.spplus.parking.develop:id/selectHoursButton"));
    By hours_of_operation_label = (By.id("com.spplus.parking.develop:id/operationHoursTitle"));

    //SELECT TIME MODAL
    By select_time_cancel_button = (By.id("com.spplus.parking.develop:id/cancelButton"));
    By select_time_select_button = (By.id("com.spplus.parking.develop:id/selectButton"));
    By days_wheel = (By.xpath("//android.widget.NumberPicker[1]"));
    By days_value = (By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][1]"));
    By hours_wheel = (By.xpath("//android.widget.NumberPicker[2]"));
    By hours_value = (By.xpath("//android.widget.NumberPicker[2]/android.widget.EditText"));
    By minutes_wheel = (By.xpath("//android.widget.NumberPicker[3]"));
    By minutes_hour = (By.xpath("//android.widget.EditText[@resource-id='android:id/numberpicker_input'][3]"));

    //FOOTER
    By parking_instructions_title = (By.xpath("//android.widget.TextView[@text='Parking Instructions']"));
    By parking_instructions_info = (By.id("com.spplus.parking.develop:id/instructionsHeaderDetailA"));

    //LOADER
    By loading = (By.id("com.spplus.parking.develop:id/tv_msg"));
    
    
    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 25);
        } catch (TimeoutException e) {
            log.info("Loader element was not displayed.");
        }
    }

    public void checkUserIsInAddTimeScreen() {
        assert_text(title, "Add Time");
        log.info("ADD TIME SCREEN");
    }

    public void assertBasicElementsForAddTimeScreen() {
        assert_element_is_displayed(current_order_card);
        assert_text(session_ends_label, "SESSION ENDS");
        assert_text(time_left_label, "TIME LEFT");
        assert_text(select_time_button, "SELECT TIME NEEDED");
        assert_text(hours_of_operation_label, "HOURS OF OPERATION");
        assert_text(parking_instructions_title, "Parking Instructions");
        log.info("All elements in OnDemand Add Time screen were displayed correctly.");
    }

    public void openSelectTimeModal() {
        click(select_time_button);
        log.info("Select Time Needed button was clicked.");
    }

    public void selectTime() {
        openSelectTimeModal();
        click(hours_value);
        clear_and_type(hours_value, "1 HOUR");
        click(hours_value);
        if(check_if_element_is_present(select_time_select_button).equals(true)){
            click_back_button();
            click(select_time_select_button);
        }
        log.info("Time was selected.");
    }

    public void addTime() {
        checkUserIsInAddTimeScreen();
        assertBasicElementsForAddTimeScreen();
        selectTime();
        waitUntilFinishLoading();
    }

}
