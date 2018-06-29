package com.tla.simplehabits.mvp.views;

import com.tla.simplehabits.data.vo.MainScreenVO;
import com.tla.simplehabits.data.vo.ProgramsVO;

import java.util.List;

public interface MainView extends BaseView {

    void displayMainScreenList(List<MainScreenVO> mainScreenList);

    void launchCurrentProgram(String currentProgramId);

    void launchCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

    void launchTopic(String topicId);

}
