package com.hermes.meituancf.log;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

/**
 * @author herm2s
 * @since 2022/10/9 15:14
 */
@Slf4j
public class LogErrorAction<R> extends AbstractLogAction<R> implements BiConsumer<R, Throwable> {

    public LogErrorAction(String methodName, Object... args) {
        super(methodName, args);
    }

    @Override
    public void accept(R r, Throwable throwable) {
        logResult(r, throwable);
    }
}
