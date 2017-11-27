package cn.eovie.ncufcbackend.model.dto;

import cn.eovie.ncufcbackend.constant.Sex;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * TODO 加入数据默认值、加入校验。优先级低
 * 球员信息
 * Created by earayu on 2017/11/27.
 */
@Data
@ToString
public class PlayerDTO {


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
         * 球员姓名
         */
        private String name;


        /**
         * 专业
         */
        private String major;


        /**
         * 入学年份
         */
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
        private String selfIntroduction;


        /**
         * 性别，默认男
         */
        private Sex sex;

        /**
         * 图片URL
         */
        private String url;












}
