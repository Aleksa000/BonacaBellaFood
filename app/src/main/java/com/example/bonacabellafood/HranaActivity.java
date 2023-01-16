package com.example.bonacabellafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HranaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hrana);

        Button buttonKategorija = findViewById(R.id.buttonKategorije);
        buttonKategorija.setOnClickListener(this);

        Button buttonOdjavi = findViewById(R.id.buttonOdjavi);
        buttonOdjavi.setOnClickListener(this);

        Button buttonLokacija = findViewById(R.id.buttonLokacija);
        buttonLokacija.setOnClickListener(this);

        Button buttonPogledaj = findViewById(R.id.buttonPogledaj);
        buttonPogledaj.setOnClickListener(this);

        initComponents();

    }

    private void initComponents() {

        String[] hrana = {"Pizza",
                "Hamburger",
                "HotDog",
                "Cheeseburger",
                "Pomrfit sa topljenim kačkavaljem",
                "Dupli Hamburger",
                "Dupli Cheeseburger"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, hrana
                );

        AutoCompleteTextView inputAutoComplete = findViewById(R.id.inputAutoComplete);
        inputAutoComplete.setThreshold(1);
        inputAutoComplete.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonKategorije:
                this.doKategorija();
                break;

            case R.id.buttonOdjavi:
                this.doOdjavi();
                break;

            case R.id.buttonLokacija:
                this.doLokacija();
                break;

            case R.id.buttonPogledaj:
                this.doPogledaj();
                break;
        }
    }

    private void doPogledaj() {
        startActivity(new Intent(this, MainActivity6.class));
    }

    private void doLokacija() {
        startActivity(new Intent(this, MapsActivity.class));
    }

    private void doOdjavi() {
        startActivity(new Intent(this, MainActivity5.class));
    }

    private void doKategorija() {
        startActivity(new Intent(this, MainActivity4.class));
    }
}
