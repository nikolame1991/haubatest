package hauba;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Test class for Buy functionality.
//Extends BaseTestCase to inherit WebDriver setup and teardown logic
public class BuyHomePageClassTest extends BaseTestCase {

	// Navigates to the application before each test method execution.
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.hauba.rs/");
	}

	// Cleans browser state after each test execution
	// to ensure test isolation.
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// End-to-end test for the buy process.
	// Uses DataProvider to execute the same test with multiple data sets.
	@Test(dataProvider = "buyFormData", dataProviderClass = BuyTestData.class)
	public void firstBuy(String firstName, String lastName, String phone, String city, String street, String zip,
			String email) {
		// Select car brand and model
		buyHomePageClass.firstClickCarosery();
		buyHomePageClass.clickDropDownFirst("RENAULT");
		// buyHomePageClass.clickDropDownSecond("RENAULT 19 88-92");
		buyHomePageClass.clickFirstModel();
		// Select part and open product modal
		buyHomePageClass.partsFirstClick();
		buyHomePageClass.modalIsDisplay();
		buyHomePageClass.getModalFirstText();

		// Increase quantity and add to cart
		buyHomePageClass.buttonPlusClikc();
		buyHomePageClass.buttonBag();

		// Validate confirmation modal and proceed to cart
		buyHomePageClass.modalMessageDisplay();
		buyHomePageClass.modalClickClose();
		buyHomePageClass.modalInputBag();

		// Proceed to checkout
		buyHomePageClass.modalBuyDisplay();
		buyHomePageClass.buttonIzvrsitiKupovinu();

		// Validate registration form visibility
		buyHomePageClass.inputFieldModal();

		// Fill registration form with provided test data
		buyHomePageClass.fillRegistationFormBuy(firstName, lastName, phone, city, street, zip, email);

		// Submit purchase
		buyHomePageClass.buttonBuyButton();

	}
}
