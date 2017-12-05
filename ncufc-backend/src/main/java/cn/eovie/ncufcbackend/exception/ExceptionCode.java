package cn.eovie.ncufcbackend.exception;

import com.google.gson.Gson;
import lombok.Data;

/**
 * 00000        成功
 * 10000-19999  自己系统异常
 * 20000-29999  中间（网络）服务气场
 * 30000-39999  业务原因异常
 * 40000-49999
 * 50000-59999  对方服务异常
 * Created by earayu on 2017/12/5.
 */
public enum  ExceptionCode {

    SUCCESS("00000", "处理成功", "处理成功"),
    FLYING_ERROR("10001", "系统繁忙", "未捕获异常"),

    COMPRESS_ERROR("10010","压缩图片异常"),









    COS_ERROR("30000", "cos参数错误", "cos参数错误"),
    UPLOAD_ERROR("30001", "上传图片失败")






    ;



    private String code;
    private String message;
    private String reason;

    ExceptionCode(String code, String message){
        this.code = code;
        this.message = message;
        this.reason = message;
    }

    ExceptionCode(String code, String message, String reason){
        this.code = code;
        this.message = message;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
