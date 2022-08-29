package com.hermes.designpattern.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * @author liu.zongbin
 * @since 2022/8/29 20:36
 */
public class Calculator {

    private Expression expression;

    public Calculator(String expStr) { // expStr = a+b
        // 安排运算先后顺序
        Stack<Expression> stack = new Stack<>();
        // 表达式拆分成字符数组
        char[] charArray = expStr.toCharArray();
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    // 取出右表达式b
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    // 取出右表达式b
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    // 如果是一个var就创建一个VarExpression对象，并push到stack
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        // 遍历完整个数组后，stack就得到最后的Expression
        this.expression = stack.pop();
    }

    public int run(Map<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
