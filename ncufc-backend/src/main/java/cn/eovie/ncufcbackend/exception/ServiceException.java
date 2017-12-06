package cn.eovie.ncufcbackend.exception;

import static cn.eovie.ncufcbackend.exception.ExceptionUtils.checkBetween;

/**
 * Created by earayu on 2017/12/6.
 */
public class ServiceException extends ExceptedException {
    public ServiceException(ExceptionCode exceptionCode) {
        super(exceptionCode);
        checkBetween(exceptionCode, 50000, 59999);
    }

    public ServiceException(ExceptionCode exceptionCode, String reason) {
        super(exceptionCode, reason);
        checkBetween(exceptionCode, 50000, 59999);
    }
}
