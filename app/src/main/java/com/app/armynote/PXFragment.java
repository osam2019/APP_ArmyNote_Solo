package com.app.armynote;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PXFragment extends Fragment {
    Button demand_result_w;
    Button order_result_w;
    String assignment;


    public PXFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_px, container, false);

        TextView textView = (TextView)v1.findViewById(R.id.title);
        demand_result_w = (Button)v1.findViewById(R.id.demand_result);
        order_result_w = (Button)v1.findViewById(R.id.order_result);

        //intent = Intent.getIntent().getStringExtra();

        return v1;
    }

    public void demandMethod(View view){
        Intent intent = new Intent(PXFragment.super.getContext(), DemandActivity.class);

        startActivity(intent);
    }

    public void orderMethod(View view){
        Intent intent = new Intent(PXFragment.super.getContext(), OrderActivity.class);

        startActivity(intent);
    }

    public void demand(View view){
        Intent intent = new Intent(PXFragment.super.getContext(), OrderActivity.class);

        startActivity(intent);
    }

    public void order(View view){
        Intent intent = new Intent(PXFragment.super.getContext(), OrderActivity.class);

        startActivity(intent);

    }
}
