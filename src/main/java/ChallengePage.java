import org.openqa.selenium.By;

public class ChallengePage extends BasePage {
    private final By participateButtonLocation = By.cssSelector("[data-js-get-the-app-popup-source='challenge-landing']");


    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenge";
    }

    public ChallengePage() {

    }

    public ChallengePage(String id) {
        open(getURL() + "/" + id);
    }

    public void clickOnParticipateButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(participateButtonLocation);
        click(find(participateButtonLocation));
    }
}