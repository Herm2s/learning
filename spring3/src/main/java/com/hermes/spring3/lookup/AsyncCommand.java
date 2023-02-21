package com.hermes.spring3.lookup;

/**
 * @author liu.zongbin
 * @since 2023/2/21
 */
public class AsyncCommand implements Command {

    private Integer state;

    @Override
    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String execute() {
        System.out.println(this.hashCode());
        return "executed, state: " + state;
    }
}
