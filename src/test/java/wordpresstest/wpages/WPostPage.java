package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wordpresstest.wdomain.RandomComment;

public class WPostPage extends WPage {
    public static final By ADDED_COMMENT_LOCATOR = By.cssSelector(".comment-content > p");
    private static final By COMMENT_LOCATOR = By.id("comment");
    private static final By EMAIL_LOCATOR = By.id("email");
    private static final By NAME_LOCATOR = By.id("author");
    private static final By WEB_LOCATOR = By.id("url");

    WPostPage(WebDriver driver) {
        super(driver);
    }

    public WPostPage enterComment(RandomComment comment) {
        return enterComment(comment.getContent(), comment.getEmail(), comment.getName(), comment.getWebPage());
    }

    public WPostPage enterComment(String content, String email, String name, String webPage){
        WebElement enterPost = driver.findElement(COMMENT_LOCATOR);
        enterPost.click();
        enterPost.clear();
        enterPost.sendKeys(content);

        WebElement enterEmail = driver.findElement(EMAIL_LOCATOR);

        enterEmail.clear();
        enterEmail.sendKeys(email);

        WebElement enterName = driver.findElement(NAME_LOCATOR);
        enterName.clear();
        enterName.sendKeys(name);

        WebElement enterWeb = driver.findElement(WEB_LOCATOR);
        enterWeb.clear();
        enterWeb.sendKeys(webPage);

        enterWeb.submit();

        return new WPostPage(driver);
    }

    public int countComments(RandomComment comment) {
        return (int) driver.findElements(ADDED_COMMENT_LOCATOR).stream()
                .filter(webElement -> webElement.getText().equals(comment.getContent()))
                .count();
    }
}
