package com.app.armynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.app.armynote.network.OrderNetworkTask;

import org.json.JSONObject;

public class OrderActivity extends AppCompatActivity {
    OrderNetworkTask networkTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void order(View view){
        networkTask.execute();
    }

    public void orderToMain(String s){
        try {
            JSONObject root = new JSONObject(s);

            String serial_number = root.getString("serial_number");
            String name = root.getString("name");
            String rank = root.getString("rank");
            String assignment = root.getString("assignment");
            boolean result = root.getBoolean("result");

            Intent intent = new Intent(this, MainActivity.class);

            if(result = true){
                intent.putExtra("serial_number", serial_number);
                intent.putExtra("name", name);
                intent.putExtra("rank", rank);
                intent.putExtra("assignment", assignment);
                //intent.putExtra("result", result);
            }else{
                Toast.makeText(getApplicationContext(), "Login 실패", Toast.LENGTH_SHORT).show();
            }

            startActivity(intent);

            Log.d("주문", "완료");

            finish();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
