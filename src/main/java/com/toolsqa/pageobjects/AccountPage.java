package com.toolsqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.toolsqa.util.app.AppPerform;

public class AccountPage {

	private WebDriver driver ;	
	
	public AccountPage(WebDriver aDriver){
		driver = aDriver ;		
		PageFactory.initElements(driver, this);				
	}
	@CacheLookup
	@FindBy(xpath="//*[@id='meta']/ul/li[1]/a")
	private WebElement linkRegister;
		
	public RegisterPage clickLinkRegister() {
		AppPerform.customExplicitWait(driver,linkRegister);
		linkRegister.click();
		Reporter.log(driver.getTitle() + "  Clicking on link Register");						
		return new RegisterPage(driver);						
	}
	
	
}
