package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CategoriesDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CurrentProgramDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.MainItemDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.TopicsDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.presenters.MainPresenter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.BaseViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.CategoriesViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.CurrentProgramViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.SeriesViewHolder;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.TopicViewHolder;

public class SeriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, MainScreenVO> {

    private static final int CURRENT_PROGRAM = 1;
    private static final int CATEGORIES_PROGRAM = 2;
    private static final int ALL_TOPIC = 3;

    private MainItemDelegate mDelegate;

    public SeriesAdapter(Context context, MainItemDelegate delegate) {
        super(context);
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == CURRENT_PROGRAM) {
            View view = mLayoutInflator.inflate(R.layout.view_item_current_program, parent, false);
            return new CurrentProgramViewHolder(view, mDelegate);
        } else if (viewType == CATEGORIES_PROGRAM) {
            View view = mLayoutInflator.inflate(R.layout.view_item_categories, parent, false);
            return new CategoriesViewHolder(view, mDelegate);
        } else {
            View view = mLayoutInflator.inflate(R.layout.view_item_topic, parent, false);
            return new TopicViewHolder(view, mDelegate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.setData(mData.get(position), position);
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof CurrentProgramsVO) {
            return CURRENT_PROGRAM;
        } else if (mData.get(position) instanceof CategoriesVO) {
            return CATEGORIES_PROGRAM;
        } else {
            return ALL_TOPIC;
        }
    }

}
