package ca.ualberta.cs.lonelytwitter;

/**
 * Created by keith on 9/13/2016.
 * @author keith
 * @see Tweet
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Not really a big deal...
     * @return
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
