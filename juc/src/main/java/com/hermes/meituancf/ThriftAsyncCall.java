package com.hermes.meituancf;

/**
 * @author herm2s
 * @since 2022/10/9 14:46
 */
@FunctionalInterface
public interface ThriftAsyncCall {

    void invoke() throws Exception;
}
