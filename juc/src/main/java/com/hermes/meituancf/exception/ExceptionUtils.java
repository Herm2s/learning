package com.hermes.meituancf.exception;

import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

/**
 * @author herm2s
 * @since 2022/10/9 15:04
 */
public class ExceptionUtils {

    public static Throwable extractRealException(Throwable throwable) {
        if (throwable instanceof CompletionException || throwable instanceof ExecutionException) {
            if (throwable.getCause() != null) {
                return throwable.getCause();
            }
        }
        return throwable;
    }
}
