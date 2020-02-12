package com.hibari.hiweather.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.hibari.hiweather.R;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-12
 * @description:
 */

public class ProgressDialogUtil {
    private static AlertDialog mAlertDialog;

    /**
     * 弹出耗时对话框
     * @param context
     */
    public static void show(Context context) {
        if (mAlertDialog == null) {
            mAlertDialog = new AlertDialog.Builder(context, R.style.CustomProgressDialog).create();
        }

        View loadView = LayoutInflater.from(context).inflate(R.layout.custom_progress_dialog_view, null);
        mAlertDialog.setView(loadView);
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.show();
    }

    /**
     * 隐藏耗时对话框
     */
    public static void dismiss() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }


}
