package com.renguangli.exception;

/**
 * 自定义异常
 *
 * @author renguangli 2018/10/30 20:23
 * @since JDK 1.8
 */
public class CustomException extends Exception{

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

}
