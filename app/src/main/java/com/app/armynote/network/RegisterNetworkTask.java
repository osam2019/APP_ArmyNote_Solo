package com.app.armynote.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.app.armynote.LoginActivity;
import com.app.armynote.RegisterActivity;

import java.util.HashMap;

public class RegisterNetworkTask extends AsyncTask<HashMap<String, String>, String, String> {
    RegisterActivity activity = null;
    //LoginActivity loginActivity = null;

    public RegisterNetworkTask(RegisterActivity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(HashMap<String, String>... maps) {
        Log.d("test100", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        HttpClient.Builder http = new HttpClient.Builder("POST", "http://192.168.123.130:8080/ArmyNote/android/register");

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

        //activity.finish();
    }

    @Override
    protected void onPostExecute(String s){
        Log.d("result", s);
    }
}