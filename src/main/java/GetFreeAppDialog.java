import org.openqa.selenium.By;

public class GetFreeAppDialog extends BasePage{

    private final By qrCode = By.cssSelector(".qrcode");

    @Override
    public String getURL() {
        return null;
    }

    public boolean isQrCodeVisible() {
        return isDisplayed(qrCode);
    }
}
