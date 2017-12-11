package com.toolsqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.toolsqa.util.app.AppPerform;

public class HomePage {

	private WebDriver driver ;
	
	public HomePage( WebDriver aDriver){
		driver = aDriver ;
		PageFactory.initElements(driver, this );
	}
	
	//driver.findElement(By.xpath("//*[@id='account']/a")).click();
	@CacheLookup
	@FindBy(xpath="//*[@id='account']/a")
	private WebElement linkMyAccount;		
	
	public AccountPage clickLinkMyAccount() {
		AppPerform.customExplicitWait(driver, linkMyAccount);
		linkMyAccount.click();				
		Reporter.log(driver.getTitle() + "  Clicking on link My Account");		
		return new AccountPage(driver);
		
	}
	
}
