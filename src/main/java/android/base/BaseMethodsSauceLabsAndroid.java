package android.base;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import appium.base.BaseMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseMethodsSauceLabsAndroid extends BaseMethods{

	// protected static AndroidDriver <WebElement> driver;
	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	protected Logger log;
	protected static String testSuiteName;
	protected static String testName;
	// protected static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<ExtentTest>();
	// protected static ExtentReports report = reporter();
	// protected static ExtentTest test;


	public void initSauceLabsSession(ITestContext ctx, String platform, String version, String device, List<String> tagsList) throws MalformedURLException, IOException{

		// testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(ctx.getCurrentXmlTest().getName());
		// testSuiteName = ctx.getSuite().getName();

		System.out.println("CTX: "+ctx);
		System.out.println("PLATFORM: "+platform);
		System.out.println("VERSION: "+version);
		System.out.println("DEVICE: "+device);

		DesiredCapabilities caps = new DesiredCapabilities();
		URL saucelabsUrl = new URL("https://jcgularte:636020b5-5aea-420c-8d29-01d7b96233db@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		// String app_uat = "storage:filename=app-uat-release (8).apk";
		String app_qa = "storage:filename=app-qa-release.apk";
		// String app_qa2 = "storage:filename=app-qa-release (3).apk";

		caps.setCapability("appium:platformVersion", version);
		caps.setCapability("platformName", platform);
		caps.setCapability("appium:deviceName", device);
		caps.setCapability("appium:app", app_qa); // The filename of the mobile app
		// caps.setCapability("tunnelIdentifier", "66cb2959c5fb4edba9c8d0da1949beab");
		// caps.setCapability("appium:autoAcceptAlerts", true);
		// caps.setCapability("appium:autoGrantPermissions", true);

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "1.22.1");
		sauceOptions.setCapability("build", "build-1");
		sauceOptions.setCapability("tags", tagsList);
		//Tunnel setup
		// sauceOptions.setCapability("tunnelName", "jcgularte_tunnel");
		// sauceOptions.setCapability("avoidProxy", true);

		sauceOptions.setCapability("name", ctx.getCurrentXmlTest().getName());
		caps.setCapability("sauce:options", sauceOptions);

		driver.set(new AndroidDriver(saucelabsUrl, caps));
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result){

		((JavascriptExecutor) driver.get()).executeScript("sauce:job-result="+(result.isSuccess() ? "passed" : "failed"));

		driver.get().quit();
		driver.remove();
	}

	//Take screenshot
	public static String takeScreenshot(String name) {
		
		File scrFile = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
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
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
	
	/** Get logs from browser console */
	protected List<LogEntry> getBrowserLogs() {
		LogEntries log = driver.get().manage().logs().get("browser");
		List<LogEntry> logList = log.getAll();
		return logList;
	}
}