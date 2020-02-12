package com.hibari.hiweather.ui.weather;

import com.hibari.hiweather.Constant;
import com.hibari.hiweather.WeatherAPI;
import com.hibari.hiweather.gson.Weather;
import com.hibari.hiweather.utils.RetrofitCreator;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public class WeatherModel {

    public void requestWeather(final String countyId, final Callback<Weather> callback){
        WeatherAPI weatherAPI = RetrofitCreator.getInstance().getRetrofit().create(WeatherAPI.class);
        Call<Weather> getWeatherTask = weatherAPI.getWeather(countyId, Constant.keyId);
        getWeatherTask.enqueue(callback);
    }
}
