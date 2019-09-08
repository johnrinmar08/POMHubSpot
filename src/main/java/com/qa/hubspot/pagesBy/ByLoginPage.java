package com.qa.hubspot.pagesBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.TimeUtil;

public class ByLoginPage extends BasePage {

	// Locators
	By emailId = By.id("username");
	By password = By.id("password");
	By loginBtn = By.id("loginBtn");
	By signupLink = By.linkText("Sign up");

	// Classes or Objects
	ElementActions element;

	// Constructor
	public ByLoginPage(WebDriver driver) {
		this.driver = driver;
		element = new ElementActions(driver);
	}

	// Methods
	public String getLoginPageTitle() {

		return element.elementGetTitle();
	}

	public boolean getSignUpLink() {

		return element.elementIsDisplayed(signupLink);

	}

	public ByHomePage doLogin(String username, String pw) {

		element.doSendKeys(emailId, username);
		element.doSendKeys(password, pw);
		element.doClick(loginBtn);
		
		TimeUtil.medWait();

		return new ByHomePage(driver);
	}
}
