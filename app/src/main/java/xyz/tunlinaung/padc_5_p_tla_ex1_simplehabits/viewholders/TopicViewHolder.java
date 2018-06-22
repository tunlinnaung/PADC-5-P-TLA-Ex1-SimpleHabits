package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.AllTopicsAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.TopicsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.MainItemDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.TopicsDelegate;

public class TopicViewHolder extends BaseViewHolder {

//    @BindView(R.id.tv_topics)
//    TextView tvTopics;

    @BindView(R.id.rv_topic)
    RecyclerView rvTopic;

    AllTopicsAdapter mAllTopicsAdapter;

    private MainItemDelegate mDelegate;

    public TopicViewHolder(View itemView, MainItemDelegate delegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        this.mDelegate = delegate;

        mAllTopicsAdapter = new AllTopicsAdapter(itemView.getContext(), mDelegate);
        rvTopic.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvTopic.setAdapter(mAllTopicsAdapter);
    }

    @Override
    public void setData(Object data, int position) {
//        if (position == 3) {
//            tvTopics.setVisibility(View.VISIBLE);
//        } else {
//            tvTopics.setVisibility(View.GONE);
//        }

        TopicsVO topicsVO = (TopicsVO) data;
        mData = topicsVO;
        mAllTopicsAdapter.addNewData(topicsVO);
    }

    @Override
    public void onClick(View view) {

    }
    
}
