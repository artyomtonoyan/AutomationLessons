import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChallengesPage extends BasePage {

    private final By activeChallengeCardLocation = By.cssSelector(".grid-cards .card");

    public void clickOnRandomActiveChallenge() {
        List<WebElement> webElementList = findAll(activeChallengeCardLocation);
        WaitHelper.getInstance().waitForElementToDisplayed(activeChallengeCardLocation);
        click(webElementList.get((int) (Math.random() * (webElementList.size() + 1))));
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "challenges";
    }
}