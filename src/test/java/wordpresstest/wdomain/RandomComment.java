package wordpresstest.wdomain;

import java.util.UUID;

public class RandomComment {
    private final String content;
    private static final String email = "marcintestowy@wp.pl";
    private static final String name = "Tester";
    private static final String webPage = "http://www.test.wp.pl";

   // private final String contentComment;
    private static final String emailComment = "commentmarcintestowy@wp.pl";
    private static final String nameComment = "TesterComment";
    private static final String webPageComment = "http://www.test.wp.pl";

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getWebPage() {
        return webPage;
    }

    public RandomComment() {
        this.content = "uuid = " + UUID.randomUUID().toString();
    }

    public String getContentComment() {
        return content;
    }

    public String getEmailComment() {
        return emailComment;
    }

    public String getNameComment() {
        return nameComment;
    }

    public String getWebPageComment() {
        return webPageComment;
    }


}
