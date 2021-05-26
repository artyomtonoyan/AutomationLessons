import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {

    private final By discoverMenuLocation = By.cssSelector("[data-test='headerNavigation-navigationListItem-Discover']");
    private final By challengeLinkInDiscoverMenu = By.cssSelector("[data-test='subNavigation-groupList'] [href='/challenges']");
    private final By loginButtonLocation = By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']");


    public HomePage() {
        open(getURL());
    }

    public void clickLoginButton() {
        click(loginButtonLocation);
    }

    public void hoverOnDiscoverMenuAndClickOnChallengesFromIt() {
        WaitHelper.getInstance().waitForElementToDisplayed(discoverMenuLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(discoverMenuLocation)).build().perform();
        WaitHelper.getInstance().waitForElementToDisplayed(challengeLinkInDiscoverMenu);
        click(find(challengeLinkInDiscoverMenu));
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART;
    }
}
