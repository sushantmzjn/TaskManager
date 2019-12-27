package com.sushant.taskmanager.Url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Url {
    public static final String Base_url = "http://10.0.2.2:3000/";

    // http://172.100.100.5:3000/

    public static Retrofit getInstance(){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    return retrofit;
    }
}
