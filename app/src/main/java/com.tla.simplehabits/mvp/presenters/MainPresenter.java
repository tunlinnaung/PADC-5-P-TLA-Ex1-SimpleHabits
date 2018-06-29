package com.tla.simplehabits.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.tla.simplehabits.data.models.SimpleHabitsModel;
import com.tla.simplehabits.data.vo.MainScreenVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.delegates.MainItemDelegate;
import com.tla.simplehabits.mvp.views.MainView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements MainItemDelegate {

    private MutableLiveData<List<MainScreenVO>> mMainScreensLD;

    @Override
    public void initPresenter(MainView view) {
        super.initPresenter(view);
        mMainScreensLD = new MutableLiveData<>();
        SimpleHabitsModel.getInstance().startLoadingMainScreenDatas(mMainScreensLD, mErrorLD);
    }

    public MutableLiveData<List<MainScreenVO>> getMainScreensLD() {
        return mMainScreensLD;
    }

    @Override
    public void onTapCurrentProgram(String currentProgramId) {
        mView.launchCurrentProgram(currentProgramId);
    }

    @Override
    public void onTapCategory(String categoryId, String programId) {
        mView.launchCategory(categoryId, programId);
    }

    @Override
    public List<ProgramsVO> getProgramsById(String programId) {
        return SimpleHabitsModel.getInstance().getProgramsById(programId);
    }

    @Override
    public void onTapTopic(String topicId) {

    }
}
