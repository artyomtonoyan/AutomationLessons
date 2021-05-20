import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTest {

    @Test
    public void challengesOpen(){
        ChallengesPage challengesPage = new ChallengesPage();
        // We can just open https://picsart.com/challenges page by constructor without opening dropdown menu
        // Also we can click on Challenges in footer without opening dropdown menu
        challengesPage.hoverOnDiscoverMenuAndClickOnChallenges();
        challengesPage.clickOnRandomActiveChallenge();
        challengesPage.clickOnParticipateButton();
        assertTrue(challengesPage.isQrCodeDisplayed(), "QR code isn't displayed");
    }
}