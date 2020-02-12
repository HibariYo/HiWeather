package com.hibari.hiweather.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends AppCompatActivity {

    private V view;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.view == null) {
            view = createView();
        }
        if (this.presenter == null) {
            presenter = createPresenter();
        }
        if (this.view != null && this.presenter != null) {
            this.presenter.attachView(view);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.view != null && this.presenter != null) {
            this.presenter.detachView();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public abstract P createPresenter();

    public abstract V createView();

    public Activity getActivity() {
        return this;
    }

    protected void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    protected void showToast(String msg) {
        if(TextUtils.isEmpty(msg)){
            return;
        }
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }


}
