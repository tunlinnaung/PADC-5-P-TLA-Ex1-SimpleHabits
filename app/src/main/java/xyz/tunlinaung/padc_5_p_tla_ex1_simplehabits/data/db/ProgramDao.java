package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;

@Dao
public abstract class ProgramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertProgram(ProgramsVO programsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertPrograms(List<ProgramsVO> programsVOs);

    @Query("SELECT * FROM program")
    public abstract LiveData<List<ProgramsVO>> getAllPrograms();

    @Query("SELECT * FROM program where programId = :programId")
    public abstract List<ProgramsVO> getProgramsById(String programId);

    @Query("DELETE FROM program")
    public abstract void deleteAll();

}
