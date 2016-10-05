package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keith on 9/27/2016.
 * @author keith
 */
public class TweetList {
    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Add.
     *
     * @param tweet the tweet
     */
    public void add(Tweet tweet) {
        if (!this.hasTweet(tweet)) {
            tweets.add(tweet);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Has tweet boolean.
     *
     * @param tweet the tweet
     * @return the boolean
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets tweet.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Delete.
     *
     * @param a the a
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Gets tweets.
     *
     * @return the tweets
     */
    public List<Tweet> getTweets() {
        return this.tweets;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return tweets.size();
    }
}
