package cn.eovie.ncufcbackend.exception;

import com.google.gson.Gson;
import lombok.Data;

/**
 * TODO
 * 1. 检查code不重复方法，自动运行
 * 2. 导出方法，生成错误字典
 * Created by earayu on 2017/12/5.
 */
public enum  ExceptionCode {

    SUCCESS("00000", "处理成功", "处理成功"),
    FLYING_ERROR("10001", "系统繁忙", "非期待异常"),
    WRONG_THROW("10002", "异常代码使用错误", "在一个异常中使用了不属于它的异常代码"),
    UNEXCEPTED_ERROR("10003", "系统繁忙", "未捕获异常, 非自定义异常类型"),



    COMPRESS_ERROR("10100","压缩图片异常"),






    UPLOAD_TIMEOUT("20000", "图片上传超时，请重试"),





    COS_ERROR("30000", "cos参数错误", "cos参数错误"),




    UPLOAD_ERROR("50000", "上传图片失败")






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
