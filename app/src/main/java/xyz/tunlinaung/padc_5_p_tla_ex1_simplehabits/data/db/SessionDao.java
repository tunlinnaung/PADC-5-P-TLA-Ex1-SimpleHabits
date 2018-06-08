package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.ProgramsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.SessionsVO;

@Dao
public abstract class SessionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertSession(SessionsVO sessionsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertSessions(List<SessionsVO> sessionsVOs);

    @Query("SELECT * FROM session")
    public abstract LiveData<List<SessionsVO>> getAllSessions();

    @Query("DELETE FROM session")
    public abstract void deleteAll();

}
