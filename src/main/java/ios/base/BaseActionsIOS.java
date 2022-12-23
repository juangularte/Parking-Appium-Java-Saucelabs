package ios.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import appium.base.BaseActions;
import io.appium.java_client.AppiumBy;
// import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
// import io.appium.java_client.ios.IOSDriver;

public class BaseActionsIOS extends BaseActions{

	public Logger log; //variable to control and print the logs

	public BaseActionsIOS(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}

	public void scroll(String direction, String text) {
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver.get();
			HashMap<String, Object> scrollDown = new HashMap<>();
			scrollDown.put("direction", direction);
			scrollDown.put("value", text);
			js.executeScript("mobile: swipe", scrollDown);
		} catch (Exception e) {
			log.error("Cannot scroll to '"+text+"'.");
		}
	}

	public void scrollDownToText(String text){
		scroll("up", text);
	}

	public void scrollUpToText(String text){
		scroll("down", text);
	}

	public void hideKeyboard() {
		click(AppiumBy.accessibilityId("Done"));
	}

	public void swipeElementUp(By from_locator, int miliseconds) {

		WebElement scrollable = find(from_locator);

		//Identifying coordinates of the scrollable element
		int centerX = scrollable.getRect().x + (scrollable.getSize().width/2);
		double startY = scrollable.getRect().y + (scrollable.getSize().height * 0.9);
		double endY = scrollable.getRect().y + (scrollable.getSize().height * 0.1);
		// int startY = scrollable.getRect().y + (scrollable.getSize().height/2);

		// System.out.println("CENTER Y"+centerY);
		// System.out.println("START X"+startX);
		// System.out.println("END X"+endX);

		//Creating the event for interaction (touch)
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		//Sequence that uses the interaction event created before
		Sequence swipe = new Sequence(finger, 1);
		//Action to perform
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(miliseconds), PointerInput.Origin.viewport(), centerX, (int)endY));
		swipe.addAction(finger.createPointerUp(0));
		
		driver.get().perform(Arrays.asList(swipe));
	}

	public void swipeElementDown(By from_locator, int miliseconds) {

		WebElement scrollable = find(from_locator);

		//Identifying coordinates of the scrollable element
		int centerX = scrollable.getRect().x + (scrollable.getSize().width/2);
		double startY = scrollable.getRect().y + (scrollable.getSize().height * 0.9);
		double endY = scrollable.getRect().y + (scrollable.getSize().height * 0.1);
		// int startY = scrollable.getRect().y + (scrollable.getSize().height/2);

		// System.out.println("CENTER Y"+centerY);
		// System.out.println("START X"+startX);
		// System.out.println("END X"+endX);

		//Creating the event for interaction (touch)
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		//Sequence that uses the interaction event created before
		Sequence swipe = new Sequence(finger, 1);
		//Action to perform
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)endY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(miliseconds), PointerInput.Origin.viewport(), centerX, (int)startY));
		swipe.addAction(finger.createPointerUp(0));
		
		driver.get().perform(Arrays.asList(swipe));
	}
	
//	FluentWait<AppiumDriver> wait = new FluentWait<AppiumDriver>(driver)
//	        .withTimeout(Duration.ofSeconds(10))
//	        .pollingEvery(Duration.ofMillis(250))
//	        .ignoring(NoSuchElementException.class)
//	        .ignoring(TimeoutException.class);
//	
//	public WebElement waitToBeVisible(WebElement locator) {
//		
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(null));
//		
//	}

//	protected IOSElement find(By locator) {
//		return driver.findElement(locator);
//	}
//	
//	protected List<IOSElement> findAll(By locator) {
//		return driver.findElements(locator);
//	}
	
//	protected void click(By locator) {
//		waitForElementToBeClickable(locator);
//		find(locator).click();
//	}
//	
//	protected String text(By locator) {
//		waitForElementToBeClickable(locator);
//		String text = find(locator).getText();
//		return text;
//	}
//	
//	protected void type(By locator, String text) {
//		waitForElementToBeVisible(locator);
//		find(locator).sendKeys(text);
//	}
//	
//	protected void assert_text(By locator, String text) {
//		Assert.assertEquals(text(locator), text, "Text is not equal.\nText found: "+text(locator)+"\nText expected: "+text+"\n");
//	}
//	
//	protected void assert_contains_text(By locator, String text) {
//		Assert.assertEquals(text(locator).contains(text), "Text is not equal.\nText found: "+text(locator)+"\nText expected: "+text+"\n");
//	}
//	
//	protected void assert_element_is_displayed(By locator) {
//		waitForElementToBeVisible(locator);
//		WebElement element = find(locator);
//		Assert.assertTrue(element.isDisplayed(), "The element is not displayed: "+locator);
//	}
//	
//	protected Boolean check_if_element_is_present(By locator) {
//		try {
////			waitForElementToBeVisible(locator);
//			WebElement element = find(locator);
//			return element.isDisplayed();
//		}catch (NoSuchElementException e){
//			return false;
//		}catch (StaleElementReferenceException e){
//		return false;
//	}
//	}
//	
//	private WebDriverWait wait_element() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		return wait;
//	}
//	
//	protected void waitForElementToBeVisible(By locator) {
//		
//		wait_element().until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}
//	
//	protected void waitForElementToBeClickable(By locator) {
//		
//		wait_element().until(ExpectedConditions.elementToBeClickable(locator));
//	}
	 
	
//	private void wait_for(ExpectedCondition<AndroidElement> condition, Duration timeout) {
//		
//		timeout = timeout != null ? timeout : Duration.ofSeconds(15);
//		WebDriverWait wait = new AndroidDriver(driver, timeout);
//		wait.until(condition);
//	}
//	
//	protected void waitForElementToBeVisible(By locator, Duration... timeout) {
//		
//		int attempts = 0;
//		while(attempts < 2) {
//			try {
//				wait_for(ExpectedConditions.visibilityOfElementLocated(locator), (timeout.length > 0 ? timeout[0] : null));
//			}catch(StaleElementReferenceException error) {
//			}
//		
//			attempts ++;
//		}
//	}
//		
//	protected void waitForElementToBeClickable(By locator, Duration... timeout) {
//		
//		int attempts = 0;
//		while(attempts < 2) {
//			try {
//				wait_for(ExpectedConditions.elementToBeClickable(locator), (timeout.length > 0 ? timeout[0] : null));
//			}catch(StaleElementReferenceException error) {
//			}
//		
//			attempts ++;
//		}
//	}
}