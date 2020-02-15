package com.hibari.hiweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import com.google.gson.Gson;
import com.hibari.hiweather.Constant;
import com.hibari.hiweather.WeatherAPI;
import com.hibari.hiweather.gson.Weather;
import com.hibari.hiweather.utils.RetrofitCreator;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AutoUpdateService extends Service {


    private static final String TAG = "Hibari";
    private WeatherAPI mWeatherAPI;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mWeatherAPI = RetrofitCreator.getInstance().getRetrofit().create(WeatherAPI.class);
        updateWeather();
        updateBingPic();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //8小时的毫秒数
        int eightHour = 8 * 60 * 60 * 1000;

        long triggerAtTime = SystemClock.elapsedRealtime() + eightHour;
        Intent i = new Intent(this, AutoUpdateService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        Log.d(TAG,"----> 服务运行中!");
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

    private void updateWeather() {
        SharedPreferences prefs = getSharedPreferences("weatherdata", MODE_PRIVATE);
        String rawJson = prefs.getString("weather", null);
        if (rawJson != null) {
            // 有缓存时直接解析天气数据
            Weather.HeWeatherBean weatherBean = new Gson().fromJson(rawJson, Weather.class).getHeWeather().get(0);
            String countyId = weatherBean.getBasic().getCid();
            mWeatherAPI.getWeather(countyId, Constant.keyId).enqueue(new Callback<Weather>() {
                @Override
                public void onResponse(Call<Weather> call, Response<Weather> response) {
                    Gson gson = new Gson();
                    String rawJSON = gson.toJson(response.body());
                    if (response.body() != null) {
                        Weather.HeWeatherBean weatherBean = response.body().getHeWeather().get(0);
                        if (weatherBean != null && "ok".equals(weatherBean.getStatus())) {
                            SharedPreferences.Editor editor = getSharedPreferences("weatherdata", Context.MODE_PRIVATE).edit();
                            editor.putString("weather", rawJSON);
                            editor.apply();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Weather> call, Throwable t) {

                }
            });
        }



    }

    private void updateBingPic() {
        mWeatherAPI.getBingPic().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.body() != null) {
                        String bingPic = response.body().string();
                        Log.d(TAG,"bingpic ---> " + bingPic);
                        SharedPreferences.Editor editor = getSharedPreferences("weatherdata", Context.MODE_PRIVATE).edit();
                        editor.putString("bing_pic", bingPic);
                        editor.apply();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }


}
