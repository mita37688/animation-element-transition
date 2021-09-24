package com.example.animation_element_transition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;

public class Ex2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        final ImageView imgC3 = findViewById(R.id.imgCay3);
        imgC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ex2.this, Ex3.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                                Ex2.this, imgC3,
                                ViewCompat.getTransitionName(imgC3));
                startActivity(intent, options.toBundle());
            }
        });

        final ImageView imgC1 = findViewById(R.id.imgCay1);
        imgC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ex2.this, Ex3_2.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        Ex2.this, imgC1,
                        ViewCompat.getTransitionName(imgC3));
                startActivity(intent, options.toBundle());
            }
        });
    }
}