package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class OnDemandEnterZoneScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public OnDemandEnterZoneScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By close_button = (By.id("com.spplus.parking.develop:id/closeButton"));

    //BODY
    By title = (By.id("com.spplus.parking.develop:id/title"));
    By subtitle = (By.id("com.spplus.parking.develop:id/subtitle"));
    By enter_zone_button = (By.id("com.spplus.parking.develop:id/codeContainer"));
    By enter_zone_hash = (By.id("com.spplus.parking.develop:id/hashIcon"));
    By enter_zone_text = (By.id("com.spplus.parking.develop:id/enterCodeField"));
    By or_label = (By.id("com.spplus.parking.develop:id/orLabel"));
    By scan_button = (By.id("com.spplus.parking.develop:id/qrButton"));
    By submit_button = (By.id("com.spplus.parking.develop:id/submitButton"));

    //LOADER
    By loading = (By.id("com.spplus.parking.develop:id/tv_msg"));
    
    
    public void waitUntilFinishLoading(){
        // assert_text(loading, "Loading…");
        try {
            WebElement loading_element = waitForElementToBeVisible(loading, (long) 5);
            log.info("Loading...");
            waitForElementToDisappear(loading_element, (long) 25);
        } catch (TimeoutException e) {
            log.info("Loader elements was not displayed.");
        }
    }

    public void checkUserIsInOnDemandScreen() {
        assert_text(title, "Pay for Parking Now");
        log.info("ONDEMAND ENTER ZONE SCREEN");
    }

    public void assertBasicElementsForOnDemandScreen() {
        assert_text(subtitle, "Find the 5-digit Zone # or QR Code on the sign nearest your vehicle.");
        assert_element_is_displayed(enter_zone_button);
        assert_element_is_displayed(enter_zone_hash);
        assert_text(enter_zone_text, "Enter Zone");
        assert_text(or_label, "OR");
        assert_text(scan_button, "SCAN");
        log.info("All elements in OnDemand Enter Zone screen were displayed correctly.");
    }

    public void enterZoneCode(String zone_code) {
        type(enter_zone_text, zone_code);
        log.info("Zone code entered: "+zone_code);
    }

    public void clickScanQR() {
        click(scan_button);
        log.info("Scan QR button was clicked.");
    }

    public void clickSubmit() {
        click(submit_button);
        log.info("Submit button was clicked.");
    }

    public void enterZoneCodeAndSubmit(String zone_code) {
        checkUserIsInOnDemandScreen();
        assertBasicElementsForOnDemandScreen();
        enterZoneCode(zone_code);
        click_back_button();
        clickSubmit();
        waitUntilFinishLoading();
    }

}
