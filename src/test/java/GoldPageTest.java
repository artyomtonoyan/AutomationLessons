import base.BaseTestWithoutLogin;
import org.testng.annotations.Test;
import pageobjects.pages.GoldPage;

import static org.testng.Assert.assertTrue;

public class GoldPageTest extends BaseTestWithoutLogin {
    @Test
    public void slideshow() {
        GoldPage goldPage = new GoldPage();
        for (int i = 0; i < goldPage.getSizeOfSlideshowDots(); i++) {
            goldPage.clickOnSlideshowDot(i);
            assertTrue(goldPage.isSlideActive(i), "Slide: " + i + 1 + ", is not active");
        }
    }

    @Test(enabled = false)
    public void slideshowWithActions() {
        new GoldPage().changeCarouselWithActions();
    }
}