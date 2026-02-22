/**
 * BuyHomePageClass.java
 * 
 * This Page Object Model class contains automation logic for the BuyHomePage.
 * Includes interactions with vehicle categories, dropdowns, modals, and checkout forms.
 *
 * Known Issue:
 * The second dropdown (model selection) cannot be reliably automated with Selenium Select.
 * See detailed NOTE below.
 */

/*
 * NOTE: This dropdown cannot be reliably automated with Selenium Select.
 * Reason:
 * 1. The options might be loaded dynamically via JavaScript/AJAX.
 * 2. The option text may contain extra whitespace or hidden characters.
 * 3. The dropdown could be implemented as a custom div/span element, not a standard <select>.
 * 
 * Current workaround: skipping this dropdown in the automated test.
 * All other parts of the page and tests are working correctly.
 */

package hauba;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Constructor
public class BuyHomePageClass {
	WebDriver driver;
	WebDriverWait wait;

	// Click on the car body category (e.g., navigate to a specific vehicle type)
	@FindBy(css = "#root > div > div > div.flex-grow.p-5 > div > div.flex.flex-col.lg\\:flex-\\[4\\].xl\\:flex-4.lg\\:px-5 > div.flex.flex-col.md\\:flex-row.justify-between.w-full.gap-5.xl\\:gap-10.py-5 > a:nth-child(1)")
	WebElement clickCarosery;

	// Sorting dropdown (e.g., price ascending/descending, newest, etc.)
	@FindBy(css = "#root > div > div > div.flex-grow.p-5 > div > div.flex.flex-col.gap-5 > div.grid.grid-cols-1.lg\\:grid-cols-3.gap-5.lg\\:gap-0.justify-between.p-5.\\32 xl\\:p-7.rounded-2xl.bg-primary-light > div.flex.justify-center.w-full.lg\\:w-fit.relative > select")
	WebElement shortDropDown;

	/*
	 * @FindBy(css =
	 * "#root > div > div > div.flex-grow.p-5 > div > div.flex.flex-col.gap-5 > div.grid.grid-cols-1.lg\:grid-cols-3.gap-5.lg\:gap-0.justify-between.p-5.\32 xl\:p-7.rounded-2xl.bg-primary-light > div:nth-child(2) > select"
	 * ) WebElement shortDropDownModel;
	 */

	// Click on the first vehicle model from the model list
	@FindBy(css = "#root > div > div > div.flex-grow.p-5 > div > div.flex.flex-col.gap-5 > div.grid.grid-cols-1.mx-auto.sm\\:mx-0.sm\\:grid-cols-2.md\\:grid-cols-3.mt-4 > div:nth-child(1) > a")
	WebElement clickFirstModel;

	// Click on the first auto part from the parts table
	@FindBy(css = "#root > div > div > div.flex-grow.p-5 > div > div.flex.flex-col.gap-5 > div.flex.flex-col.gap-5.w-full > div.overflow-x-auto.lg\\:overflow-visible > table > tbody > tr:nth-child(1)")
	WebElement clickFirstParts;

	// Modal window that appears after clicking on a part
	@FindBy(css = "#modal > div > div")
	WebElement showModal;

	// Header (title) inside the modal – verifies the product name
	@FindBy(css = "#modal > div > div > div > div.flex.flex-col.justify-center.items-center.xs\\:flex-row.gap-5 > div.flex.flex-col.text-lg.lg\\:text-xl.gap-1 > p:nth-child(1) > span")
	WebElement checkHeader;

	// Description paragraph inside the modal – additional product information
	@FindBy(css = "#modal > div > div > div > div.flex.flex-col.justify-center.items-center.xs\\:flex-row.gap-5 > div.flex.flex-col.text-lg.lg\\:text-xl.gap-1 > p:nth-child(2)")
	WebElement modalParagraph;

