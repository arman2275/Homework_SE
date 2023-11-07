
package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {
	WebDriver driver;
	public HomePage homePage;

	// chromeDriver setup
	// url --get
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/armanpias/eclipse-workspace/com.cricketworldcup/driver/119.105_chromedriver");
		// or we can use ChromeDriver as WebDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.cricketworldcup.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void end() {
		driver.quit();
	}
}
