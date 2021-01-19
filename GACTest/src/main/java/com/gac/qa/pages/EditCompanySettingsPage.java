package com.gac.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.gac.qa.base.TestBase;

public class EditCompanySettingsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Edit Company Setting')]")
	WebElement editCompanySettingLabel;
	
	@FindBy(xpath="//input[@name='companyName']")
	WebElement company;
	
	@FindBy(xpath="//input[@name='contactPerson']")
	WebElement contactPerson;
	
	@FindBy(xpath="//input[@name='address']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postalCode;
	
	@FindBy(xpath="/html/body/app-root/app-full-layout/div/div/div/app-edit-company/form/div[2]"
			+ "/div/div/div/div[6]/div[1]/div/label[2]/ng-select/div/div/div[3]/input")
	WebElement currencyCode;
	
	@FindBy(xpath="//input[@name='contactNumber']")
	WebElement contactNumber;
	
	@FindBy(xpath="/html/body/app-root/app-full-layout/div/div/div/app-edit-company/form/div[2]"
			+ "/div/div/div/div[3]/div[2]/div[1]/div/div/label[2]/ng-select/div/div/div[3]/input")
	WebElement country;
	
	@FindBy(xpath="//input[@id='active']")
	WebElement radioBtnActive;
	
	@FindBy(xpath="//input[@id='inactive']")
	WebElement radioBtnInactive;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;
	
	public EditCompanySettingsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyEditCompanySettingLabel() {
		editCompanySettingLabel.isDisplayed();
	}
	
	public void enterCompanySettings(String comp, String contactP, String add, String st, 
			String postCode, String currency, String contact, String cntry, String status ) {
		company.clear();
		company.sendKeys(comp);
		contactPerson.clear();
		contactPerson.sendKeys(contactP);
		address.clear();
		address.sendKeys(add);
		state.clear();
		state.sendKeys(st);
		postalCode.clear();
		postalCode.sendKeys(postCode);
		currencyCode.clear();
		currencyCode.sendKeys(currency);
		contactNumber.clear();
		contactNumber.sendKeys(contact);
		country.clear();
		Select select = new Select(country);
		select.selectByVisibleText(cntry);
		
		if(status.equals("Active")) {
			radioBtnActive.click();
		}
		else radioBtnInactive.click();
		
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
	
	public void clickOnCancelBtn() {
		cancelBtn.click();
	}
	
	

}
