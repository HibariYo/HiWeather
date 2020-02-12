package com.hibari.hiweather.ui.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hibari.hiweather.base.BasePresenter;
import com.hibari.hiweather.gson.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public class WeatherPresenter extends BasePresenter<WeatherView> {
    private static final String TAG = "Hibari";
    private WeatherModel mWeatherModel;

    public WeatherPresenter() {
        this.mWeatherModel = new WeatherModel();
    }

    public void requestWeather(final String countyId) {
        mWeatherModel.requestWeather(countyId, new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Gson gson = new Gson();
                Log.d(TAG, "rawJSON --> " + response.body());
                String rawJSON = gson.toJson(response.body());
                if (response.body() != null) {
                    Weather.HeWeatherBean weatherBean = response.body().getHeWeather().get(0);
                    getView().getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (weatherBean != null && "ok".equals(weatherBean.getStatus())) {
                                SharedPreferences.Editor editor = getView().getActivity()
                                        .getSharedPreferences("weatherdata", Context.MODE_PRIVATE).edit();
                                editor.putString("weather", rawJSON);
                                editor.apply();
                                getView().showWeatherInfo(weatherBean);
                            } else {
                                Toast.makeText(getView().getActivity(), "获取天气信息失败",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                getView().getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getView().getActivity(), "获取天气信息失败",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}
