package com.nyinyihtunlwin.justlockme.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.nyinyihtunlwin.justlockme.R;
import com.nyinyihtunlwin.justlockme.utils.SaveState;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LockScreenActivity extends BaseActivity {

    @BindView(R.id.btn_open_now)
    Button btnOpenNow;

    private SaveState mSaveState;
    private String app, main;
    private boolean abc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);
        ButterKnife.bind(this, this);
/*
        mSaveState = new SaveState(this);
        Intent gotIntent = getIntent();
        Bundle bundle = gotIntent.getExtras();
        app = bundle.getString("app");
        try {
            main = bundle.getString("main");
            abc = main.equals("true");
        } catch (Exception e) {

        }*/

        btnOpenNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        /*        mSaveState.saveState("false");
                startApp(app);
                finish();*/
            }
        });
    }

    private void startApp(String packagename) {
        if (abc) {
            startMain();
        } else {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packagename);
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }
    }

    private void startMain() {
        Intent i = new Intent(LockScreenActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
