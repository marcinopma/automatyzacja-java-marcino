package pageobjects.pages;

import org.openqa.selenium.WebDriver;

public abstract class GooglePage {
    public static final String GOOGLE_ADDRESS = "http://www.google.pl/";
    protected WebDriver driver;

    public GooglePage(WebDriver driver){
        this.driver = driver;


    }

}
