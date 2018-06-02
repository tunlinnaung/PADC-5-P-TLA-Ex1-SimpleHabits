package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by eidoshack on 5/23/18.
 */

public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected W mData;

    private int position;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void setData(W data, int position);
}
