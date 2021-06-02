package pageobjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.BasePage;

import java.util.List;

public class ChallengesPage extends BasePage {

    @FindBy(css = ".grid-cards .card")
    private List<WebElement> activeChallengeCard;

    public ChallengesPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRandomActiveChallenge() {
        click(activeChallengeCard.get((int) (Math.random() * (activeChallengeCard.size() + 1))));
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenges";
    }
}