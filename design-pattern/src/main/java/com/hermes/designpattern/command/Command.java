package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:44
 */
public interface Command {

    /**
     * 执行动作
     */
    void execute();

    /**
     * 撤销操作
     */
    void undo();
}
