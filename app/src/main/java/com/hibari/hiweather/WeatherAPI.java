package com.hibari.hiweather;

import com.hibari.hiweather.gson.Weather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public interface WeatherAPI {

    @GET("/api/weather")
    Call<Weather> getWeather(@Query("cityid") String countyId, @Query("key") String key);

    @GET("/api/bing_pic")
    Call<ResponseBody> getBingPic();

}
