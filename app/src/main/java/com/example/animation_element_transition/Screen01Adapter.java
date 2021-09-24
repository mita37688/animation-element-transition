package com.example.animation_element_transition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Screen01Adapter extends RecyclerView.Adapter<Screen01Adapter.Screen01Holder> {

    private LinkedList<Singer> singers;
    private LayoutInflater inflater;
    private Context context;
    private Activity activity;

    public Screen01Adapter(LinkedList<Singer> singers, Context context, Activity activity) {
        this.singers = singers;
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Screen01Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rv_music, parent, false);
        return new Screen01Holder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull Screen01Holder holder, int position) {
        Singer singer = singers.get(position);
        holder.tvNameSinger.setText(singer.getNameSinger());
        holder.tvNameSong.setText(singer.getNameSong());
        holder.img.setImageResource(singer.getImg());
    }

    @Override
    public int getItemCount() {
        return singers.size();
    }

    public class Screen01Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Screen01Adapter adapter;
        ImageView img;
        TextView tvNameSong, tvNameSinger;

        public Screen01Holder(@NonNull View itemView, Screen01Adapter adapter) {
            super(itemView);

            tvNameSinger = itemView.findViewById(R.id.tvNameSinger);
            tvNameSong = itemView.findViewById(R.id.tvNameSong);
            img = itemView.findViewById(R.id.imgSinger);

            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, Screen02.class);
            Singer singer = singers.get(getLayoutPosition());

            Bundle bundle = new Bundle();
            bundle.putSerializable("singer", singer);
            intent.putExtra("entity", bundle);

            context.startActivity(intent);
            activity.overridePendingTransition(R.anim.enter_x, R.anim.exit_x);
        }
    }
}
