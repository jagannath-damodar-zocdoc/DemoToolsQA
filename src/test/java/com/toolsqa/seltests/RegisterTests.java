package com.toolsqa.seltests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.toolsqa.dataobjects.RegistrationData;
import com.toolsqa.pageobjects.RegisterPage;
import com.toolsqa.util.app.AppPerform;
import com.toolsqa.util.testng.BaseTestNGClass;

public class RegisterTests extends BaseTestNGClass {

	@Test( groups = {"register"} ,enabled=true ,
			dataProvider = "regData" , dataProviderClass = RegistrationData.class , 
			dependsOnMethods = "RegisterPageHasAllRequiredElements" )
	public void registerWithValidUsernameAndPasswd(RegistrationData aTestdata)  {
		// registering with same username and password results is not permitted and results in failure
		String username = aTestdata.getUsername() + new Random().nextInt(10000);
		String emailId = aTestdata.getEmailId() + new Random().nextInt(10000)+ "@gmail.com";
	  
		driver.get(appURL);	  	   
		RegisterPage regPage  = AppPerform.navigateToRegisterPage(driver);
		regPage.registerWithUsernameAndEmailId(username,emailId);	 
		String registerResult = regPage.getRegisterResultTextLabel();						
		Assert.assertEquals(registerResult, "Registration complete. Please check your email.");	  	  
  }
 	
	@Test( groups = { "register" , "regression" } , enabled=true )
	public void RegisterPageHasAllRequiredElements() {			
		driver.get(appURL);
		RegisterPage regPage = AppPerform.navigateToRegisterPage(driver);		
		SoftAssert sftAssert = new SoftAssert(); 		
		//sftAssert.assertEquals(driver.getTitle(), "ONLINE STORE | Toolsqa Dummy Test site");
		sftAssert.assertTrue(regPage.isTextBoxEmailIdPresent(), "TextBoxEmailIdPresent");
		sftAssert.assertTrue(regPage.isbtnRegisterPresent(),"btnRegisterPresent");	
		sftAssert.assertTrue(regPage.isRegisterResultTextLabelPresent(),"RegisterResultTextLabelPresent");
		sftAssert.assertTrue(regPage.isLinkLogInPresent(),"LinkLogInPresent");
		sftAssert.assertTrue(regPage.isLinkLostPasswordPresent(),"LinkLostPasswordPresent");
		sftAssert.assertTrue(regPage.isLinkToOnlineStorePresent(),"isLinkToOnlineStorePresent");		
		sftAssert.assertTrue(regPage.isTextBoxUserNamePresent(),"isTextBoxUserNamePresent");		
		sftAssert.assertAll();			
	}
	
	
	@Test(enabled=true , groups = { "register" } )
	public void registerWithAlreadyRegisteredEmailId() {
		
		String username1 = "Jagan" + new Random().nextInt(10000);
		String username2 = "Jagan" + new Random().nextInt(10000);
		
		String emailId = "Jagan" + new Random().nextInt(10000)+ "@gmail.com";
		
		driver.get(appURL);
		AppPerform.navigateToRegisterPage(driver).registerWithUsernameAndEmailId(username1, emailId);
		
		// register again different username but with same emailId
		driver.navigate().to(appURL);
		RegisterPage regPage = AppPerform.navigateToRegisterPage(driver) ;
		regPage.registerWithUsernameAndEmailId(username2, emailId);
		String registerResultMessage = regPage.getLoginErrorText(); 						
		Assert.assertEquals(registerResultMessage, "ERROR: This email is already registered, please choose another one.");
		
	}
	
	@Test(enabled=true , groups = { "register" } )
	public void registerWithAlreadyRegisteredUsername() {
		
		String username = "Jagan" + new Random().nextInt(10000);		
		String emailId1 = "Jagan" + new Random().nextInt(10000)+ "@gmail.com";
		String emailId2 = "Jagan" + new Random().nextInt(10000)+ "@gmail.com";
		
		driver.get(appURL);
		AppPerform.navigateToRegisterPage(driver).registerWithUsernameAndEmailId(username, emailId1);
		
		// register again with same emailId but different username
		driver.navigate().to(appURL);
		RegisterPage regPage = AppPerform.navigateToRegisterPage(driver) ;
		regPage.registerWithUsernameAndEmailId(username, emailId2);
		String registerResultMessage = regPage.getLoginErrorText(); 		
		Assert.assertEquals(registerResultMessage, "ERROR: This username is already registered. Please choose another one.");				
	
	}
	
}

