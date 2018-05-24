package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.widget.TextView;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;

public class MeActivity extends BaseActivity {

    @BindView(R.id.tv_progress_title)
    TextView tvProgressTitle;

    public static Intent newIntent(Context context) {
        return new Intent(context, MeActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        ButterKnife.bind(this);
    }

    @Override
    void initBottomNavigation() {
        BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        Intent mainIntent = SeriesActivity.newIntent(getApplicationContext());
                        startActivity(mainIntent);
                        break;
                    case R.id.tab_me:
                        //Intent myIntent = SeriesActivity.newIntent(getApplicationContext());
                        //startActivity(myIntent);
                        break;
                    case R.id.tab_more:
                        //Intent moreIntent = SeriesActivity.newIntent(getApplicationContext());
                        //startActivity(moreIntent);
                        break;
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(tvProgressTitle, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }
}