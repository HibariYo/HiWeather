package com.hibari.hiweather.ui.weather;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hibari.hiweather.Constant;
import com.hibari.hiweather.WeatherAPI;
import com.hibari.hiweather.base.BasePresenter;
import com.hibari.hiweather.gson.Weather;
import com.hibari.hiweather.utils.RetrofitCreator;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public class WeatherPresenter extends BasePresenter<WeatherView> implements IWeatherPresenter {
    private static final String TAG = "Hibari";
    private WeatherAPI mWeatherAPI;

    public WeatherPresenter() {
        mWeatherAPI = RetrofitCreator.getInstance().getRetrofit().create(WeatherAPI.class);
    }

    @Override
    public void requestWeather(String countyId) {
        mWeatherAPI.getWeather(countyId, Constant.keyId).enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Gson gson = new Gson();
                String rawJSON = gson.toJson(response.body());
                if (response.body() != null) {
                    Weather.HeWeatherBean weatherBean = response.body().getHeWeather().get(0);
                    if (weatherBean != null && "ok".equals(weatherBean.getStatus())) {
                        SharedPreferences.Editor editor = getActivity()
                                .getSharedPreferences("weatherdata", Context.MODE_PRIVATE).edit();
                        editor.putString("weather", rawJSON);
                        editor.apply();
                        getView().showWeatherInfo(weatherBean);
                    } else {
                        getView().showMessage("获取天气信息失败");
                    }
                }
                getView().setSwipreRefreshing(false);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                getView().showMessage("获取天气信息失败");
                getView().setSwipreRefreshing(false);
            }
        });

    }

    @Override
    public void loadBingPic() {
        mWeatherAPI.getBingPic().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if (response.body() != null) {
                        String bingPic = response.body().string();
                        SharedPreferences.Editor editor = getActivity()
                                .getSharedPreferences("weatherdata", Context.MODE_PRIVATE).edit();
                        editor.putString("bing_pic", bingPic);
                        editor.apply();
                        getView().showBingPic(bingPic);
                    }
                    getView().setSwipreRefreshing(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                getView().showMessage("获取背景图片失败");
                getView().setSwipreRefreshing(false);
            }
        });
    }

}
