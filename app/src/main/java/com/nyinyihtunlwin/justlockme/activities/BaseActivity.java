package com.nyinyihtunlwin.justlockme.activities;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Dell on 12/2/2017.
 */

public abstract class BaseActivity extends AppCompatActivity{
    protected void hideSoftKeyboard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

}
