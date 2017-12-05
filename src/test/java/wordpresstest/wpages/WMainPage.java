package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class WMainPage extends WPage{
    public static final By LOCATOR_FIRST_POST = By.className("entry-title");

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
}
