package com.gac.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.EditProfileSettingPage;
import com.gac.qa.pages.LoginPage;
import com.gac.qa.pages.ProfileSettingPage;
import com.gac.qa.util.TestUtil;

public class EditProfileSettingPageTest extends TestBase{
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	ProfileSettingPage profileSettingPage;
	EditProfileSettingPage editProfileSettingPage;
	
	public EditProfileSettingPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
		profileSettingPage = dashboardPage.clickOnProfileSettingLink();
		editProfileSettingPage = profileSettingPage.clickOnEditBtn();
		
	}
	
	@DataProvider
	public Object[][] getProfileSettingData() {
		Object[][] data = TestUtil.getTestData("profileSetting");
		return data;
	}
	
	@Test(priority=1)
	public void veifyEditLabelTest(){
		editProfileSettingPage.verifyEditLabel();
	}
	
	@Test(dataProvider = "getProfileSettingData", priority =2)
		public void editProfileSettingTest(String fName, String lName, String contactNo, String sysUserId, String depart) {
			editProfileSettingPage.editProfileSetting(fName,lName,contactNo,sysUserId,depart);
			editProfileSettingPage.clickOnSaveBtn();
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}




