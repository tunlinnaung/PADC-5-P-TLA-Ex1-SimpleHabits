package com.tla.simplehabits.data.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.tla.simplehabits.data.vo.CategoriesVO;
import com.tla.simplehabits.data.vo.CurrentProgramsVO;
import com.tla.simplehabits.data.vo.MainScreenVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.data.vo.SessionsVO;
import com.tla.simplehabits.data.vo.TopicsVO;
import com.tla.simplehabits.network.responses.GetTopicResponse;
import com.tla.simplehabits.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsModel extends BaseModel {

    private final int mmNewsPageIndex = 1;

    private List<MainScreenVO> mMainScreenList = new ArrayList<>();
    private List<CurrentProgramsVO> mCurrentProgramList = new ArrayList<>();
    private List<CategoriesVO> mCategoryList = new ArrayList<>();
    private List<ProgramsVO> mProgramList = new ArrayList<>();
    private List<SessionsVO> mSessionList = new ArrayList<>();

    private static SimpleHabitsModel mObjInstance;

    private SimpleHabitsModel(Context context) {
        super(context);
    }

    public static void initAppModel(Context context) {
        mObjInstance = new SimpleHabitsModel(context);
    }

    public static SimpleHabitsModel getInstance() {
        if (mObjInstance == null) {
            throw new RuntimeException("SimpleHabitsModel is being invoked before initializing.");
        }
        return mObjInstance;
    }

    public void startLoadingMainScreenDatas(final MutableLiveData<List<MainScreenVO>> mainScreensLD,
                                            final MutableLiveData<String> errorLD) {

        mApi.loadCurrentPrograms(mmNewsPageIndex, AppConstants.ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(getCurrentProgramsResponse -> {
                    if (getCurrentProgramsResponse != null) {

                        CurrentProgramsVO currentProgram = getCurrentProgramsResponse.getCurrentProgram();
                        if (currentProgram != null) {
                            mMainScreenList.add(currentProgram);
                            persistCurrentProgram(currentProgram);
                        }
                    }

                    // TODO can't catch error when failed
                    return mApi.loadCategories(mmNewsPageIndex, AppConstants.ACCESS_TOKEN)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                })
                .flatMap(getCategoriesResponse -> {

                    if (getCategoriesResponse != null
                            && getCategoriesResponse.getCategoriesPrograms() != null) {

                        List<CategoriesVO> categorieList = getCategoriesResponse.getCategoriesPrograms();
                        if (categorieList.size() > 0) {
                            mMainScreenList.addAll(categorieList);
                            persistCategories(categorieList);
                        }
                    }
                    return mApi.loadTopics(mmNewsPageIndex, AppConstants.ACCESS_TOKEN)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
                })
                .subscribe(new Observer<GetTopicResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTopicResponse getTopicResponse) {
                        if (getTopicResponse != null
                                && getTopicResponse.getTopics() != null) {

                            List<TopicsVO> topicList = getTopicResponse.getTopics();
                            if (topicList.size() > 0) {
                                mMainScreenList.addAll(getTopicResponse.getTopics());
                                persistTopics(topicList);
                            }
                        }

                        if (mMainScreenList.size() > 0) {
                            mainScreensLD.setValue(mMainScreenList);
                        } else {
                            errorLD.setValue("No data found from network.");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void persistCurrentProgram(CurrentProgramsVO currentProgram) {
        for (SessionsVO session : currentProgram.getSessions()) {
            mAppDatabase.sessionDao().insertSession(session);

            currentProgram.setSessionId(session.getSessionId());
            mAppDatabase.currentProgramDao().insertCurrentProgram(currentProgram);
        }
    }

    private void persistCategories(List<CategoriesVO> categories) {
        for (CategoriesVO category : categories) {
            for (ProgramsVO program : category.getPrograms()) {
                for (SessionsVO session : program.getSessions()) {
                    mAppDatabase.sessionDao().insertSession(session);

                    program.setSessionId(session.getSessionId());
                    mAppDatabase.programDao().insertProgram(program);
                }

                category.setProgramId(program.getProgramId());
                mAppDatabase.categoriesDao().insertCategory(category);
            }
        }
    }

    private void persistTopics(List<TopicsVO> topics) {
        // TODO persist topics data
    }

    public List<ProgramsVO> getProgramsById(String programId) {
        return mAppDatabase.programDao().getProgramsById(programId);
    }

    public CurrentProgramsVO getCurrentProgram(String programId) {
        // TODO many looping to extract datas.
        if (mCurrentProgramList.size() == 0) {
            mCurrentProgramList.addAll(mAppDatabase.currentProgramDao().getAllCurrentPrograms());

            for (CurrentProgramsVO currentProgramsVO : mCurrentProgramList) {
                List<SessionsVO> sessions = mAppDatabase.sessionDao().getSessionById(currentProgramsVO.getSessionId());
                currentProgramsVO.setSessions(sessions);
            }

        }
        for (CurrentProgramsVO currentProgramsVO : mCurrentProgramList) {
            if (TextUtils.equals(programId, currentProgramsVO.getProgramId())) {
                return currentProgramsVO;
            }
        }
        return null;
    }

    public @Nullable ProgramsVO getCategoryId(String categoryId, String programId) {
        // TODO many looping to extract datas.
        // TODO how to reflect changes after new data changes
        if (mCategoryList.size() == 0) {
            mCategoryList = mAppDatabase.categoriesDao().getAllCategories();
            mProgramList = mAppDatabase.programDao().getAllPrograms();
            mSessionList = mAppDatabase.sessionDao().getAllSessions();

            for (CategoriesVO categoriesVO : mCategoryList) {
                List<ProgramsVO> programsVOS = mAppDatabase.programDao().getProgramsById(categoriesVO.getProgramId());
                categoriesVO.setPrograms(programsVOS);

                for (ProgramsVO categoryProgram : categoriesVO.getPrograms()) {
                    for (SessionsVO sessionsVO : mSessionList) {
                        for (ProgramsVO programsVO : mProgramList) {
                            if (sessionsVO.getSessionId().equals(programsVO.getSessionId())
                                    && categoryProgram.getProgramId().equals(programsVO.getProgramId())) {
                                categoryProgram.getSessions().add(sessionsVO);
                            }
                        }
                    }
                }

            }
        }
        for (CategoriesVO categoriesVO : mCategoryList) {
            if (TextUtils.equals(categoryId, categoriesVO.getCategoryId())) {
                for (ProgramsVO programsVO : categoriesVO.getPrograms()) {
                    if (TextUtils.equals(programId, programsVO.getProgramId())) {
                        return programsVO;
                    }
                }
            }
        }
        return null;
    }

}
