package wordpresstest.wtest;

import org.junit.Test;
import pageobjects.test.BaseTest;
import wordpresstest.wpages.WAdminPage;
import wordpresstest.wpages.WLoginPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void logIn(){
        WLoginPage loginPage = new WLoginPage(driver);

        WAdminPage adminPage = loginPage.logIn("autotestjava@gmail.com", "P@ssw0rd1");

        assertTrue("Should open admin page", adminPage.isOpen());
    }
}
