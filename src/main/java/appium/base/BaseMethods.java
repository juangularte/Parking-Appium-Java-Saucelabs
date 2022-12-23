package appium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseMethods {
	
//	protected static IOSDriver<IOSElement> driver;
	static AppiumDriverLocalService appium;
	protected static FileInputStream propFile;
	protected static Properties prop;
	protected static ExtentSparkReporter reportLocation;
	protected static ExtentReports report;
	
	public static void sleep(int s) throws InterruptedException {
		Thread.sleep(s);
	}
	
	protected static ExtentReports reporter(String platform, String env) {
		
		reportLocation = new ExtentSparkReporter("test-output/reports/extent-reports/"+platform+env+"ExecutionReport.html");
		reportLocation.config().setReportName(platform);
		reportLocation.config().setDocumentTitle(platform+" Automation Framework");
		reportLocation.config().setTheme(Theme.DARK);
		reportLocation.config().setEncoding("utf-8");
		reportLocation.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		
		report = new ExtentReports();
		report.attachReporter(reportLocation);
		report.setSystemInfo(platform+" Tests", "Juan Gularte");
		
		return report;
		
	}
	
	public static String getPropData(String parameter) throws IOException {
		propFile = new FileInputStream("src/main/resources/global.properties");
		prop = new Properties();
		prop.load(propFile);
		return (String) prop.get(parameter);
	}

	@DataProvider(name = "csvReader")
	public static Iterator<Object[]> csvReader(Method method) {
		List<Object[]> list = new ArrayList<Object[]>();
		String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "DataProviders" + File.separator + method.getDeclaringClass().getSimpleName() + File.separator
				+ method.getName() + ".csv";
		//TODO Make pathname as parameter
		File file = new File(pathname);
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			String[] keys = reader.readNext();
			if (keys != null) {
				String[] dataParts;
				while ((dataParts = reader.readNext()) != null) {
					Map<String, String> testData = new HashMap<String, String>();
					for (int i = 0; i < keys.length; i++) {
						testData.put(keys[i], dataParts[i]);
					}
					list.add(new Object[] { testData });
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File " + pathname + " was not found.\n" + e.getStackTrace().toString());
		} catch (IOException e) {
			throw new RuntimeException("Could not read " + pathname + " file.\n" + e.getStackTrace().toString());
		} catch (CsvValidationException e) {
			e.printStackTrace();
		}
		return list.iterator();
	}

	// @DataProvider(name = "saucelabsAndroidDevices", parallel = true)
	// public static Object[][] saucelabsAndroidDevices() throws IOException {
	// 	return new Object[][]{
	// 		// Format: {[Platform], [OS Version], [Device], [File_id]}
	// 		new Object[]{"Android", "12", "Samsung.Galaxy.", "storage:filename="+getPropData("saucelabsAndroidApp")}, //Looks for any Samsung Galaxy device using Android 12
	// 		new Object[]{"Android", "11", "Google.*", "storage:filename="+getPropData("saucelabsAndroidApp")}, //Looks for any Google device using Android 11
	// 		new Object[]{"Android", "", "^(?=Nokia.|Oppo.|Huawei.|Xiaomi.).*", "storage:filename="+getPropData("saucelabsAndroidApp")} //Looks for any Nokia, Oppo, Huawei, or Xiaomi device on any Android version
	// 	};
	// }

	@DataProvider(name = "saucelabsAndroidSimulators", parallel = true)
	public static Object[][] saucelabsAndroidSimulators() throws IOException {
		return new Object[][]{
			// Format: {[Platform], [OS Version], [Device], [File_id]}
			// new Object[]{"Android", "12", "Google Pixel 6 GoogleAPI Emulat or"},//Looks for any Samsung Galaxy device using Android 12
			new Object[]{"Android", "11", "Samsung Galaxy S20 WQHD GoogleAPI Emulator"} //Looks for any Google device using Android 11
			// new Object[]{"Android", "", "^(?=Nokia.|Oppo.|Huawei.|Xiaomi.).*", "storage:filename=app-uat-release.apk"} //Looks for any Nokia, Oppo, Huawei, or Xiaomi device on any Android version
		};
	}

	@DataProvider(name = "saucelabsAndroidRealDevices", parallel = true)
	public static Object[][] saucelabsAndroidRealDevices() throws IOException {
		
		return new Object[][]{
			// Format: {[Platform], [OS Version], [Device], [File_id]}
			// Android Apps - Multiple Devices
			new Object[]{"Android", "11", "Samsung Galaxy S20 WQHD GoogleAPI Emulator"}, //Looks for any Google device using Android 11			
			// new Object[]{"Android", "12", "Samsung Galaxy S21 5G"}, // Samsung Galaxy 21 - SM-G991U
			// new Object[]{"Android", "12", "Samsung Galaxy S22 Ultra 5G"}, // Samsung Galaxy Ultra - SM-G998U
			// new Object[]{"Android", "11", "Samsung Galaxy S10"}, // Samsung Galaxy S10 - SM-G973U
			// new Object[]{"Android", "10", "Samsung Galaxy S9"} // Samsung Galaxy S9 - SM-G960U
			// new Object[]{"Android", "", "Samsung.*", "storage:filename=app-uat-release.apk"} //Looks for any Samsung real device on any Android version
		};
	}

	@DataProvider(name = "saucelabsiOSRealDevices", parallel = true)
	public static Object[][] saucelabsiOSRealDevices() throws IOException {
		return new Object[][]{
			// Format: {[Platform], [OS Version], [Device], [File_id]}
				
				
			new Object[]{"iOS", "15", "iPhone 13 Pro Max"},// Latest iPhone 13, 12, 11, X
			new Object[]{"iOS", "14", "iPhone 12"} //Looks for any Google device using Android 11
			// new Object[]{"Android", "", "^(?=Nokia.|Oppo.|Huawei.|Xiaomi.).*", "storage:filename=app-uat-release.apk"} //Looks for any Nokia, Oppo, Huawei, or Xiaomi device on any Android version
		};
	}

	@DataProvider(name = "saucelabsiOSSimulators", parallel = true)
	public static Object[][] saucelabsiOSSimulators() throws IOException {
		return new Object[][]{
			// Format: {[Platform], [OS Version], [Device], [File_id]}
			new Object[]{"iOS", "15", "iPhone 13 Pro Max", "storage:filename=Parking Dev.ipa"},//Looks for any Samsung Galaxy device using Android 12
			// new Object[]{"iOS", "13", "iPhone X", "storage:filename=Parking Dev.ipa"} //Looks for any Google device using Android 11
			// new Object[]{"Android", "", "^(?=Nokia.|Oppo.|Huawei.|Xiaomi.).*", "storage:filename=app-uat-release.apk"} //Looks for any Nokia, Oppo, Huawei, or Xiaomi device on any Android version
		};
	}
	
	@DataProvider(name = "jsonReader")
	public static Object [][] jsonReader() throws IOException{
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/resources/DataProviders/Json/tags.json");
		return new Object [][] { 	
									{data.get(0)}
								};
	}
	
	public static List<HashMap<String, String>> getJsonData(String jsonPath) throws IOException{
		
//		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/resources/DataProviders/Json/negativeLoginErrors.json"));
		String jsonContent = FileUtils.readFileToString(new File(jsonPath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}
	 
	public boolean checkIfServerIsRunning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public void startAppium() throws NumberFormatException, IOException {
		
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		// Tell builder where node is installed. Or set this path in an environment variable named NODE_PATH
		builder.usingDriverExecutable(new File(getPropData("node")));
		// Tell builder where Appium is installed. Or set this path in an environment variable named APPIUM_PATH
		builder.withAppiumJS(new File(getPropData("mainJS")));
		builder.withIPAddress(getPropData("ipAddress"));
		builder.withArgument(() -> "--base-path", "/wd/hub");
		builder.usingPort(Integer.parseInt(getPropData("port")));
		
		boolean isAppiumRunning = checkIfServerIsRunning(Integer.parseInt(getPropData("port")));
		
		if(isAppiumRunning == false) {
			appium = AppiumDriverLocalService.buildService(builder);
			appium.start();
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopAppium() throws NumberFormatException, IOException {
	
		boolean isAppiumRunning = checkIfServerIsRunning(Integer.parseInt(getPropData("port")));
		
		if(isAppiumRunning == true) {
	//        	appium.close();
			appium.stop();
			
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}