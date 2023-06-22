package com.example.myquran.ui;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquran.R;
import com.example.myquran.repository.local.model.Surah;
import com.example.myquran.repository.local.model.audio.AudioFilesItem;

import java.util.ArrayList;

public class AdapterSurah extends RecyclerView.Adapter<AdapterSurah.ViewHolder>{

    private ArrayList<Surah> list;
    private Context context;

    private final MediaPlayer mediaPlayer;

    public AdapterSurah(ArrayList<Surah> list,Context context) {
        this.list = list;
        this.mediaPlayer = new MediaPlayer();
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterSurah.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_surah_audio, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSurah.ViewHolder holder, int position) {
        Surah item = list.get(position);
        holder.tvItem.setText(item.getNumber()+" "+item.getEnglishName()+" ("+item.getName()+")");
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nomor",String.valueOf(item.getNumber()));
            intent.putExtra("surah",String.valueOf(item.getEnglishName()));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
        holder.btnPlay.setOnClickListener(view ->{
            Intent intent = new Intent(context, AudioActivity.class);
            intent.putExtra("surah",item.getEnglishName());
            intent.putExtra("url","https://download.quranicaudio.com/qdc/abdul_baset/mujawwad/"+position+1+".mp3");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvItem;
        private final Button btnPlay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItemArab);
            btnPlay = itemView.findViewById(R.id.idBtnPlay);
        }
    }

}
