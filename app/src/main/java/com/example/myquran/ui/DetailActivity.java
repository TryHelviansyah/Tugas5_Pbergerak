package com.example.myquran.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myquran.databinding.ActivityDetailBinding;
import com.example.myquran.repository.local.model.AyatItem;
import com.example.myquran.repository.local.model.ResponseAyat;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private ArrayList<AyatItem> listAyat;
    private ArrayList<AyatItem> listAyatTranslate;
    private AdapterAyat adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle(getIntent().getStringExtra("surah"));
        listAyat = new ArrayList<>();
        listAyatTranslate = new ArrayList<>();
        getDetail(Integer.parseInt(getIntent().getStringExtra("nomor")));

    }

    private void getDetail(int nomor) {
        Call<ResponseAyat> client = ApiConfig.getApiService().getDetailSurah(nomor);
        client.enqueue(new Callback<ResponseAyat>() {
            @Override
            public void onResponse(Call<ResponseAyat> call, Response<ResponseAyat> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listAyat.addAll(response.body().getData().get(0).getAyahs());
                        listAyatTranslate.addAll(response.body().getData().get(1).getAyahs());
                        adapter = new AdapterAyat(listAyat,listAyatTranslate,getApplicationContext());
                        binding.rvAyat.setAdapter(adapter);
                    }
                }else {
                    if (response.body() != null){
                        Log.i("cek", "onFailure: "+response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseAyat> call, Throwable t) {
                Log.i("cek", "onFailure: "+t.getMessage());
            }
        });
    }
}