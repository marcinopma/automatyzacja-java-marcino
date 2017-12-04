package pageobjects.test;

import org.junit.Assert;
import org.junit.Test;
import pageobjects.domain.CodeSprinters;
import pageobjects.pages.GoogleMainPage;
import pageobjects.pages.GooglePage;
import pageobjects.pages.GoogleResultPage;

public class GoogleSearchTest extends BaseTest{

        @Test
        public void verifyGoogleFindsCodeSprintersPage(){
           // GooglePage gP = new GooglePage(driver);
            // Arrange - przygotowanie testu
            //-- otworzyć główną stronę googla jako obiekt
            GoogleMainPage mainPage = new GoogleMainPage(driver);
            mainPage.open();


            //act - działanie
            GoogleResultPage resultPage = mainPage.searchFor(CodeSprinters.PAGE_NAME);




            // assert
            Assert.assertTrue("CS page found", resultPage.containsResultWithURL(CodeSprinters.PAGE_URL) > 0);
        }

}
