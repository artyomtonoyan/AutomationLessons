package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;

public class HomePage extends BasePage {

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

    public void clickLoginButton() {
        click(loginButton);
    }

    public void hoverOnDiscoverMenuAndClickOnChallengesFromIt() {
        Actions actions = new Actions(driver);
        actions.moveToElement(discoverMenu).build().perform();
        click(challengeLinkInDiscoverMenu);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART;
    }
}