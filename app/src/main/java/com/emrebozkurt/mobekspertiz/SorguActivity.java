package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SorguActivity extends AppCompatActivity {
    private WebView sorguView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorgu);

        sorguView = findViewById(R.id.sorguView);
        sorguView.setWebViewClient(new WebViewClient());
        sorguView.loadUrl("https://www.sahibinden.com/oto360/hasar-sorgulama");

        WebSettings webSettings = sorguView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (sorguView.canGoBack()) {
            sorguView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
