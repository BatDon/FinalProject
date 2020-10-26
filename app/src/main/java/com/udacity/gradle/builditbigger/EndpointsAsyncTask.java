package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.androidjokelibrary.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.IdlingResource.SimpleIdlingResource;
//import com.udacity.gradle.builditbigger.backend.MyBean;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
//import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
import com.udacity.gradle.builditbigger.backend.MyEndpoint;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
//import com.udacity.gradle.builditbigger.backend.myApi.model.MyJokeBean;
//import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
//import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;
//import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

import static com.example.androidjokelibrary.JokeActivity.JOKE_FROM_JAVA_JOKE_JAR;


public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    private SimpleIdlingResource simpleIdlingResource;

    public EndpointsAsyncTask(SimpleIdlingResource simpleIdlingResource){
        this.simpleIdlingResource=simpleIdlingResource;
//        this.context=context;
    }

    public EndpointsAsyncTask(){
    }

//    public interface JokeDelayerCallback{
//        void onDone(String joke);
//    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setApplicationName("FinalProject")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });


            // end options for devappserver

            myApiService = builder.build();
        }


        try {
            //commenting out for testing
            Log.i("Endpoints","try starting");
            MyBean myBean=myApiService.getJokeBean().execute();
            Log.i("Endpoints background","myBean successfuly created");
            String jokeString=myBean.getMyBeanJoke();
            Log.i("EndPoints background","jokeString= "+jokeString);
            return myBean.getMyBeanJoke();
//            return myApiService.getJoke().execute().getMyBeanJoke();
            //Log.i("EndpointsAsyncTask, in try section");
//            return "What do you call a pig that does karate?\nA pork chop.";
        }catch (Throwable t) {
            Log.i("Endpoints error", "catching error");
//            return e.getMessage();
            return null;
        }
        //commeting out for testing
//        } catch (IOException e) {
////            return e.getMessage();
//            return null;
//        }
    }

    @Override
    protected void onPostExecute(String result) {

        Log.i("EndpointsAsyncTask","onPostExecuted called");
        Log.i("EndpointsAsyncTask","result= "+result);

        if(result!=null) {
            Log.i("EndpointsAsyncTask","not null result= "+result);
//            Intent intent=new Intent(this, JokeActivity.class);
//            intent.putExtra(JOKE_FROM_JAVA_JOKE_JAR, result);
//            startActivity(intent);

//            simpleIdlingResource.setIdleState(true);
            //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            com.udacity.gradle.builditbigger.StartJokeActivity startJokeActivity=new com.udacity.gradle.builditbigger.StartJokeActivity(result);
        }
        if(simpleIdlingResource!=null){
            simpleIdlingResource.setIdleState(true);
        }


    }
}
