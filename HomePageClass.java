/**
 * HomePageClass.java
 * 
 * This Page Object Model class contains automation logic for the Home Page.
 * It handles authentication modal interactions, user registration form,
 * validation messages, and login-related functionality.
 *
 * Features covered:
 * - Open login modal
 * - Navigate to "New Member" registration form
 * - Fill registration fields (personal and contact information)
 * - Submit registration form
 * - Validate error messages (e.g., email already exists)
 *
 * The class uses:
 * - PageFactory for element initialization
 * - Explicit waits (WebDriverWait) for reliable interactions
 * - Reusable helper method for input field handling
 */
package hauba;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageClass {
	WebDriver driver;
	WebDriverWait wait;

	// Login button in navigation bar (opens authentication modal)
	@FindBy(css = "#root > div > div > div.hidden.lg\\:flex.flex-col > div.flex.items-center.justify-between.bg-secondary-light.p-2.text-white > div > div.flex.items-center.gap-2 > div.relative.flex.flex-col.justify-center.items-center")
	WebElement clickLogin;

	// Modal container element
	@FindBy(css = "#modal > div > div")
	WebElement modalDisplay;

	// Text element inside the modal (e.g., title or message)
	@FindBy(xpath = "//*[@id=\"modal\"]/div/div/div/form/div/span")
	WebElement textDisplay;

	// Button for creating a new member
	@FindBy(css = "#modal > div > div > div > form > div > span")
	WebElement clickClan;

	// Registration form fields
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(3) > input:nth-child(1)")
	WebElement inputFieldName; // First name

	@FindBy(css = "#modal > div > div > div > form > div:nth-child(3) > input:nth-child(2)")
	WebElement inputFieldLastName; // Last name

	@FindBy(css = "#modal > div > div > div > form > div:nth-child(4) > input:nth-child(1)")
	WebElement inputFieldPhoneNumber; // Phone number

	@FindBy(css = "#modal > div > div > div > form > div:nth-child(4) > input:nth-child(2)")
	WebElement inputFieldCity; // City

	@FindBy(css = "#modal > div > div > div > form > div:nth-child(5) > input:nth-child(1)")
	WebElement inputFieldStreet; // Street

	@FindBy(css = "#modal > div > div > div > form > div:nth-child(5) > input:nth-child(2)")
	WebElement inputZipCode; // ZIP code

	@FindBy(css = "#modal > div > div > div > form > input.outline-none.bg-grey-main.text-lg.rounded-full.p-2.text-black.text-center.border-2.focus\\:bg-grey-light.transition-all.ease-out.duration-200")
	WebElement inputEmail; // Email

	@FindBy(css = "#modal > div > div > div > form > input:nth-child(7)")
	WebElement inputPassword; // Password

	@FindBy(css = "#modal > div > div > div > form > input:nth-child(8)")
	WebElement inputPasswordConfirmation; // Confirm password

	// Button to submit the form
	@FindBy(css = "#modal > div > div > div > form > button")
	WebElement clickButton;

	// Element displaying error messages (e.g., "Email already exists")
	@FindBy(css = "#modal > div > div > div > form > h3")
	WebElement errorMessage;

	// Constructor: initializes WebDriver, PageFactory elements, and WebDriverWait
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Private method to enter text into a field with visibility check
	private void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)); // Wait until field is visible
		element.clear(); // Clear existing text
		element.sendKeys(text); // Enter new text
	}

	// Clicks the login button to open the modal
	public void loginIsClick() {
		wait.until(ExpectedConditions.visibilityOf(clickLogin)).click();
	}

	// Checks if the modal is displayed
	public boolean modalIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(modalDisplay));
		return modalDisplay.isDisplayed();
	}

	// Clicks the "new member" button inside the modal
	public void noviClanClick() {
		wait.until(ExpectedConditions.visibilityOf(clickClan)).click();
	}

	// Fills out the registration form with provided values
	public void fillRegistrationForm(String first, String last, String phoneNum, String cityName, String streetName,
			String zipCode, String emailAddr, String pass, String confirmPass) {
		enterText(inputFieldName, first);
		enterText(inputFieldLastName, last);
		enterText(inputFieldPhoneNumber, phoneNum);
		enterText(inputFieldCity, cityName);
		enterText(inputFieldStreet, streetName);
		enterText(inputZipCode, zipCode);
		enterText(inputEmail, emailAddr);
		enterText(inputPassword, pass);
		enterText(inputPasswordConfirmation, confirmPass);

	}

	// Clicks the submit button on the registration form
	public void buttonIsClick() {
		wait.until(ExpectedConditions.elementToBeClickable(clickButton)).click();
	}

	// Retrieves the text of the error message displayed in the modal
	public String getErrorMessageText() {
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		return errorMessage.getText().trim();
	}

}
