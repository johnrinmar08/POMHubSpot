package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	/*
	 * Locators
	 */
	@FindBy(id = "username")
	WebElement emailId;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign up")
	WebElement signUpLink;
	
	/*
	 * Constructor
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	/*
	 * Methods
	 */
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean signUpLink() {
		
		return signUpLink.isDisplayed();
	}
	
	public HomePage doLogin(String username, String pw) {
		
		emailId.sendKeys(username);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage(driver);
	}
}
