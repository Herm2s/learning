package com.hermes.designpattern.command;

/**
 * @author liu.zongbin
 * @since 2022/8/21 15:46
 */
public class LightOffCommand implements Command{

    LightReceiver light;

    public LightOffCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
