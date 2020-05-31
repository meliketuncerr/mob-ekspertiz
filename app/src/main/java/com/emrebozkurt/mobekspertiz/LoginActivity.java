package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        mTextUsername = findViewById(R.id.mTextUsername);
        mTextPassword = findViewById(R.id.mTextPassword);
        mButtonLogin = findViewById(R.id.mButtonLogin);
        mTextViewRegister = findViewById(R.id.mTextViewRegister);
        mTextViewRegister.setPaintFlags(mTextViewRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if(res == true)
                {
                    Intent HomePage = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(HomePage);
                    Toast.makeText(LoginActivity.this,"Hoşgeldiniz, " +mTextUsername.getText().toString().trim(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Kullanıcı Adı veya Şifre Hatalı",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}