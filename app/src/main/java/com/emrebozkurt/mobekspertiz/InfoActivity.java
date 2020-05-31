package com.emrebozkurt.mobekspertiz;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        mySong = MediaPlayer.create(InfoActivity.this,R.raw.summit);
    }

    public void playIT(View v) {
        mySong.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySong.release();
    }
}
