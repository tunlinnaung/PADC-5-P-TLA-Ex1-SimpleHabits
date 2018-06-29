package com.tla.simplehabits.activities;

import android.app.AlertDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tla.simplehabits.R;
import com.tla.simplehabits.adapters.SeriesAdapter;
import com.tla.simplehabits.data.models.SimpleHabitsModel;
import com.tla.simplehabits.data.vo.MainScreenVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.mvp.presenters.MainPresenter;
import com.tla.simplehabits.mvp.views.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

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

        mPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mPresenter.initPresenter(this);

        initBottomNavigation();

        dialog = new SpotsDialog(this, "Loading...");
        dialog.show();

        rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mSeriesAdapter = new SeriesAdapter(getApplicationContext(), mPresenter);
        rvMain.setAdapter(mSeriesAdapter);

        mPresenter.getMainScreensLD().observe(this, new Observer<List<MainScreenVO>>() {
            @Override
            public void onChanged(@Nullable List<MainScreenVO> mainScreenVOS) {
                dialog.dismiss();
                mSeriesAdapter.appendNewData(mainScreenVOS);
            }
        });
    }

    @Override
    public void displayMainScreenList(List<MainScreenVO> mainScreenList) {
        dialog.dismiss();
        mSeriesAdapter.appendNewData(mainScreenList);
    }

    @Override
    public void launchCurrentProgram(String currentProgramId) {
        Intent intent = SeriesDetailsActivity.newIntentByCurrentProgram(this.getApplicationContext(), currentProgramId);
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
