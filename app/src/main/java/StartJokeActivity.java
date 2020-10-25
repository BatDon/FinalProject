package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

import com.example.androidjokelibrary.JokeActivity;

import static com.example.androidjokelibrary.JokeActivity.JOKE_FROM_JAVA_JOKE_JAR;


public class StartJokeActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public StartJokeActivity(String joke){

        if(joke!=null) {

            Intent intent = new Intent(this, JokeActivity.class);
            intent.putExtra(JOKE_FROM_JAVA_JOKE_JAR, joke);
            startActivity(intent);
        }
    }


}
