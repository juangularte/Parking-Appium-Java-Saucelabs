package android.saucelabs.Login;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import android.base.BaseMethodsSauceLabsAndroid;
import android.screens.AccountScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.LoginScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidSauceLabsLoginTests extends BaseMethodsSauceLabsAndroid{
	
	// @Test (dataProvider="saucelabsAndroidSimulators")
	@Test(dataProvider="saucelabsAndroidRealDevices")
	// public void positiveLogin(String username, String password) throws MalformedURLException{
	public void positiveLogin(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{
		
		// ITestResult result = Reporter.getCurrentTestResult();
  		// result.setAttribute("device", device);
		// ctx.setAttribute("device", device);
		List<String> tags = new ArrayList<>();
		tags.add("Login");
		initSauceLabsSession(ctx, platform, version, device, tags);
		// parameters.toString();
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		welcome.clickOnLetsParkButton();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		dashboard.verifyUserIsLoggedIn();
		
		Assert.assertTrue( true);

	}
	
	// @Test(dataProvider="saucelabsAndroidSimulators")
	@Test(dataProvider="saucelabsAndroidRealDevices")
	// public void negativeLoginWithInvalidCredentials(String username, String password, String errorMsg) throws MalformedURLException{
	public void negativeLoginWithInvalidCredentials(ITestContext ctx, String platform, String version, String device) throws MalformedURLException, Exception{

		List<String> tags = new ArrayList<>();
		tags.add("Login");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		welcome.clickOnLetsParkButton();
		// dashboard.setInitialConfigurations();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		// login.negativeLoginProcess(username, password, errorMsg);
		login.negativeLoginProcess("jcgularte@spplus.com", "IncorrectPwd");
			
		Assert.assertTrue( true);
	}
}
