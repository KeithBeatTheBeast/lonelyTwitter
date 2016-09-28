package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.List;

/**
 * Created by keith on 9/27/2016.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet =  new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));

    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet =  new NormalTweet("Hello!");
        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a =  new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi");
        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello");
        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    public void testAddTwice() {
        TweetList list = new TweetList();

        Tweet a =  new NormalTweet("a");
        list.add(a);
        try {
            list.add(a);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertFalse(false);
        }
    }

    public void testGetTweets() {
        TweetList list = new TweetList();

        Tweet a =  new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi");
        list.add(a);
        list.add(b);
        List<Tweet> otherList = list.getTweets();
        assertEquals(a, otherList.get(0));
        assertEquals(b, otherList.get(1));
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("jjj");
        Tweet b = new NormalTweet("jjj");
        Tweet c = new NormalTweet("jjj");
        assertEquals(0, list.getCount());
        list.add(a);
        assertEquals(1, list.getCount());
        list.add(b);
        assertEquals(2, list.getCount());
        list.add(c);
        assertEquals(3, list.getCount());
    }
}
