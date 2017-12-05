package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpresstest.wdomain.RandomComment;

public class WAddCommentPage extends WPage{
    public static final By ADDED_COMMENT_LOCATOR = By.cssSelector(".comment-content > p");
    private static final By COMMENT_LOCATOR = By.id("comment");
    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By NAME_LOCATOR = By.id("author");
    private static final By WEB_LOCATOR = By.id("url");

    WAddCommentPage(WebDriver driver) {
        super(driver);
    }

    public WAddCommentPage enterReplyComment(RandomComment commentContent) {
        return enterComment(commentContent.getContentComment(), commentContent.getEmailComment(), commentContent.getNameComment(), commentContent.getWebPageComment());
    }

    public WAddCommentPage enterComment(String content, String emailComment, String nameComment, String webPageComment){

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(COMMENT_LOCATOR));

        WebElement enterComment = driver.findElement(COMMENT_LOCATOR);
        enterComment.click();
        enterComment.clear();
        enterComment.sendKeys(content);

        WebElement enterEmail = driver.findElement(EMAIL_LOCATOR);

        enterEmail.clear();
        enterEmail.sendKeys(emailComment);

        WebElement enterName = driver.findElement(NAME_LOCATOR);
        enterName.clear();
        enterName.sendKeys(nameComment);

        WebElement enterWeb = driver.findElement(WEB_LOCATOR);
        enterWeb.clear();
        enterWeb.sendKeys(webPageComment);

        enterWeb.submit();

        return new WAddCommentPage(driver);
    }

    public int countComments(RandomComment comment) {
        return (int) driver.findElements(ADDED_COMMENT_LOCATOR).stream()
                .filter(webElement -> webElement.getText().equals(comment.getContent()))
                .count();
    }
}
