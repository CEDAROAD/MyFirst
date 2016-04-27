package com.example.cedar.myfirst;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMediaPlayer();
        mediaPlayer.start();
    }

    private void initMediaPlayer()
    {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.love);
        mediaPlayer.setLooping(false);
        try {
            mediaPlayer.prepare();
            } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
            } catch (IOException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}



