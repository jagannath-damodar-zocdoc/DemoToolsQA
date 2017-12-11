package com.toolsqa.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.toolsqa.util.app.AppPerform;

public class RegisterPage {

	private static WebDriver driver ;
	
	@CacheLookup
	@FindBy(xpath="//*[@id='user_login']")
	private WebElement textBoxUserName;

	@CacheLookup
	@FindBy(xpath="//*[@id='user_email']")
	private WebElement textBoxEmailId;

	@CacheLookup
	@FindBy(xpath="//*[@id='wp-submit']")
	private WebElement btnRegister;

	@CacheLookup
	@FindBy(xpath="//*[@id='login']/p[1]")
	private WebElement registerResultTextLabel;
	
	@FindBy(xpath="//*[@id='nav']/a[1]")
	private WebElement linkLogIn ;
	
	@FindBy(xpath="//*[@id='nav']/a[2]")		
	private WebElement linkLostPassword ;		
				
	@FindBy(xpath="//*[@id='backtoblog']/a")
	private WebElement linkToOnlineStore ;
	
	
	//*[@id="login_error"]
	
	@FindBy(xpath="//*[@id='login_error']")
	private WebElement textLabelLoginError ;
			
	
	public RegisterPage(WebDriver aDriver) {
		 driver = aDriver ;
		 PageFactory.initElements(driver, this);		 
	}
		
	public RegisterPage enterUserName(String aUserName) {
		AppPerform.customExplicitWait(driver,textBoxUserName);
		textBoxUserName.sendKeys(aUserName);
		Reporter.log(driver.getTitle() + "  Entered Username"+ aUserName);
		return this;		
	}

	public RegisterPage enterEmailId(String aEmailId) {		
		AppPerform.customExplicitWait(driver,textBoxEmailId);
		textBoxEmailId.sendKeys(aEmailId);
		Reporter.log(driver.getTitle() + "  Entered EmailId" + aEmailId);
		return this ;
	}
		
	public RegisterPage clickbtnRegister() {
		AppPerform.customExplicitWait(driver, btnRegister);
		btnRegister.click();
		Reporter.log(driver.getTitle() + "  Click Register Button");
		return this;			
	}

	public String getRegisterResultTextLabel() {
		AppPerform.customExplicitWait(driver, registerResultTextLabel);
		return registerResultTextLabel.getText() ;
	}
	
	public String getLoginErrorText(){
		AppPerform.customExplicitWait(driver, textLabelLoginError);		
		return textLabelLoginError.getText();	
	}
	
	public RegisterPage registerWithUsernameAndEmailId(String aUserName , String aEmailId){
		 enterUserName(aUserName)
		 .enterEmailId(aEmailId)
		 .clickbtnRegister();
		 return this ;		
	}
	
	public boolean isTextBoxUserNamePresent(){
		return textBoxUserName.isDisplayed();		
	}
	
	
	public boolean isTextBoxEmailIdPresent(){
		return textBoxEmailId.isDisplayed();
	}
	
	public boolean isbtnRegisterPresent(){
		return btnRegister.isDisplayed();
	}
	
	public boolean isRegisterResultTextLabelPresent(){
		return btnRegister.isDisplayed();
	}
	
	public boolean  isLinkLogInPresent(){
		return linkLogIn.isDisplayed();		
	}
	
	public boolean  isLinkLostPasswordPresent(){
		return linkLostPassword.isDisplayed();
	}
				
	public boolean  isLinkToOnlineStorePresent(){
		return linkToOnlineStore.isDisplayed();
	}
	
	
} // end of class
