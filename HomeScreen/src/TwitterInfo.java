

import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Map;

public class TwitterInfo {
public static void main(String[] a) {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey("z1BYweY29GZA3366xzg4tZDVX");
    cb.setOAuthConsumerSecret("Wwvw5GQl7FzpfuTmaAtBd9jssmsc88IQih5eTHbnR17n1uO97D");
    cb.setOAuthAccessToken("494949222-InfE0MU8dgRXcH59L2bfSsC65Cl9aapaPObN1nGh");
    cb.setOAuthAccessTokenSecret("k7TKdVZ25OnS6saNjVqo08v69O9a5YHSxflQZgfe1elix");

    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

    String user = "seeocon";
    List<Status> statuses = new ArrayList();

    while (true) {

      try {

        int size = statuses.size(); 
        Paging page = new Paging(1, 5);
        statuses.addAll(twitter.getUserTimeline(user, page));
        if (statuses.size() == size)
          break;
      }
      catch(TwitterException e) {

        e.printStackTrace();
      }
    }
    for (Status s : statuses){
        System.out.println("@" + s.getUser().getScreenName() + " tweeted " + s.getText() + "\n");
    }

}
}