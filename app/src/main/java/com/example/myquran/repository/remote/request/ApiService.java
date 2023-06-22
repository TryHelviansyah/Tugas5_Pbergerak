package com.example.myquran.repository.remote.request;

import com.example.myquran.repository.local.model.ResponseAyat;
import com.example.myquran.repository.local.model.ResponseSurah;
import com.example.myquran.repository.local.model.audio.ResponseAudio;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("surah")
    Call<ResponseSurah> getAllSurah();

    @GET("surah/{nomor}/editions/quran-uthmani,en.asad,en.pickthall")
    Call<ResponseAyat> getDetailSurah(@Path("nomor") int nomor);

    @GET("chapter_recitations/{nomor}/")
    Call<ResponseAudio> getAudioSurah(@Path("nomor") int nomor);
}
