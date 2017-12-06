package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WPage {
    public static final String WORDPRESS_ADDRESS = "https://autotestjava.wordpress.com/";
    protected WebDriver driver;

    public WPage(WebDriver driver){
        this.driver = driver;


    }

    protected void writeInto(String content, WebElement webElement) {
        webElement.click();
        webElement.clear();
        webElement.sendKeys(content);
    }

    protected void waitUntilElementsIsClickable(WebElement userPasswordBox){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(userPasswordBox));
    }
}
