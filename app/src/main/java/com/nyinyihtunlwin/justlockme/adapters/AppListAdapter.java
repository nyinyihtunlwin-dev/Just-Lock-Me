package com.nyinyihtunlwin.justlockme.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nyinyihtunlwin.justlockme.R;
import com.nyinyihtunlwin.justlockme.data.vos.AppVO;
import com.nyinyihtunlwin.justlockme.viewholders.AppListViewHolder;

public class AppListAdapter extends BaseRecyclerAdapter<AppListViewHolder, AppVO> {

    public AppListAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AppListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.view_item_app, parent, false);
        return new AppListViewHolder(view);
    }
}
