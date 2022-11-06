package com.hermes.algorithm.string;

/**
 * 设计Goal解析器
 *
 * @author herm2s
 * @since 2022/11/6 12:08
 */
public class Question1678 {

    public String interpret(String command) {
        return command.replace("()", "o")
                .replace("(al)", "al");
    }

    public String interpret1(String command) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                res.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                } else {
                    res.append("al");
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Question1678 question1678 = new Question1678();
        System.out.println(question1678.interpret1("G()()()()(al)"));
    }
}
