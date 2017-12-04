package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class GoogleResultPage extends GooglePage{

    private static final By LOCATOR_SINGLE_RESULT = By.cssSelector(".rc > .r > a");
    private static final By LOCATOR_NEXT_PAGE_LINK = By.id("pnnext");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public int containsResultWithURL(String pageUrl) {
        List<WebElement> results = driver.findElements(LOCATOR_SINGLE_RESULT);
        Stream<WebElement> resultStream = results.stream();
        return(int) resultStream.filter(result -> result.getAttribute("href").equals(pageUrl)).count();
    }

    public GoogleResultPage displayNexPage() {
        driver.findElement(LOCATOR_NEXT_PAGE_LINK).click();
        return new GoogleResultPage(driver);
    }

    public int countResultWithURLMatching(String pageUrl) {
        return(int) driver.findElements(By.cssSelector(".rc > .r > a"))
                .stream()
                .filter(result -> result.getAttribute("href").equals(pageUrl)).count();
    }
/*
    public int containsResultWithURL2(String pageUrl) {
        // inny zapis containsResultWithURL
        return(int) driver.findElements(By.cssSelector(".rc > .r > a"))
                .stream()
                .filter(result -> result.getAttribute("href").equals(pageUrl)).count();

    }
*/

}
