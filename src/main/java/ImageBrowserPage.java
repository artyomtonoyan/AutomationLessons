import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ImageBrowserPage extends BasePage {
    public static final String[] HASHTAGS = {"#MYTEST", "#HELLO", "#DDDD"};

    private final By likeIconLocation = By.cssSelector(".actions-section .notifier-hover-toggle .like");
    private final By descriptionLocationHashtagsList = By.cssSelector(".description a");
    private final By likesCountIconLocation = By.cssSelector(".notifier-hover-toggle .js-likes-count");

    public void clickOnLikeIcon() {
        WaitHelper.getInstance().waitForElementToDisplayed(likeIconLocation);
        click(likeIconLocation);
    }

    public ImageBrowserPage(String imageId) {
        open(getURL() + imageId);
    }

    public ImageBrowserPage() {

    }

    ArrayList<String> getHashtagsList() {
        WaitHelper.getInstance().waitForElementToDisplayed(descriptionLocationHashtagsList);
        List<WebElement> hashtagsElements = findAll(descriptionLocationHashtagsList);
        ArrayList<String> hashtagsList = new ArrayList<>();
        for (WebElement hashtagElement : hashtagsElements) {
            hashtagsList.add(hashtagElement.getText());
        }
        return hashtagsList;
    }

    public boolean isHashtagsAdded() {
        if (getHashtagsList().isEmpty()) {
            return false;
        }
        for (String hashtag : HASHTAGS) {
            if (!getHashtagsList().contains(hashtag)) {
                return false;
            }
        }
        return true;
    }

    public boolean isLikedOld() {
        WaitHelper.getInstance().waitForElementToDisplayed(likeIconLocation);
        return find(likeIconLocation).getAttribute("class").contains("active");
    }

    public boolean isLiked() {
        WaitHelper.getInstance().waitForElementToDisplayed(likesCountIconLocation);
        return find(likesCountIconLocation).getText().equals("1");
    }

    @Override
    public String getURL() {
        return BASE_URL_PICSART + "i/";
    }

}
