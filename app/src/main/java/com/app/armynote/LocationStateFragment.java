package com.app.armynote;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationStateFragment extends Fragment {
    String title;

    public LocationStateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_location_state, container, false);

        TextView textView = (TextView)v1.findViewById(R.id.title);

        textView.setText(title);

        return v1;
    }
}