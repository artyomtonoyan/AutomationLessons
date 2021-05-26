import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTestWithoutLogin {

    @Test
    public void challengesOpenLongWayTest() {
        HomePage homePage = new HomePage();
        homePage.hoverOnDiscoverMenuAndClickOnChallengesFromIt();
        ChallengePage challengePage = new ChallengePage();
        ChallengesPage challengesPage = new ChallengesPage();
        challengesPage.clickOnRandomActiveChallenge();
        challengePage.clickOnParticipateButton();
        GetFreeAppDialog getFreeAppDialog = new GetFreeAppDialog();
        assertTrue(getFreeAppDialog.isQrCodeVisible(), "QR code isn't visible");
    }

    @Test
    public void qrTest() {
        ChallengePage challengePageWithID = new ChallengePage("ircbadmintonbirdie");
        challengePageWithID.clickOnParticipateButton();
        GetFreeAppDialog getFreeAppDialog = new GetFreeAppDialog();
        assertTrue(getFreeAppDialog.isQrCodeVisible(), "QR is not visible");
    }
}