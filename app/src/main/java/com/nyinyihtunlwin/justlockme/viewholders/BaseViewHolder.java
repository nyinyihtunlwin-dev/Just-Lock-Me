package com.nyinyihtunlwin.justlockme.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private W mData;

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void setData(W mData);

}
