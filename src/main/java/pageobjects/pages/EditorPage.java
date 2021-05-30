package pageobjects.pages;

import org.openqa.selenium.By;
import pageobjects.base.BasePage;
import utilities.WaitHelper;

import static utilities.FileHelper.isFileExistsInDirectory;

public class EditorPage extends BasePage {
    private final By itemsInSideBarLocation = By.cssSelector(("[class*='customSizeContainer']"));
    private final By fitIconLocation = By.id("background-category");
    private final By downloadButton = By.id("download-button");
    private final By downloadButtonInModal = By.cssSelector("[data-test='downloaded-button']");
    private final By downloadSuccessfulDialog = By.className("ReactModal__Content");
    private final By fileNameLocation = By.cssSelector("[data-test='downloaded-file-name']");
    private final By extensionOfDownloadableFileLocations = By.cssSelector("[data-test='unit'] span");

    private String nameOfFile;
    private String extensionOfFile;

    public int getCountOfItemsInSideBar() {
        WaitHelper.getInstance().waitForElementToDisplayed(itemsInSideBarLocation);
        return findAll(itemsInSideBarLocation).size();
    }

    public void clickOnFitIcon() {
        WaitHelper.getInstance().waitForElementToDisplayed(fitIconLocation);
        click(fitIconLocation);
    }

    public void clickOnDownloadButton() {
        WaitHelper.getInstance().waitForElementToDisplayed(downloadButton);
        click(downloadButton);
        nameOfFile = find(fileNameLocation).getAttribute("value");
        extensionOfFile = find(extensionOfDownloadableFileLocations).getText().toLowerCase();
    }

    public void clickOnDownloadButtonInModal() {
        WaitHelper.getInstance().waitForElementToDisplayed(downloadButtonInModal);
        WaitHelper.getInstance().waitForTextToBePresentInElement(find(downloadButtonInModal), "Download");
        click(downloadButtonInModal);
    }

    public boolean isDownloadSuccessfulDialogOpened() {
        try {
            WaitHelper.getInstance().waitForElementToDisplayed(downloadSuccessfulDialog);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public String getNameOfTheDownloadableFile() {
        return nameOfFile;
    }

    public String getExtensionOfDownloadableFile() {
        return extensionOfFile;
    }


    public boolean isFileDownloaded() {
        return isFileExistsInDirectory("/Users/artyomtonoyan/Documents", getNameOfTheDownloadableFile(), getExtensionOfDownloadableFile());
    }

    public void open(String endOfUrl) {
        super.open(getURL() + endOfUrl);/**/
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "create/editor";
    }
}