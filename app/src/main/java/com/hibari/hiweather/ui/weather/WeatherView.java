package com.hibari.hiweather.ui.weather;

import com.hibari.hiweather.base.BaseView;
import com.hibari.hiweather.gson.Weather;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public interface WeatherView extends BaseView {

    /**
     * 显示天气信息
     * @param weather
     */
    void showWeatherInfo(Weather.HeWeatherBean weather);

    /**
     * 显示背景图片
     * @param bingPicAddress
     */
    void showBingPic(String bingPicAddress);

    void setSwipreRefreshing(boolean flag);

}
