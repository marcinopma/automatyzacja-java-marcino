package wordpresstest.wtest;

import org.junit.Assert;
import org.junit.Test;
import wordpresstest.wdomain.RandomComment;
import wordpresstest.wpages.WMainPage;
import wordpresstest.wpages.WPostPage;


public class WTest extends WBaseTest{

    @Test
    public void enterToBlogPage(){
        WMainPage mainPage = new WMainPage(driver);
        mainPage.open();

        WPostPage postPage = mainPage.enterFirstPost();

        RandomComment comment = new RandomComment();
        WPostPage refreshedPostPage = postPage.enterComment(comment);

        //Asercja czy komentarz został dodany
        Assert.assertTrue("'" + comment.getContent() + "' page found", refreshedPostPage.countComments(comment) == 1);
    }
}
