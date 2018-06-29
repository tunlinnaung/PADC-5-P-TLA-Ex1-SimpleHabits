package com.tla.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.tla.simplehabits.R;
import com.tla.simplehabits.data.vo.SessionsVO;
import com.tla.simplehabits.viewholders.AllSessionsViewHolder;
import com.tla.simplehabits.viewholders.BaseViewHolder;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllSessionsAdapter extends BaseRecyclerAdapter<BaseViewHolder, SessionsVO> {

    public AllSessionsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View allSessionsItemView = mLayoutInflator.inflate(R.layout.view_item_all_series_details, parent, false);
        return new AllSessionsViewHolder(allSessionsItemView);
    }
}
