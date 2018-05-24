package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.AllTopicsViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllTopicsAdapter extends BaseRecyclerAdapter {

    public AllTopicsAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View allTopicsItemView = mLayoutInflator.inflate(R.layout.view_item_all_topics, parent, false);
        return new AllTopicsViewHolder(allTopicsItemView);
    }
}
