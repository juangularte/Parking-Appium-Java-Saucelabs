package appium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.Logger;

public class BaseActions {
	
	protected ThreadLocal<AppiumDriver> driver;
	protected Logger log;
	protected WebDriverWait wait;
	
	public BaseActions(ThreadLocal<AppiumDriver> driver, Logger log) {
		
		this.driver = driver;
		this.log = log;
	}

	public WebDriverWait wait_for(Long timeout) {
		// timeout = timeout == 0 ? timeout : 15;
		return wait = new WebDriverWait(driver.get(), Duration.ofSeconds(timeout));
	}

	public WebElement waitForElementToBeLocated(By locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeClickable(By locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public Boolean waitForElementToDisappear(WebElement locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.invisibilityOf(locator));
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> waitForElementsToBePresent(By locator, Long timeout) {
		
		return wait_for(timeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public WebElement find(By locator) {
		
		return driver.get().findElement(locator);
	}
	
	public List<WebElement> find_all(By locator) {
		
		waitForElementsToBeVisible(locator, (long) 10);
		return driver.get().findElements(locator);
	}
	
	public void click(By locator) {
		
		waitForElementToBeClickable(locator, (long) 10).click();
	}

	protected void doubleClick(By locator){
		waitForElementToBeClickable(locator, (long) 10).click();
		find(locator).click();
	}

	protected void doubleClickElement(WebElement element){
		// wait_for((long) 10).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		sleep(500);
		element.click();
	}
	
	protected String text(By locator) {
		return waitForElementToBeLocated(locator, (long) 15).getText();
	}

	protected String attribute(By locator, String attribute) {
		return waitForElementToBeVisible(locator, (long) 10).getAttribute(attribute);
	}

	protected void click_and_type(By locator, String text) {
		WebElement input_field = waitForElementToBeVisible(locator, (long) 10);
		input_field.click();
		input_field.sendKeys(text);
	}
	
	protected void type(By locator, String text) {
		waitForElementToBeVisible(locator, (long) 10).sendKeys(text);
	}

	protected void clear(By locator) {
		WebElement input_field = waitForElementToBeVisible(locator, (long) 10);
		input_field.clear();
		// driver.get().hideKeyboard();
	}

	protected void clear_and_type(By locator, String text) {
		WebElement input_field = waitForElementToBeVisible(locator, (long) 10);
		input_field.clear();
		input_field.sendKeys(text);
		// driver.get().hideKeyboard();
	}
	
	protected void assert_text(By locator, String text) {
		Assert.assertEquals(text(locator), text, "Text is not equal.\nText found: "+text(locator)+"\nText expected: "+text+"\n");
	}

	protected void assert_input_text(By locator, String text) {
		Assert.assertEquals(text(locator).toLowerCase(), text.toLowerCase(), "Text is not equal.\nText found: "+text(locator)+"\nText expected: "+text+"\n");
	}

	protected void assert_contains_text(By locator, String text) {
		Assert.assertTrue(text(locator).contains(text), "Text doesn't contain the text expected.\nThe text '"+text+"' is not present in '"+text(locator)+"'\n");
	}

	protected void assert_element_is_checked(By locator) {
		// Assert.assertTrue(waitForElementToBeVisible(locator, (long) 10).isSelected());
		Assert.assertTrue(attribute(locator, "checked").equals("true"));
	}	
	
	protected void assert_element_is_displayed(By locator) {
		Assert.assertTrue(waitForElementToBeVisible(locator, (long) 10).isDisplayed(), "The element is not displayed: "+locator);
	}

	protected void assert_element_is_not_displayed(By locator){
		Assert.assertFalse(check_if_element_is_present(locator), "The element is displayed: "+locator);
	}
	
	protected Boolean check_if_element_is_present(By locator) {
		try {
			return find(locator).isDisplayed();
		}catch (NoSuchElementException e){
			return false;
		}catch (StaleElementReferenceException e){
			return false;
		}
	}

	// protected void check_if_element_can_be_clicked(By locator){
	// 	try{
	// 		find(locator).isDisplayed();
	// 	}
	// }

	protected void sleep(int miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected Integer amount_of_elements(By locator){
		List<WebElement> elements = find_all(locator);
		return elements.size();
	}

	protected Boolean assert_elements_list_bigger_than_number(By locator, int number){
		Assert.assertTrue(amount_of_elements(locator) > number);
		return true;
	}

	protected void assert_elements_list_amount(By locator, int number){
		Assert.assertTrue(amount_of_elements(locator) == number);
	}

	protected void click_element_by_text_from_elements_list(By locator, String text){
		for(WebElement element : find_all(locator)){
			if(element.getText().contains(text)) {
				element.click();
				break;
			}
		}
	}

	public WebElement select_random_element_from_list_of_elements(List<WebElement> list) {
		Random random = new Random();
        WebElement random_element = list.get(random.nextInt(list.size()));
		return random_element;
	}

	protected void click_back_button(){
		driver.get().navigate().back();
	}

	// public void hide_Keyboard() {
	// 	AppiumDriver.hideKeyboard();
	// }

	// protected void open_all_elements_to_find_required_element(By locator, String text){
	// 	for(WebElement element : find_all(locator)){
	// 		element.click();

	// 		if(element.getText().equals(text)) {
	// 			element.click();
	// 		}
	// 	}
	// }
}
