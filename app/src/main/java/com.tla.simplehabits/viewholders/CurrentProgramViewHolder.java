package com.tla.simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import com.tla.simplehabits.R;
import com.tla.simplehabits.data.vo.CurrentProgramsVO;
import com.tla.simplehabits.delegates.MainItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentProgramViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_current_program)
    TextView tvCurrentProgram;

    @BindView(R.id.tv_starter_title)
    TextView tvStarterTitle;

    @BindView(R.id.tv_current_period)
    TextView tvCurrentPeriod;

    @BindView(R.id.tv_average_lengths)
    TextView tvAverageLengths;

    private MainItemDelegate mDelegate;

    private CurrentProgramsVO mCurrentProgramsVO;

    public CurrentProgramViewHolder(View itemView, MainItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.mDelegate = delegate;
    }

    @Override
    public void setData(Object data, int position) {
        mCurrentProgramsVO = (CurrentProgramsVO) data;
        tvStarterTitle.setText(mCurrentProgramsVO.getTitle());
        tvCurrentPeriod.setText(mCurrentProgramsVO.getCurrentPeriod());
        tvAverageLengths.setText(mCurrentProgramsVO.getAverageLengths()[0] + " mins");
    }

    @Override
    public void onClick(View view) {
        mDelegate.onTapCurrentProgram(mCurrentProgramsVO.getProgramId());
    }

}
