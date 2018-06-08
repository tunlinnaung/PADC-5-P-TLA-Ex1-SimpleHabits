package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;

@Dao
public abstract class CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertCategory(CategoriesVO categoriesVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertCategories(List<CategoriesVO> categoriesVOs);

    @Query("SELECT * FROM categories")
    public abstract LiveData<List<CategoriesVO>> getAllCategories();

    @Query("DELETE FROM categories")
    public abstract void deleteAll();

}
