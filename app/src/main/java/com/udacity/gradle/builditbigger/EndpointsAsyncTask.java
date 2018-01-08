package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.MyEndpoint;


import java.io.IOException;

/**
 * Created by Administrator on 2018/1/1 0001.
 * com.udacity.gradle.builditbigger,FinalProject
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>,Void,String> {
    private static MyEndpoint myEndpoint = null;

    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
        if(myEndpoint == null) {  // Only do this once
            MyEndpoint.Builder builder = new MyEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myEndpoint = builder.build();
        }

        context = pairs[0].first;
        String name = pairs[0].second;

        try {
            return myEndpoint.sayHi(Integer.valueOf(name)).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
        return null;
    }

}
