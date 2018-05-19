package com.nyinyihtunlwin.justlockme.viewholders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.nyinyihtunlwin.justlockme.R;
import com.nyinyihtunlwin.justlockme.data.vos.AppVO;
import com.nyinyihtunlwin.justlockme.services.LockService;
import com.nyinyihtunlwin.justlockme.utils.ConfigUtils;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppListViewHolder extends BaseViewHolder<AppVO> {

    @BindView(R.id.tv_app_name)
    TextView tvAppName;

    @BindView(R.id.iv_app_icon)
    ImageView ivAppIcon;

    @BindView(R.id.sw_app)
    Switch swApp;

    private AppVO mData;
    private SharedPreferences.Editor editor;

    public AppListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        editor = ConfigUtils.getObjInstance().getEditor();
    }

    @Override
    public void setData(final AppVO mData) {


        if (mData != null) {
            if (mData.getName() != null) {
                tvAppName.setText(mData.getName());
            }
            if (mData.getIcon() != null) {
                ivAppIcon.setImageDrawable(mData.getIcon());
            }
            swApp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        if (mData.getPackageName() != null)
                            editor.putBoolean(mData.getPackageName(), true).apply();
                    } else {
                        if (mData.getPackageName() != null)
                            editor.putBoolean(mData.getPackageName(), false).apply();
                    }
                    if (itemView.getContext() != null) {
                        itemView.getContext().startService(new Intent(itemView.getContext(), LockService.class));
                    }
                }
            });
        }


    }

    @Override
    public void onClick(View v) {

    }
}
