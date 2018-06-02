package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
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

    public CurrentProgramsVO mCurrentProgram;
    public List<CategoriesVO> mCategories;
    public List<TopicsVO> mTopics;
    private int mmNewsPageIndex = 1;

    private SimpleHabitsModel() {
        EventBus.getDefault().register(this);
        mCurrentProgram = new CurrentProgramsVO();
        mCategories = new ArrayList<>();
        mTopics = new ArrayList<>();
    }

    public static SimpleHabitsModel getInstance() {
        if(objInstance == null) {
            objInstance = new SimpleHabitsModel();
        }
        return objInstance;
    }

    public void startLoadingSimpleHabits() {
        SimpleHabitsDataAgentImpl.getInstance().loadCurrentPrograms(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
        SimpleHabitsDataAgentImpl.getInstance().loadCategories(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
        SimpleHabitsDataAgentImpl.getInstance().loadTopics(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }

    @Subscribe
    public void onCurrentProgramDataLoaded(RestApiEvents.CurrentProgramsDataLoadedEvent event) {
        mCurrentProgram = event.getLoadCurrentPrograms();
    }

    @Subscribe
    public void onCategoriesDataLoaded(RestApiEvents.CategoriesDataLoadedEvent event) {
        mCategories.addAll(event.getLoadCategories());
    }

    @Subscribe
    public void onTopicsDataLoaded(RestApiEvents.TopicsDataLoadedEvent event) {
        mTopics.addAll(event.getLoadTopics());
    }

    public ProgramsVO getProgramId(String id) {
        for (CategoriesVO categoriesVO : mCategories) {
            for (ProgramsVO programsVO : categoriesVO.getPrograms()) {
                if (programsVO.getProgramId().equalsIgnoreCase(id)) {
                    return programsVO;
                }
            }
        }
        return new ProgramsVO();
    }

}
