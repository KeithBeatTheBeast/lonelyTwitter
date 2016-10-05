package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by keith on 9/13/2016.
 * @author keith
 */
public interface Tweetable {

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate();
}
