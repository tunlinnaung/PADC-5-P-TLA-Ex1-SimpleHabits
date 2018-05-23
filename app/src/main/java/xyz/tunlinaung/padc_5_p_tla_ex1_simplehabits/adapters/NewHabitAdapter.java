package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.NewHabitViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

/**
 * Created by eidoshack on 5/17/18.
 */

public class NewHabitAdapter extends BaseRecyclerAdapter {
    private LayoutInflater mLayoutInflator;

    public NewHabitAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newHabitItemView = mLayoutInflator.inflate(R.layout.view_item_new_habit, parent, false);
        return new NewHabitViewHolder(newHabitItemView);
    }
}
