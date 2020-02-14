package com.hibari.hiweather.base;

import androidx.annotation.StringRes;

/**
 * @author: Hibari_Yo
 * @date: 2020-01-22
 * @description:回调接口的高度抽象
 */

public interface BaseView {

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    BaseActivity getActivity();

}
