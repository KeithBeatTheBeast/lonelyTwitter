package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 * @see BaseMood
 * One of the required moods.
 * @author keith
 *
 */
public class AngryMood extends BaseMood {

    /**
     * Instantiates a new Angry mood, with default fate.
     */
    public AngryMood() {
        super();
        this.mood = "Angry";
    }

    /**
     * Instantiates a new Angry mood, with specified date.
     *
     * @param date the date
     */
    public AngryMood(Date date) {
        super();
        this.mood = "Angry";
        this.setDate(date);
    }

    /**
     * Characteristic mood.
     * @return "Angry"
     */
    @Override
    public String whatIsTheMood() {
        return this.mood;
    }
}
