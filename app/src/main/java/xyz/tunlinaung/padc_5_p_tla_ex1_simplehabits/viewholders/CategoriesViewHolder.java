package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.CategoriesAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CategoriesDelegate;

public class CategoriesViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_categories)
    TextView tvCategories;

    @BindView(R.id.rv_category)
    RecyclerView rvCategory;

    CategoriesAdapter mCategoriesAdapter;

    private CategoriesDelegate mCategoriesDelegate;

    private CategoriesVO categoriesVO;

    public CategoriesViewHolder(View itemView, CategoriesDelegate categoriesDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mCategoriesDelegate = categoriesDelegate;

        mCategoriesAdapter = new CategoriesAdapter(itemView.getContext(), mCategoriesDelegate);
        rvCategory.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvCategory.setAdapter(mCategoriesAdapter);
    }

    @Override
    public void setData(Object data, int position) {
        CategoriesVO categoriesVO = (CategoriesVO) data;
        mData = categoriesVO;
        tvCategories.setText(categoriesVO.getTitle().toString());
        mCategoriesAdapter.setNewData(categoriesVO.getPrograms());
        mCategoriesAdapter.setData(categoriesVO);
    }

    @Override
    public void onClick(View view) {

    }
    
}
