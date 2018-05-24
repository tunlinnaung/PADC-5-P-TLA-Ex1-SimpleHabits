package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.TopicsVO;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllTopicsViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_topic_title)
    TextView tvTopicTitle;

    @BindView(R.id.tv_topic_description)
    TextView tvTopicDescription;

    public AllTopicsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Object data) {
        TopicsVO topicDatObj = (TopicsVO) data;
        tvTopicTitle.setText(topicDatObj.getTopicName());
        tvTopicDescription.setText(topicDatObj.getTopicDesc());
    }

    @Override
    public void onClick(View view) {

    }
}