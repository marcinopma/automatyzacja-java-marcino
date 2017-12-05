package wordpresstest.wtest;

import org.junit.Assert;
import org.junit.Test;
import wordpresstest.wdomain.RandomComment;
import wordpresstest.wdomain.WordPressPage;
import wordpresstest.wpages.WAddCommentPage;
import wordpresstest.wpages.WMainPage;
import wordpresstest.wpages.WPostPage;


public class WTest extends WBaseTest{

    @Test
    public void enterToBlogPage(){
        WMainPage mainPage = new WMainPage(driver);
        mainPage.open();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, WordPressPage.PAGE_URL);

        WPostPage postPage = mainPage.enterFirstPost();

        RandomComment comment = new RandomComment();
        WPostPage refreshedPostPage = postPage.enterComment(comment);

        //Asercja czy komentarz został dodany
        Assert.assertTrue("'" + comment.getContent() + "' page found", refreshedPostPage.countComments(comment) == 1);
/////////////////////////////////////////////////////////////////////////////////// PART 2
        WAddCommentPage addComment = mainPage.enterFirstComment(comment);

        RandomComment commentContent = new RandomComment();
        WAddCommentPage refreshedReplayPage = addComment.enterReplyComment(commentContent);
        //Asercja czy komentarz został dodany
        Assert.assertTrue("'" + commentContent.getContent() + "' page found", refreshedReplayPage.countComments(commentContent) == 1);

    }
/*
    @Test
    public void enterComment(){
        WMainPage mainPage = new WMainPage(driver);
        mainPage.open();
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, WordPressPage.PAGE_URL);

        WAddCommentPage addComment = mainPage.enterFirstComment();

        RandomComment commentContent = new RandomComment();
        WAddCommentPage refreshedReplayPage = addComment.enterReplyComment(commentContent);
        //Asercja czy komentarz został dodany
        Assert.assertTrue("'" + commentContent.getContent() + "' page found", refreshedReplayPage.countComments(commentContent) == 1);

    }
    */
/*
    @Test
    public void enterCommentToComment(){


    }
    */
}
