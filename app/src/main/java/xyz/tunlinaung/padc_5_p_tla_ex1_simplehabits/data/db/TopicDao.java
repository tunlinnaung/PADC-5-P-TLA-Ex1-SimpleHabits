package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.SessionsVO;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.TopicsVO;

@Dao
public abstract class TopicDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertTopic(TopicsVO topicsVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertTopics(List<TopicsVO> topicsVOs);

    @Query("SELECT * FROM topic")
    public abstract LiveData<List<TopicsVO>> getAllTopics();

    @Query("DELETE FROM topic")
    public abstract void deleteAll();

}
