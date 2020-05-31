package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {
    DatabaseHelper2 db;
    EditText mNumberPlate;
    EditText mCeiling;
    EditText mFrontPanel;
    EditText mChassis;
    EditText mMasts;
    EditText mGlass;
    Button addReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        db = new DatabaseHelper2(this);
        mNumberPlate = findViewById(R.id.mNumberPlate);
        mCeiling = findViewById(R.id.mCeiling);
        mFrontPanel = findViewById(R.id.mFrontPanel);
        mChassis = findViewById(R.id.mChassis);
        mMasts = findViewById(R.id.mMasts);
        mGlass = findViewById(R.id.mGlass);
        addReportButton = findViewById(R.id.addReportButton);


        addReportButton.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String numberPlate = mNumberPlate.getText().toString().trim();
                        String ceiling = mCeiling.getText().toString().trim();
                        String frontpanel = mFrontPanel.getText().toString().trim();
                        String chassis = mChassis.getText().toString().trim();
                        String masts = mMasts.getText().toString().trim();
                        String glass = mGlass.getText().toString().trim();

                        db.addReport(numberPlate,ceiling,frontpanel,chassis,masts,glass);
                        Toast.makeText(ReportActivity.this,"Başarıyla Rapor Oluşturdunuz!",Toast.LENGTH_SHORT).show();
                        Intent ReportView = new Intent(ReportActivity.this,ReportViewActivity.class);
                        startActivity(ReportView);
                    }
                }
        );
    }
}
