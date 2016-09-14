package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 */
public abstract class BaseMood {

    protected String mood;
    private Date date;

    public BaseMood() {
        this.date = new Date();
    }

    public BaseMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String whatIsTheMood();
}
