package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        // explicit wait jak się nie doczekamy na element to nieleci exception element not found tylko timeout czekania na element
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(LOCATOR_SEARCH_BOX));

        return new GoogleResultPage(driver);
    }
}
