package com.qa.hubspot.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.hubspot.util.TimeUtil;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		String pageLoadTimeout = prop.getProperty("pageLoadTimeout");
		
		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"C://Users//john//Desktop//Rinmar-ISTQB//Selenium_Eclipse_Maven//Drivers//chromedriver.exe");
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equals("firefox")) {	
			
			System.setProperty("webdriver.chrome.driver",
					"C://Users//john//Desktop//Rinmar-ISTQB//Selenium_Eclipse_Maven//Drivers//geckodriver.exe");
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		} else if(browser.equals("ie")) {
			
			driver = new InternetExplorerDriver();
		} else {
			System.out.println(browser + " : NO Browser defined");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(pageLoadTimeout), TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		TimeUtil.medWait();
		
		return getDriver();

	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties init_prop() {
		
		prop = new Properties();
		
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public String getScreenshot() {
		
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "./FailedScreenShots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e1) {
			System.out.println("Captured Failed " + e1.getMessage());
			e1.printStackTrace();
		}
		
		return path;
	}
	

}
