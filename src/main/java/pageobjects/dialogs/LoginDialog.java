package pageobjects.dialogs;

import org.openqa.selenium.By;
import pageobjects.base.BasePage;
import utilities.WaitHelper;

public class LoginDialog extends BasePage {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By signInButtonLocation = By.cssSelector(".pa-uiLib-authentication-btn.primary");


    public void typeUsername(String username) {
        WaitHelper.getInstance().waitForElementToDisplayed(usernameFieldLocation);
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        WaitHelper.getInstance().waitForElementToDisplayed(passwordFieldLocation);
        type(passwordFieldLocation, password);
    }

    public void clickSignInButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(signInButtonLocation);
        click(signInButtonLocation);
    }

    @Override
    public String getURL() {
        return null;
    }
}