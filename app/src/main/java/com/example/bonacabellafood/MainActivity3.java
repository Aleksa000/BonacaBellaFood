package com.example.bonacabellafood;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.LinkedList;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        LinkedList<Kontakt> lista = KontaktAPI.getMyContacts();
        LinearLayout mainScrollView = findViewById(R.id.mainScrollView);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (Kontakt kontakt : lista){

            ConstraintLayout item = (ConstraintLayout) inflater.inflate(R.layout.moj_pogled, null);

            TextView labelIme = item.findViewById(R.id.labelIme);
            labelIme.setText(kontakt.getIme());

            TextView labelVrednost =item.findViewById(R.id.labelVrednost);
            labelVrednost.setText(kontakt.getVrednost());

            ImageView imageIkonica = item.findViewById(R.id.imageIkonica);

            switch (kontakt.getTipKontakta()){

                case EMAIL:
                    imageIkonica.setImageResource(R.drawable.email);
                    imageIkonica.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String vrednostKontakta = kontakt.getVrednost();
                            String  to = vrednostKontakta;
                            String subject = "Slanje mejla klikom";
                            String message = "Slanje mejla klikom na ikonicu";

                            Intent email = new Intent(Intent.ACTION_SEND);
                            email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                            email.putExtra(Intent.EXTRA_SUBJECT,subject);
                            email.putExtra(Intent.EXTRA_TEXT, message);

                            email.setType("message/rfc822");

                            startActivity(Intent.createChooser(email, "Izaberite nacin slanja:"));

                        }
                    });
                    break;
            }

            mainScrollView.addView(item);
        }
    }
}


