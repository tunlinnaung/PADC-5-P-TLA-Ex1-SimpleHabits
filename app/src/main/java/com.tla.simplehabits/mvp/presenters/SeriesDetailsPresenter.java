package com.tla.simplehabits.mvp.presenters;

import com.tla.simplehabits.data.models.SimpleHabitsModel;
import com.tla.simplehabits.data.vo.CurrentProgramsVO;
import com.tla.simplehabits.data.vo.ProgramsVO;
import com.tla.simplehabits.mvp.views.SeriesDetailsView;

public class SeriesDetailsPresenter extends BasePresenter<SeriesDetailsView> {

    @Override
    public void initPresenter(SeriesDetailsView view) {
        super.initPresenter(view);
    }

    public void onUiReady(String programData, String categoryId, String programId) {
        if (programData.equalsIgnoreCase("CURRENT_PROGRAM")) {
            CurrentProgramsVO currentProgramsVO = SimpleHabitsModel.getInstance().getCurrentProgram(programId);
            mView.bindCurrentProgramDetails(currentProgramsVO);
        } else if (programData.equalsIgnoreCase("CATEGORY")) {
            ProgramsVO programsVO = SimpleHabitsModel.getInstance().getCategoryId(categoryId, programId);
            mView.bindCategoriesDetails(programsVO);
        }
    }

}
