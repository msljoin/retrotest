package com.msl.retrotest.network;

import com.msl.retrotest.utils.Constants;
import com.msl.retrotest.utils.PlaceHolderApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
// singleton class
public class NetworkService {

    // self initialize variable
    private static NetworkService mInstance;
    // initialize retrofit variable
    private final Retrofit mRetrofit;

    // constructor
    private NetworkService() {

        // initialize interceptor for logging
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // set level of logging
        // BODY to show request content
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // initialize okhttp instance
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

        // building retrofit instance by Builder
        mRetrofit = new Retrofit.Builder()
                // generate url
                .baseUrl(Constants.URL)
                // json converter
                .addConverterFactory(GsonConverterFactory.create())
                // add okhttp
                .client(client)
                // add all options
                .build();
    }
    // generate new single instance
    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }
    // get from interface api json request ?
    public PlaceHolderApi getJsonApi() {
        return mRetrofit.create(PlaceHolderApi.class);
    }
}