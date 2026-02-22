package hauba;

import org.testng.annotations.DataProvider;

public class TestData {

	// Correct registration data (could be used for positive test cases)
	String correctFirstName = "Bruce";
	String correctLastName = "Wayne";
	String correctPhoneNumber = "123456789";
	String correctNameCity = "Gotham City";
	String correctNameStreet = "44E Street";
	String correctZipCode = "21000";
	String correctEmail = "nikola@gmail.com";
	String correctPassword = "N!k0L@91";
	String correctPasswordConfirmated = "N!k0L@91";

	// DataProvider for incorrect credentials (example of a failed registration
	// attempt)
	@DataProvider(name = "incorrectCredentials")
	public Object[][] registrationSuccessData() {
		// Each array represents one test case with input data
		return new Object[][] { { "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "21000",
				"bruce@gmail.com", "Test123!", "Test123!" } };
	}

	// DataProvider for various registration errors (fields left empty to trigger
	// validation)
	@DataProvider(name = "registrationErrors")
	public Object[][] registrationErrorData() {
		// Each array represents one test case where a field is missing
		return new Object[][] {
				{ "", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "bruce@gmail.com", "Test123!",
						"Test123!" }, // Missing first name
				{ "Bruce", "", "123456789", "Gotham City", "44E Street", "21000", "bruce@gmail.com", "Test123!",
						"Test123!" }, // Missing last name
				{ "Bruce", "Wayne", "", "Gotham City", "44E Street", "21000", "bruce@gmail.com", "Test123!",
						"Test123!" }, // Missing phone number
				{ "Bruce", "Wayne", "123456789", "", "44E Street", "21000", "bruce@gmail.com", "Test123!", "Test123!" }, // Missing
																															// city
				{ "Bruce", "Wayne", "123456789", "Gotham City", "", "21000", "bruce@gmail.com", "Test123!",
						"Test123!" }, // Missing street
				{ "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "", "bruce@gmail.com", "Test123!",
						"Test123!" }, // Missing ZIP code
				{ "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "", "Test123!", "Test123!" }, // Missing
																														// email
				{ "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "bruce@gmail.com", "",
						"Test123!" }, // Missing password
				{ "Bruce", "Wayne", "123456789", "Gotham City", "44E Street", "21000", "bruce@gmail.com", "Test123!",
						"" } };// Missing password confirmation
	}
}
