package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 */
public class AngryMood extends BaseMood {

    public AngryMood() {
        super();
        this.mood = "Angry";
    }

    public AngryMood(Date date) {
        super();
        this.mood = "Angry";
        this.setDate(date);
    }

    @Override
    public String whatIsTheMood() {
        return this.mood;
    }
}
