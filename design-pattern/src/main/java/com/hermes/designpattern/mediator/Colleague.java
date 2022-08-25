package com.hermes.designpattern.mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liu.zongbin
 * @since 2022/8/25 19:44
 */
@Data
@AllArgsConstructor
public abstract class Colleague {

    private Mediator mediator;

    private String name;

    public abstract void sendMessage(int stateChange);
}
