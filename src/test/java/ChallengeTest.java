import base.BaseTestWithoutLogin;
import pageobjects.dialogs.GetFreeAppDialog;
import org.testng.annotations.Test;
import pageobjects.pages.ChallengePage;
import pageobjects.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class ChallengeTest extends BaseTestWithoutLogin {

    @Test
    public void challengesOpenLongWayTest() {
        new HomePage().hoverOnDiscoverMenuAndClickOnChallengesFromIt()
                .clickOnRandomActiveChallenge()
                .clickOnParticipateButton();
        assertTrue(new GetFreeAppDialog().isQrCodeVisible(), "QR code isn't visible");
    }

    @Test
    public void qrOpenedTest() {
        new ChallengePage("srcneonheadphones").clickOnParticipateButton();
        assertTrue(new GetFreeAppDialog().isQrCodeVisible(), "QR is not visible");
    }
}