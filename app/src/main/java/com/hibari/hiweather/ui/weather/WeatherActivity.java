package com.hibari.hiweather.ui.weather;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hibari.hiweather.R;
import com.hibari.hiweather.base.BaseActivity;
import com.hibari.hiweather.gson.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherActivity extends BaseActivity<WeatherView, WeatherPresenter> implements WeatherView {

    @BindView(R.id.tv_title_city)
    TextView tvTitleCity;
    @BindView(R.id.tv_title_update_time)
    TextView tvTitleUpdateTime;
    @BindView(R.id.tv_degree)
    TextView tvDegree;
    @BindView(R.id.tv_weather_info)
    TextView tvWeatherInfo;
    @BindView(R.id.lv_forecast_layout)
    LinearLayout lvForecastLayout;
    @BindView(R.id.tv_aqi)
    TextView tvAqi;
    @BindView(R.id.tv_pm25_text)
    TextView tvPm25Text;
    @BindView(R.id.tv_comfort)
    TextView tvComfort;
    @BindView(R.id.tv_car_wash)
    TextView tvCarWash;
    @BindView(R.id.tv_sport)
    TextView tvSport;
    @BindView(R.id.sv_weather)
    ScrollView svWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        SharedPreferences prefs = getSharedPreferences("weatherdata", MODE_PRIVATE);
        String rawJson = prefs.getString("weather", null);
        if (rawJson != null) {
            // 有缓存时直接解析天气数据
            Weather.HeWeatherBean weatherBean = new Gson().fromJson(rawJson, Weather.class).getHeWeather().get(0);
            showWeatherInfo(weatherBean);
        } else {
            // 无缓存时去服务器查询天气
            String weatherId = getIntent().getStringExtra("weather_id");
            svWeather.setVisibility(View.INVISIBLE);
            getPresenter().requestWeather(weatherId);
        }
    }

    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }

    @Override
    public WeatherView createView() {
        return this;
    }

    @Override
    public void showWeatherInfo(Weather.HeWeatherBean weather) {
        String cityName = weather.getBasic().getCity();
        String updateTime = weather.getBasic().getUpdate().getLoc().split(" ")[1];
        String degree = weather.getNow().getTmp() + "℃";
        String weatherInfo = weather.getNow().getCond().getTxt();
        tvTitleCity.setText(cityName);
        tvTitleUpdateTime.setText(updateTime);
        tvDegree.setText(degree);
        tvWeatherInfo.setText(weatherInfo);
        lvForecastLayout.removeAllViews();
        for (Weather.HeWeatherBean.DailyForecastBean forecast : weather.getDaily_forecast()) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, lvForecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.tv_forecast_item_date);
            TextView infoText = (TextView) view.findViewById(R.id.tv_forecast_item_info);
            TextView maxText = (TextView) view.findViewById(R.id.tv_forecast_item_max);
            TextView minText = (TextView) view.findViewById(R.id.tv_forecast_item_min);
            dateText.setText(forecast.getDate());
            infoText.setText(forecast.getCond().getTxt_d());
            maxText.setText(forecast.getTmp().getMax());
            minText.setText(forecast.getTmp().getMin());
            lvForecastLayout.addView(view);
        }
        if (weather.getAqi() != null) {
            tvAqi.setText(weather.getAqi().getCity().getAqi());
            tvPm25Text.setText(weather.getAqi().getCity().getPm25());
        }
        String comfort = "舒适度：" + weather.getSuggestion().getComf().getTxt();
        String carWash = "洗车指数：" + weather.getSuggestion().getCw().getTxt();
        String sport = "运动建议：" + weather.getSuggestion().getSport().getTxt();
        tvComfort.setText(comfort);
        tvCarWash.setText(carWash);
        tvSport.setText(sport);
        svWeather.setVisibility(View.VISIBLE);
    }
}
