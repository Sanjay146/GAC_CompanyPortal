package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gac.qa.base.TestBase;

public class CompanySettingsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Company Setting Detail')]")
	WebElement companySettingLabel;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editBtn;
	
	public CompanySettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCompanySettingLabel() {
		companySettingLabel.isDisplayed();
	}
	
	public EditCompanySettingsPage clickOnEditBtn() {
		editBtn.click();
		return new EditCompanySettingsPage();
	}


}
