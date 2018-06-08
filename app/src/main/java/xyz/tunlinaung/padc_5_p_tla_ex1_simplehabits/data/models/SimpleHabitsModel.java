package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db.AppDatabase;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.SessionsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.TopicsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.SimpleHabitsDataAgentImpl;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.utils.AppConstants;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsModel extends ViewModel {

    private static AppDatabase mAppDatabase;

    public static List<MainScreenVO> mMainScreenVOs;

    private LiveData<List<CategoriesVO>> categories;

    private LiveData<List<CurrentProgramsVO>> currentPrograms;

    private LiveData<List<TopicsVO>> topics;

    private int mmNewsPageIndex = 1;

    public SimpleHabitsModel() {
        EventBus.getDefault().register(this);
        mMainScreenVOs = new ArrayList<>();
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getNewsDatabase(context);
    }

    public LiveData<List<CategoriesVO>> getCategories() {
        return mAppDatabase.categoriesDao().getAllCategories();
    }

    public LiveData<List<CurrentProgramsVO>> getCurrentPrograms() {
        return mAppDatabase.currentProgramDao().getAllCurrentPrograms();
    }

    public LiveData<List<TopicsVO>> getTopics() {
        return mAppDatabase.topicDao().getAllTopics();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        AppDatabase.destroyInstance();
    }

    public void startLoadingSimpleHabits() {
        SimpleHabitsDataAgentImpl.getInstance().loadCurrentPrograms(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramLoaded(RestApiEvents.CurrentProgramsDataLoadedEvent event) {
//        mMainScreenVOs.add(event.getLoadCurrentPrograms());

        CurrentProgramsVO currentProgram = event.getLoadCurrentPrograms();
        for (SessionsVO session : currentProgram.getSessions()) {
            mAppDatabase.sessionDao().insertSession(session);

            currentProgram.setSessionId(session.getSessionId());
            mAppDatabase.currentProgramDao().insertCurrentProgram(currentProgram);
        }

        SimpleHabitsDataAgentImpl.getInstance().loadCategories(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesProgramLoaded(RestApiEvents.CategoriesDataLoadedEvent event) {
//        mMainScreenVOs.addAll(event.getLoadCategories());

        List<CategoriesVO> loadedCategories = event.getLoadCategories();
        for (CategoriesVO category : loadedCategories) {

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

        SimpleHabitsDataAgentImpl.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicsLoaded(RestApiEvents.TopicsDataLoadedEvent event) {
//        mMainScreenVOs.addAll(event.getLoadTopics());
//        RestApiEvents.MainScreenLoadedEvent mainEvent = new RestApiEvents.MainScreenLoadedEvent(mMainScreenVOs);
//        EventBus.getDefault().post(mainEvent);

        mAppDatabase.topicDao().insertTopics(event.getLoadTopics());
    }

    public List<ProgramsVO> getProgramsById(String programId) {
        return mAppDatabase.programDao().getProgramsById(programId);
    }

    public CurrentProgramsVO getCurrentProgram() {
        for (MainScreenVO mainScreenVO : mMainScreenVOs) {
            if (mainScreenVO instanceof CurrentProgramsVO) {
                return (CurrentProgramsVO) mainScreenVO;
            }
        }
        return null;
    }

    public @Nullable ProgramsVO getCategoryId(String categoryId, String programId) {
        for (MainScreenVO mainScreenVO : mMainScreenVOs) {
            if (mainScreenVO instanceof CategoriesVO) {
                CategoriesVO categoriesVO = (CategoriesVO) mainScreenVO;
                if (TextUtils.equals(categoryId, categoriesVO.getCategoryId())) {
                    for (ProgramsVO programsVO : categoriesVO.getPrograms()) {
                        if (TextUtils.equals(programId, programsVO.getProgramId())) {
                            return programsVO;
                        }
                    }
                }
            }
        }
        return null;
    }

}
