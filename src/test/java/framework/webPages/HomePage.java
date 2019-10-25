package framework.webPages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	private By emailTextField = By.xpath("//input[@name = 'reg_email__']");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.name("firstname");
	private By lastNameTextField = By.name("lastname");
	private By mobileNumberTextField = By.xpath("//input[@name = 'reg_email__']");
	private By newPasswordTextField = By.name("reg_passwd__");
	private By errorMessage = By.id("errorMessage");
	private By invalidEmailErrorMessage = By.xpath("//div[@class='uiContextualLayerPositioner _572t uiLayer']//div//div//div");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.id("");
	private By redWarningButton = By.xpath("//div[@id='u_0_i']//div//i");
	private By emailConfirmTextField = By.name("reg_email_confirmation__");

	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}
	public void clickOnNewPassword() {clickOn(newPasswordTextField);}
	public void clickOnRedWarning() {clickOn(redWarningButton);}

	public void enterEmail(String enterEmail) {
		setValue(emailTextField, enterEmail);
	}
	
	public void enterPassword(String enterPassword) {
		setValue(passwordTextField, enterPassword);
	}

	public void enterFirstName(String firstName) {
		setValue(firstNameTextField, firstName);
	}

	public void enterLastName(String lastName) {
		setValue(lastNameTextField, lastName);
	}

	public void enterMobileNumber(String mobileNum) {
		setValue(mobileNumberTextField, mobileNum);
	}

	public void enterNewPassword(String password) {
		setValue(newPasswordTextField, password);
	}

	public String getErrorMessage() {
		return getTextFromElement(errorMessage);
	}
	public String getInvalidEmailErrorMessage() {
		return getTextFromElement(invalidEmailErrorMessage);
	}
	public boolean isGenderFemaleSelected() {
		return isElementSelected(femaleGender);
	}

	public void clickOnFemaleGender() {
		clickOn(femaleGender);
	}

	public boolean isGenderMaleSelected() {
		return isElementSelected(maleGender);
	}

	public void clickOnMaleGender() {
		clickOn(maleGender);
	}

	public void clickOnMessengerLink() {
		clickOn(messengerLink);
	}
}
