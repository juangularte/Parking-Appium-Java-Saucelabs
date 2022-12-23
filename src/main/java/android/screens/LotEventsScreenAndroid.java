package android.screens;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class LotEventsScreenAndroid extends BaseActionsAndroid{

    protected Logger log;

    public LotEventsScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
        super(driver, log);
        this.log = log;
    }

    //HEADER
    By close_button = (By.id("com.spplus.parking.develop:id/close"));
    By title = (By.id("com.spplus.parking.develop:id/titleTextView"));

    //FIND EVENT PARKING
    By find_event_parking_for = (By.id("com.spplus.parking.develop:id/findEventParkingForTextView"));
    By lot_address = (By.id("com.spplus.parking.develop:id/addressTextView"));

    //ENTRANCE TIME
    By entrance_time_label = (By.id("com.spplus.parking.develop:id/entranceTimeTextView"));
    By calendar_icon = (By.id("com.spplus.parking.develop:id/calendarImageView"));
    By select_date_input = (By.id("com.spplus.parking.develop:id/selectDateTextView"));

    //SEARCH EVENT NAME
    By search_event_name_label = (By.id("com.spplus.parking.develop:id/searchEventNameTextView"));
    By circle_icon = (By.id("com.spplus.parking.develop:id/magGlassImageView"));
    By enter_event_name_input = (By.id("com.spplus.parking.develop:id/enterANameEditText"));
    By clear_filters = (By.id("com.spplus.parking.develop:id/clearFiltersTextView"));

    //EVENTS
    By events_label = (By.xpath("//android.widget.TextView[@text='EVENTS']"));
    By prices_reflects_label = (By.id("com.spplus.parking.develop:id/eventsOversize"));
    By events_list = (By.id("com.spplus.parking.develop:id/eventsList"));

    //EVENTS CARDS
    By events_cards = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup"));

    //EVENTS DETAILS
    By upcoming_event_calendar_icon = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/date']"));
    By upcoming_event_calendar_icon_month = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemMonthTextView']"));
    By upcoming_event_calendar_icon_day_number = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDayTextView']"));
    By upcoming_event_calendar_icon_day_name = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDayStrTextView']"));
    By upcoming_event_name = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemName']"));
    By upcoming_event_location = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemSubname']"));
    By upcoming_event_date = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDateTextView']"));
    By upcoming_event_time = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemTimeTextView']"));
    By upcoming_event_price = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemPriceTextView']"));
    By upcoming_event_book_parking = (By.xpath(".//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemBookNowButton']"));

    //SECOND EVENT DISPLAYED
    By second_upcoming_event_calendar_icon = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/date']"));
    By second_upcoming_event_calendar_icon_month = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemMonthTextView']"));
    By second_upcoming_event_calendar_icon_day_number = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDayTextView']"));
    By second_upcoming_event_calendar_icon_day_name = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDayStrTextView']"));
    By second_upcoming_event_name = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemName']"));
    By second_upcoming_event_location = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemSubname']"));
    By second_upcoming_event_date = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemDateTextView']"));
    By second_upcoming_event_time = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemTimeTextView']"));
    By second_upcoming_event_price = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemPriceTextView']"));
    By second_upcoming_event_book_parking = (By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.spplus.parking.develop:id/eventsList']/android.view.ViewGroup[2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/garageDetailEventModalItemBookNowButton']"));

    public void assertUserIsOnLotEventsScreen(String location) {
        assert_text(title, location+" Events");
        log.info("lOT EVENTS SCREEN");
    }

    public void assertBasicItems(String location, String lot_address_value) {
        assertUserIsOnLotEventsScreen(location);
        assert_text(find_event_parking_for, "Find event parking for");
        assert_text(lot_address, lot_address_value.replace("ENTRANCE  ", ""));
        assert_text(entrance_time_label, "ENTRANCE TIME");
        assert_text(search_event_name_label, "SEARCH EVENT NAME");
        assert_text(clear_filters, "Clear Filters");
        assert_text(events_label, "EVENTS");
        assert_text(prices_reflects_label, "Prices Reflect Standard Rate");
        log.info("Lot events basic items were asserted correctly.");
    }

    public void scrollUpEventList() {
        swipeElementUp(events_list, 200);
        log.info("Events list swiped up.");
    }

    public String[] getBookableUpcomingEventDetailsAndClickOnBookParking() {
        
        String event_name = new String();
        String event_location = new String();
        String event_price = new String();
        String event_date = new String();
        String event_time = new String();

        Boolean bookable_parking_found = false;

        DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDateTime current_date = LocalDateTime.now();
        LocalDateTime tomorrow_date = LocalDateTime.now().plusDays(1);

        DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("h:mm a");
        // DateTimeFormatter hour_formatter = DateTimeFormatter.ofPattern("h");
        // DateTimeFormatter minutes_formatter = DateTimeFormatter.ofPattern("mm");
        // DateTimeFormatter am_pm_formatter = DateTimeFormatter.ofPattern("a");
        LocalDateTime current_time = LocalDateTime.now();

        String today = date_formatter.format(current_date);
        String tomorrow = date_formatter.format(tomorrow_date);
        String time = time_formatter.format(current_time);
        // String hour = hour_formatter.format(current_time);
        // String minutes = minutes_formatter.format(current_time);
        // String am_pm = am_pm_formatter.format(current_time);

        // System.out.println("TODAY: "+today);
        // System.out.println("TOMORROW: "+tomorrow);
        // System.out.println("HOUR: "+hour);
        // System.out.println("MINUTES: "+minutes);
        // System.out.println("AM/PM: "+am_pm);

        // System.out.println("NUMBER OF CARDS DISPLAYED: "+amount_of_elements(events_cards));

        while(bookable_parking_found.equals(false)){
            events_cards_loop : for (WebElement event : find_all(events_cards)){

                event_name = event.findElement(upcoming_event_name).getText();
                event_location = event.findElement(upcoming_event_location).getText();
                event_price = event.findElement(upcoming_event_price).getText();
                event_date = event.findElement(upcoming_event_date).getText();
                event_time = event.findElement(upcoming_event_time).getText();

                String event_time_am_pm = event_time.replace("at ", "");
                // String event_am_pm = event_time.substring(event_time.length() - 2);
                // String split_time = event_time.replace(" ", "").replace("at", "").replace("AM", "").replace("PM", "");
                // String event_hour = split_time.substring(0, split_time.indexOf(":"));
                // String event_minutes = split_time.substring(split_time.length() - 2);

                // System.out.println("CARD DATE: "+event_date);
                // System.out.println("CARD AM/PM: "+event_am_pm);
                // System.out.println("TIME SPLITTED: "+split_time);
                // System.out.println("CARD HOUR: "+event_hour);
                // System.out.println("CARD MINUTES 1: "+event_minutes);

                LocalTime local_time = LocalTime.parse(time, time_formatter);
                LocalTime event_card_time = LocalTime.parse(event_time_am_pm, time_formatter);

                System.out.println("SYSTEM DATE: "+today);
                System.out.println("TOMORROW DATE: "+tomorrow);
                System.out.println("CARD DATE: "+event_date);
                System.out.println("SYSTEM TIME: "+local_time);
                System.out.println("CARD TIME: "+event_card_time);

                if(event_date.equals(today)){

                    System.out.println("DAY IS EQUAL: "+event_date +" /////// "+today);

                    if(local_time.isBefore(event_card_time)){

                        System.out.println("BEFORE TIME: "+local_time +" /////// "+event_card_time);
                    
                        log.info("All the event information was gathered correctly.");
    
                        bookable_parking_found = true;
                        event.findElement(upcoming_event_book_parking).click();
                        log.info("Book Parking button for selected upcoming event was clicked.");
                        break events_cards_loop;
                    }
                }

                if(event_date.equals(tomorrow)){

                    System.out.println("DAY IS TOMORROW: "+event_date +" /////// "+tomorrow);
    
                    log.info("All the event information was gathered correctly.");
    
                    bookable_parking_found = true;
                    event.findElement(upcoming_event_book_parking).click();
                    log.info("Book Parking button for selected upcoming event was clicked.");
                    break events_cards_loop;
                }
            }

            if(bookable_parking_found.equals(false)){
                scrollUpEventList();
            }
        }

        log.info("Event name: "+event_name);
        log.info("Event location: "+event_location);
        log.info("Event price: "+event_price);
        log.info("Event date: "+event_date);
        log.info("Event time: "+event_time);

        return new String[] {event_name, event_location, event_price, event_date, event_time};
    }

    public void clickOnBookParkingForSelectedUpcomingEvent() {
        click(upcoming_event_book_parking);
        log.info("Book Parking button for selected upcoming event was clicked.");
    }

    public String[] getSelectedUpcomingEventDetailsAndClickBookParking(String location, String lot_address) {
        assertBasicItems(location, lot_address);
        // scrollUpEventList();
        String[] event_details = getBookableUpcomingEventDetailsAndClickOnBookParking();
        return event_details;
    }

}