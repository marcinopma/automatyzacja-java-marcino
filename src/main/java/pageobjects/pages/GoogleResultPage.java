package pageobjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

public class GoogleResultPage extends GooglePage{
    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public int containsResultWithURL(String pageUrl) {
        List<WebElement> results = driver.findElements(By.cssSelector(".rc > .r > a"));
        Stream<WebElement> resultStream = results.stream();
        return(int) resultStream.filter(result -> result.getAttribute("href").equals(pageUrl)).count();
    }

    public int containsResultWithURL2(String pageUrl) {
    //    return(int) driver.findElements(By.cssSelector(".rc > .r > a"))
return 0;
     //   Stream<WebElement> resultStream = results.stream();
     //   return(int) resultStream.filter(result -> result.getAttribute("href").equals(pageUrl)).count();
    }
}
