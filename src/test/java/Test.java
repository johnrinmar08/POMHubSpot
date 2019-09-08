import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver" , "C://Users//john//Desktop//Rinmar-ISTQB//Selenium_Eclipse_Maven//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

	}

}
