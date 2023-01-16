package com.example.bonacabellafood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;
    private TextView eRegister;
    private CheckBox eRememberMe;

    boolean isValid = false;
    private int counter = 5;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        eRegister = findViewById(R.id.tvRegister);
        eRememberMe = findViewById(R.id.cbRememberMe);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDB", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        if(sharedPreferences != null){

            String savedUsername = sharedPreferences.getString("Username", "");
            String savedPassword = sharedPreferences.getString("Password", "");

            RegistrationActivity.credentials = new Credentials(savedUsername, savedPassword);

            if(sharedPreferences.getBoolean("RememberMeCheckbox", false)){
                eName.setText(savedUsername);
                ePassword.setText(savedPassword);
                eRememberMe.setChecked(true);
            }
        }

        eRememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferencesEditor.putBoolean("RememberMeCheckbox", eRememberMe.isChecked());

                sharedPreferencesEditor.apply();
            }
        });

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity5.this, RegistrationActivity.class));
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity5.this, "Uneli ste sve podatke uspešno!", Toast.LENGTH_SHORT).show();
                }else{

                    isValid = validate(inputName, inputPassword);

                    if(!isValid){

                        counter--;

                        Toast.makeText(MainActivity5.this, "Nisu tačno uneti parametri!", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("Broj pokušaja: " + counter);

                        if(counter == 0){
                            eLogin.setEnabled(false);
                        }

                    }else{

                        Toast.makeText(MainActivity5.this, "Logovanje uspešno!", Toast.LENGTH_SHORT).show();

                        // Add the code to go to new activity
                        Intent intent = new Intent(MainActivity5.this, HranaActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });
    }

    private boolean validate(String name, String password){

        if(RegistrationActivity.credentials != null){
            if(name.equals(RegistrationActivity.credentials.getUsername()) && password.equals(RegistrationActivity.credentials.getPassword())){
                return true;
            }
        }

        return false;
    }
    }
