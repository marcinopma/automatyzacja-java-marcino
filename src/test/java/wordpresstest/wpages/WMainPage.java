package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wordpresstest.wdomain.RandomComment;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WMainPage extends WPage{
    public static final By LOCATOR_FIRST_POST = By.className("entry-title");
    public static final By LOCATOR_REPLAY = By.cssSelector(".reply > a");
    public static final By ADDED_COMMENT_POST_LOCATOR = By.cssSelector(".comment-body");


    public WMainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(WORDPRESS_ADDRESS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public WPostPage enterFirstPost(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(LOCATOR_FIRST_POST);

        searchBox.click();
        return new WPostPage(driver);
    }

    public WAddCommentPage enterFirstComment(RandomComment comment){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        List<WebElement> webElements = driver.findElements(ADDED_COMMENT_POST_LOCATOR)
                .stream()
                .filter(webElement -> webElement.findElement(By.cssSelector("p")).getText().equals(comment.getContent()))
                .collect(Collectors.toList());

        if (webElements.size() > 1) {
            throw new RuntimeException("Someone made terrible mistake.");
        }

        webElements.get(0).findElement(LOCATOR_REPLAY).click();
        return new WAddCommentPage(driver);
    }
}
