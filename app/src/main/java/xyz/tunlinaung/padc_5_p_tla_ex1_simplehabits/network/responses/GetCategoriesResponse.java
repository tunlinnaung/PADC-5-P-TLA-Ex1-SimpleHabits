package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.network.responses;

import java.util.List;

import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo.CategoriesVO;

/**
 * Created by eidoshack on 5/23/18.
 */

public class GetCategoriesResponse {

    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<CategoriesVO> categoriesPrograms;

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

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesVO> getCategoriesPrograms() {
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }
}
