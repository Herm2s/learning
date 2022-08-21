package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:50
 */
public class RemoteController {

    /**
     * 开按钮的命令数组
     */
    Command[] onCommands;
    /**
     * 关按钮的命令数组
     */
    Command[] offCommands;

    /**
     * 执行撤销的命令
     */
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        // 初始化时，先预设一组空命令
        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * 给按钮设置需要的命令
     */
    public void setCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    /**
     * 按下开按钮
     */
    public void onButtonWasPushed(int no) {
        // 调用对应按钮的方法
        onCommands[no].execute();
        // 记录这次操作，用于撤销
        undoCommand = onCommands[no];

    }

    /**
     * 按下关按钮
     */
    public void offButtonWasPushed(int no) { // no 0
        // 调用对应按钮的方法
        offCommands[no].execute();
        // 记录这次的操作，用于撤销
        undoCommand = offCommands[no];
    }

    /**
     * 撤销
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }
}
