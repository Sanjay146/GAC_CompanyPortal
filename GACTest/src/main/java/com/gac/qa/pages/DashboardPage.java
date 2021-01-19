package com.gac.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gac.qa.base.TestBase;

public class DashboardPage extends TestBase {

	
	@FindBy(xpath = "//li/a/span")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//div[contains(text(), 'g')]")
	WebElement profileMenu;
	
	@FindBy(xpath = "//a[@href='javascript:void(0);']")
	WebElement logoutLink;
	
	@FindBy(xpath = "/html/body/div/div/div[3]/button[1]")
	WebElement logoutBtnPopup;
	
	@FindBy(xpath = "//select")
	WebElement customersForMonth;
	
	@FindBy(xpath="//a[@href='/profile' and @class='ng-star-inserted']")
	WebElement profileSettingLink;
	
	@FindBy(xpath = "//a[@href='/companysetting']")
	WebElement companySettingsLink;
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashboardTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnProfileMenu() {
		profileMenu.click();
	}
	
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	
	public void logout() {
		clickOnProfileMenu();
		clickOnLogoutLink();
		logoutBtnPopup.click();
	}
	
	public ProfileSettingPage clickOnProfileSettingLink() {
		profileSettingLink.click();
		return new ProfileSettingPage();
	}
	
	public CompanySettingsPage clickOnCompanySettingsLink() {
		companySettingsLink.click();
		return new CompanySettingsPage();
	}
}
