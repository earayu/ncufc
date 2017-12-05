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
public class Result {

    private boolean success;

    private String code;

    private String message;

    private String reason;

    public static Result success(){
        return Result.builder().success(true).code(SUCCESS.getCode()).message(SUCCESS.getMessage()).reason(SUCCESS.getReason()).build();
    }

    public static Result fail(String code, String message, String reason){
        return Result.builder().success(false).code(code).message(message).reason(reason).build();
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
