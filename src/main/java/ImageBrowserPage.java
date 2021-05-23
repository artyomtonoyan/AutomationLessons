import org.openqa.selenium.By;

public class ImageBrowserPage extends BasePage {

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");

    public void clickOnLikeIcon() {
        WaitHelper.getInstance().waitForElementToDisplayed(likeIconLocation);
        click(likeIconLocation);
    }

    public boolean isLiked() {
        return find(likeIconLocation).getAttribute("class").contains("active");
    }

    public ImageBrowserPage() {
        open(getURL());
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "i/image-male-359193804035201";
    }

}
