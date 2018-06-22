package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.adapters.SeriesAdapter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models.SimpleHabitsModel;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.presenters.MainPresenter;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    SeriesAdapter mSeriesAdapter;

    private MainPresenter mPresenter;

    AlertDialog dialog;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        mPresenter = new MainPresenter(this);
        mPresenter.onCreate();

        initBottomNavigation();

        dialog = new SpotsDialog(this, "Loading...");
        dialog.show();

        rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mSeriesAdapter = new SeriesAdapter(getApplicationContext(), mPresenter);
        rvMain.setAdapter(mSeriesAdapter);

        /**
        simpleHabitsModel = ViewModelProviders.of(this).get(SimpleHabitsModel.class);
        simpleHabitsModel.initDatabase(getApplicationContext());
        simpleHabitsModel.getCategories().observe(this,
                categoriesVOs -> SimpleHabitsModel.getInstance().getMainScreens().addAll(categoriesVOs));
        simpleHabitsModel.getCurrentPrograms().observe(this,
                currentProgramsVOs -> SimpleHabitsModel.getInstance().getMainScreens().addAll(currentProgramsVOs));
        simpleHabitsModel.getTopics().observe(this, topicsVOs -> {
            SimpleHabitsModel.getInstance().getMainScreens().addAll(topicsVOs);
            mSeriesAdapter.setNewData(SimpleHabitsModel.getInstance().getMainScreens());
            dialog.dismiss();
        });
        **/
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void displayMainScreenList(List<MainScreenVO> mainScreenList) {
        dialog.dismiss();
        mSeriesAdapter.appendNewData(mainScreenList);
    }

    @Override
    public void launchCurrentProgram(String currentProgramId) {
        Intent intent = SeriesDetailsActivity.newIntentByCurrentProgram(this.getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void launchCategory(String categoryId, String programId) {
        Intent intent = SeriesDetailsActivity.newIntentByCategory(this.getApplicationContext(), categoryId, programId);
        startActivity(intent);
    }

    @Override
    public List<ProgramsVO> getProgramsById(String programId) {
        return SimpleHabitsModel.getInstance().getProgramsById(programId);
    }

    @Override
    public void launchTopic(String topicId) {

    }

    @Override
    public void displayError(String errMsg) {

    }
}
