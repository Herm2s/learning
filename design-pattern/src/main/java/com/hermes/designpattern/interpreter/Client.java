package com.hermes.designpattern.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author liu.zongbin
 * @since 2022/8/29 21:38
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // a+b
        String expStr = getExpStr();
        // var {a=10, b=20}
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果" + expStr + "=" + calculator.run(var));
    }

    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();

        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-' && ch != '=') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + ch + "的值：");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }

        return map;
    }
}
