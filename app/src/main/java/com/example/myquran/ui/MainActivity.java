package com.example.myquran.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myquran.databinding.ActivityMainBinding;
import com.example.myquran.repository.local.model.ResponseSurah;
import com.example.myquran.repository.local.model.Surah;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<Surah> listSurah;
    private AdapterSurah adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listSurah = new ArrayList<>();
        getAllSurah();

    }

    private void getAllSurah() {
        Call<ResponseSurah> client = ApiConfig.getApiService().getAllSurah();
        client.enqueue(new Callback<ResponseSurah>() {

            @Override
            public void onResponse(Call<ResponseSurah> call, Response<ResponseSurah> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        listSurah.addAll(response.body().getData());
                        adapter = new AdapterSurah(listSurah,getApplicationContext());
                        binding.rvSurah.setAdapter(adapter);
                    }
                }else {
                    if (response.body() != null){
                        Log.i("cek", "onFailure: "+response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSurah> call, Throwable t) {
                Log.i("cek", "onFailure: "+t.getMessage());
            }
        });
    }

}