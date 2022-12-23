package android.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import android.base.BaseActionsAndroid;
import io.appium.java_client.AppiumDriver;

public class MyPaymentMethodsScreenAndroid extends BaseActionsAndroid{
	
	protected Logger log;

	public MyPaymentMethodsScreenAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//HEADER
	By back_button = (By.id("com.spplus.parking.develop:id/backButton"));
	By payment_methods_title = (By.id("com.spplus.parking.develop:id/lotName"));
	
	//DEFAULT
	By default_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT CARD']"));
	By default_card_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT CARD']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));
	By default_card_type_number = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT CARD']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By default_card_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='DEFAULT CARD']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[1]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));

	//ADDTIONAL
	By additional_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']"));
	By additional_cards = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']"));
	By first_additional_card_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][1]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));	
	By first_additional_card_type_number = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][1]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By first_additional_card_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][1]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));	
	By second_additional_card_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));	
	By second_additional_card_type_number = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By second_additional_card_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][2]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));	
	By third_additional_card_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][3]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));	
	By third_additional_card_type_number = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][3]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By third_additional_card_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][3]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));	
	By fourth_additional_card_title = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][4]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']"));	
	By fourth_additional_card_type_number = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][4]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']"));
	By fourth_additional_card_edit_button = (By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout'][4]/android.widget.TextView[@resource-id='com.spplus.parking.develop:id/editLabel']"));	

	//FOOTER
	By add_payment_button = (By.id("com.spplus.parking.develop:id/addVehicleButton"));


	public void assertUserIsOnMyPaymentMethodsScreen(){
		assert_text(payment_methods_title, "Payment Methods");
		log.info("MY PAYMENT METHODS SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertTextsLoggedUser() {
		assert_text(default_title, "DEFAULT CARD");
		assert_text(additional_title, "ADDITIONAL");
		log.info("All basic assertions for logged user passed.");
	}

	public String[] getDefaultCardValues(){
		String card_title = text(default_card_title);
		log.info("Default card title: "+card_title);
		//TODO Solve the issue with the locators
		String card_type_number = text(default_card_type_number);
		log.info("Default card type and number: "+card_type_number);
		return new String[] {card_title, card_type_number};
	}

	public Integer calculateAmountOfAdditionalCards() {
		int amount_of_additional_cards = amount_of_elements(additional_cards);
		log.info("There are "+amount_of_additional_cards+" additional cards added.");
		return amount_of_additional_cards;
	}

	public String[][] getAdditionalCardsValues(){
		int additional_cards_number = calculateAmountOfAdditionalCards();
		String[][] cards = new String[additional_cards_number][];
		String card_title;
		if(additional_cards_number == 0){
			log.info("There are no addtional cards added.");
		}else {
			for (int i = 0; i < additional_cards_number; i++) {
				
				if(check_if_element_is_present(By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']")).equals(true)){
					card_title = text((By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title']")));
					log.info("Additional card nº"+(i+1)+" title: "+card_title);
				}else{
					card_title = "EMPTY";
					log.info("Additional card nº"+(i+1)+" doesn't have a title.");
				}
				
				String card_type_number = text((By.xpath("//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/title'][@text='ADDITIONAL']/parent::android.widget.LinearLayout/following-sibling::android.view.ViewGroup[@resource-id='com.spplus.parking.develop:id/swipeRevealLayout']["+(i+1)+"]//android.widget.TextView[@resource-id='com.spplus.parking.develop:id/subtitle']")));
				log.info("Additional card nº"+(i+1)+" type and number: "+card_type_number);
				cards[i] = new String[] {card_title, card_type_number};
			}
		}
		// System.out.println("ADDITIONAL CARDS: "+cards[3][0]);
		return cards;
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

	public String[][] getAllCardsValues(){
		String [][] all_cards = getAdditionalCardsValues();
		String[][] cards = new String[all_cards.length+1][];
		cards[0] = getDefaultCardValues();
		for (int i = 0; i <= all_cards.length-1; i++) {
			cards[i+1] = all_cards[i];
		}
		return cards;
	}

	public void goBack(){
		click(back_button);
		log.info("Back button was clicked.");
	}

	public String[][] getCreditCardsDataFromUserAndGoBackToAccountScreen() {
		assertUserIsOnMyPaymentMethodsScreen();
		assertTextsLoggedUser();
		String[][] cards = getAllCardsValues();
		goBack();
		return cards;
	}
}
