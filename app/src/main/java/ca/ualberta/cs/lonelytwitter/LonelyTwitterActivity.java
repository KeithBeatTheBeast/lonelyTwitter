/*
 Copyright (c) 2016 Team 5, CMPUT 301, University of Alberta - All Rights Reserved.
 You may use, distribute, and copy all or parts of this code under terms and conditions of
 University of Alberta and the Code of Student Behaviour.
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This is the main view class of LonelyTwitter project. It handles all
 * user interactions as well as file manipulations.
 *
 * @author keith
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * File that contains all tweets; json
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	private ArrayAdapter<Tweet> adapter;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;

	/**
	 * Called when the activity is first created.
	 * Contains listeners for save and clear buttons
	 * Main function
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * Post the new tweet to gui and save all tweets in JSON file
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		/**
		 * Clear tweet list and write a "nothing" to file.
		 */
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);

				tweetList.clear();
				saveInFile();
				adapter.notifyDataSetChanged();
			}
		});

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
	}

	/**
	 * Auto-generated
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
//		String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"LonelyTwitter Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app URL is correct.
				Uri.parse("android-app://ca.ualberta.cs.lonelytwitter/http/host/path")
		);
		AppIndex.AppIndexApi.start(client, viewAction);
	}

	/**
	 * This method loads the tweets from file.sav
	 * @throws FileNotFoundException
	 * @exception RuntimeException
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// From stackoverflow
			Type listtyppe = new TypeToken<ArrayList<NormalTweet>>() {
			}.getType();

			tweetList = gson.fromJson(in, listtyppe);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList =  new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}


	/**
	 * Called as a result of save button being clicked
	 * Saves list of tweets with GSON/JSON
	 * @throws RuntimeException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Generated by App Indexing API
	 */
	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		Action viewAction = Action.newAction(
				Action.TYPE_VIEW, // TODO: choose an action type.
				"LonelyTwitter Page", // TODO: Define a title for the content shown.
				// TODO: If you have web page content that matches this app activity's content,
				// make sure this auto-generated web page URL is correct.
				// Otherwise, set the URL to null.
				Uri.parse("http://host/path"),
				// TODO: Make sure this auto-generated app URL is correct.
				Uri.parse("android-app://ca.ualberta.cs.lonelytwitter/http/host/path")
		);
		AppIndex.AppIndexApi.end(client, viewAction);
		client.disconnect();
	}
}