package com.udacity.gradle.builditbigger.JokeDownloader;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;


public class JokeDownloader {


    static String joke=null;

    public interface JokeDelayerCallback{
        void onDone(String joke);
    }

    public static void downloadJoke(Context context, final JokeDelayerCallback callback,
                              @Nullable final SimpleIdlingResource simpleIdlingResource) {


        if (simpleIdlingResource != null) {
            simpleIdlingResource.setIdleState(false);
        }

        new EndpointsAsyncTask(simpleIdlingResource).execute(null, null, null);

//        joke="funny joke";

//        Handler handler = new Handler();
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if (callback != null) {
//                    callback.onDone(joke);
//                    if (simpleIdlingResource != null) {
//                        simpleIdlingResource.setIdleState(true);
//                    }
//                }
//            }
//        });



    }


}
