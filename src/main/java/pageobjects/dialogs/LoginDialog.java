package pageobjects.dialogs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import pageobjects.pages.CreatePage;
import utilities.WaitHelper;

public class LoginDialog extends PageBase {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".pa-uiLib-authentication-btn.primary")
    private WebElement signInButton;

    public LoginDialog() {
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String username) {
        WaitHelper.getInstance().waitForElementToDisplayed(usernameField);
        type(usernameField, username);
    }

    public void typePassword(String password) {
        WaitHelper.getInstance().waitForElementToDisplayed(passwordField);
        type(passwordField, password);
    }

    public CreatePage clickSignInButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(signInButton);
        click(signInButton);
        return new CreatePage();
    }

    @Override
    public String getURL() {
        return null;
    }
}