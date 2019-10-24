package com.app.armynote.network;

import android.os.AsyncTask;
import android.util.Log;

import com.app.armynote.DemandActivity;

import java.util.HashMap;

public class LocationStateNetworkTask extends AsyncTask<HashMap<String, String>, String, String> {
    DemandActivity activity = null;

    public LocationStateNetworkTask(DemandActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(HashMap<String, String>... maps) {
        Log.d("test100", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        HttpClient.Builder http = new HttpClient.Builder("POST", "http://192.168.123.130:8080/ArmyNote/android/demand");

        http.addAllParameters(maps[0]);

        HttpClient post = http.create();
        post.request();

        int statusCode = post.getHttpStatusCode();
        String body = post.getBody();

        return body;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s){
        Log.d("result", s);

        //activity.loginToMain(s);
    }
}