package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.udacity.gradle.Joke;
//this is the javaJokes library
//import com.udacity.gradle.Joke;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    TextView jokeTextView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        jokeTextView=root.findViewById(R.id.jokeTextView);

        return root;
    }

    public void tellJoke(View view){
        Log.i("MainActivityFragment","tellJokeClicked");
        Joke jokeClass=new Joke();
        jokeTextView.setText(jokeClass.getJoke());
    }
}