package com.tla.simplehabits.mvp.views;

import com.tla.simplehabits.data.vo.CurrentProgramsVO;
import com.tla.simplehabits.data.vo.ProgramsVO;

public interface SeriesDetailsView extends BaseView {

    void bindCurrentProgramDetails(CurrentProgramsVO currentProgramsVO);

    void bindCategoriesDetails(ProgramsVO programsVO);

}
