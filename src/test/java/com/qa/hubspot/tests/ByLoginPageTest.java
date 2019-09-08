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

public class ByLoginPageTest {

	// Classes and Objects

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	ByLoginPage byLoginPage;
	ByHomePage byHomePage;

	@BeforeMethod
	public void setup() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		byLoginPage = new ByLoginPage(driver);

	}

	@Test
	public void verifyLoginTitle() {

		String title = byLoginPage.getLoginPageTitle();
		Assert.assertEquals(title, ConstantValues.LOGIN_PAGE_TITLE);
	}

	@Test
	public void verifySignupLink() {

		boolean link = byLoginPage.getSignUpLink();
		Assert.assertTrue(link);
	}

	@Test
	public void doLogin() {

		byHomePage = byLoginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(byHomePage.getHomePageTitle(), ConstantValues.HOME_PAGE_TITLE);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
