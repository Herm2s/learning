package com.hermes.designpattern.interpreter;

import java.util.Map;

/**
 * 抽象运算符号解释器，这里每个运算符号，都只喝自己左右两个数字有关系
 * 但左右两个数字有可能也是一个解析的结果，无论那种类型，都是Expression的实现类
 *
 * @author liu.zongbin
 * @since 2022/8/29 20:47
 */
public class SymbolExpression extends Expression {

    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return 0;
    }
}
