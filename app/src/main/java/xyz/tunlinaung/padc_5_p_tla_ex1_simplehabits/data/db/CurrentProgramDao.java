package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;

@Dao
public abstract class CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertCurrentProgram(CurrentProgramsVO currentProgramsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertCurrentPrograms(List<CurrentProgramsVO> currentProgramsVOs);

    @Query("SELECT * FROM currentprogram")
    public abstract LiveData<List<CurrentProgramsVO>> getAllCurrentPrograms();

    @Query("DELETE FROM currentprogram")
    public abstract void deleteAll();

}
