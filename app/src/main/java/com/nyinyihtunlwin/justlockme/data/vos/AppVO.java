package com.nyinyihtunlwin.justlockme.data.vos;

import android.graphics.drawable.Drawable;

public class AppVO {

    private String name;
    private String packageName;
    private String versionName;
    private int versionCode = 0;
    private Drawable icon;

    public AppVO() {
    }

    public AppVO(String name, String packageName, String versionName, int versionCode, Drawable icon) {
        this.name = name;
        this.packageName = packageName;
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
