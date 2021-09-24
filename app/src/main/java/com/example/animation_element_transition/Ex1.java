package com.example.animation_element_transition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ex1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        findViewById(R.id.btnGoEx1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ex1.this, Ex2.class));
                overridePendingTransition(R.anim.enter_x, R.anim.exit_x);
            }
        });
    }
}