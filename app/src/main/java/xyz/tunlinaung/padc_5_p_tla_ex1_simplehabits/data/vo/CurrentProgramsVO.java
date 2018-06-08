package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.db.ProgramLengthTypeConverter;

/**
 * Created by eidoshack on 5/23/18.
 */
@Entity(tableName = "CurrentProgram")
public class CurrentProgramsVO implements MainScreenVO {

    @PrimaryKey
    @NonNull
    @SerializedName("program-id")
    private String programId;

    private String title;

    @SerializedName("current-period")
    private String currentPeriod;

    private String background;

    private String description;

    @SerializedName("average-lengths")
    @TypeConverters(ProgramLengthTypeConverter.class)
    private int[] averageLengths;

    @Ignore
    private List<SessionsVO> sessions;

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

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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
