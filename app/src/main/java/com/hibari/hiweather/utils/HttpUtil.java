package com.hibari.hiweather.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-03
 * @description:
 */

public class HttpUtil {

    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
