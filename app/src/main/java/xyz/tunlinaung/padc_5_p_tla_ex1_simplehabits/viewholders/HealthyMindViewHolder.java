package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

/**
 * Created by eidoshack on 5/17/18.
 */

public class HealthyMindViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_evening_title)
    TextView tvEveningTitle;

    @BindView(R.id.tv_evening_duration)
    TextView tvEveningDuration;

    public HealthyMindViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Object data) {
        ProgramsVO newHabitDataObj = (ProgramsVO) data;
        if (newHabitDataObj != null) {
            tvEveningTitle.setText(newHabitDataObj.getTitle());
            tvEveningDuration.setText(newHabitDataObj.getAverageLengths().get(0) + " mins");
        }
    }

    @Override
    public void onClick(View view) {

    }
}
