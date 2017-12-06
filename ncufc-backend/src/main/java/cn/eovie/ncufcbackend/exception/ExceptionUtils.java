package cn.eovie.ncufcbackend.exception;

import static cn.eovie.ncufcbackend.exception.ExceptionCode.WRONG_THROW;

/**
 * Created by earayu on 2017/12/6.
 */
public class ExceptionUtils {


    public static void throwCodeException(ExceptionCode exceptionCode){
        throw new CodeException(exceptionCode);
    }

    public static void throwCodeException(ExceptionCode exceptionCode, String reason){
        throw new CodeException(exceptionCode, reason);
    }

    public static void throwLogicalException(ExceptionCode exceptionCode){
        throw new LogicalException(exceptionCode);
    }

    public static void throwLogicalException(ExceptionCode exceptionCode, String reason){
        throw new LogicalException(exceptionCode, reason);
    }

    public static void throwNetworkException(ExceptionCode exceptionCode){
        throw new NetworkException(exceptionCode);
    }

    public static void throwNetworkException(ExceptionCode exceptionCode, String reason){
        throw new NetworkException(exceptionCode, reason);
    }


    public static void throwServiceException(ExceptionCode exceptionCode){
        throw new ServiceException(exceptionCode);
    }

    public static void throwServiceException(ExceptionCode exceptionCode, String reason){
        throw new ServiceException(exceptionCode, reason);
    }





    /******************************************************************/



    /**
     * 错误码必须在left和right之间
     * @param exceptionCode
     * @param left
     * @param right
     */
    public static void checkBetween(ExceptionCode exceptionCode, int left, int right){
        if(Integer.valueOf(exceptionCode.getCode())<left || Integer.valueOf(exceptionCode.getCode())>right){
            throwCodeException(WRONG_THROW);
        }
    }

}
