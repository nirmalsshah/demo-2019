package framework.webPages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {

    private By SignUpButton = By.partialLinkText("Sign");

    public void clickOnSignUp(){
        clickOn(SignUpButton);
    }
}
