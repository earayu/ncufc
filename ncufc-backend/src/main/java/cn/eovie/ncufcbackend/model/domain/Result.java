package cn.eovie.ncufcbackend.model.domain;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;

import static cn.eovie.ncufcbackend.exception.ExceptionCode.SUCCESS;

/**
 * Created by earayu on 2017/12/5.
 */
@Data
@Builder
public class Result<T> {

    private boolean success;

    private String code;

    private String message;

    private String reason;

    private T data;

    public static<T> Result success(T data){
        return Result.builder().success(true).code(SUCCESS.getCode()).message(SUCCESS.getMessage()).reason(SUCCESS.getReason()).data(new Gson().toJson(data)).build();
    }

    public static Result fail(String code, String message, String reason){
        return Result.builder().success(false).code(code).message(message).reason(reason).build();
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
