package cn.eovie.ncufcbackend.exception;

import static cn.eovie.ncufcbackend.exception.ExceptionUtils.checkBetween;

/**
 * 这个类专注于30000-39999
 *
 * Created by earayu on 2017/12/6.
 */
public class LogicalException extends ExceptedException {
    public LogicalException(ExceptionCode exceptionCode) {
        super(exceptionCode);
        checkBetween(exceptionCode, 30000, 39999);
    }

    public LogicalException(ExceptionCode exceptionCode, String reason) {
        super(exceptionCode, reason);
        checkBetween(exceptionCode, 30000, 39999);
    }


}
