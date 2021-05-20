import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private final By signInButtonLocation = By.cssSelector(".pa-uiLib-authentication-btn.primary");
    private final By avatarLocation = By.cssSelector(".pa-uiLib-headerProfileInfo-avatar");

    public LoginPage() {
        open(BASE_URL_PICSART);
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
        WaitHelper.getInstance().waitForElementToDisplayed(usernameFieldLocation);
    }

    public void typeUsername(String username) {
        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {
        type(passwordFieldLocation, password);
    }

    public void clickSignInButton() {
        click(signInButtonLocation);
    }

    public boolean isAvatarDisplayed() {
        return isDisplayed(avatarLocation);
    }

    public boolean isUserLoggedIn() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(avatarLocation);
            return true;
        } catch (Error e) {
            return false;
        }
    }

    public void waitForAvatarToDisplayed() {
        WaitHelper.getInstance().waitForElementToDisplayed(avatarLocation);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART;
    }
}