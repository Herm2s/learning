package com.hermes.designpattern.interpreter;

import java.util.Map;

/**
 * 变量解释器
 *
 * @author liu.zongbin
 * @since 2022/8/29 20:47
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    /**
     * 求出left和right表达式相减后的结果
     */
    @Override
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
