package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import viewholders.EveningMeditationViewHolder;
import viewholders.NewHabitViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

/**
 * Created by eidoshack on 5/17/18.
 */

public class NewHabitAdapter extends RecyclerView.Adapter {
    private LayoutInflater mLayoutInflator;

    public NewHabitAdapter(Context context) {
        mLayoutInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newHabitItemView = mLayoutInflator.inflate(R.layout.view_item_new_habit, parent, false);
        return new NewHabitViewHolder(newHabitItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 9;
    }
}
