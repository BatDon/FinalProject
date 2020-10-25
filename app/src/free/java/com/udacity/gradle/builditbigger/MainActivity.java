package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidjokelibrary.JokeActivity;
//import com.udacity.gradle.Joke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.Joke;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;
import com.udacity.gradle.builditbigger.JokeDownloader.JokeDownloader;
import com.udacity.gradle.builditbigger.R;


//public class MainActivity extends AppCompatActivity implements JokeDownloader.JokeDelayerCallback  {
public class MainActivity extends AppCompatActivity {

    //testing
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    private InterstitialAd mInterstitialAd;

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }


    public static final String JOKE_FROM_JAVA_JOKE_JAR="com.udacity.gradle.builditbigger.Java_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up interstatial add
        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
//        // Load an interstitial ad
//        mInterstitialAd.loadAd(adRequest);
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial ad if one isn't already loaded. Then, kick off a task
//                // to retrieve a joke
//                startTask();
//            }
//        });

        getIdlingResource();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void tellJoke(View view) {
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
//    }

        public void tellJoke(View view){
        Log.i("MainActivityFragment","tellJokeClicked");
        Joke jokeClass=new Joke();
//        jokeTextView.setText(jokeClass.getJoke());
            String joke=jokeClass.getJoke();
//        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();

//            Intent intent=new Intent(this, JokeActivity.class);
//            intent.putExtra(JOKE_FROM_JAVA_JOKE_JAR, joke);
//            startActivity(intent);

            startAsyncTask();

//            new JokeDownloader().downloadJoke(this, MainActivity.this, mIdlingResource);

    }

    private void showInterstatialAd(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.i("free/MainActivity","Interstatial Ad can't be shown. It hasn't loaded yet");
//            startTask();
        }
    }

    private void loadInterstatialAd() {
            //loads anew interstatial ad every time activty is launched
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
        // Kick off a task to retrieve a joke
//        new EndpointsAsyncTask(this).execute(mCategory);


//    @Override
//    public void onDone(String joke){
//        new StartJokeActivity(joke);
//    }

    private void startAsyncTask() {
        new EndpointsAsyncTask(mIdlingResource).execute(null, null, null);
    }



}
