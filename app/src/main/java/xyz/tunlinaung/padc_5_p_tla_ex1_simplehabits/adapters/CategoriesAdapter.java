package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CategoriesDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CurrentProgramDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders.CategoryViewHolder;

/**
 * Created by eidoshack on 5/17/18.
 */

public class CategoriesAdapter extends BaseRecyclerAdapter {

    CategoriesDelegate mCategoriesDelegate;

    CategoriesVO categoriesVO;

    public CategoriesAdapter(Context context, CategoriesDelegate categoriesDelegate) {
        super(context);
        this.mCategoriesDelegate = categoriesDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eveningItemView = mLayoutInflator.inflate(R.layout.view_item_category, parent, false);
        return new CategoryViewHolder(eveningItemView, mCategoriesDelegate, categoriesVO);
    }

    public void setData(CategoriesVO categoriesVO) {
        this.categoriesVO = categoriesVO;
    }
}
