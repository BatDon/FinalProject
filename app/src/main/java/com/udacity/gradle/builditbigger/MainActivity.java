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
import com.udacity.gradle.Joke;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;
import com.udacity.gradle.builditbigger.JokeDownloader.JokeDownloader;


//public class MainActivity extends AppCompatActivity implements JokeDownloader.JokeDelayerCallback  {
public class MainActivity extends AppCompatActivity {

    //testing
    @Nullable
    private SimpleIdlingResource mIdlingResource;

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
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();

//            Intent intent=new Intent(this, JokeActivity.class);
//            intent.putExtra(JOKE_FROM_JAVA_JOKE_JAR, joke);
//            startActivity(intent);

            new EndpointsAsyncTask(mIdlingResource).execute(null, null, null);

//            new JokeDownloader().downloadJoke(this, MainActivity.this, mIdlingResource);

    }

//    @Override
//    public void onDone(String joke){
//        new StartJokeActivity(joke);
//    }


}
