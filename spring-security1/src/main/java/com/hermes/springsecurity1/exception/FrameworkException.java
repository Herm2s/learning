package com.hermes.springsecurity1.exception;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
public class FrameworkException extends RuntimeException{

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
