package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.delegates;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

/**
 * Created by eidoshack on 6/1/18.
 */

public interface CategoriesDelegate {

    void onTapCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

}
