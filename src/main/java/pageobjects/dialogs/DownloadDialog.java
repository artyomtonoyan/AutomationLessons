package pageobjects.dialogs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.base.PageBase;
import utilities.WaitHelper;

import static utilities.FileHelper.isFileExistsInDirectory;

public class DownloadDialog extends PageBase {

    @FindBy(css = "[data-test='downloaded-file-name']")
    private WebElement fileName;

    @FindBy(css = "[data-test='unit'] span")
    private WebElement extensionOfDownloadableFile;

    @FindBy(css = "[data-test='downloaded-button']")
    private WebElement downloadButtonInModal;

    private static String nameOfFile;
    private static String extensionOfFile;

    public DownloadDialog() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public String getURL() {
        return null;
    }

    public void clickOnDownloadButtonInModal() {
        WaitHelper.getInstance().waitForTextToBePresentInElement(downloadButtonInModal, "Download");
        nameOfFile = fileName.getAttribute("value");
        extensionOfFile = extensionOfDownloadableFile.getText().toLowerCase();
        click(downloadButtonInModal);
    }

    public String getNameOfTheDownloadableFile() {
        return nameOfFile;
    }

    public String getExtensionOfDownloadableFile() {
        return extensionOfFile;
    }

    public boolean isFileDownloaded() {
        return isFileExistsInDirectory(System.getProperty("user.dir") + "/src/main/resources", getNameOfTheDownloadableFile(), getExtensionOfDownloadableFile());
    }
}