package com.hibari.hiweather.ui.weather;

import com.hibari.hiweather.base.BaseView;
import com.hibari.hiweather.gson.Weather;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-13
 * @description:
 */

public interface WeatherView extends BaseView {

    void showWeatherInfo(Weather.HeWeatherBean weather);
}
