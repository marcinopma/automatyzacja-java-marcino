package wordpresstest.wpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WLoginPage extends WPage{

    public static final String WORDPRESS_LOGIN_PAGE_ADRESS = WORDPRESS_ADDRESS + "wp-login.php";
    private @FindBy(id = "usernameOrEmail") WebElement userNameInputBox;
    private @FindBy(id = "password") WebElement userPasswordBox;

    public WLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WAdminPage logIn(String userName, String passWord){
        driver.get(WORDPRESS_LOGIN_PAGE_ADRESS);

       // WebElement userNameInputBox = driver.findElement(By.id("usernameOrEmail"));
        writeInto(userName, userNameInputBox);
        userNameInputBox.submit();

     //   WebDriverWait wait = new WebDriverWait(driver, 30);
     //   wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        waitUntilElementsIsClickable(userPasswordBox);

       // WebElement userPasswordBox = driver.findElement(By.id("password"));
        writeInto(passWord, userPasswordBox);
        userPasswordBox.submit();

        return new WAdminPage(driver);

    }



}
