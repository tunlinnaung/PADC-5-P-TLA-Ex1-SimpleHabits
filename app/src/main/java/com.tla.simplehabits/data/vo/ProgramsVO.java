package com.tla.simplehabits.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;
import com.tla.simplehabits.data.db.ProgramLengthTypeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eidoshack on 5/23/18.
 */
@Entity(tableName = "Program",
        primaryKeys = { "programId", "sessionId"} )
public class ProgramsVO {

    @NonNull
    @SerializedName("program-id")
    private String programId;

    private String title;

    private String image;

    private String description;

    @SerializedName("average-lengths")
    @TypeConverters(ProgramLengthTypeConverter.class)
    private int[] averageLengths;

    @Ignore
    private List<SessionsVO> sessions;

    @NonNull
    private String sessionId;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getAverageLengths() {
        return averageLengths;
    }

    public void setAverageLengths(int[] averageLengths) {
        this.averageLengths = averageLengths;
    }

    public List<SessionsVO> getSessions() {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        return sessions;
    }

    public void setSessions(List<SessionsVO> sessions) {
        this.sessions = sessions;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
