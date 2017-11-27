package cn.eovie.ncufcbackend.constant;

import lombok.Data;
import lombok.ToString;

/**
 * Created by earayu on 2017/11/27.
 */
@ToString
public enum EventType {

    MATCH("比赛"),
    EAT_DRINK("聚餐");

    private String desc;

    EventType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
