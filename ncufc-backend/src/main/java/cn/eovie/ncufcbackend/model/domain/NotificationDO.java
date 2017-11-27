package cn.eovie.ncufcbackend.model.domain;

import cn.eovie.ncufcbackend.constant.EventType;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by earayu on 2017/11/27.
 */
@Data
@ToString
@Document(collection = "notification")
public class NotificationDO {

    /**
     * 主键
     */
    @Id
    private int id;

    /**
     * 发布时间
     */
    @NotNull
    private Date postTime;

    /**
     * 是否被删除
     */
    @NotNull
    private boolean deleted;

    /**
     * 上传人
     */
    @NotBlank
    private String postUser;

    /**
     * 开始时间
     */
    @NotNull
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 时间类型（比赛，聚餐。。。）
     */
    @NotNull
    private EventType type;

    /**
     * 对手
     */
    private String opponent;

    /**
     * 详细信息
     */
    @NotNull
    private String message;

}
