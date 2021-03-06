package com.tla.simplehabits.viewholders;

import android.view.View;
import android.widget.TextView;

import com.tla.simplehabits.R;
import com.tla.simplehabits.data.vo.TopicsVO;
import com.tla.simplehabits.delegates.MainItemDelegate;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by eidoshack on 5/17/18.
 */

public class AllTopicsViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_topic_title)
    TextView tvTopicTitle;

    @BindView(R.id.tv_topic_description)
    TextView tvTopicDescription;

    private MainItemDelegate mDelegate;

    TopicsVO topicDatObj;

    public AllTopicsViewHolder(View itemView, MainItemDelegate delegate) {
        super(itemView);
        this.mDelegate = delegate;
    }

    @Override
    public void setData(Object data, int position) {
        topicDatObj = (TopicsVO) data;
        tvTopicTitle.setText(topicDatObj.getTopicName());
        tvTopicDescription.setText(topicDatObj.getTopicDesc());
    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.cv_topic)
    public void onTapTopic(View view) {
    }
}
