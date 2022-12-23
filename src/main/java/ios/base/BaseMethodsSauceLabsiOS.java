package ios.base;
import java.io.File;
import java.io.IOException;
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
import io.appium.java_client.ios.IOSDriver;

public class BaseMethodsSauceLabsiOS extends BaseMethods{
	
	
	// protected static AndroidDriver <WebElement> driver;
	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	public static AppiumDriver driver_instance;
	protected static Logger log;
	protected static String testSuiteName;
	protected static String testName;
	static String runner;
	public static TakesScreenshot screenshot;

	public void initSauceLabsSession(ITestContext ctx, String platform, String version, String device, List<String> tagsList) throws IOException{
	// public void initSauceLabsSession(ITestContext ctx, String platform, String version, String device) throws IOException{
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		// testSuiteName = ctx.getSuite().getName();

		System.out.println("CTX: "+ctx);
		System.out.println("PLATFORM: "+platform);
		System.out.println("VERSION: "+version);
		System.out.println("DEVICE: "+device);

		DesiredCapabilities caps = new DesiredCapabilities();
		URL saucelabsUrl = new URL("https://jcgularte:636020b5-5aea-420c-8d29-01d7b96233db@ondemand.us-west-1.saucelabs.com:443/wd/hub");
		String app = "storage:filename=Parking Dev (3).ipa";

		caps.setCapability("appium:platformVersion", version);
		caps.setCapability("platformName", platform);
		caps.setCapability("appium:deviceName", device);
		caps.setCapability("appium:app", app); // The filename of the mobile app
		
		MutableCapabilities sauceOptions = new MutableCapabilities();
		// sauceOptions.setCapability("appiumVersion", "1.22.3");
		// sauceOptions.setCapability("build", "<your build id>");
		sauceOptions.setCapability("tags", tagsList);
		sauceOptions.setCapability("name", ctx.getCurrentXmlTest().getName());
		caps.setCapability("sauce:options", sauceOptions);

		driver.set(new IOSDriver(saucelabsUrl, caps));

		driver_instance = driver.get();
	}
	
	// @BeforeMethod(alwaysRun = true)
	// public void goToWelcomeScreen() throws IOException {

	// 	runner = getPropData("runner");

	// 	if(runner.equals("local")){
	// 		Activity welcomeScreenActivity = new Activity("com.spplus.parking.develop","com.spplus.parking.presentation.splash.SplashActivity");
	// 		driver.startActivity(welcomeScreenActivity);
	// 	}
	// }

	public AppiumDriver getDriver(){

		return driver.get();
	}
	
	// @AfterClass(alwaysRun = true)
	// public void shutDown() throws IOException {
	// 	driver.get().quit();
	// 	// stopAppium();
	// }

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result){

		((JavascriptExecutor) driver.get()).executeScript("sauce:job-result="+(result.isSuccess() ? "passed" : "failed"));

		driver.get().quit();
		driver.remove();
	}
//	
//	@AfterClass(alwaysRun = true)
//	public void stopAppium() {
//		
//	}
	
	//Take screenshot
	public static String takeScreenshot(String name) {
		
		File scrFile = ((TakesScreenshot) driver_instance).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")//main directory
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
