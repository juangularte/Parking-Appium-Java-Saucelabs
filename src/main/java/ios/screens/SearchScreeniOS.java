package ios.screens;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import com.google.common.base.CharMatcher;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class SearchScreeniOS extends BaseActionsIOS{

    protected Logger log;

    public SearchScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By back_button = (AppiumBy.accessibilityId("ic back"));
    By find_parking_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Find Parking\"`]"));
    // By find_parking_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/itemFindParking']/android.widget.TextView"));
    // By my_account_option_guest = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/guestOption']/android.widget.TextView"));
    // By my_account_option_reg = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/accountOption']/android.widget.TextView"));
    // By logout_option = (By.xpath("//*[@resource-id='com.spplus.parking.develop:id/logoutOption']/android.widget.TextView"));

    //SEARCH BOX
    By search_location_box = (AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Search for Location\"`]"));
    By clear_search_button = (AppiumBy.accessibilityId("Clear text"));
    By daily_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Daily\"`]"));
    By monthly_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Monthly\"`]"));

    //DATE AND TIME
    By entrance_label = (AppiumBy.accessibilityId("ENTRANCE TIME"));
    By exit_label= (AppiumBy.accessibilityId("EXIT TIME"));
    By entrance_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='ENTRANCE TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By exit_date_time = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name='EXIT TIME']/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeTextField"));
    By calendar_box = (AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypePicker\""));
    By dates_wheel = (AppiumBy.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel[1]"));
    By hours_wheel = (AppiumBy.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel[2]"));
    By minutes_wheel = (AppiumBy.xpath("//XCUIElementTypePicker/XCUIElementTypePickerWheel[3]")); 
    
    //VEHICLE SIZE
    By vehicle_size_title = (AppiumBy.accessibilityId("SELECT VEHICLE SIZE"));
    By vehicle_size_rates_message = (AppiumBy.accessibilityId("Show rates from standard size vehicles."));
    By standard_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"STANDARD\"`]"));
    By oversize_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"OVERSIZE\"`]"));
    By parking_near_me_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Parking near me\"`]"));
    
    //RECOMMENDATIONS
    By recomendations_title = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"RECOMMENDATIONS\"`]"));
    By all_results = (AppiumBy.xpath("//XCUIElementTypeOther[@name='RECOMMENDATIONS']/following-sibling::XCUIElementTypeCell/XCUIElementTypeStaticText"));
    By first_result = (AppiumBy.xpath("//XCUIElementTypeOther[@name='RECOMMENDATIONS']/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText"));
    
    //FOOTER
    By search_parking_button = (AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"SEARCH PARKING\"`]"));
    
    //MENU METHODS
    // public void displayMenuIfItsNotDisplayed(){
    //     if (check_if_element_is_present(menu).equals(true)){
    //         log.info("Menu is already displayed.");
    //     }else{
    //         clickMenu();
    //     }
    // }

    // public void clickMenu(){
    //     click(menu_button);
    //     log.info("Menu button was clicked. Menu is displayed.");
    // }

    // public void hideMenu(){
    //     //TODO Add steps to click outside the menu to hide it
    // }

    // public void clickAccountGuestOption(){
    //     click(my_account_option_guest);
    //     log.info("My Account option was clicked.");
    // }

    // public void clickFindParkingOption(){
    //     click(find_parking_option);
    //     log.info("Find Parking option was clicked.");
    // }

    //SEARCH VIEW METHODS
    public void assertUserIsOnSearchScreen(){
        assert_text(find_parking_title, "Find Parking");
        log.info("SEARCH SCREEN");
    }

    public void typeLocationToSearch(String location){
        type(search_location_box, location);
        log.info(("Location to search: "+location));
    }

    public void checkRecomendationsListAppears(){
        sleep(1000);
        assert_element_is_displayed(parking_near_me_button);
        assert_text(recomendations_title, "RECOMMENDATIONS");
        assert_elements_list_bigger_than_number(all_results, 0);
        log.info("At least one result appeared.");
    }

    public void selectExactResult(String location){
        click_element_by_text_from_elements_list(all_results, location);
        log.info("Exact location entered was selected in the recommendations list: "+location);
    }

    public void openCalendar() {
        assertUserIsOnSearchScreen();
        click(entrance_date_time);
        log.info("Calendar is open.");
    }

    // public void selectRandomFutureDay(){
    //     List<WebElement> future_days_enabled = find_all(days_enabled);
    //     future_days_enabled.remove(0);
    //     // for(WebElement day : future_days_enabled){System.out.println("DAY EMABLED: "+day.getAttribute("content-desc"));}
    //     WebElement random_day = select_random_element_from_list_of_elements(future_days_enabled);
    //     random_day.click();
    //     log.info("Day selected: "+random_day.getAttribute("content-desc"));
    //     click(calendar_ok_button);
    //     log.info("OK button was clicked.");
    // }

    // public void selectTime() {
    //     click(calendar_ok_button);
    //     log.info("OK button was clicked.");
    // }

    public void selectRandomFutureDay(){
        swipeElementUp(calendar_box, 1000);
        String date_selected = text(dates_wheel);
        String date_number = CharMatcher.inRange('0', '9').retainFrom(date_selected);
        String date_month = date_selected.substring(date_selected.length() - 3);
        String date_selected_format = date_month+". "+date_number;
        assert_contains_text(entrance_date_time, date_selected_format);
        // assert_contains_text(exit_date_time, date_selected_format);
        log.info("Date selected: "+date_selected);
    }

    public void selectRandomFutureDayForAccessCode(){
        click(exit_date_time);
        if(!text(dates_wheel).equals("Today")){
            //DO THIS
            swipeElementUp(calendar_box, 1500);
            click(entrance_date_time);
            swipeElementUp(calendar_box, 1000);
            click(exit_date_time);
        }else{
            if(Integer.parseInt(text(hours_wheel).replace(" o’clock", "")) > 14){
                swipeElementUp(calendar_box, 1500);
                click(entrance_date_time);
                swipeElementUp(calendar_box, 1000);
                click(exit_date_time);
            }
        }
        click(dates_wheel);
        type(hours_wheel, "14");
        type(minutes_wheel, "30");
        click(entrance_date_time);
        type(hours_wheel, "12");
        type(minutes_wheel, "30");
        // click(dates_wheel);
        swipeElementUp(calendar_box, 1500);
        String date_selected = text(dates_wheel);
        String date_number = CharMatcher.inRange('0', '9').retainFrom(date_selected);
        String date_month = date_selected.substring(date_selected.length() - 3);
        String date_selected_format = date_month+". "+date_number;
        assert_contains_text(entrance_date_time, date_selected_format);
        // assert_contains_text(exit_date_time, date_selected_format);
        log.info("Date selected: "+date_selected);
    }

    public void selectTimeEnabledForAccessCode() {
        // click(calendar_ok_button);
        // log.info("OK button was clicked.");
    }

    public void setRandomFutureDayForCancellation() {
        openCalendar();
        selectRandomFutureDay();
        // selectTime();
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
        // setRandomFutureDayForCancellation();
        typeLocationToSearch(location);
        hideKeyboard();
        checkRecomendationsListAppears();
        selectExactResult(location);
        selectRandomFutureDay();
        String[] dateTimeValues = getEntranceExitTimes();
        clickOnSearchParking();
        log.info("Location searched: "+location);
        return dateTimeValues;
    }

    public String[] searchExactAccessCodeLocation(String location){
        // setRandomFutureDayForCancellation();
        typeLocationToSearch(location);
        hideKeyboard();
        checkRecomendationsListAppears();
        selectExactResult(location);
        selectRandomFutureDayForAccessCode();
        String[] dateTimeValues = getEntranceExitTimes();
        clickOnSearchParking();
        log.info("Location searched: "+location);
        return dateTimeValues;
    }

}
