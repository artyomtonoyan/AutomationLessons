package pageobjects.dialogs;

import org.openqa.selenium.By;
import pageobjects.base.BasePage;

public class GetFreeAppDialog extends BasePage {

    private final By qrCodeLocation = By.cssSelector(".qrcode");

    public boolean isQrCodeVisible() {
        return isDisplayed(qrCodeLocation);
    }

    @Override
    public String getURL() {
        return null;
    }
}