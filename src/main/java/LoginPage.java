import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By usernameFieldLocation = By.name("username");
    private final By passwordFieldLocation = By.name("password");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");
    private final By signInButtonLocation = By.cssSelector(".pa-uiLib-authentication-btn.primary");
    private final By avatarLocation = By.cssSelector(".pa-uiLib-headerProfileInfo-avatar");

    public LoginPage() {
        super();
        open(BASE_URL);
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
        new WebDriverWait(driver, 3).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(usernameFieldLocation));
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
            waitUntilExpectedCondition(driver, 30, avatarLocation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getURL() {
        return BASE_URL;
    }
}
