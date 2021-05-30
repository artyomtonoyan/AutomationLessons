import base.BaseTestWithoutLogin;
import pageobjects.dialogs.GetFreeAppDialog;
import org.testng.annotations.Test;
import pageobjects.pages.ChallengePage;
import pageobjects.pages.ChallengesPage;
import pageobjects.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTestWithoutLogin {

    @Test(enabled = false)
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
    public void qrOpenedTest() {
        ChallengePage challengePageWithID = new ChallengePage("ircfilltheplate");
        challengePageWithID.clickOnParticipateButton();
        GetFreeAppDialog getFreeAppDialog = new GetFreeAppDialog();
        assertTrue(getFreeAppDialog.isQrCodeVisible(), "QR is not visible");
    }
}