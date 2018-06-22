package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CategoriesDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CurrentProgramDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.MainItemDelegate;

/**
 * Created by eidoshack on 5/17/18.
 */

public class CategoryViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_evening_title)
    TextView tvEveningTitle;

    @BindView(R.id.tv_evening_duration)
    TextView tvEveningDuration;

    private MainItemDelegate mDelegate;

    ProgramsVO programsVO;

    CategoriesVO categoriesVO;

    public CategoryViewHolder(View itemView, MainItemDelegate delegate, CategoriesVO categoriesVO) {
        super(itemView);
        this.mDelegate = delegate;
        this.categoriesVO = categoriesVO;
    }

    @Override
    public void setData(Object data, int position) {
        programsVO = (ProgramsVO) data;
        if (programsVO != null) {
            tvEveningTitle.setText(programsVO.getTitle());
            tvEveningDuration.setText(programsVO.getAverageLengths()[0] + " mins");
        }
    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapCategory(categoriesVO.getCategoryId(), programsVO.getProgramId());
    }
}
