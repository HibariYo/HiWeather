package com.hibari.hiweather.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * @author: Hibari_Yo
 * @date: 2020-02-12
 * @description:
 */

public class ProgressDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        ProgressBar progressBar = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyle);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("正在加载...");
        builder.setView(progressBar);
        builder.setCancelable(false);
        return builder.create();
    }
}
