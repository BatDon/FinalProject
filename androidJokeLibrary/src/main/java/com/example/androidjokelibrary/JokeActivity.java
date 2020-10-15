package com.example.androidjokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.example.android.jokedisplay.R;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_FROM_JAVA_JOKE_JAR="com.udacity.gradle.builditbigger.Java_joke";

    TextView jokeTextView;

    public static final String TAG=JokeActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTextView=findViewById(R.id.jokeTextView);

        Intent intent = getIntent();

        if (intent != null){
            String joke=intent.getStringExtra(JOKE_FROM_JAVA_JOKE_JAR);
            jokeTextView.setText(joke);
        }

        else {
            Log.d(TAG, "intent was null");
        }
    }
}
