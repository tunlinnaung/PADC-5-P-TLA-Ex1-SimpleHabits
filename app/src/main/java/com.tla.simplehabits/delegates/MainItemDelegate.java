package com.tla.simplehabits.delegates;

import com.tla.simplehabits.data.vo.ProgramsVO;

import java.util.List;

/**
 * Created by aung on 11/11/17.
 */

public interface MainItemDelegate {

    void onTapCurrentProgram(String currentProgramId);

    void onTapCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

    void onTapTopic(String topicId);

}
