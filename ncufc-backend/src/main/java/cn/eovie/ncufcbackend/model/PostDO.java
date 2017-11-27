package cn.eovie.ncufcbackend.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by earayu on 2017/11/27.
 */
@Data
@ToString
@Document(collection = "post")
public class PostDO {

    /**
     * 主键
     */
    @Id
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
     * url
     */
    private String url;

    /**
     * 名称
     */
    private String name;



}
