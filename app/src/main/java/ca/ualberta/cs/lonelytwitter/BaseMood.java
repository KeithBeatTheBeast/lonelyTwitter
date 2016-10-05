package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 * Abstract mood class
 * @see AngryMood
 * @see HappyMood
 * @author keith
 */
public abstract class BaseMood {

    /**
     * The Mood.
     */
    protected String mood;
    private Date date;

    /**
     * Instantiates a new Base mood with default date.
     */
    public BaseMood() {
        this.date = new Date();
    }

    /**
     * Instantiates a new Base mood with specified date.
     *
     * @param date the date
     */
    public BaseMood(Date date) {
        this.date = date;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * What is the mood string.
     *
     * @return the string
     */
    public abstract String whatIsTheMood();
}
