package com.hermes.meituancf.log;

import com.hermes.meituancf.exception.ExceptionUtils;
import com.hermes.meituancf.exception.TBase;
import lombok.extern.slf4j.Slf4j;

/**
 * @author herm2s
 * @since 2022/10/9 15:06
 */
@Slf4j
public abstract class AbstractLogAction<R> {

    protected final String methodName;

    protected final Object[] args;

    public AbstractLogAction(String methodName, Object... args) {
        this.methodName = methodName;
        this.args = args;
    }

    protected void logResult(R result, Throwable throwable) {
        if (throwable != null) {
            boolean isBusinessError = throwable instanceof TBase || (throwable.getCause() != null && throwable.getCause() instanceof TBase);
            if (isBusinessError) {
                logBusinessError(throwable);
            } else {
                log.error("{} unknown error, param:{} , error:{}", methodName, args, ExceptionUtils.extractRealException(throwable));
            }
        } else {
            if (isLogResult()) {
                log.info("{} param:{} , result:{}", methodName, args, result);
            } else {
                log.info("{} param:{}", methodName, args);
            }
        }
    }

    private void logBusinessError(Throwable throwable) {
        log.error("{} business error, param:{} , error:{}", methodName, args, throwable.toString(), ExceptionUtils.extractRealException(throwable));
    }

    private boolean isLogResult() {
        return true;
    }
}
