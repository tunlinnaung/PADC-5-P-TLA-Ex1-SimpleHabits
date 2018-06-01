package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.SeriesDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.EveningMeditationViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

/**
 * Created by eidoshack on 5/17/18.
 */

public class EveningMeditationsAdapter extends BaseRecyclerAdapter {

    SeriesDelegate seriesDelegate;

    public EveningMeditationsAdapter(Context context, SeriesDelegate seriesDelegate) {
        super(context);
        this.seriesDelegate = seriesDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eveningItemView = mLayoutInflator.inflate(R.layout.view_item_evening, parent, false);
        return new EveningMeditationViewHolder(eveningItemView, seriesDelegate);
    }
}
