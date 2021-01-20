package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gac.qa.base.TestBase;

public class EditProfileSettingPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Edit')]")
	WebElement editLabel;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='contactNumber']")
	WebElement contactNumber;

	@FindBy(xpath="//input[@id='systemUserId']")
	WebElement systemUserId;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='department']")
	WebElement department;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	public EditProfileSettingPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void editProfileSetting(String fName, String lName, 
			String contactNo, String sysUserId, String depart ) {
		firstName.clear();
		firstName.sendKeys(fName);
		lastName.clear();
		lastName.sendKeys(lName);
		contactNumber.clear();
		contactNumber.sendKeys(contactNo);
		systemUserId.clear();
		systemUserId.sendKeys(sysUserId);
		department.clear();
		department.sendKeys(depart);
	}
	
	public void verifyEditLabel() {
		editLabel.isDisplayed();
	}
	
	public void clickOnSaveBtn() {
		Assert.assertTrue(saveBtn.isEnabled());
		saveBtn.click();
	}
	
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
}
