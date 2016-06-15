

import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Map;

public class TwitterInfo {
    
    // username: nhstvnews
    // password: ics4u1
    
public static void main(String[] a) throws TwitterException {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey("3I1RTnsA7JhWgnbomQuYrEhmP");
    cb.setOAuthConsumerSecret("tNvpM739osUCRtTjDT47Yifbc4OB5mvxXWsKLld4lGRvn1X4SU");
    cb.setOAuthAccessToken("743138963767107584-3MZxk0Et5tmBhDXHWAppmHlyiPO5OW4");
    cb.setOAuthAccessTokenSecret("QaQPydUPRdH8SicXDVoIU13dSq5NKOxcloJlX1ZYYkrCO");

    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
    List<Status> statuses = twitter.getHomeTimeline();
    System.out.println("Showing home timeline.");
    
    // shows the first newest
    for (int i = 0; i<= (statuses.size() < 5 ? statuses.size()-1 : 5); i++){
        System.out.println("@"+statuses.get(i).getUser().getScreenName() + ": " +
                           statuses.get(i).getText());
    }
    
    /*for (Status status : statuses) {
        System.out.println("@"+status.getUser().getScreenName() + ":" +
                           status.getText());
        //status.getUser().getName()           -> gets the name
        //status.getUser().getScreenName().get -> gets the @ user name
        //status.getText()                     -> gets the actual tweet content
    }*/

}
}