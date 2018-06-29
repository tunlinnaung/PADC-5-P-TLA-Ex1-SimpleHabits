package com.tla.simplehabits.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tla.simplehabits.data.vo.ProgramsVO;

import java.util.List;

@Dao
public abstract class ProgramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertProgram(ProgramsVO programsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertPrograms(List<ProgramsVO> programsVOs);

    @Query("SELECT * FROM program")
    public abstract List<ProgramsVO> getAllPrograms();

    @Query("SELECT * FROM program where programId = :programId")
    public abstract List<ProgramsVO> getProgramsById(String programId);

    @Query("DELETE FROM program")
    public abstract void deleteAll();

}
