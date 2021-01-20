package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gac.qa.base.TestBase;

public class ProfileSettingPage extends TestBase {
	
	@FindBy(xpath="//h4//span/span[contains(text(),'Profile Setting')]")
	WebElement profileSettingLabel;
	
	@FindBy(xpath="//button[contains(text(),'Change Password')]")
	WebElement changePasswordBtn;
	
	@FindBy(xpath="//button[contains(text(),'Edit')]")
	WebElement editBtn;

	public ProfileSettingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProfileSettingLabel() {
		return profileSettingLabel.isDisplayed();
	}
	
	public ChangePasswordPage clickOnChangePasswordBtn() {
		Assert.assertTrue(changePasswordBtn.isEnabled());
		changePasswordBtn.click();
		return new ChangePasswordPage();
	}
	
	public EditProfileSettingPage clickOnEditBtn() {
		Assert.assertTrue(editBtn.isEnabled());
		editBtn.click();
		return new EditProfileSettingPage();
	}
	
	
}
