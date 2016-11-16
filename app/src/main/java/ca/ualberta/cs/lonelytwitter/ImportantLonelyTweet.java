package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

/**
 * Created by keith on 11/15/2016.
 * #7, fix  this... ah.
 */
public class ImportantLonelyTweet extends LonelyTweet {

    // Delete redundant constructor never used #4

    public ImportantLonelyTweet(String text) {
        super(text);
    }

    public String getTweetBody() {
        return tweetBody.toUpperCase();
    }

    @Override
    public String toString() {
        String s = getTweetDate() + " | " + getTweetBody() ;
        Log.i("important lonely tweet", s);
        return s;
    }
}
