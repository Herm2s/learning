package com.hermes.designpattern.interpreter;

import java.util.Map;

/**
 * 加号表达式
 *
 * @author liu.zongbin
 * @since 2022/8/29 20:47
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 求出left和right表达式相减后的结果
     */
    @Override
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
