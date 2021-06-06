package pageobjects.dialogs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;

public class GetFreeAppDialog extends PageBase {

    @FindBy(css = ".qrcode")
    private WebElement qrCode;

    public GetFreeAppDialog() {
        PageFactory.initElements(driver, this);
    }

    public boolean isQrCodeVisible() {
        return isDisplayed(qrCode);
    }

    @Override
    public String getURL() {
        return null;
    }
}