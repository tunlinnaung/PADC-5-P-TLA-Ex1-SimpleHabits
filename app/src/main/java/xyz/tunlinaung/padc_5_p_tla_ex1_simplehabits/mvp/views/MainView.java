package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.mvp.views;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

public interface MainView extends BaseView {

    void displayMainScreenList(List<MainScreenVO> mainScreenList);

    void launchCurrentProgram(String currentProgramId);

    void launchCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

    void launchTopic(String topicId);

}
