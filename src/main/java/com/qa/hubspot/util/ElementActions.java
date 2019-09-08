package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.pages.BasePage;

public class ElementActions extends BasePage {

	WebDriver driver;

	public ElementActions(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getElement(By by) {

		waitForElement(by);
		WebElement element = driver.findElement(by);

		return element;
	}

	public void waitForElement(By by) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void doSendKeys(By by, String input) {

		getElement(by).sendKeys(input);
	}

	public void doClick(By by) {

		try {

			getElement(by).click();

		} catch (Exception e) {

			System.out.println("Exception occured: " + by);
		}
	}

	public boolean elementIsDisplayed(By by) {

		return getElement(by).isDisplayed();
	}

	public String elementGetTitle() {

		return driver.getTitle();
	}
	
	public String elementGetText(By by) {
		
		return getElement(by).getText();
	}

}
