package hauba;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageClassTest extends BaseTestCase {

	// Before each test, navigate to the homepage
	@BeforeMethod
	public void navigation() {
		driver.navigate().to("https://www.hauba.rs/");
	}

	// After each test, delete all cookies to avoid session interference
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	// Test registration with incorrect credentials (DataProvider:
	// "incorrectCredentials")
	@Test(dataProvider = "incorrectCredentials", dataProviderClass = TestData.class)
	public void clickLogin(String inputFieldName, String inputFieldLastName, String inputFieldPhoneNumber,
			String inputFieldCity, String inputFieldStreet, String inputZipCode, String inputEmail,
			String inputPassword, String inputPasswordConfirmation) {

		// Click the login button to open modal
		haubaPageClass.loginIsClick();

		// Wait for modal to be visible
		haubaPageClass.modalIsDisplay();

		// Click "new member" inside modal
		haubaPageClass.noviClanClick();

		// Fill registration form
		// ⚠️ ISSUE: You are passing literal strings like "inputFieldName" instead of
		// the method parameters
		haubaPageClass.fillRegistrationForm("inputFieldName", "inputFieldLastName", "inputFieldPhoneNumber",
				"inputFieldCity", "inputFieldStreet", "inputZipCode", "inputEmail", "inputPassword",
				"inputPasswordConfirmation");

		// Click the submit button
		haubaPageClass.buttonIsClick();

		// Note: No assertion here yet; you might want to check for success message or
		// URL
	}

	// Test registration with missing/invalid fields to verify error messages
	@Test(dataProvider = "registrationErrors", dataProviderClass = TestData.class)
	public void clickLoginError(String inputFieldName, String inputFieldLastName, String inputFieldPhoneNumber,
			String inputFieldCity, String inputFieldStreet, String inputZipCode, String inputEmail,
			String inputPassword, String inputPasswordConfirmation) {

		// Open login modal
		haubaPageClass.loginIsClick();

		// Wait for modal
		haubaPageClass.modalIsDisplay();

		// Click "new member" to open registration form
		haubaPageClass.noviClanClick();

		// Fill form with test data from DataProvider
		// ⚠️ SAME ISSUE: currently using literal strings; should pass method parameters
		haubaPageClass.fillRegistrationForm("inputFieldName", "inputFieldLastName", "inputFieldPhoneNumber",
				"inputFieldCity", "inputFieldStreet", "inputZipCode", "inputEmail", "inputPassword",
				"inputPasswordConfirmation");

		// Submit the form
		haubaPageClass.buttonIsClick();

		// Retrieve the displayed error message
		String actualError = haubaPageClass.getErrorMessageText();

		// Verify that the error message is displayed and not empty
		Assert.assertNotNull(actualError, "Error poruka nije prikazana.");
		Assert.assertFalse(actualError.isEmpty(), "Error poruka je prazna.");
	}

}
