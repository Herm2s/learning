package com.hermes.designpattern.interpreter;

import java.util.Map;

/**
 * 变量解释器
 *
 * @author liu.zongbin
 * @since 2022/8/29 20:47
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    /**
     * 根据变量名称取值
     */
    @Override
    public int interpreter(Map<String, Integer> var) {
        return var.get(key);
    }
}
