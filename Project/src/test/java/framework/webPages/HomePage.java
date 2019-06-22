package framework.webPages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

	private By emailTextField = By.id("email");
	private By passwordTextField = By.id("pass");
	private By loginButton = By.id("loginbutton");
	private By firstNameTextField = By.id("u_0_e");
	private By lastNameTextField = By.id("u_0_g");

	//private By mobileNumberTextField = By.id("mobileNumber");
	private By mobileNumberTextField = By.name("reg_email__");

	//private By newPasswordTextField = By.id("newPwd");
	private By newPasswordTextField = By.name("reg_passwd__");

	private By errorExclamationIcon = By.xpath("//div[@class='mbm _a4y']//div[contains(@class,'_5dbb')]//*[contains(@class,'_5dbc')]");

	private By readMsg = By.xpath("//*[contains(@class, '_5633 _5634')]");




	private By errorMessage = By.id("errorMessage");
	private By femaleGender = By.id("u_0_9");
	private By maleGender = By.id("u_0_a");
	private By messengerLink = By.linkText("Messenger");
	private By signupButton = By.id("u_0_y");

	
	public void clickOnLoginButton() {
		clickOn(loginButton);
	}

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

	public boolean isSignupButtonEnable() {
		return isElementEnabled(signupButton);
	}





	///////////////////////////////////////////

	public void clickOnNewPasswordField(){
		clickOn(newPasswordTextField);
	}

	public void clickOnErrorIcon(){
		clickOn(errorExclamationIcon);
	}

	public String getErrorPopupText(){
		return getTextFromElement(readMsg);
	}

	/////////////////////////////////////////////



}
