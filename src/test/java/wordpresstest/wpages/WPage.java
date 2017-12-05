package wordpresstest.wpages;

import org.openqa.selenium.WebDriver;

public abstract class WPage {
    public static final String WORDPRESS_ADDRESS = "https://autotestjava.wordpress.com/";
    protected WebDriver driver;

    public WPage(WebDriver driver){
        this.driver = driver;


    }
}
