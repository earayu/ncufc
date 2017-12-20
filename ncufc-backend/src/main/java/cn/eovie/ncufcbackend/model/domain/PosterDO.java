package cn.eovie.ncufcbackend.model.domain;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.RegEx;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * TODO
 * 增加group、description字段
 * Created by earayu on 2017/11/27.
 */
@Data
@ToString
@Document(collection = "poster")
public class PosterDO {

//    /**
//     * 主键
//     */
//    @Id
//    @NotNull
//    private int id;

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
    @NotNull
    private String postUser;

    /**
     * url
     */
    @NotBlank
    private String url;

    /**
     * 名称
     */
    @NotBlank
    private String name;



}
