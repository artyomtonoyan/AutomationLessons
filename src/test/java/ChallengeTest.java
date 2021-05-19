import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTest {

    @Test
    public void challengesOpen() throws InterruptedException {
        //Can we avoid using this here? Sometimes @Before method runs in parallel with @Test method, which cause problems
        Thread.sleep(10000);
        ChallengesPage challengesPage = new ChallengesPage();
        // We can just open https://picsart.com/challenges page by constructor without opening dropdown menu
        // Also we can click on Challenges in footer without opening dropdown menu
        challengesPage.hoverOnDiscoverMenuAndClickOnChallenges();
        challengesPage.clickOnRandomActiveChallenge();
        challengesPage.clickOnParticipateButton();
        assertTrue(challengesPage.isQrCodeDisplayed(), "QR code isn't displayed");
    }
}
