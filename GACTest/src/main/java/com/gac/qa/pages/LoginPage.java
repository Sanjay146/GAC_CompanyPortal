package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gac.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name = "email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text() ,\"Forgot Password\")]")
	WebElement forgotPassword;
	
	@FindBy(xpath= "//img[@title='2C2P']")
	WebElement logo2c2p;
	
	// Initializing the Page Objects
	public LoginPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
	//Actions
	public String validateLodinPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean validate2c2pLogo() 
	{
		return logo2c2p.isDisplayed();
	}
	
	public DashboardPage login(String un, String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new DashboardPage();
	}

}
