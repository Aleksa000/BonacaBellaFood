package com.example.bonacabellafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonZapocni = findViewById(R.id.buttonZapocni);
        buttonZapocni.setOnClickListener(this);

        Button buttonLogovanje = findViewById(R.id.buttonLogovanje);
        buttonLogovanje.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonZapocni:
                this.doZapocni();
                break;

            case R.id.buttonLogovanje:
                this.doLogovanje();
                break;
        }
    }

    private void doLogovanje() {
        startActivity(new Intent(this, LogujeActivity.class));
    }

    private void doZapocni() {
        startActivity(new Intent(this,MainActivity5.class));
    }
}