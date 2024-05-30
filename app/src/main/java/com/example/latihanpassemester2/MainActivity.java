package com.example.latihanpassemester2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.latihanpassemester2.Liga.LigaInggris;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefsFile";
    Button btnLogin;
    EditText txtUsername,txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText() .toString().equals("Satria") && txtPassword.getText().toString().equals("Satria")) {
                    editor.putString("username", txtUsername.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, navigasi_burger.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    txtUsername.setText("");
                    txtPassword.setText("");
                }
            }
        });
    }
}