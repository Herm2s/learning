package com.hermes.spring3.lookup;

public abstract class CommandManager {

    public Object process(Integer commandState) {
        Command command = createCommand();
        command.setState(commandState);
        return command.execute();
    }

    protected abstract Command createCommand();
}