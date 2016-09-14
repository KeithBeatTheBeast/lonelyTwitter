package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 */
public class HappyMood extends BaseMood {

    public HappyMood() {
        super();
        this.mood = "Happy";
    }

    public HappyMood(Date date) {
        super();
        this.mood = "Happy";
        this.setDate(date);
    }

    @Override
    public String whatIsTheMood() {
        return this.mood;
    }
}
