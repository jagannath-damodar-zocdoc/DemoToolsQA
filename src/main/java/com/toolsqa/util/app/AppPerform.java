package com.toolsqa.util.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toolsqa.pageobjects.AccountPage;
import com.toolsqa.pageobjects.HomePage;
import com.toolsqa.pageobjects.RegisterPage;

public class AppPerform {
	
	public static final int  explicitWaitTime = 90 ; 

	public static final void customExplicitWait(WebDriver aDriver , WebElement aElement){
		new WebDriverWait(aDriver, AppPerform.explicitWaitTime).until(ExpectedConditions.visibilityOf(aElement));		
	}	

	public static RegisterPage navigateToRegisterPage(WebDriver aDriver) {		
		 HomePage hPage = new HomePage(aDriver);
		 AccountPage accountPage = hPage.clickLinkMyAccount();		
		 RegisterPage registerPage =  accountPage.clickLinkRegister();		
		 return registerPage;				
	}
	
}




