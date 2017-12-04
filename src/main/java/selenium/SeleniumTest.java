package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
// import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    private static final String CLASS_RC_CLASS_R_A_HREF_AGILESZKOLENIA_PL = "//*[@class='rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    private static final By CS_PAGE_LOCATOR = By.xpath(CLASS_RC_CLASS_R_A_HREF_AGILESZKOLENIA_PL);

    //   @BeforeClass   // startuje raz i używa tego samego webdrivera przez wszystkie testy dobre przy uruchamianiu kolejnym testów a nie ma to sensu przy uruchomieniu kilku testów na raz
    //dobre przy ustalaniu połaczenia z bazą którego użyją inne testy na przykład

    public WebDriver driver;


    @Before  //Before będzie powtarzane przed każdym testem a nie jednorazowo
    public void initializeBrowser(){
       // System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");  //linia zbędna jeżeli mamy chomedrivera w zmiennej środowiskowej systemowej
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void firstSeleniumTest() throws InterruptedException {
        driver.get("http://google.com");
        //lst-ib
        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.click();
        searchBox.clear();
        searchBox.sendKeys("code sprinters");
        searchBox.submit();

        Assert.assertTrue("CS page found", driver.findElements(CS_PAGE_LOCATOR).size()>0);


        Thread.sleep(1000); //nie stosować thread sleep w testach bo zatrzymuje wątek na sekundę on się zawsze minimum sekundę będzie wykonywałtesty mogą się przez to wydłużyć

    }

    @After  // po wykonaniu testów zamknij na przykład przeglądarkę
    public void closeBrowser(){
            if (driver != null) {
                driver.quit(); //zamknij przeglądarkę bo close zamyka taba
            }
        }
}
