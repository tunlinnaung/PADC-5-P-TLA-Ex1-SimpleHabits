package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.SessionsVO;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllSessionsViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_session_count)
    TextView tvSessionCount;

    @BindView(R.id.tv_session_title)
    TextView tvSessionTitle;

    @BindView(R.id.tv_session_duration)
    TextView tvSessionDuration;

    public AllSessionsViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(Object data, int position) {
        SessionsVO sessionsVO = (SessionsVO) data;
        tvSessionCount.setText("" + (position + 1));
        tvSessionTitle.setText(sessionsVO.getTitle());
        tvSessionDuration.setText(secondsToString(sessionsVO.getLengthInSeconds()));
    }

    @Override
    public void onClick(View view) {

    }

    private String secondsToString(int pTime) {
        return String.format("%02d:%02d", pTime / 60, pTime % 60);
    }
}
