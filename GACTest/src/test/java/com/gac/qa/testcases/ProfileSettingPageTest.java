package com.gac.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.LoginPage;
import com.gac.qa.pages.ProfileSettingPage;

public class ProfileSettingPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfileSettingPage profileSettingPage;
	
	public ProfileSettingPageTest() 
	{
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		profileSettingPage = dashboardPage.clickOnProfileSettingLink();
	}
	
	@Test(priority = 1)
	public void verifyProfileSettingLabelTest() {
		Assert.assertTrue(profileSettingPage.verifyProfileSettingLabel());	
	}
	
	@Test(priority = 2)
	public void clickOnChangePasswordBtnTest() {
		profileSettingPage.clickOnChangePasswordBtn();
	}
	
	@Test(priority = 3)
	public void clickOnEditBtnTest() {
		profileSettingPage.clickOnEditBtn();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
