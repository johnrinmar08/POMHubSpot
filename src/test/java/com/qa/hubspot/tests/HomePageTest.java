package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ConstantValues;
import com.qa.hubspot.util.TimeUtil;

public class HomePageTest {
	
	WebDriver driver;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		
		BasePage basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		TimeUtil.medWait();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitle() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(ConstantValues.HOME_PAGE_TITLE));
		
		String title = homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, ConstantValues.HOME_PAGE_TITLE);
	}
	
	@Test
	public void verifyHomePageHeader() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(homePage.homePageHeader));
		
		String header = homePage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, ConstantValues.HOME_PAGE_HEADER);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
