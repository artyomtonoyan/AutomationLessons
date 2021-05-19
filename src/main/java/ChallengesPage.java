import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ChallengesPage extends BasePage {

    private final By discoverMenuLocation = By.cssSelector("[data-test='headerNavigation-navigationListItem-Discover']");
    private final By challengeLinkInDiscoverMenu = By.cssSelector("[data-test='subNavigation-groupList'] [href='/challenges']");
    private final By activeChallengeCardLocation = By.cssSelector(".grid-cards .card");
    private final By participateButtonLocation = By.cssSelector("[data-js-get-the-app-popup-source='challenge-landing']");
    private final By qrCodeLocation = By.id("qrcode");

    public ChallengesPage() {
//        open(getURL());
    }

    public void hoverOnDiscoverMenuAndClickOnChallenges() {
        WaitHelper.getInstance().waitForElementToDisplayed(discoverMenuLocation);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(discoverMenuLocation)).build().perform();
        WaitHelper.getInstance().waitForElementToDisplayed(challengeLinkInDiscoverMenu);
        click(find(challengeLinkInDiscoverMenu));
    }

    public void clickOnRandomActiveChallenge() {
        WaitHelper.getInstance().waitForElementToDisplayed(activeChallengeCardLocation);
        click(findAll(activeChallengeCardLocation).get((int) (Math.random() * (findAll(activeChallengeCardLocation).size() + 1))));
    }

    public void clickOnParticipateButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(participateButtonLocation);
        click(find(participateButtonLocation));
    }

    public boolean isQrCodeDisplayed() {
        return isDisplayed(qrCodeLocation);
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenges";
    }
}