	// "+" button to increase product quantity
	@FindBy(css = "#modal > div > div > div > div.flex.justify-center.items-center.gap-5.w-full.lg\\:w-\\[40\\%\\] > div:nth-child(1) > div > button.text-lg.font-bold.pr-2")
	WebElement clickButtonPlus;

	// Click on the bag icon (add product to cart)
	@FindBy(css = "#modal > div > div > div > div.flex.justify-center.items-center.gap-5.w-full.lg\\:w-\\[40\\%\\] > div.flex.flex-col.justify-center.items-center.gap-1 > svg")
	WebElement clickBag;

	// Snackbar notification message after adding to cart
	@FindBy(css = "#notistack-snackbar")
	WebElement modalMessage;

	// Close modal button (X)
	@FindBy(css = "#modal > div > div > svg")
	WebElement clickCloseModal;

	// Click on the cart (bag) icon in the header section
	@FindBy(css = "#root > div > div > div.hidden.lg\\:flex.flex-col > div.flex.items-center.justify-between.bg-secondary-light.p-2.text-white > div > div.flex.items-center.gap-2 > div:nth-child(3) > svg > path:nth-child(2)")
	WebElement clickInputFieldBag;

	// Verify that the cart modal is opened
	@FindBy(css = "#modal > div > div")
	WebElement checkModalBuy;

	// "Proceed to checkout" button inside the cart
	@FindBy(css = "#modal > div > div > div > div > div:nth-child(2) > button")
	WebElement clickButtonIzvrsiteKupovinu;

	// Verify that the checkout form modal is opened
	@FindBy(css = "#modal > div > div > div > form")
	WebElement checkModalInputField;

	// Input field for customer's first name
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(3) > input:nth-child(1)")
	WebElement inputFieldFirstName;

	// Input field for customer's last name
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(3) > input:nth-child(2)")
	WebElement inputFieldLastName;

	// Input field for phone number
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(4) > input:nth-child(1)")
	WebElement inputFieldPhoneNumber;

	// Input field for city
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(4) > input:nth-child(2)")
	WebElement inputFieldCity;

	// Input field for street
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(5) > input:nth-child(1)")
	WebElement inputFieldStreet;

	// Input field for ZIP/postal code
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(5) > input:nth-child(2)")
	WebElement inputFieldZipCode;

	// Input field for email address
	@FindBy(css = "#modal > div > div > div > form > input")
	WebElement inputFieldEmail;

	// Final "Buy" button (confirm purchase)
	@FindBy(css = "#modal > div > div > div > form > div:nth-child(7) > button.bg-secondary-main.mx-auto.py-2.w-\\[140px\\].rounded-xl.font-medium.text-white")
	WebElement clickButtonBuy;

