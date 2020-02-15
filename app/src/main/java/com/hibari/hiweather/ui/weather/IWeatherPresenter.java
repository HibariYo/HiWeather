package com.hibari.hiweather.ui.weather;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-14
 * @description:
 */

public interface IWeatherPresenter {

    /**
     * 请求天气信息
     * @param countyId 城市ID
     */
    void requestWeather(String countyId);

    /**
     * 请求背景图片
     */
    void loadBingPic();
}
