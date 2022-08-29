package com.hermes.designpattern.interpreter;

import java.util.Map;

/**
 * @author liu.zongbin
 * @since 2022/8/29 20:11
 */
public abstract class Expression {

    public abstract int interpreter(Map<String, Integer> var);
}
