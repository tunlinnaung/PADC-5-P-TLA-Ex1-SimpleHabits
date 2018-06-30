package com.tla.simplehabits.data.models;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tla.simplehabits.data.db.AppDatabase;
import com.tla.simplehabits.network.SimpleHabitsAPI;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel {

    private static final String BASE_URL = "http://padcmyanmar.com/padc-5/simple-habits/";

    protected SimpleHabitsAPI mApi;

    protected AppDatabase mAppDatabase;

    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mApi = retrofit.create(SimpleHabitsAPI.class);
        mAppDatabase = AppDatabase.getNewsDatabase(context);
    }

}
