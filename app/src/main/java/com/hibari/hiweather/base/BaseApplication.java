package com.hibari.hiweather.base;

import android.app.Application;

import org.litepal.LitePal;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-12
 * @description:
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }

}
