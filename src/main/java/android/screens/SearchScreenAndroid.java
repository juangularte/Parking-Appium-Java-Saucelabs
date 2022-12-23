package android.screens;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class SearchScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public SearchScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //MENU
    By menu_button = (By.id("com.spplus.parking.develop:id/hamburger"));
    By menu = (By.id("com.spplus.parking.develop:id/drawerFragment"));
    By find_parking_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/itemFindParking']/android.widget.TextView"));
    By my_account_option_guest = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/guestOption']/android.widget.TextView"));
    By my_account_option_reg = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/accountOption']/android.widget.TextView"));
    By logout_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/logoutOption']/android.widget.TextView"));

    //SEARCH VIEW
    By find_parking_title = (By.id("com.spplus.parking.develop:id/titleLabelTextView"));
    By search_location_box = (By.id("com.spplus.parking.develop:id/searchEntry"));
    By clear_search_button = (By.id("com.spplus.parking.develop:id/clearSearchButton"));
    By parking_near_me = (By.id("com.spplus.parking.develop:id/parkingNearMeTextView"));
    By recomendations_title = (By.id("com.spplus.parking.develop:id/listTitleTextView"));
    By results_list = (By.id("com.spplus.parking.develop:id/resultsRecyclerView"));
    By first_result = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/resultsRecyclerView']/android.widget.TextView[1]"));
    By all_results = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/resultsRecyclerView']/android.widget.TextView"));
    By search_parking_button = (By.id("com.spplus.parking.develop:id/searchParkingButton"));
    By date_time_box = (By.id("com.spplus.parking.develop:id/periodSelectorView"));
    By entrance_label = (By.id("com.spplus.parking.develop:id/entranceTimeLabel"));
    By exit_label= (By.id("com.spplus.parking.develop:id/exitTimeLabel"));
    By entrance_date_time = (By.id("com.spplus.parking.develop:id/entranceTime"));
    By exit_date_time = (By.id("com.spplus.parking.develop:id/exitTime"));

    //CALENDAR
    By calendar = (By.id("com.spplus.parking.develop:id/mdtp_day_picker_selected_date_layout"));
    By year = (By.id("com.spplus.parking.develop:id/mdtp_date_picker_year"));
    By selected_date = (By.id("com.spplus.parking.develop:id/mdtp_date_picker_day"));
    By next_month_arrow = (By.id("com.spplus.parking.develop:id/mdtp_next_month_arrow"));
    By days_displayed = (By.xpath("//android.widget.ViewAnimator[@resource-id='com.spplus.parking.develop:id/mdtp_animator']//androidx.recyclerview.widget.RecyclerView/android.view.View/android.view.View"));
    By days_enabled = (By.xpath("//android.widget.ViewAnimator[@resource-id='com.spplus.parking.develop:id/mdtp_animator']//androidx.recyclerview.widget.RecyclerView/android.view.View/android.view.View[@enabled='true']"));
    By am_button = (By.id("com.spplus.parking.develop:id/mdtp_am_label"));
    By pm_button = (By.id("com.spplus.parking.develop:id/mdtp_pm_label"));
    By circular_time_picker = (By.id("com.spplus.parking.develop:id/mdtp_time_picker"));
    By selected_hour = (By.id("com.spplus.parking.develop:id/mdtp_hours"));
    By selected_minute = (By.id("com.spplus.parking.develop:id/mdtp_minutes"));

    By calendar_cancel_button = (By.id("com.spplus.parking.develop:id/mdtp_cancel"));
    By calendar_ok_button = (By.id("com.spplus.parking.develop:id/mdtp_ok"));
    
    //MENU METHODS
    public void displayMenuIfItsNotDisplayed(){
        if (check_if_element_is_present(menu).equals(true)){
            log.info("Menu is already displayed.");
        }else{
            clickMenu();
        }
    }

    public void clickMenu(){
        click(menu_button);
        log.info("Menu button was clicked. Menu is displayed.");
    }

    public void hideMenu(){
        //TODO Add steps to click outside the menu to hide it
    }

    public void clickAccountGuestOption(){
        click(my_account_option_guest);
        log.info("My Account option was clicked.");
    }

    public void clickFindParkingOption(){
        click(find_parking_option);
        log.info("Find Parking option was clicked.");
    }

    //SEARCH VIEW METHODS
    public void assertUserIsOnSearchScreen(){
        assert_text(find_parking_title, "Find Parking"); //TODO: Remove the error in the text
        log.info("SEARCH SCREEN");
    }

    public void typeLocationToSearch(String location){
        type(search_location_box, location);
        log.info(("Location to search: "+location));
    }

    public void checkRecomendationsListAppears(){
        sleep(1000);
        assert_element_is_displayed(parking_near_me);
        assert_text(recomendations_title, "RECOMMENDATIONS");
        assert_elements_list_bigger_than_number(all_results, 0);
        log.info("At least one result appeared.");
    }

    public void selectExactResult(String location){
        click_element_by_text_from_elements_list(all_results, location);
        log.info("Exact location entered was selected in the recommendations list: "+location);
    }

    public void openCalendar() {
        click(entrance_date_time);
        log.info("Calendar is open.");
    }

    public void selectRandomFutureDay(){
        List<WebElement> future_days_enabled = find_all(days_enabled);
        future_days_enabled.remove(0);
        // for(WebElement day : future_days_enabled){System.out.println("DAY EMABLED: "+day.getAttribute("content-desc"));}
        WebElement random_day = select_random_element_from_list_of_elements(future_days_enabled);
        random_day.click();
        log.info("Day selected: "+random_day.getAttribute("content-desc"));
        click(calendar_ok_button);
        log.info("OK button was clicked.");
    }

    public void selectTime() {
        click(calendar_ok_button);
        log.info("OK button was clicked.");
    }

    public void setRandomFutureDayForCancellation() {
        openCalendar();
        selectRandomFutureDay();
        selectTime();
    }

    public String[] getEntranceExitTimes(){
        String entrance_date_time_value = text(entrance_date_time);
        String exit_date_time_value = text(exit_date_time);
        return new String[]{ entrance_date_time_value, exit_date_time_value};
    }

    public void clickOnSearchParking(){
        click(search_parking_button);
        log.info("Search Parking button was clicked.");
    }

    public String[] searchExactLocation(String location){
        assertUserIsOnSearchScreen();
        typeLocationToSearch(location);
        checkRecomendationsListAppears();
        selectExactResult(location);
        setRandomFutureDayForCancellation();
        String[] dateTimeValues = getEntranceExitTimes();
        clickOnSearchParking();
        log.info("Location searched: "+location);
        return dateTimeValues;
    }

}
