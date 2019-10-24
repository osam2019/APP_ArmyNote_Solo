package com.app.armynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.app.armynote.network.LoginNetworkTask;

import org.json.JSONObject;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    RadioGroup radiogroup_w;
    RadioButton category_w;
    EditText serial_number_w;
    EditText pw_w;
    Button register;
    Button search_pw;
    Button login;

    LoginNetworkTask networkTask = null;
    String response_result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        networkTask = new LoginNetworkTask(this);

        radiogroup_w = (RadioGroup)findViewById(R.id.category);

        radiogroup_w.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                category_w = (RadioButton)findViewById(checkedId);
            }
        });

        serial_number_w = (EditText)findViewById(R.id.serial_number);
        pw_w = (EditText)findViewById(R.id.pw);
        register = (Button)findViewById(R.id.register);
        search_pw = (Button)findViewById(R.id.search_pw);
        login = (Button)findViewById(R.id.login);
    }

    public void registerMethod(View view){
        Intent intent = new Intent(this, RegisterActivity.class);

        this.onPause();
        startActivity(intent);
    }

    public void search_pwMethod(View view){
        Intent intent = new Intent(this, SearchPwActivity.class);

        startActivity(intent);
    }

    public void loginMethod(View view){
        String category, serial_number, pw;

        category = category_w.getText().toString();
        serial_number = serial_number_w.getText().toString();
        pw = pw_w.getText().toString();

        HashMap<String, String> maps = new HashMap<String, String>();

        maps.put("category", category);
        maps.put("serial_number", serial_number);
        maps.put("pw", pw);

        networkTask.execute(maps);

    }

    public void loginToMain(String s){
        try {
            JSONObject root = new JSONObject(s);

            String serial_number = root.getString("serial_number");
            String name = root.getString("name");
            String rank = root.getString("rank");
            String assignment = root.getString("assignment");
            String location = root.getString("location");
            boolean result = root.getBoolean("result");

            Intent intent = new Intent(this, MainActivity.class);

            if(result = true){
                intent.putExtra("serial_number", serial_number);
                intent.putExtra("name", name);
                intent.putExtra("rank", rank);
                intent.putExtra("assignment", assignment);
                intent.putExtra("location", location);
            }else{
                Toast.makeText(getApplicationContext(), "Login 실패", Toast.LENGTH_SHORT).show();
            }

            startActivity(intent);

            Log.d("로그인", "성공");

            finish();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}