package com.tla.simplehabits.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tla.simplehabits.data.vo.SessionsVO;

import java.util.List;

@Dao
public abstract class SessionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertSession(SessionsVO sessionsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertSessions(List<SessionsVO> sessionsVOs);

    @Query("SELECT * FROM session")
    public abstract List<SessionsVO> getAllSessions();

    @Query("SELECT * FROM session where sessionId = :sessionId")
    public abstract List<SessionsVO> getSessionById(String sessionId);

    @Query("DELETE FROM session")
    public abstract void deleteAll();

}
