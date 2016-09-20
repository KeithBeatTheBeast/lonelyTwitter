package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 */
public abstract class Tweet {

    private String message;
    private Date date;
    private ArrayList<BaseMood> tweetMoodList;


    public Tweet(String message) {
        this.message = message;
        this.tweetMoodList = new ArrayList<BaseMood>();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
        this.tweetMoodList = new ArrayList<BaseMood>();
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            // Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void addAMood(BaseMood mood) {
        tweetMoodList.add(mood);
        System.out.println("Added a mood! Mood is ");
        System.out.println(mood.whatIsTheMood());
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
