package cn.eovie.ncufcbackend.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 *
 * 主页海报
 *
 * Created by earayu on 2017/11/27.
 */
@Data
@Builder
@ToString
public class PosterDTO {

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
    private boolean deleted = false;

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
