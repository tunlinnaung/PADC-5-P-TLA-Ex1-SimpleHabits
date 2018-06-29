package com.tla.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.tla.simplehabits.R;
import com.tla.simplehabits.data.vo.TopicsVO;
import com.tla.simplehabits.delegates.MainItemDelegate;
import com.tla.simplehabits.viewholders.AllTopicsViewHolder;
import com.tla.simplehabits.viewholders.BaseViewHolder;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllTopicsAdapter extends BaseRecyclerAdapter<BaseViewHolder, TopicsVO> {

    private MainItemDelegate mDelegate;

    public AllTopicsAdapter(Context context, MainItemDelegate delegate) {
        super(context);
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View allTopicsItemView = mLayoutInflator.inflate(R.layout.view_item_all_topics, parent, false);
        return new AllTopicsViewHolder(allTopicsItemView, mDelegate);
    }
}
