package cn.eovie.ncufcbackend.exception;

import cn.eovie.ncufcbackend.model.domain.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.eovie.ncufcbackend.exception.ExceptionCode.FLYING_ERROR;

/**
 * Created by linyang on 2017/5/23.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 异常的统一处理器
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exp(Exception ex) {
        if (ex instanceof SpecificException) {
            String code = ((SpecificException) ex).getCode();
            String messge = ((SpecificException) ex).getMessage();
            String reason = ((SpecificException) ex).getReason();
            logger.error("特定异常。code:{},message:{},reason:{} ", code, messge, reason);
            return Result.fail(code, messge,reason);
        }
        logger.error("系统异常。ex:{}", ex);
        return Result.fail(FLYING_ERROR.getCode(), ex.getMessage(), FLYING_ERROR.getReason());
    }
}
