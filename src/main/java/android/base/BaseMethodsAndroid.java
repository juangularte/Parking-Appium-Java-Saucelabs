package android.base;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import appium.base.BaseMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseMethodsAndroid extends BaseMethods{
	
	
	// protected static AndroidDriver <WebElement> driver;
	protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	// static AppiumDriver driver2;
	protected Logger log;
	AppiumDriverLocalService appium;
	protected static String testSuiteName;
	protected static String testName;
	static String runner;

	@BeforeClass(alwaysRun = true)
	public void setCapabilities(ITestContext ctx) throws IOException {
		
		// startAppium();
		
		String testName = ctx.getCurrentXmlTest().getName(); //to get the name of the test suite
		log = LogManager.getLogger(testName);
		testSuiteName = ctx.getSuite().getName();
		
		File appDir = new File("src/main/resources");
		File app = new File(appDir, getPropData("androidApp"));
		DesiredCapabilities caps = new DesiredCapabilities();
		// URL localUrl = new URL("http://127.0.0.1:4723/wd/hub");
		// String localUrl = "http://127.0.0.1:4723/wd/hub";

		System.out.println("TEST NAME IS: "+testName);

		caps.setCapability(MobileCapabilityType.DEVICE_NAME, getPropData("androidDevice"));
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.UDID, getPropData("androidUDID"));
		caps.setCapability("platformName", "Android");
		caps.setCapability("appActivity", "com.spplus.parking.presentation.splash.SplashActivity");
		caps.setCapability("appPackage", "com.spplus.parking.develop");
		caps.setCapability("setWebContentsDebuggingEnabled", true);
		caps.setCapability("resetKeyboard", true);
		
		// driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		// byte[] bytes = "http://127.0.0.1:4723/wd/hub".getBytes();
		// String encodedString = new String(Base64.getUrlEncoder().encode(bytes));
		driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps));
		
		// driver2 = driver.get();
		System.out.println("Session is up and running.");
	}

	public AppiumDriver getDriver(){

		return driver.get();
	}

	// public static void stopDriver() {
	// 	driver.get().quit();
	// }
	
	@AfterClass(alwaysRun = true)
	public void shutDown() throws IOException {
		// driver.get().
		driver.get().quit();
		// stopAppium();
	}
//	
//	@AfterClass(alwaysRun = true)
//	public void stopAppium() {
//		
//	}

// 	public static void getScreenshot(String name) {
// 		File scrFile = driver2.getScreenshotAs(OutputType.FILE);
// 		// File srcFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);

// 		String path = System.getProperty("user.dir")//main directory
// 				+ File.separator + "test-output" 
// 				+ File.separator + "screenshots"
// 				+ File.separator + getTodaysDate()
// 				+ File.separator + getSystemTime()
// 				+ File.separator + testSuiteName 
// 				+ File.separator + name + ".png";
// //				+ File.separator + testMethodName + ".png";
// //				+ File.separator + getSystemTime() 
// //				+ " " + fileName + ".png";		

// 		try {
// 			FileUtils.copyFile(scrFile, new File(path));
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}

// 	}

	public static String takeScreenshot(String name) {
		
//		String testName = ctx.getCurrentXmlTest().getName();
//		testSuiteName = ctx.getSuite().getName();
//		testMethodName = method.getName();
		TakesScreenshot scrShot = ((TakesScreenshot) driver.get());
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		// File srcFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir")//main directory
				+ File.separator + "test-output"
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate()
				+ File.separator + getSystemTime()
				+ File.separator + testSuiteName 
				+ File.separator + name + ".png";
//				+ File.separator + testMethodName + ".png";
//				+ File.separator + getSystemTime() 
//				+ " " + fileName + ".png";		

		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}
	
	/** Todays date in yyyyMMdd format */
	protected static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	/** Current time in HHmmssSSS */
	protected static String getSystemTime() {
		return (new SimpleDateFormat("HH-mm-ss-SSS").format(new Date()));
	}
	
	/** Get logs from browser console */
	// protected List<LogEntry> getBrowserLogs() {
	// 	LogEntries log = driver.get().manage().logs().get("browser");
	// 	List<LogEntry> logList = log.getAll();
	// 	return logList;
	// }
	
}
