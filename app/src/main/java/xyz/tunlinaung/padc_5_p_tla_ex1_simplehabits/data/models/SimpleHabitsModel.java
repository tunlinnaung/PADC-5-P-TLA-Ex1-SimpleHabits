package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.TopicsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.events.RestApiEvents;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.SimpleHabitsDataAgentImpl;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.utils.AppConstants;

/**
 * Created by eidoshack on 5/23/18.
 */

public class SimpleHabitsModel {

    private static SimpleHabitsModel objInstance;

    private List<MainScreenVO> mMainScreenVOs;
    private int mmNewsPageIndex = 1;

    private SimpleHabitsModel() {
        EventBus.getDefault().register(this);
        mMainScreenVOs = new ArrayList<>();
    }

    public static SimpleHabitsModel getInstance() {
        if(objInstance == null) {
            objInstance = new SimpleHabitsModel();
        }
        return objInstance;
    }

    public void startLoadingSimpleHabits() {
        SimpleHabitsDataAgentImpl.getInstance().loadCurrentPrograms(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCurrentProgramLoaded(RestApiEvents.CurrentProgramsDataLoadedEvent event) {
        mMainScreenVOs.add(event.getLoadCurrentPrograms());
        SimpleHabitsDataAgentImpl.getInstance().loadCategories(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCategoriesProgramLoaded(RestApiEvents.CategoriesDataLoadedEvent event) {
        mMainScreenVOs.addAll(event.getLoadCategories());
        SimpleHabitsDataAgentImpl.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTopicsLoaded(RestApiEvents.TopicsDataLoadedEvent event) {
        mMainScreenVOs.addAll(event.getLoadTopics());
        RestApiEvents.MainScreenLoadedEvent mainEvent = new RestApiEvents.MainScreenLoadedEvent(mMainScreenVOs);
        EventBus.getDefault().post(mainEvent);
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
