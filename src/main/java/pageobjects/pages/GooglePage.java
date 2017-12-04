package pageobjects.pages;

import org.openqa.selenium.WebDriver;

public class GooglePage {
    public static final String GOOGLE_ADDRESS = "http://www.google.com/";
    protected WebDriver driver;

    public GooglePage(WebDriver driver){
        this.driver = driver;


    }

}
