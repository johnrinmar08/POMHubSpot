package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pagesBy.ByHomePage;
import com.qa.hubspot.pagesBy.ByLoginPage;
import com.qa.hubspot.util.ConstantValues;


public class ByHomePageTest {
	
	//Classes or Objects
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ByLoginPage byLogin;
	ByHomePage byHomePage;
	
	
	@BeforeMethod
	public void setup() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		byLogin = new ByLoginPage(driver);
		byHomePage = byLogin.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageHeader() {
		String header = byHomePage.getHomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, ConstantValues.HOME_PAGE_HEADER);
	}
	
	@Test
	public void verifyHomePageTitle() {
		String title = byHomePage.getHomePageTitle();
		Assert.assertEquals(title, ConstantValues.HOME_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
