package com.nyinyihtunlwin.justlockme;

import android.app.Application;

import com.nyinyihtunlwin.justlockme.utils.ConfigUtils;

public class JustLockMeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ConfigUtils.initConfigUtils(getApplicationContext());
    }
}
