package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String mail, pass;
    TextView tv_web;
    EditText et_mail, et_pass;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle(R.string.login);

        tv_web = findViewById(R.id.tv_web);
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
            Toast.makeText(this,R.string.buit, Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkFilds() {
        boolean isTrue = true;
        if ((et_pass.getText().toString()).equals("")){
            et_pass.setError(getText(R.string.buit));
            isTrue = false;
        }
        if ((et_mail.getText().toString()).equals("")){
            et_mail.setError(getText(R.string.buit));
            isTrue = false;
        }
        return isTrue;

    }

    public void openWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String url = tv_web.getText().toString();
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
