package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    DatabaseHelper db;
    RelativeLayout rellay_tramer;
    RelativeLayout rellay_rapor_ekle;
    RelativeLayout rellay_rapor;
    RelativeLayout rellay_info;
    RelativeLayout rellay_exit;
    RelativeLayout rellay_message;

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Lütfen Çıkış Yapınız!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db = new DatabaseHelper(this);

        rellay_tramer = findViewById(R.id.rellay_tramer);
        rellay_rapor_ekle = findViewById(R.id.rellay_rapor_ekle);
        rellay_rapor = findViewById(R.id.rellay_rapor);
        rellay_info = findViewById(R.id.rellay_info);
        rellay_exit = findViewById(R.id.rellay_exit);
        rellay_message = findViewById(R.id.rellay_message);

        rellay_tramer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SorguActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellay_rapor_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ReportActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellay_rapor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ReportViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellay_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InfoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellay_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MessageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        rellay_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
