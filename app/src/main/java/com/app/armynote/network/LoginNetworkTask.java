package com.app.armynote.network;

import android.os.AsyncTask;
import android.util.Log;

import com.app.armynote.LoginActivity;
import com.app.armynote.RegisterActivity;

import java.util.HashMap;

public class LoginNetworkTask extends AsyncTask<HashMap<String, String>, String, String> {
    LoginActivity activity = null;

    public LoginNetworkTask(LoginActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(HashMap<String, String>... maps) {
        Log.d("test100", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        HttpClient.Builder http = new HttpClient.Builder("POST", "http://192.168.123.130:8080/ArmyNote/android/login");

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

        activity.loginToMain(s);
    }
}