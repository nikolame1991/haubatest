package hauba;

import org.testng.annotations.DataProvider;

//Provides test data for Buy form scenarios.
//Used for parameterized testing with TestNG DataProvider.
public class BuyTestData {

	// Example of valid test data (currently unused fields).
	// Can be used if you want centralized reusable test data.
	String correctFirstNameBuy = "Bruce";
	String correctLastNameBuy = "Wayne";
	String correctPhoneNumberBuy = "123456789";
	String correctNameCityBuy = "Gotham City";
	String correctNameStreetBuy = "44E Street";
	String correctZipCodeBuy = "21000";
	String correctEmailBuy = "nikola@gmail.com";

	// DataProvider that supplies multiple data sets
	// for testing the Buy form functionality.
	// Each row represents one test execution.
	@DataProvider(name = "buyFormData")
	public Object[][] buyFormData() {
		return new Object[][] {

				// Positive test case – valid input data
				{ "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "nikola@gmail.com" },

				// Negative test case – missing first name
				{ "", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "nikola@gmail.com" } };
	}
}
