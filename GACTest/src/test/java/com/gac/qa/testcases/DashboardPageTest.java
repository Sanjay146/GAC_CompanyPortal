package com.gac.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.CompanySettingsPage;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.LoginPage;
import com.gac.qa.pages.ProfileSettingPage;

public class DashboardPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfileSettingPage profileSettingPage;
	CompanySettingsPage companySettingsPage;
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		profileSettingPage = new ProfileSettingPage();
		companySettingsPage = new CompanySettingsPage();
	}
	
	@Test(priority=1)
	public void verifyDashboardPageTitleTest() {
		String dashboardTitle = dashboardPage.verifyDashboardTitle();
		Assert.assertEquals(dashboardTitle, "Global App Controller", "Dashboard title is not matching");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(dashboardPage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyProfileSettingLinkTest() {
		profileSettingPage = dashboardPage.clickOnProfileSettingLink();
	}
	
	@Test(priority=4)
	public void verifyCompanySettingsLinkTest() {
		companySettingsPage = dashboardPage.clickOnCompanySettingsLink();
	}
	
	@Test(priority=5)
	public void verifyLogoutTest() {
		dashboardPage.logout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
