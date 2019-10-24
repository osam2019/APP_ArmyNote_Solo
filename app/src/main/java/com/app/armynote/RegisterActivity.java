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

import com.app.armynote.network.RegisterNetworkTask;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    RadioGroup radiogroup_w;
    RadioButton category_w;
    EditText serial_number_w;
    EditText pw_w;
    //EditText re_pw;
    EditText name_w;
    EditText birth_date_w;
    EditText enlist_date_w;
    Button register;
    Button cancel;

    RegisterNetworkTask networkTask = new RegisterNetworkTask(this);
    LoginActivity loginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        radiogroup_w = (RadioGroup)findViewById(R.id.category);

        radiogroup_w.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                category_w = (RadioButton)findViewById(checkedId);
            }
        });

        serial_number_w = (EditText)findViewById(R.id.serial_number);
        pw_w = (EditText)findViewById(R.id.pw);
        //re_pw = (EditText)findViewById(R.id.re_pw);
        name_w = (EditText)findViewById(R.id.name);
        birth_date_w = (EditText)findViewById(R.id.birth_date);
        enlist_date_w = (EditText)findViewById(R.id.enlist_date);
        register = (Button)findViewById(R.id.register);
        cancel = (Button)findViewById(R.id.cancel);
    }

    public void registerMethod(View view){
        String category, serial_number, pw, name, birth_date, enlist_date;

        category = category_w.getText().toString();
        Log.d("test",category);
        serial_number = serial_number_w.getText().toString();
        pw = pw_w.getText().toString();
        name = name_w.getText().toString();
        birth_date = birth_date_w.getText().toString();
        enlist_date = enlist_date_w.getText().toString();

        HashMap<String, String> maps = new HashMap<String, String>();

        maps.put("category", category);
        maps.put("serial_number", serial_number);
        maps.put("pw", pw);
        maps.put("soldier_name", name);
        maps.put("birth_date", birth_date);
        maps.put("enlist_date", enlist_date);

        networkTask.execute(maps);

        Toast.makeText(getApplicationContext(), "가입 성공", Toast.LENGTH_SHORT).show();

        finish();
    }

    public void cancelMethod(){
        finish();

        //Intent intent = new Intent(this, LoginActivity.class);
    }
}
