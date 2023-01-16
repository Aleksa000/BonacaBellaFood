package com.example.bonacabellafood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRegName;
    private EditText eRegPassword;
    private EditText eEmail;
    private EditText eTelefon;
    private EditText ePosta;
    private Button eRegister;

    public static Credentials credentials;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRegName = findViewById(R.id.etRegName);
        eEmail = findViewById(R.id.inputMejl);
        eTelefon = findViewById(R.id.inputTelefon);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById(R.id.btnRegister);
        ePosta = findViewById(R.id.inputPosta);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String regUsername = eRegName.getText().toString();
                String regPassword = eRegPassword.getText().toString();
                String regEmail = eEmail.getText().toString();
                String regTelefon = eTelefon.getText().toString();
                String regPosta = ePosta.getText().toString();


                if (validate(regUsername, regPassword, regEmail, regTelefon,regPosta)) {
                    credentials = new Credentials(regUsername, regPassword, regEmail, regTelefon,regPosta);

                    /* cuvanje akreditivra */
                    sharedPreferencesEditor.putString("Username", regUsername);
                    sharedPreferencesEditor.putString("Password", regPassword);
                    sharedPreferencesEditor.putString("Email", regEmail);
                    sharedPreferencesEditor.putString("Telefon", regTelefon);
                    sharedPreferencesEditor.putString("Posta", regPosta);



                    /* uzima promene i dodaje u datoteku */
                    sharedPreferencesEditor.apply();

                    startActivity(new Intent(RegistrationActivity.this, HranaActivity.class));
                    Toast.makeText(RegistrationActivity.this, "Uspešna registracija!", Toast.LENGTH_SHORT).show();


                }

            }

            private void doRegister() {
            }
        });

    }

    private boolean validate(String posta, String telefon, String email, String username, String password) {

        if (username.isEmpty() || password.length() < 8 || email.isEmpty() || telefon.isEmpty()) {
            Toast.makeText(this, "Molimo vas svako polje pažljivo popunite, lozinka mora imati najmanje 8 karaktera!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (username.matches("[A-Z][a-z]+") && email.matches("[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+") && telefon.matches("[0-9]{10}")&& posta.matches("[A-Z][a-z]+[0-9]{2}")) {
                startActivity(new Intent(this, HranaActivity.class));
            }
            return true;
        }
    }
}




