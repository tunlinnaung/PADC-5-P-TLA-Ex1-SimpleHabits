package com.tla.simplehabits.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eidoshack on 5/23/18.
 */
@Entity(tableName = "Categories")
public class CategoriesVO implements MainScreenVO {

    @PrimaryKey
    @NonNull
    @SerializedName("category-id")
    private String categoryId;

    private String title;

    @Ignore
    private List<ProgramsVO> programs;

    private String programId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramsVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramsVO> programs) {
        this.programs = programs;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }
}
