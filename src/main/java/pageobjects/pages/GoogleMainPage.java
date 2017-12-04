package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMainPage extends GooglePage{

    public static final By LOCATOR_SEARCH_BOX = By.id("lst-ib");

    public GoogleMainPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(GOOGLE_ADDRESS);
    }

    public GoogleResultPage searchFor(String pageName) {
        WebElement searchBox = driver.findElement(LOCATOR_SEARCH_BOX);
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys(pageName);
        searchBox.submit();

        return new GoogleResultPage(driver);
    }
}
