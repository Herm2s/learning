package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:56
 */
public class Client {

    public static void main(String[] args) {
        // 遥控器
        RemoteController remoteController = new RemoteController();

        System.out.println("\n=========使用遥控器操作电灯==========");

        // 创建电灯的命令接收者
        LightReceiver lightReceiver = new LightReceiver();
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);


        // 给遥控器设置命令，比如no=0对应的是电灯的开和关操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("--------按下开灯按钮--------");
        remoteController.onButtonWasPushed(0);
        System.out.println("--------按下关灯按钮---------");
        remoteController.offButtonWasPushed(0);
        System.out.println("--------按下撤销按钮---------");
        remoteController.undoButtonWasPushed();


        System.out.println("\n=========使用遥控器操作电视机==========");

        TVReceiver tvReceiver = new TVReceiver();
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);

        // 给遥控器设置命令，比如no=1对应的是电视的开和关操作
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        System.out.println("--------按下开电视按钮--------");
        remoteController.onButtonWasPushed(1);
        System.out.println("--------按下关电视按钮--------");
        remoteController.offButtonWasPushed(1);
        System.out.println("--------按下撤销按钮---------");
        remoteController.undoButtonWasPushed();
    }
}
