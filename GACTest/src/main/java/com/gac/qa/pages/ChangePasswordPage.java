package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gac.qa.base.TestBase;

public class ChangePasswordPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Change Password')]")
	WebElement changePasswordLabel;

	@FindBy(xpath="//input[@id='oldPassword']")
	WebElement currentPassword;
	
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@id='confirmNewPassword']")
	WebElement confirmNewPassword;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	public ChangePasswordPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public void verifyChangePasswordLabel() {
		changePasswordLabel.isDisplayed();
	}
	
	public void changePassword(String oldPas, String newPas) {
		currentPassword.sendKeys(oldPas);
		newPassword.sendKeys(newPas);
		confirmNewPassword.sendKeys(newPas);
	}
	
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
	
	
}
