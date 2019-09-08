package com.qa.hubspot.pagesBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.util.ElementActions;

public class ByHomePage extends BasePage {

	// Locators
	By homePageHeader = By.xpath("//h1[@class='private-page__title']");
	By accountName = By.xpath("//span[@class='account-name']");
	By contacts = By.id("nav-primary-contacts-branch");
	By subContacts = By.id("nav-secondary-contacts");
	
	//Classes or Objects
	ElementActions element;

	// Constructor
	public ByHomePage(WebDriver driver) {
		this.driver = driver;
		element = new ElementActions(driver);
	}

	// Methods
	public String getHomePageTitle() {

		return element.elementGetTitle();
		
	}

	public String getHomePageHeader() {

		return element.elementGetText(homePageHeader);
	}

	public String getLoginAccountValue() {

		return element.elementGetText(accountName);
	}
}
