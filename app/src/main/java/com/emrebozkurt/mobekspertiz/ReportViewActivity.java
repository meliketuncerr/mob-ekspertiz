package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;


public class ReportViewActivity extends AppCompatActivity {

    ListView ReportViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_view);

        ReportViewList = findViewById(R.id.reportViewList);
        Listele();

    }


    public void Listele(){
        DatabaseHelper2 vt = new DatabaseHelper2(ReportViewActivity.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ReportViewActivity.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        ReportViewList.setAdapter(adapter);
    }
}
