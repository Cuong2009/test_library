package com.example.library;

import okhttp3.MediaType;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDemo {

    public static Retrofit retrofit;

    MediaType CONTENT_TYPE = okhttp3.MediaType.parse("application/json; charset=utf-8");

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    //baseUrl("https://5fd17bebb485ea0016eee709.mockapi.io")
                    baseUrl("https://reqres.in")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
