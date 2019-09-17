package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String mail, pass;
    EditText et_mail, et_pass;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle(R.string.login);

        et_mail = findViewById(R.id.et_mail);
        et_pass = findViewById(R.id.et_pass);

        prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

    }

    public void login(View view) {
        if (checkFilds()) {

            mail = et_mail.getText().toString();
            pass = et_pass.getText().toString();

            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("sharedMail", mail);
            editor.putString("sharedPass", pass);

            editor.commit();

            finish();
        }else {
            Toast.makeText(this,R.string.errorGhibli, Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkFilds() {
        boolean isTrue = true;
        if ((et_pass.getText().toString()).equals("")){
            et_pass.setError(getText(R.string.buit));
            isTrue = false;
        }else{
            isTrue = true;
        }

        if ((et_mail.getText().toString()).equals("")){
            et_mail.setError(getText(R.string.buit));
            isTrue = false;
        } else{
            isTrue= true;
        }
        return isTrue;

    }
}
