package com.example.bonacabellafood;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class MainActivity4 extends FragmentActivity implements MeniFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    @Override
    public void menuItemSelected(String os, String version) {
        DetaljiFragment detalji = (DetaljiFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetalji);
        detalji.changeFields(os, version);
    }
}