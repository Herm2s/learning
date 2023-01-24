package com.hermes.springsecurity1.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
@Data
@AllArgsConstructor(staticName = "create")
public class JsonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> JsonResult<T> success(String message, T data) {
        return create(0, message, data);
    }

    public static <T> JsonResult<T> success(String message) {
        return create(0, message, null);
    }

    public static <T> JsonResult<T> success(T data) {
        return create(0, "success", data);
    }

    public static <T> JsonResult<T> failure(String message) {
        return create(1, message, null);
    }
}
