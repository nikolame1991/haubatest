package hauba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//Base test class responsible for WebDriver setup and teardown.
//All test classes extend this class to reuse driver configuration.
public class BaseTestCase {

	// Shared WebDriver instance for test execution
	WebDriver driver;

	// Page Object instances used across tests
	HomePageClass haubaPageClass;
	TestData testData;
	BuyHomePageClass buyHomePageClass;

	// Initializes WebDriver and Page Object classes before test execution.
	@BeforeTest
	public void initalization() {
		// Launch Chrome browser
		driver = new ChromeDriver();

		// Maximize browser window for consistent UI behavior
		driver.manage().window().maximize();

		// Initialize Page Object Model classes
		haubaPageClass = new HomePageClass(driver);
		testData = new TestData();
		buyHomePageClass = new BuyHomePageClass(driver);
	}

	// Closes browser and ends WebDriver session after all tests are executed.
	@AfterTest
	public void closeDriver() {
		driver.quit();
	}
}
