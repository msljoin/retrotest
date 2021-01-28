package com.msl.retrotest;

import android.text.format.Time;

import com.msl.retrotest.utils.Constants;
import com.msl.retrotest.utils.PlaceHolderApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static NetworkService mInstance;
    private final Retrofit mRetrofit;

    private NetworkService() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.outUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public PlaceHolderApi getJsonApi() {
        return mRetrofit.create(PlaceHolderApi.class);
    }
}