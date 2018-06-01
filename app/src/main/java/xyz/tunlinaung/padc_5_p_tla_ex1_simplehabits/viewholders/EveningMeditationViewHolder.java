package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.SeriesDelegate;

/**
 * Created by eidoshack on 5/17/18.
 */

public class EveningMeditationViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_evening_title)
    TextView tvEveningTitle;

    @BindView(R.id.tv_evening_duration)
    TextView tvEveningDuration;

    SeriesDelegate seriesDelegate;

    ProgramsVO eveningDatObj;

    public EveningMeditationViewHolder(View itemView, SeriesDelegate seriesDelegate) {
        super(itemView);
        this.seriesDelegate = seriesDelegate;
    }

    @Override
    public void setData(Object data, int position) {
        eveningDatObj = (ProgramsVO) data;
        if (eveningDatObj != null) {
            tvEveningTitle.setText(eveningDatObj.getTitle());
            tvEveningDuration.setText(eveningDatObj.getAverageLengths().get(0) + " mins");
        }
    }

    @Override
    public void onClick(View view) {
        seriesDelegate.onTapProgram(eveningDatObj.getProgramId());
    }
}
