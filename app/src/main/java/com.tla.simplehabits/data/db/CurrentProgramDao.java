package com.tla.simplehabits.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tla.simplehabits.data.vo.CurrentProgramsVO;

import java.util.List;

@Dao
public abstract class CurrentProgramDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertCurrentProgram(CurrentProgramsVO currentProgramsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertCurrentPrograms(List<CurrentProgramsVO> currentProgramsVOs);

    @Query("SELECT * FROM currentprogram")
    public abstract List<CurrentProgramsVO> getAllCurrentPrograms();

    @Query("DELETE FROM currentprogram")
    public abstract void deleteAll();

}
