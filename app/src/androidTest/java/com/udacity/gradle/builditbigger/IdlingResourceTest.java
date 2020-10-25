package com.udacity.gradle.builditbigger;

//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.IdlingResource;
//import android.support.test.espresso.ViewAssertion;
//import android.support.test.rule.ActivityTestRule;

//import android.support.test.espresso.Espresso;
//import android.support.test.espresso.IdlingResource;
//import android.support.test.runner.AndroidJUnit4;

//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;

//import android.support.test.runner.AndroidJUnit4;
//import android.test.ext.junit.rules.ActivityTestRule;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
//import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.notNullValue;

//import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.assertion.ViewAssertions.matches;
//import static android.support.test.espresso.matcher.ViewMatchers.withId;
//import static android.support.test.espresso.matcher.ViewMatchers.withText;
//import static org.hamcrest.Matchers.containsString;



//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;

//import android.support.test.rule.ActivityTestRule;

//import android.support.test.espresso.ViewAssertion;
//import static android.support.test.espresso.assertion.ViewAssertions.*;

//import android.support.test.espresso.ViewAssertion;

//import android.support.test.espresso.ViewAssertion;


@RunWith(AndroidJUnit4.class)
public class IdlingResourceTest {

    /**
     * The ActivityTestRule is a rule provided by Android used for functional testing of a single
     * activity. The activity that will be tested, MenuActivity in this case, will be launched
     * before each test that's annotated with @Test and before methods annotated with @Before.
     *
     * The activity will be terminated after the test and methods annotated with @After are
     * complete. This rule allows you to directly access the activity during the test.
     */
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);



    private IdlingResource mIdlingResource;


    // Registers any resource that needs to be synchronized with Espresso before the test is run.
    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        // To prove that the test fails, omit this call:
        Espresso.registerIdlingResources(mIdlingResource);
    }

    @Test
    public void testAsyncTask() throws InterruptedException, ExecutionException {
        // on the MainActivity execute the AsyncTask
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();

        // the String returned in the onPostExecute is being retrieved
        Object randomJoke = endpointsAsyncTask.get();

        // If string is not null then test passes
        //a joke was successfully received from GCE
        notNullValue((Class<Object>) randomJoke);
    }

//    @Test
//    public void idlingResourceTest() {
//        Espresso.onView(withId(R.id.jokeTextView))
//                .check(matches(withText(
//                        containsString("A joke will be displayed here"))));
//
//        Espresso.onView(withId(R.id.tellJokeButton))
//                .perform(click());
//
//        Espresso.onView(withId(R.id.jokeTextView))
//                .check(matches(withText(
//                        containsString("What do you call a pig that does karate?\nA pork chop."))));
//
//    }
//
//    // Remember to unregister resources when not needed to avoid malfunction.
//    @After
//    public void unregisterIdlingResource() {
//        if (mIdlingResource != null) {
//            Espresso.unregisterIdlingResources(mIdlingResource);
//        }
//    }
}

