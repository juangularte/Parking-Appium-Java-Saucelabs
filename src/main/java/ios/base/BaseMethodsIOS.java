package ios.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import appium.base.BaseMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseMethodsIOS extends BaseMethods{
	
//	protected static IOSDriver<IOSElement> driver;
	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	
	protected Logger log;
	static AppiumDriverLocalService appium;
	protected static String testSuiteName;
	protected static String testName;

	@BeforeClass(alwaysRun = true)
	public void setCapabilities(ITestContext ctx) throws IOException {
		
		// startAppium();
		
		String testName = ctx.getCurrentXmlTest().getName(); //to get the name of the test suite
		log = LogManager.getLogger(testName);
		
		testSuiteName = ctx.getSuite().getName();
//		this.testMethodName = method.getName();
		
		File appDir = new File("src/main/resources");
		DesiredCapabilities caps = new DesiredCapabilities();
		
		File app = new File(appDir, getPropData("iOSApp"));

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.5");
		caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "7Y5H54G6U7");
		caps.setCapability(MobileCapabilityType.UDID, "5e52703771b1d814bc75d52327f255f80a88d4cc");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OGA's iPhone");
		caps.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "com.spplus.parkingdevelopment");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		// caps.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS, 50000);
//		caps.setCapability("commandTimeouts", "12000");
		
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver.set(new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps));
		log.info("App is up and running.");
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public AppiumDriver getDriver(){

		return driver.get();
	}
	
	@AfterClass(alwaysRun = true)
	public void shutDownApp() throws IOException {
//		driver.close();
		driver.get().quit();
		log.info("App closed.");
		// stopAppium();
	}
	
//	@AfterSuite
//	public void shutDownAppium() {
//		stopAppium();
//	}
	
	public static String takeScreenshot(String name) {
		
		File scrFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") //main directory
				+ File.separator + "test-output"
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate()
				+ File.separator + getSystemTime()
				+ File.separator + testSuiteName
				+ File.separator + name + ".png";
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
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.get().manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}

}
