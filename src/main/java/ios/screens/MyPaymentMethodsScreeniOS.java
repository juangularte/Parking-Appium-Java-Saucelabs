package ios.screens;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import ios.base.BaseActionsIOS;

public class MyPaymentMethodsScreeniOS extends BaseActionsIOS{
	
	protected Logger log;

	public MyPaymentMethodsScreeniOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	//HEADER
	By back_button = (AppiumBy.accessibilityId("ic back"));
	By payment_methods_title = (AppiumBy.accessibilityId("Payment Methods"));
	
	//DEFAULT
	By default_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"DEFAULT CARD\"]"));
	By default_card_title = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT CARD\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/following-sibling::XCUIElementTypeStaticText[not(@value='EDIT')][not(contains(@value,'*'))]"));
	By default_card_type_number = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT CARD\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]"));
	By default_card_edit_button = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"DEFAULT CARD\"]/following-sibling::XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@name=\"EDIT\"]"));

	//ADDTIONAL
	By additional_title = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ADDITIONAL\"]"));
	By additional_cards = (AppiumBy.xpath("//XCUIElementTypeOther[@name=\"ADDITIONAL\"]/following-sibling::XCUIElementTypeCell"));
	By additional_cards_title = (AppiumBy.xpath(".//XCUIElementTypeStaticText[not(@value='EDIT')][not(contains(@value,'*'))]"));
	By additional_cards_type_number = (AppiumBy.xpath(".//XCUIElementTypeStaticText[(contains(@value,'*'))]"));
	By additional_cards_edit_button = (AppiumBy.xpath(".//XCUIElementTypeStaticText[@name=\"EDIT\"]"));
	
	//FOOTER
	By add_payment_button = (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"ADD PAYMENT\"]"));


	public void assertUserIsOnMyPaymentMethodsScreen(){
		assert_text(payment_methods_title, "Payment Methods");
		log.info("MY PAYMENT METHODS SCREEN");
	}

	//USER LOGGED IN METHODS
	public void assertTextsLoggedUser(){
		assert_text(default_title, "DEFAULT CARD");
		if(check_if_element_is_present(additional_title)){
			assert_text(additional_title, "ADDITIONAL");
		}
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
		try {
			int amount_of_additional_cards = amount_of_elements(additional_cards);
			log.info("There are "+amount_of_additional_cards+" additional cards added.");
			return amount_of_additional_cards;
		} catch (TimeoutException e) {
			return 0;
		}
		
	}

	public String[][] getAdditionalCardsValues(){
		int additional_cards_number = calculateAmountOfAdditionalCards();
		String[][] cards = new String[additional_cards_number][];
		String card_title;
		int i= 0;
		if(additional_cards_number == 0){
			log.info("There are no addtional cards added.");
		}else {

			for (WebElement card : find_all(additional_cards)){

				Boolean have_title;

				try {
					have_title = card.findElement(additional_cards_title).isDisplayed();
				}catch (NoSuchElementException | StaleElementReferenceException e){
					have_title =  false;
				}

				if (have_title.equals(true)) {
					card_title = card.findElement(additional_cards_title).getText();
					log.info("Additional card nº"+(i+1)+" title: "+card_title);
				} else {
					card_title = "EMPTY";
					log.info("Additional card nº"+(i+1)+" doesn't have a title.");
				}

				String card_type_number = card.findElement(additional_cards_type_number).getText();
				log.info("Additional card nº"+(i+1)+" type and number: "+card_type_number);
				cards[i] = new String[] {card_title, card_type_number};
				i++;
			}
		}
		return cards;
	}

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
