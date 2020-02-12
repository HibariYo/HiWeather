package com.hibari.hiweather.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-03
 * @description:
 */

public class HttpUtil {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:9102")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getRetrofit(){
        return retrofit;
    }

    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
