package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.presenters;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.models.SimpleHabitsModel;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views.SeriesDetailsView;

public class SeriesDetailsPresenter extends BasePresenter<SeriesDetailsView> {

    public SeriesDetailsPresenter(SeriesDetailsView mView) {
        super(mView);
    }

    public void onFinishUIComponentSetup(String programData, String categoryId, String programId) {
        if (programData.equalsIgnoreCase("CURRENT_PROGRAM")) {
            CurrentProgramsVO currentProgramsVO = SimpleHabitsModel.getInstance().getCurrentProgram();
            mView.bindCurrentProgramDetails(currentProgramsVO);
        } else if (programData.equalsIgnoreCase("CATEGORY")) {
            ProgramsVO programsVO = SimpleHabitsModel.getInstance().getCategoryId(categoryId, programId);
            mView.bindCategoriesDetails(programsVO);
        }
    }

}
