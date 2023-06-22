package com.example.myquran.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myquran.databinding.ActivityAudioBinding;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {

    private ActivityAudioBinding binding;
    MediaPlayer mediaPlayer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle(getIntent().getStringExtra("surah"));
        binding.idBtnPlay.setOnClickListener(view ->{
            playAudio(getIntent().getStringExtra("url"),getIntent().getStringExtra("surah"));
        });
        binding.idBtnPause.setOnClickListener(view ->{
            if (mediaPlayer.isPlaying()) {
                // pausing the media player if media player
                // is playing we are calling below line to
                // stop our media player.
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();

                // below line is to display a message
                // when media player is paused.
                Toast.makeText(AudioActivity.this, "Pause", Toast.LENGTH_SHORT).show();
            } else {
                // this method is called when media
                // player is not playing.
                Toast.makeText(AudioActivity.this, "Not Play", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void playAudio(String url, String name) {

        // initializing media player
        mediaPlayer = new MediaPlayer();

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer.setDataSource(url);
            // below line is use to prepare
            // and start our media player.
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // below line is use to display a toast message.
        Toast.makeText(this, "Audio started playing "+name, Toast.LENGTH_SHORT).show();
    }
}