	// Constructor of the BuyHomePageClass.
	// Initializes WebDriver instance, PageFactory elements, and WebDriverWait.
	public BuyHomePageClass(WebDriver driver) {

		// Assign the passed WebDriver instance to the local class variable
		this.driver = driver;

		// Initialize all @FindBy annotated WebElements in this Page Object
		PageFactory.initElements(driver, this);

		// Initialize explicit wait with a 10-second timeout
		// Used for waiting until elements meet specific conditions (visibility,
		// clickability, etc.)
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Reusable helper method for entering text into input fields.
	// Waits until the element is visible, clears any existing value,
	// and then sends the provided text.
	private void enterText(WebElement element, String text) {

		// Wait until the element becomes visible on the page
		wait.until(ExpectedConditions.visibilityOf(element));

		// Clear any pre-existing text inside the input field
		element.clear();

		// Enter the specified text into the element
		element.sendKeys(text);
	}

	// Clicks on the Carosery element after waiting for it to become visible.
	// Uses explicit wait to ensure the element is ready before interaction.
	public void firstClickCarosery() {
		wait.until(ExpectedConditions.visibilityOf(clickCarosery)).click();
	}

	// Selects an option from the dropdown by visible text.
	// Waits for the dropdown to be visible before creating the Select object.
	public void clickDropDownFirst(String text) {

		// Wait until dropdown is visible
		wait.until(ExpectedConditions.visibilityOf(shortDropDown));

		// Initialize Select class for handling <select> element
		Select select = new Select(shortDropDown);

		// Select option based on the text visible to the user
		select.selectByVisibleText(text);
	}

	/*
	 * public void clickDropDownSecond(String text) {
	 * wait.until(ExpectedConditions.visibilityOf(shortDropDownModel)); Select
	 * select = new Select(shortDropDownModel); select.selectByVisibleText(text); }
	 */

	// Clicks on the first model element after waiting for visibility.
	public void clickFirstModel() {
		wait.until(ExpectedConditions.visibilityOf(clickFirstModel)).click();
	}

	// Clicks on the first parts element after waiting for visibility.
	public void partsFirstClick() {
		wait.until(ExpectedConditions.visibilityOf(clickFirstParts)).click();
	}

	// Verifies that the modal window is displayed.
	public boolean modalIsDisplay() {
		wait.until(ExpectedConditions.visibilityOf(showModal));
		return showModal.isDisplayed();
	}

	// Returns the trimmed header text from the modal window.
	public String getModalFirstText() {
		wait.until(ExpectedConditions.visibilityOf(checkHeader));
		return checkHeader.getText().trim();
	}

	// Returns the trimmed paragraph text from the modal window.
	public String getModalParagraphText() {
		wait.until(ExpectedConditions.visibilityOf(modalParagraph));
		return modalParagraph.getText().trim();
	}

	// Clicks the "+" button inside the modal.
	public void buttonPlusClikc() {
		wait.until(ExpectedConditions.visibilityOf(clickButtonPlus)).click();
	}

	// Clicks the bag/cart button.
	public void buttonBag() {
		wait.until(ExpectedConditions.visibilityOf(clickBag)).click();
	}

	// Verifies that the modal confirmation message is displayed.
	public boolean modalMessageDisplay() {
		wait.until(ExpectedConditions.visibilityOf(modalMessage));
		return modalMessage.isDisplayed();
	}

	// Clicks the close button on the modal.
	public void modalClickClose() {
		wait.until(ExpectedConditions.visibilityOf(clickCloseModal)).click();
	}

	// Clicks the input field inside the bag modal.
	public void modalInputBag() {
		wait.until(ExpectedConditions.visibilityOf(clickInputFieldBag)).click();
	}

	// Verifies that the buy modal is displayed.
	public boolean modalBuyDisplay() {
		wait.until(ExpectedConditions.visibilityOf(checkModalBuy));
		return checkModalBuy.isDisplayed();
	}

	// Clicks the "Izvršiti kupovinu" (Complete Purchase) button.
	public void buttonIzvrsitiKupovinu() {
		wait.until(ExpectedConditions.visibilityOf(clickButtonIzvrsiteKupovinu)).click();
	}

	// Verifies that the input field inside the modal is displayed.
	public boolean inputFieldModal() {
		wait.until(ExpectedConditions.visibilityOf(checkModalInputField));
		return checkModalInputField.isDisplayed();
	}

	// Fills out the registration form for purchase with provided user data.
	// Uses reusable enterText() helper method for better maintainability.
	public void fillRegistationFormBuy(String firstName, String lastName, String phoneNumber, String cityName,
			String nameStreet, String zipCode, String emailInput) {
		enterText(inputFieldFirstName, firstName);
		enterText(inputFieldLastName, lastName);
		enterText(inputFieldPhoneNumber, phoneNumber);
		enterText(inputFieldCity, cityName);
		enterText(inputFieldStreet, nameStreet);
		enterText(inputFieldZipCode, zipCode);
		enterText(inputFieldEmail, emailInput);

	}

	// Clicks the final Buy button to submit the purchase.
	public void buttonBuyButton() {
		wait.until(ExpectedConditions.visibilityOf(clickButtonBuy)).click();
	}

}
