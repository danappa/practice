package com.crm.Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void BS() {
	}
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void BC() throws Throwable {
		FileUtility fileUtil = new FileUtility();
		//		String BROWSER=System.getProperty("chrome");
		String BROWSER = fileUtil.getPropertyKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		sdriver = driver;
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void BM() throws Throwable {
		FileUtility fileUtil = new FileUtility();
		String url = fileUtil.getPropertyKeyValue("url");
		String UserName = fileUtil.getPropertyKeyValue("un");
		String Password = fileUtil.getPropertyKeyValue("pw");
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.login(UserName, Password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void AM() {
		HomePage homepage=new HomePage(driver);
		homepage.signoutLinkImage();
		homepage.clickOnSignoutLink(driver);
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void AC() {
		driver.close();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void AS() {
	}

}
