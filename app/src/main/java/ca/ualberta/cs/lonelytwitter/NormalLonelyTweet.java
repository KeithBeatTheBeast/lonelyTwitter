package ca.ualberta.cs.lonelytwitter;

public class NormalLonelyTweet extends LonelyTweet {

	// #5 delete redundant constructor.

	public NormalLonelyTweet(String text) {
		super(text);
	}

	public String getTweetBody() {
        return tweetBody;
    }

	@Override
    public String toString() {
        return getTweetDate() + " | " + getTweetBody() ;
    }
}