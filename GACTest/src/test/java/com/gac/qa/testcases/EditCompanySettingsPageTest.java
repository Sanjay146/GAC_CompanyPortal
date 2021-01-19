package com.gac.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.CompanySettingsPage;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.EditCompanySettingsPage;
import com.gac.qa.pages.LoginPage;
import com.gac.qa.util.TestUtil;

public class EditCompanySettingsPageTest extends TestBase{
	
	EditCompanySettingsPageTest() {
		super();
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CompanySettingsPage companySettingsPage;
	EditCompanySettingsPage editCompanySettingsPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		companySettingsPage = dashboardPage.clickOnCompanySettingsLink();
		editCompanySettingsPage = companySettingsPage.clickOnEditBtn();
		
	}
	
	@DataProvider
	public Object[][] getCompanySettingsData() {
		Object[][] data = TestUtil.getTestData("companySettings");
		return data;
	}
	
	@Test
	public void verifyCompanySettingsLabelTest() {
		editCompanySettingsPage.verifyEditCompanySettingsLabel();
	}
	
	@Test(dataProvider="getCompanySettingsData", priority=2)
	public void enterCompanySettingsTest(String comp, String contactP, String add, String st, 
			String postCode, String currency, String contact, String cntry, String status ) {
		
		editCompanySettingsPage.enterCompanySettings(comp, contactP, add, st, 
				postCode, currency, contact, cntry, status);
		editCompanySettingsPage.clickOnSaveBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	
	

}
