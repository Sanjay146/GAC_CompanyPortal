package com.gac.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.ChangePasswordPage;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.LoginPage;
import com.gac.qa.pages.ProfileSettingPage;
import com.gac.qa.util.TestUtil;

public class ChangePasswordPageTest extends TestBase {
	
	ChangePasswordPageTest(){
		super();
	}

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfileSettingPage profileSettingPage;
	ChangePasswordPage changePasswordPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		profileSettingPage = dashboardPage.clickOnProfileSettingLink();
		changePasswordPage = profileSettingPage.clickOnChangePasswordBtn();
		
	}
	
	@DataProvider
	public Object[][] getChangePasswordData() {
		Object[][] data = TestUtil.getTestData("changePass");
		return data;
	}
	
	@Test(dataProvider = "getChangePasswordData", priority =1)
	public void changePasswordTest(String oldPass, String newPass) {
		changePasswordPage.changePassword(oldPass, newPass);
		
	}
	
	@Test(priority = 2)
	public void verifyChangePasswordLabelTest() {
		changePasswordPage.verifyChangePasswordLabel();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
