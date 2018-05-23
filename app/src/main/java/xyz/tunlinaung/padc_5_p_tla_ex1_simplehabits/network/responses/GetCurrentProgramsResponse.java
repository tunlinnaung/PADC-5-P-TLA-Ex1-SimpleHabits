package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CurrentProgramsVO;

/**
 * Created by eidoshack on 5/23/18.
 */

public class GetCurrentProgramsResponse {

    private int code;
    private String message;
    private String apiVersion;
    private CurrentProgramsVO currentProgram;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public CurrentProgramsVO getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(CurrentProgramsVO currentProgram) {
        this.currentProgram = currentProgram;
    }
}
