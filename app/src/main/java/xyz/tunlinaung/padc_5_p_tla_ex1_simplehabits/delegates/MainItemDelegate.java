package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.MainScreenVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

/**
 * Created by aung on 11/11/17.
 */

public interface MainItemDelegate {

    void onTapCurrentProgram(String currentProgramId);

    void onTapCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

    void onTapTopic(String topicId);

}
