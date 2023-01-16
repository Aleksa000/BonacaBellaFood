package com.example.bonacabellafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogujeActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguje);

        Button buttonKontakt = findViewById(R.id.buttonKontakt);
        buttonKontakt.setOnClickListener(this);

        Button buttonVesti = findViewById(R.id.buttonVesti);
        buttonVesti.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonKontakt:
                this.doKontakt();
                break;

            case R.id.buttonVesti:
                this.doVesti();
                break;
        }
    }

    private void doVesti() {
        startActivity(new Intent(this,MainActivity2.class));
    }

    private void doKontakt() {

        startActivity(new Intent(this,MainActivity3.class));
    }

}