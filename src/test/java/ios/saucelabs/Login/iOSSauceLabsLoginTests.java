package ios.saucelabs.Login;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import ios.base.BaseMethodsSauceLabsiOS;
import ios.screens.AccountScreeniOS;
import ios.screens.DashboardScreeniOS;
import ios.screens.LoginScreeniOS;
import ios.screens.WelcomeScreeniOS;

public class iOSSauceLabsLoginTests extends BaseMethodsSauceLabsiOS{
	
	@Test (dataProvider="saucelabsiOSRealDevices")
	public void positiveLogin(ITestContext ctx, String platform, String version, String device) throws IOException{

		List<String> tags = new ArrayList<>();
		tags.add("Reservations");
		initSauceLabsSession(ctx, platform, version, device, tags);
		
		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		AccountScreeniOS account = new AccountScreeniOS(driver, log);
		LoginScreeniOS login = new LoginScreeniOS(driver, log);

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		dashboard.verifyUserIsLoggedIn();

		Assert.assertTrue(true);

	}
	
	// @Parameters({ "username", "password", "errorMsg" })
	// @Test
	// public void negativeLoginWithInvalidCredentials(String username, String password, String errorMsg) throws MalformedURLException{
		
	// 	WelcomeScreenAndroid welcome = new WelcomeScreenAndroid(driver, log);
	// 	DashboardScreenAndroid dashboard = new DashboardScreenAndroid(driver, log);
	// 	AccountScreenAndroid account = new AccountScreenAndroid(driver, log);
	// 	LoginScreenAndroid login = new LoginScreenAndroid(driver, log);

	// 	welcome.clickOnLetsParkButton();
	// 	dashboard.setInitialConfigurations();
	// 	dashboard.goToAccountScreen();
	// 	account.goToLoginScreen();
	// 	login.negativeLoginProcess(username, password, errorMsg);
		
	// }
	
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
