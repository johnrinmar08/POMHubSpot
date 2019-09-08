package com.qa.hubspot.tests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.ConstantValues;
import com.qa.hubspot.util.TimeUtil;

public class LoginPageTest {

	WebDriver driver;

	BasePage basePage;
	Properties prop;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);

		TimeUtil.medWait();
	}

	@Test(priority = 2)
	public void verifyLoginPageTitle() {

		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(ConstantValues.LOGIN_PAGE_TITLE, title);
	}
	
	@Test(priority = 1)
	public void verifySignUpLink() {

		boolean link = loginPage.signUpLink();
		System.out.println(link);
		Assert.assertTrue(link);
	}
	
	public void doLogin() {
		
		String uName = prop.getProperty("username").trim();
		String pw = prop.getProperty("password").trim();
		
		loginPage.doLogin(uName, pw);
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
