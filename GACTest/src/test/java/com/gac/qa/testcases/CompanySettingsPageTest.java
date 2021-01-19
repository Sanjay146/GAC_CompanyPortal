package com.gac.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.CompanySettingsPage;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.LoginPage;

public class CompanySettingsPageTest extends TestBase{

	CompanySettingsPageTest()
	{
		super();
	}
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CompanySettingsPage companySettingsPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		companySettingsPage = dashboardPage.clickOnCompanySettingsLink();
	}
	
	@Test
	public void verifyCompanySettingsLabelTest() {
		companySettingsPage.verifyCompanySettingLabel();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
