package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by keith on 11/15/2016.
 * #6 fix this... ah...
 */

public abstract class LonelyTweet implements Serializable {

    private static final long serialVersionUID = 1L;
    protected Date tweetDate;
    protected String tweetBody;

    public LonelyTweet() {
        this.tweetDate = new Date();
        this.tweetBody = "#notmypresident? #dealwithit!";
    }

    public LonelyTweet(String text) {
        this.tweetDate = new Date();
        this.tweetBody = text;
    }

    public Date getTweetDate() {
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(tweetDate);
        out.writeObject(tweetBody);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        tweetDate = (Date) in.readObject();
        tweetBody = (String) in.readObject();
    }

    public boolean isValid() {
        // If statement simplified. #1
        int s = tweetBody.trim().length();
        if (s == 0 || s > 10) {
            return false;
        }

        return true;
    }

}
