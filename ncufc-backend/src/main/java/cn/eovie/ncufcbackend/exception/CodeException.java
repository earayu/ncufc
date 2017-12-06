package cn.eovie.ncufcbackend.exception;

import static cn.eovie.ncufcbackend.exception.ExceptionCode.FLYING_ERROR;
import static cn.eovie.ncufcbackend.exception.ExceptionUtils.checkBetween;

/**
 * Created by earayu on 2017/12/6.
 */
public class CodeException extends ExceptedException {

    private Throwable cause;

    public CodeException(ExceptionCode exceptionCode) {
        super(exceptionCode);
        checkBetween(exceptionCode, 10000, 19999);
    }

    public CodeException(ExceptionCode exceptionCode, String reason) {
        super(exceptionCode, reason);
        checkBetween(exceptionCode, 10000, 19999);
    }

    public CodeException(Throwable cause) {
        super(cause);
        this.code = FLYING_ERROR.getCode();
        this.message = FLYING_ERROR.getMessage();
        this.reason = cause.getMessage();
        this.cause = cause;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
