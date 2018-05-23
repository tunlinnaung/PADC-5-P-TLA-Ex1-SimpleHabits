package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eidoshack on 5/23/18.
 */

public class TopicsVO {

    @SerializedName("topic-name")
    private String topicName;
    @SerializedName("topic-desc")
    private String topicDesc;
    private String icon;
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
