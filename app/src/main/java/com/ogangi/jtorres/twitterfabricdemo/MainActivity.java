package com.ogangi.jtorres.twitterfabricdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetui.TweetUi;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String TWITTER_KEY = getResources().getString(R.string.twitter_key);
        String TWITTER_SECRET =  getResources().getString(R.string.twitter_secret);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new TweetUi(), new TweetComposer());


        if(TwitterCore.getInstance().getSessionManager().getActiveSession() == null){
            Intent login = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(login);
        }else{
            Intent timeline = new Intent(getApplicationContext(),TimelineActivity.class);
            startActivity(timeline);
        }
        finish();
    }
}
