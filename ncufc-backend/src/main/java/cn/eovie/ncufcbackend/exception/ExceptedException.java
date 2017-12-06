package cn.eovie.ncufcbackend.exception;

import com.google.gson.Gson;
import lombok.Data;

/**
 * Created by earayu on 2017/12/5.
 */
@Data
public abstract class ExceptedException extends RuntimeException{

    protected String code;

    protected String message;

    protected String reason;

    /**
     * 可以确定问题的异常，code、message、reason都是我预定义的
     * @param exceptionCode
     */
    public ExceptedException(ExceptionCode exceptionCode){
        super();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
        this.reason = exceptionCode.getReason();
    }

    /**
     * 某个代码块的不确定原因的异常
     * code、message由代码块确定
     * reason为真实的错误原因，即: ((Exception)e).getMessage()
     * 一般这对应ExceptionCode中的2参数枚举
     * @param exceptionCode
     * @param reason
     */
    public ExceptedException(ExceptionCode exceptionCode, String reason){
        super();
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
        this.reason = reason;
    }

    public ExceptedException(Throwable cause) {
        super(cause);
    }



    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
