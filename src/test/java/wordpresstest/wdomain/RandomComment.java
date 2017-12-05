package wordpresstest.wdomain;

import java.util.UUID;

public class RandomComment {
    private final String content;
    private static final String email = "marcintestowy@wp.pl";
    private static final String name = "Tester";
    private static final String webPage = "http://www.test.wp.pl";

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
}
