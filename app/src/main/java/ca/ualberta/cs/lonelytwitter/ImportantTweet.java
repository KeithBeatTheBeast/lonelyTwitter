package ca.ualberta.cs.lonelytwitter;

/**
 * Created by keith on 9/13/2016.
 * @author keith
 * @see Tweet
 */
public class ImportantTweet extends Tweet {
    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     *  It's actually really important
     * @return
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
