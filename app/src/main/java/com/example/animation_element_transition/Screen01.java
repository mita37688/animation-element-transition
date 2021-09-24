package com.example.animation_element_transition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.LinkedList;

public class Screen01 extends AppCompatActivity {

    RecyclerView rv_music;
    Screen01Adapter adapter;
    LinkedList<Singer> singers = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen01);

        rv_music = findViewById(R.id.rv_music);

        singers.add(new Singer("Taylor Swift", "Love Story", R.drawable.taylorswift));
        singers.add(new Singer("Sơn Tùng", "Em của ngày hôm qua", R.drawable.sontung));
        singers.add(new Singer("Phát Hồ", "Cố Giang Tình", R.drawable.phatho));
        singers.add(new Singer("Chi Dân", "Không quan tâm", R.drawable.chidan));
        singers.add(new Singer("Khắc Việt", "Như vậy nhé", R.drawable.khacviet));

        adapter = new Screen01Adapter(singers, this, this);
        rv_music.setAdapter(adapter);
        rv_music.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}