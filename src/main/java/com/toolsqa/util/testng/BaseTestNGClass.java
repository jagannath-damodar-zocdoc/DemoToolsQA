package com.toolsqa.util.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTestNGClass {

	public static WebDriver driver ;
	public static String appURL ; 
	public static String browser ;
	
	@BeforeSuite
	@Parameters( { "appURL" })
	public void setAppURL(@Optional("http://store.demoqa.com/") String aAppUrl){
		BaseTestNGClass.appURL = aAppUrl ;		
		Reporter.log("Application URL ="+ appURL);
		System.out.println("Application URL ="+ appURL);				
	}
		
	@BeforeTest
	@Parameters( { "browser" } )
	public void setUpBrowser(@Optional("chrome") String brw){
		browser = brw ;
		Reporter.log("Opening Browser . Option selected ="+ brw);
		System.out.println("Opening Browser . Option selected ="+ brw);		
		if (brw.equalsIgnoreCase("chrome")){						
			System.setProperty("webdriver.chrome.driver","C:\\mySoftware\\Chrome Webdriver\\chromedriver.exe");
			driver = new ChromeDriver();						
		}else if(brw.equalsIgnoreCase("firefox")){			
			System.setProperty("webdriver.gecko.driver","C:\\mySoftware\\geckodriver\\geckodriver-v0.13.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();					
		}else if(brw.equalsIgnoreCase("ie")) {			
			System.setProperty("webdriver.ie.driver","C:\\mySoftware\\IE_Driver\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
			
			// slow typing
			//System.setProperty("webdriver.ie.driver","C:\\mySoftware\\IE_Driver\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");
			
			/*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			driver = new InternetExplorerDriver(cap);*/
			
			DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("ignoreProtectedModeSettings", true);
			//cap.setVersion("11");
			driver = new InternetExplorerDriver(cap);
			
		}else {			
			Reporter.log("Invalid Browser option = "+ brw);			
			System.out.println("Invalid Browser option = "+ brw);			
		}
		//driver.get(appURL);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS)	;
	}
		
	@AfterTest
	public void tearDownBrowser() throws InterruptedException{
		Reporter.log("Closing Browser");
		System.out.println("Closing Browser");
				
		// firefox versions has bugs because of which we are not able to quit properly.
		// Hence removing the processes manually.
		if (browser.equalsIgnoreCase("firefox")){
			try{
				System.out.println("==================================================");
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		        Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
		        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");	
			}catch (Exception e){				
				System.out.println("Exception while killing firefox or geckodriver or plugin container");
				e.printStackTrace();
			}	
		// quit normally for chrome and ie	
		}else {
			
			System.out.println("Closing driver ="+ browser );
			driver.quit();
			
		}
	}
						
}// end of class  
	

