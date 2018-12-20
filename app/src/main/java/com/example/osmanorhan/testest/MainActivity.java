package com.example.osmanorhan.testest;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool sp;
    int[] soundIds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes attrs = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        sp = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(attrs)
                .build();

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        soundIds = new int[10];
        soundIds[0] = sp.load(getApplicationContext(), R.raw.footstep1, 1);
        soundIds[1] = sp.load(getApplicationContext(), R.raw.theme, 1);
        //rest of sounds goes here

    }

    @Override
    protected void onDestroy() {
        sp.release();
        super.onDestroy();
    }

    public void buttonClick(View v){
        sp.play(soundIds[0], 1.0f, 1.0f, 1, -1, 0.8f);
    }

    public void button2Click(View v){
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.theme);
        mp.setVolume(0.05f, 0.05f);
        mp.setLooping(true);
        mp.start();
    }
}
