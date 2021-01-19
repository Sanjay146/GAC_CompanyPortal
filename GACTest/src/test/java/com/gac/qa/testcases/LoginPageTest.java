package com.gac.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gac.qa.base.TestBase;
import com.gac.qa.pages.DashboardPage;
import com.gac.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest() 
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() 
	{
		initialization();
		loginPage = new LoginPage();	
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() 
	{
		String title = loginPage.validateLodinPageTitle();
		Assert.assertEquals(title, "Global App Controller");
	}
	
	@Test(priority = 2)
	public void validateLogo2c2pTest() 
	{
		boolean flag = loginPage.validate2c2pLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() 
	{
		dashboardPage = loginPage.login(prop.getProperty("username") , prop.getProperty("password"));
	}

}
