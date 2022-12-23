package android.local.Login;
import java.net.MalformedURLException;
//import java.util.HashMap;
//import java.util.Map;

import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import android.base.BaseMethodsAndroid;
import android.screens.AccountScreenAndroid;
import android.screens.DashboardScreenAndroid;
import android.screens.LoginScreenAndroid;
import android.screens.WelcomeScreenAndroid;

public class AndroidLoginTests extends BaseMethodsAndroid{
	
//	public FirstTest(AndroidDriver<AndroidElement> driver) {
//		super(driver);
//	}
		
//	AndroidDriver<AndroidElement> driver;
	
	@Parameters({ "username", "password" })
	@Test
	public void positiveLogin(String username, String password) throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		// try {
		// 	welcome.clickOnLetsParkButton();
		// 	dashboard.setConfigurationsAndGoToAccountScreen();
		// 	account.goToLoginScreen();
		// 	login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		// } catch (TimeoutException e) {
		// 	log.info("Initial configurations have been set already.");
		// 	try {
		// 		dashboard.goToAccountScreen();
		// 		account.goToLoginScreen();
		// 		login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		// 	} catch (TimeoutException i) {
		// 		log.info("User is already logged in.");
		// 	}
		// }

		// dashboard.verifyUserIsLoggedInAndGoToAccountScreen();

		welcome.clickOnLetsParkButton();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		login.positiveLoginProcess(username, password);
		dashboard.verifyUserIsLoggedIn();
	}
	
	@Parameters({ "username", "password"})
	@Test
	public void negativeLoginWithInvalidCredentials(String username, String password) throws MalformedURLException{
		
		WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
		DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
		AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
		LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

		welcome.clickOnLetsParkButton();
		// dashboard.setInitialConfigurations();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		login.negativeLoginProcess(username, password);
		
	}
	
//	@Test(dataProvider = "csvReader")//, dataProviderClass = CsvDataProviders.class)
//	public void negativeLoginErrors(Map<String, String> testData) throws MalformedURLException{
//		
//		String username = testData.get("username");
//		String password = testData.get("password");
//		String expected_error_msg = testData.get("errorMessage");
//		
//		WelcomeScreenAndroid welcome_screen = new WelcomeScreenAndroid(driver, log);
//		
//		welcome_screen.goToLoginScreen();
//		
//	}
//	
//	@Test(dataProvider = "jsonReader")//, dataProviderClass = CsvDataProviders.class)
//	public void negativeLoginErrorsJson(HashMap<String, String> testData) throws MalformedURLException{
//		
//		String username = testData.get("username");
//		String password = testData.get("password");
//		String expected_error_msg = testData.get("errorMessage");
//		
//		WelcomeScreenAndroid welcome_screen = new WelcomeScreenAndroid(driver, log);
//		
//		welcome_screen.goToLoginScreen();
//		
//	}
}
