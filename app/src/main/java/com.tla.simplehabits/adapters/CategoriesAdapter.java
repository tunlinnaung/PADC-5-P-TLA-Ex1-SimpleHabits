package com.tla.simplehabits.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.tla.simplehabits.R;
import com.tla.simplehabits.data.vo.CategoriesVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.delegates.MainItemDelegate;
import com.tla.simplehabits.viewholders.BaseViewHolder;
import com.tla.simplehabits.viewholders.CategoryViewHolder;

/**
 * Created by eidoshack on 5/17/18.
 */

public class CategoriesAdapter extends BaseRecyclerAdapter<BaseViewHolder, ProgramsVO> {

    MainItemDelegate mDelegate;

    CategoriesVO categoriesVO;

    public CategoriesAdapter(Context context, MainItemDelegate delegate) {
        super(context);
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View eveningItemView = mLayoutInflator.inflate(R.layout.view_item_category, parent, false);
        return new CategoryViewHolder(eveningItemView, mDelegate, categoriesVO);
    }

    public void setData(CategoriesVO categoriesVO) {
        this.categoriesVO = categoriesVO;
    }
}
