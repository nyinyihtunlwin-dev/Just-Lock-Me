package com.nyinyihtunlwin.justlockme.activities;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.nyinyihtunlwin.justlockme.R;
import com.nyinyihtunlwin.justlockme.adapters.AppListAdapter;
import com.nyinyihtunlwin.justlockme.components.EmptyViewPod;
import com.nyinyihtunlwin.justlockme.components.SmartRecyclerView;
import com.nyinyihtunlwin.justlockme.data.vos.AppVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_apps)
    SmartRecyclerView rvApps;

    @BindView(R.id.loading_bar)
    ContentLoadingProgressBar loadingProgressBar;

    @BindView(R.id.tv_message)
    TextView tvMessge;

    private AppListAdapter mAdapter;
    private List<AppVO> installedApps;
    private PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this, this);
        mAdapter = new AppListAdapter(this);
        rvApps.setAdapter(mAdapter);
        rvApps.setHasFixedSize(true);
        rvApps.setLayoutManager(new LinearLayoutManager(this));

        installedApps = new ArrayList<>();
        packageManager = getPackageManager();
        new LoadApplications().execute();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private class LoadApplications extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {


            List<PackageInfo> apps = packageManager.getInstalledPackages(PackageManager.SIGNATURE_MATCH);
            if (apps != null && !apps.isEmpty()) {
                for (int i = 0; i < apps.size(); i++) {
                    PackageInfo p = apps.get(i);
                    ApplicationInfo appInfo = null;
                    try {
                        appInfo = packageManager.getApplicationInfo(p.packageName, 0);
                        AppVO app = new AppVO();
                        app.setName(p.applicationInfo.loadLabel(packageManager).toString());
                        app.setPackageName(p.packageName);
                        app.setVersionName(p.versionName);
                        app.setVersionCode(p.versionCode);
                        app.setIcon(p.applicationInfo.loadIcon(packageManager));
                        installedApps.add(app);
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loadingProgressBar.setVisibility(View.GONE);
            if (installedApps.size() > 0) {
                mAdapter.setNewData(installedApps);
                tvMessge.setVisibility(View.GONE);
            } else {
                tvMessge.setVisibility(View.VISIBLE);
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }


}
