package com.gac.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.gac.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\gac\\qa\\config\\config.properties");
			prop.load(ip);
			System.out.println("driver: " + driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() 
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) 
			{
			 	System.setProperty("webdriver.chrome.driver","C:\\Users\\perennial\\PS-workspace"
			 		+ "\\GACTest\\Drivers\\chromedriver.exe");
			 	driver = new ChromeDriver();
			}
		else if (browserName.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\perennial\\PS-workspace"
					+ "\\GACTest\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}

		else if (browserName.equalsIgnoreCase("IE")) 
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\perennial\\PS-workspace"
					+ "\\GACTest\\Drivers\\IEDriverServerver.exe");
				driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}	
	
}


