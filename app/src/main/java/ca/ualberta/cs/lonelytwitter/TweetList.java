package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keith on 9/27/2016.
 */

public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        if (!this.hasTweet(tweet)) {
            tweets.add(tweet);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

    public List<Tweet> getTweets() {
        return this.tweets;
    }

    public int getCount() {
        return tweets.size();
    }
}
