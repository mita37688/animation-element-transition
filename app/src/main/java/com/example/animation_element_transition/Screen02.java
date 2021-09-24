package com.example.animation_element_transition;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Screen02 extends AppCompatActivity {

    ImageView img_taylor, img_music;
    TextView tvSongSinger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen02);

        img_music = findViewById(R.id.img_music);
        img_taylor = findViewById(R.id.img_taylor);
        tvSongSinger = findViewById(R.id.tvSongSinger);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("entity");
        Singer singer = (Singer) bundle.getSerializable("singer");
        tvSongSinger.setText(singer.getNameSinger() + "-" + singer.getNameSong());
        img_taylor.setImageResource(singer.getImg());

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anirotate);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.aniblink);

        img_taylor.startAnimation(animation);
        img_music.startAnimation(animation1);
    }
}