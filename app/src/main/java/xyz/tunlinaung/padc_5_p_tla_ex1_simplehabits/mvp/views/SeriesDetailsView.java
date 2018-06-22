package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

public interface SeriesDetailsView extends BaseView {

    void bindCurrentProgramDetails(CurrentProgramsVO currentProgramsVO);

    void bindCategoriesDetails(ProgramsVO programsVO);

}
