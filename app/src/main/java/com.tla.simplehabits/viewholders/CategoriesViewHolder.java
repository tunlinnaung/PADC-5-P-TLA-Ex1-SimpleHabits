package com.tla.simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tla.simplehabits.R;
import com.tla.simplehabits.adapters.CategoriesAdapter;
import com.tla.simplehabits.data.vo.CategoriesVO;
import com.tla.simplehabits.delegates.MainItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_categories)
    TextView tvCategories;

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    CategoriesAdapter mCategoriesAdapter;

    private MainItemDelegate mDelegate;

    private CategoriesVO categoriesVO;

    public CategoriesViewHolder(View itemView, MainItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mDelegate = delegate;

        mCategoriesAdapter = new CategoriesAdapter(itemView.getContext(), mDelegate);
        rvCategory.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCategory.setAdapter(mCategoriesAdapter);
    }

    @Override
    public void setData(Object data, int position) {
        CategoriesVO categoriesVO = (CategoriesVO) data;
        mData = categoriesVO;
        tvCategories.setText(categoriesVO.getTitle().toString());
        //List<ProgramsVO> programs = mDelegate.getProgramsById(categoriesVO.getProgramId());
        mCategoriesAdapter.setNewData(categoriesVO.getPrograms());
        mCategoriesAdapter.setData(categoriesVO);
    }

    @Override
    public void onClick(View view) {

    }
    
}
