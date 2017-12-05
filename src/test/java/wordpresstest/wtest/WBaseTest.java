package wordpresstest.wtest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WBaseTest {
    // klasa w której stworzymy sobie naszego webdrivera
    protected WebDriver driver;

    @Before
    public void initWebdriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @After  // po wykonaniu testów zamknij na przykład przeglądarkę
    public void closeBrowser(){
        if (driver != null) {
            driver.quit(); //zamknij przeglądarkę bo close zamyka taba
        }
    }
}
