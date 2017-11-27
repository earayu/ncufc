package cn.eovie.ncufcbackend.model.domain;

import cn.eovie.ncufcbackend.constant.Sex;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
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
@Document(collection = "player")
public class PlayerDO {

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
     * 球员姓名
     */
    @NotBlank
    private String name;


    /**
     * 专业
     */
    private String major;


    /**
     * 入学年份
     */
    @NotBlank
    private String enrollYear;


    /**
     * 号码
     */
    private String number;

    /**
     * 球场位置
     */
    private String position;

    /**
     * 自我介绍（140字）
     */
    @Length(max = 140)
    private String selfIntroduction;


    /**
     * 性别，默认男
     */
    @NotNull
    private Sex sex;

    /**
     * 图片URL
     */
    @NotBlank
    private String url;










}
