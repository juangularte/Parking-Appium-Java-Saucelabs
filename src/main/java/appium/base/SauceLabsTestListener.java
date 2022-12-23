package appium.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import android.base.BaseMethodsSauceLabsAndroid;
// import ios.base.BaseMethodsIOS;
// import io.appium.java_client.AppiumDriver;
import ios.base.BaseMethodsSauceLabsiOS;

public class SauceLabsTestListener implements ITestListener{
	
	// AppiumDriver driver;
	Logger log;
	String testName;
	String testMethodName;
	ExtentReports androidReport = BaseMethods.reporter("Android","SauceLabs");
	ExtentReports iOSReport = BaseMethods.reporter("iOS","SauceLabs");
	ExtentTest test;
	ThreadLocal<ExtentTest> testThread = new ThreadLocal<ExtentTest>();


	@Override
	public void onTestStart(ITestResult result) {
		// this.testMethodName = result.getMethod().getMethodName();
		// if(result.getTestContext().getSuite().getName().contains("Android")){
		if(testName.contains("Android")){
			test = androidReport.createTest(result.getTestContext().getCurrentXmlTest().getName());
		}else{
			test = iOSReport.createTest(result.getTestContext().getCurrentXmlTest().getName());
		}
		// test = report.createTest(result.getTestContext().getCurrentXmlTest().getName());
		testThread.set(test);
		log.info("[Starting " + this.testName + "]");
		//TODO Add retry method
	}
	
	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		log.info("[TEST " + testName + " STARTED]");
		// test = report.createTest(testMethodName);
		// testThread.set(test);
		// test = report.createTest(context.getCurrentXmlTest().getName());
		// this.test = report.createTest(testName);
	}

	@Override
	public void onFinish(ITestContext context) {
		log.info("[ALL " + testName + " FINISHED]");
		
		if(context.getCurrentXmlTest().getSuite().getName().contains("Android")){
			androidReport.flush();
		}else{
			iOSReport.flush();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// ((JavascriptExecutor) driver).executeScript("sauce:job-result=passed");
		log.info("[Test " + result.getMethod().getMethodName() + " passed]");
		// test.log(Status.PASS, "Test Passed");
		testThread.get().log(Status.PASS, "Test Passed");
		// // BaseMethodsSauceLabsAndroid.tearDown(result);
		// BaseMethodsSauceLabsAndroid.quitDriver();
		// BaseMethodsSauceLabsAndroid.removeDriver();
		
//		test.pass(result.getThrowable());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		// try {
		// 	driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// }

		log.info("[Test " + result.getMethod().getMethodName() + " failed]");
		testThread.get().log(Status.FAIL, "Test Failed");
		testThread.get().fail(result.getThrowable());

		System.out.println(result.getTestContext().getSuite().getName());

		if(testName.contains("Android")){
			testThread.get().addScreenCaptureFromPath(BaseMethodsSauceLabsAndroid.takeScreenshot(result.getMethod().getMethodName()), result.getMethod().getMethodName());
		}else if (testName.contains("iOS")){
			testThread.get().addScreenCaptureFromPath(BaseMethodsSauceLabsiOS.takeScreenshot(result.getMethod().getMethodName()), result.getMethod().getMethodName());
		}
		
		// }
		// // BaseMethodsSauceLabsAndroid.tearDown(result);
		// BaseMethodsSauceLabsAndroid.quitDriver();
		// BaseMethodsSauceLabsAndroid.removeDriver();
		
		// else if (os.contains("IOS")) {
		// 	test.addScreenCaptureFromPath(BaseMethodsIOS.takeScreenshot(), result.getMethod().getMethodName());
		// }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("[Test " + testMethodName + " skipped]");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}
