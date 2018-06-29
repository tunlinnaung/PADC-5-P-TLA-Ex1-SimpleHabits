package com.tla.simplehabits.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tla.simplehabits.data.vo.CategoriesVO;

import java.util.List;

@Dao
public abstract class CategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertCategory(CategoriesVO categoriesVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertCategories(List<CategoriesVO> categoriesVOs);

    @Query("SELECT * FROM categories")
    public abstract List<CategoriesVO> getAllCategories();

    @Query("DELETE FROM categories")
    public abstract void deleteAll();

}
