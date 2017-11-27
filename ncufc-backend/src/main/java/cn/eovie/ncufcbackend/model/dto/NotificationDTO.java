package cn.eovie.ncufcbackend.model.dto;

import cn.eovie.ncufcbackend.constant.EventType;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * Created by earayu on 2017/11/27.
 */
@Data
@ToString
public class NotificationDTO {

    /**
     * 主键
     */
    private int id;

    /**
     * 发布时间
     */
    private Date postTime;

    /**
     * 是否被删除
     */
    private boolean deleted;

    /**
     * 上传人
     */
    private String postUser;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 时间类型（比赛，聚餐。。。）
     */
    private EventType type;

    /**
     * 对手
     */
    private String opponent;

    /**
     * 详细信息
     */
    private String message;

}
