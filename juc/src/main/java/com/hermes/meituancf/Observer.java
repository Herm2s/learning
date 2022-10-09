package com.hermes.meituancf;

/**
 * @author herm2s
 * @since 2022/10/9 14:54
 */
public interface Observer<T> {

    void onSuccess(T t);

    void onFailure(Throwable throwable);
}
