package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import pageobjects.dialogs.LoginDialog;

public class HomePage extends PageBase {

    @FindBy(css = "[data-test='headerNavigation-navigationListItem-Discover']")
    private WebElement discoverMenu;

    @FindBy(css = "[data-test='subNavigation-groupList'] [href='/challenges']")
    private WebElement challengeLinkInDiscoverMenu;

    @FindBy(css = "[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']")
    private WebElement loginButton;

    public HomePage() {
        open(getURL());
        PageFactory.initElements(driver, this);
    }

    public LoginDialog clickLoginButton() {
        click(loginButton);
        return new LoginDialog();
    }

    public ChallengesPage hoverOnDiscoverMenuAndClickOnChallengesFromIt() {
        Actions actions = new Actions(driver);
        actions.moveToElement(discoverMenu).build().perform();
        click(challengeLinkInDiscoverMenu);
        return new ChallengesPage();
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART;
    }
}