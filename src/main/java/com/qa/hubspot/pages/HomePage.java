package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// Elements or Locators
	
	@FindBy(xpath = "//h1[@class='private-page__title']")
	public WebElement homePageHeader;

	@FindBy(xpath = "//span[@class='account-name']")
	public WebElement accountName;

	@FindBy(id = "nav-primary-contacts-branch")
	public WebElement contacts;

	@FindBy(id = "nav-secondary-contacts")
	public WebElement subContacts;
	


	// Constructor
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	// Methods
	public String getHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public String getHomePageHeader() {
		
		return homePageHeader.getText();
	}
	
	public String getLoginAccountValue() {
		
		return accountName.getText();
	}
	
}
