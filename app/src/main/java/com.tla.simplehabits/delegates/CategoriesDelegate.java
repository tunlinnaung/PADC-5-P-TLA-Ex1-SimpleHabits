package com.tla.simplehabits.delegates;

import com.tla.simplehabits.data.vo.ProgramsVO;

import java.util.List;

/**
 * Created by eidoshack on 6/1/18.
 */

public interface CategoriesDelegate {

    void onTapCategory(String categoryId, String programId);

    List<ProgramsVO> getProgramsById(String programId);

}
