package com.example.cachetest;

import android.app.Application;

import com.example.cachetest.utils.ConstantUtils;

public class App extends Application {

    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        ConstantUtils.init(this);     //全局Utils

    }

    public static App getInstance() {
        return instance;
    }
}
