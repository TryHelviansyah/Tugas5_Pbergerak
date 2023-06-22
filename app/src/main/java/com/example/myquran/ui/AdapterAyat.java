package com.example.myquran.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myquran.R;
import com.example.myquran.repository.local.model.AyatItem;

import java.util.ArrayList;

public class AdapterAyat extends RecyclerView.Adapter<AdapterAyat.ViewHolder>{

    private ArrayList<AyatItem> list;
    private ArrayList<AyatItem> list2;
    private Context context;

    public AdapterAyat(ArrayList<AyatItem> list, ArrayList<AyatItem> list2, Context context) {
        this.list = list;
        this.list2 = list2;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAyat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ayat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAyat.ViewHolder holder, int position) {
        AyatItem item = list.get(position);
        AyatItem item1 = list2.get(position);
        holder.tvArabic.setText(item.getText());
//        holder.tvIndo.setText(item.getTeksLatin());
        holder.tvArti.setText(item1.getText());
        holder.tvNo.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvArabic,tvIndo,tvArti,tvNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNo = itemView.findViewById(R.id.tvNomor);
            tvArabic = itemView.findViewById(R.id.tvArabic);
            tvIndo = itemView.findViewById(R.id.tvIndo);
            tvArti = itemView.findViewById(R.id.tvArti);
        }
    }
}
