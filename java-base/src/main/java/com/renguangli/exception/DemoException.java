package com.renguangli.exception;

/**
 * DemoException
 *
 * @author renguangli 2018/8/20 10:49
 * @since JDK 1.8
 */
public class DemoException extends RuntimeException {

    public DemoException() {
        super();
    }

    public DemoException(String message) {
        super(message);
    }

    public DemoException(Throwable throwable, String message) {
        super(message, throwable);
    }

}
