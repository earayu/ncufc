package cn.eovie.ncufcbackend.exception;

import static cn.eovie.ncufcbackend.exception.ExceptionUtils.checkBetween;

/**
 * Created by earayu on 2017/12/6.
 */
public class NetworkException extends ExceptedException {
    public NetworkException(ExceptionCode exceptionCode) {
        super(exceptionCode);
        checkBetween(exceptionCode, 20000, 29999);
    }

    public NetworkException(ExceptionCode exceptionCode, String reason) {
        super(exceptionCode, reason);
        checkBetween(exceptionCode, 20000, 29999);
    }
}
