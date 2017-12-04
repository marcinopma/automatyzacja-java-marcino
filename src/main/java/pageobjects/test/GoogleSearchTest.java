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

            GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);




            // assert
            Assert.assertTrue("'" + CodeSprinters.PAGE_NAME + "' page found", resultPage.containsResultWithURL(CodeSprinters.PAGE_URL) > 0);
        }

    private GoogleResultPage searchOnGoogle(String pageName) {
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();
        return mainPage.searchFor(pageName);
    }

    @Test
        public void verifyGoogleShowsNoCodeSprinterOnSecondPage(){
            GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
            GoogleResultPage secondResultPage = resultPage.displayNexPage();
            Assert.assertTrue("'Page with URL starting with" + CodeSprinters.PAGE_NAME + "' page not found",
                    secondResultPage.countResultWithURLMatching(CodeSprinters.PAGE_URL) == 0);
        }

}
