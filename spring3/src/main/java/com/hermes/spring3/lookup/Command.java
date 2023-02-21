package com.hermes.spring3.lookup;

/**
 * @author liu.zongbin
 * @since 2023/2/21
 */
public interface Command {

    void setState(Integer state);

    String execute();
}
