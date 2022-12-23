package ios.local.Login;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import ios.base.BaseMethodsIOS;
import ios.screens.AccountScreeniOS;
import ios.screens.DashboardScreeniOS;
import ios.screens.LoginScreeniOS;
import ios.screens.WelcomeScreeniOS;

public class iOSLoginTests extends BaseMethodsIOS{
	
	// @Parameters({ "username", "password" })
	@Test
	public void positiveLogin() throws MalformedURLException{

		WelcomeScreeniOS welcome = new WelcomeScreeniOS(driver, log);
		DashboardScreeniOS dashboard = new DashboardScreeniOS(driver, log);
		AccountScreeniOS account = new AccountScreeniOS(driver, log);
		LoginScreeniOS login = new LoginScreeniOS(driver, log);

		welcome.checkFirstTimeOpeningAppAndClickOnLetsParkButton();
		dashboard.setConfigurationsAndGoToAccountScreen();
		account.goToLoginScreen();
		// login.positiveLoginProcess("jcgularte@spplus.com", "Helloworld10");
		login.positiveLoginProcess("parkingtest2@mailinator.com", "Helloworld10");
		dashboard.verifyUserIsLoggedIn();
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
