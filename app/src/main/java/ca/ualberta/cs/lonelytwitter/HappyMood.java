package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 * @author keith
 * @see BaseMood
 */
public class HappyMood extends BaseMood {

    /**
     * Instantiates a new Happy mood with default date
     */
    public HappyMood() {
        super();
        this.mood = "Happy";
    }

    /**
     * Instantiates a new Happy mood with specified date
     *
     * @param date the date
     */
    public HappyMood(Date date) {
        super();
        this.mood = "Happy";
        this.setDate(date);
    }

    /**
     * "Happy"
     * @return
     */
    @Override
    public String whatIsTheMood() {
        return this.mood;
    }
}
