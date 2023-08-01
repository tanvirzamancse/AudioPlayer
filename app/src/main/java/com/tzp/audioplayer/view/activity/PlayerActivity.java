package com.tzp.audioplayer.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.tzp.audioplayer.R;
import com.tzp.audioplayer.databinding.ActivityPlayerBinding;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity {
    private ActivityPlayerBinding binding;
    private static String songUrl;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initializations();
        body();
        clickEvent();


    }

    private void initializations() {
        Intent intent = getIntent();
        songUrl = intent.getStringExtra("url");


    }

    private void body() {


    }

    private void clickEvent() {

        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(songUrl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                mediaPlayer.start();

            }
        });
        binding.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.stop();

            }

        });


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               onBackPressed();

            }

        });
    }
}