package com.app.armynote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class DemandActivity extends AppCompatActivity {
    private Spinner spinner;
    ArrayList<String> category_list;
    ArrayAdapter<String> category_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demand);

        category_list = new ArrayList<>();

        category_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, category_list);

        //spinner = (Spinner)findViewById(R.id.s);

        spinner.setAdapter(category_adapter);
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListner(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });*/
    }
}
