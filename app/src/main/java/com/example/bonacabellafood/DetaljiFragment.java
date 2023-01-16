package com.example.bonacabellafood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class DetaljiFragment extends Fragment {

    private TextView osTitle;
    private TextView osVersion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalji, container, false);
        osTitle = view.findViewById(R.id.labelOS);
        osVersion = view.findViewById(R.id.labelVersion);
        return view;
    }

    public void changeFields(String os, String ver){
        osTitle.setText(os);
        osVersion.setText(ver);
    }

}