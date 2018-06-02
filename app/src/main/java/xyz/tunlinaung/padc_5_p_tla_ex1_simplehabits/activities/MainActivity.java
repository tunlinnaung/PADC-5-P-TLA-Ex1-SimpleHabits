package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.SeriesAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models.SimpleHabitsModel;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CategoriesDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.CurrentProgramDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates.TopicsDelegate;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;

public class MainActivity extends BaseActivity implements CurrentProgramDelegate, CategoriesDelegate, TopicsDelegate {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    SeriesAdapter mSeriesAdapter;

    AlertDialog dialog;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        initBottomNavigation();

        SimpleHabitsModel.getInstance().startLoadingSimpleHabits();

        dialog = new SpotsDialog(this, "Loading...");
        dialog.show();

        rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mSeriesAdapter = new SeriesAdapter(getApplicationContext(), this, this, this);
        rvMain.setAdapter(mSeriesAdapter);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainScreenLoaded(RestApiEvents.MainScreenLoadedEvent event) {
        mSeriesAdapter.setNewData(event.getMainScreenVOS());
        dialog.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestApiEvents.ErrorInvokingAPIEvent event) {
        Snackbar.make(rvMain, event.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void onTapCategory(String categoryId, String programId) {
        Intent intent = SeriesDetailsActivity.newIntentByCategory(this.getApplicationContext(), categoryId, programId);
        startActivity(intent);
    }

    @Override
    public void onTapCurrentProgram(String id) {
        Intent intent = SeriesDetailsActivity.newIntentByCurrentProgram(this.getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapTopic(String id) {

    }
}
