package com.nyinyihtunlwin.justlockme.utils;

import android.content.Context;
import android.content.SharedPreferences;


public class ConfigUtils {

    private SharedPreferences mSharedPreferences;

    private static ConfigUtils sObjInstance;


    private ConfigUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("chosen_apps", Context.MODE_PRIVATE);
    }

    public static void initConfigUtils(Context context) {
        sObjInstance = new ConfigUtils(context);
    }

    public static ConfigUtils getObjInstance() {
        return sObjInstance;
    }

    public SharedPreferences.Editor getEditor() {
        return mSharedPreferences.edit();
    }

}
