package android.base;

import java.time.Duration;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import appium.base.BaseActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class BaseActionsAndroid extends BaseActions{

	// protected ThreadLocal<AppiumDriver> driver; //to make it available for other class that extends this one
	public Logger log; //variable to control and print the logs
	

	public BaseActionsAndroid(ThreadLocal<AppiumDriver> driver, Logger log) {
		super(driver, log);
		this.log = log;
	}
	
	public void scrollToText(String text) {

		// String bounds = attribute(from_locator, "bounds");
		// // System.out.println("BOUNDS 1: "+bounds);
		// String startX = bounds.replace("[", "")
		// 						.substring(0, bounds.indexOf(","))
		// 						.replace(",","");

		// String startY = bounds.replace(bounds.substring(0, bounds.indexOf(","))+",","")
		// 						.split("]")[0];

		// // System.out.println("X: "+startX);
		// // System.out.println("Y: "+startY);

		// // int startX_int = Integer.valueOf(startX);
		// int startY_int = Integer.valueOf(startY);
		
		// while(true){
		// 	log.info("Scrolling down.");
		// 	new TouchAction(driver.get())
		// 		.longPress(PointOption.point(Integer.valueOf(startX), Integer.valueOf(startY)))
		// 		// a bit more reliable when we add small wait
		// 	//    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
		// 	//    .moveTo(PointOption.point(startX_int - 1500, Integer.valueOf(startY)))
		// 		.moveTo(PointOption.point(Integer.valueOf(startX), startY_int-200))
		// 		.release().perform();

		// 	if(check_if_element_is_present(locator_to_appear).equals(true)){
		// 		log.info("Element found after scrolling.");
		// 		break;
		// 	}
		// }
		
		driver.get().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
		log.info("Scroll to find '"+text+"'");

		// JavascriptExecutor js = (JavascriptExecutor) driver.get();
		// HashMap<String, Object> scrollObject = new HashMap<String, Object>();
		// scrollObject.put("direction", "down");
		// scrollObject.put("value", text);
		// js.executeScript("mobile: swipe", scrollObject);
	}

	// @SuppressWarnings("")
	public void swipeElementToLeft(By from_locator) {		
		//METHOD 1
		// String bounds = attribute(from_locator, "bounds");
		// // System.out.println("BOUNDS 1: "+bounds);
		// String startX = bounds.replace("[", "")
		// 						.substring(0, bounds.indexOf(","))
		// 						.replace(",","");

		// String startY = bounds.replace(bounds.substring(0, bounds.indexOf(","))+",","")
		// 						.split("]")[0];

		// // System.out.println("X: "+startX);
		// // System.out.println("Y: "+startY);

		// int startX_int = Integer.valueOf(startX);

		// Map<String, Object> args = new HashMap<>();
		// args.put("command", "input");
		// args.put("args", Lists.newArrayList("swipe", startX, startY, startX_int-700, startY));
		// driver.get().executeScript("mobile: shell", args);

		//METHOD 2
		// String bounds = attribute(from_locator, "bounds");
		// // System.out.println("BOUNDS 1: "+bounds);
		// String startX = bounds.replace("[", "")
		// 						.substring(0, bounds.indexOf(","))
		// 						.replace(",","");

		// String startY = bounds.replace(bounds.substring(0, bounds.indexOf(","))+",","")
		// 						.split("]")[0];

		// // int startX_int = Integer.valueOf(startX);

		// new TouchAction(driver.get())
		// 	   .longPress(PointOption.point(Integer.valueOf(startX), Integer.valueOf(startY)))
		// 	   // a bit more reliable when we add small wait
		// 	//    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
		// 	//    .moveTo(PointOption.point(startX_int - 1500, Integer.valueOf(startY)))
		// 		.moveTo(PointOption.point(0, Integer.valueOf(startY)))
		// 	   .release().perform();

		//METHOD 3
		// JavascriptExecutor js = (JavascriptExecutor) driver.get();
		// HashMap<String, String> scrollObject = new HashMap<String, String>();
		// scrollObject.put("direction", "down");
		// scrollObject.put("value", "PARKING PASS");
		// js.executeScript("mobile: swipe", scrollObject);

		//METHOD 4
		//HORIZONTAL SCROLLING

		//Searching scrollable element
		WebElement scrollable = find(from_locator);

		//Identifying coordinates of the scrollable element
		int centerY = scrollable.getRect().y + (scrollable.getSize().height/2);
		double startX = scrollable.getRect().x + (scrollable.getSize().width * 0.9);
		double endX = scrollable.getRect().x + (scrollable.getSize().width * 0.1);

		// System.out.println("CENTER Y"+centerY);
		// System.out.println("START X"+startX);
		// System.out.println("END X"+endX);

		//Creating the event for interaction (touch)
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		//Sequence that uses the interaction event created before
		Sequence swipe = new Sequence(finger, 1);
		//Action to perform
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int)startX, centerY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int)endX, centerY));
		swipe.addAction(finger.createPointerUp(0));
		
		driver.get().perform(Arrays.asList(swipe));
	}

	public void swipeElementUp(By from_locator, int miliseconds) {

		WebElement scrollable = find(from_locator);

		//Identifying coordinates of the scrollable element
		int centerX = scrollable.getRect().x + (scrollable.getSize().width/2);
		double startY = scrollable.getRect().y + (scrollable.getSize().height * 0.9);
		double endX = scrollable.getRect().y + (scrollable.getSize().height * 0.1);

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
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(miliseconds), PointerInput.Origin.viewport(), centerX, (int)endX));
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
	// @AndroidFindBy(xpath = "")
	// public WebElement element;

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
