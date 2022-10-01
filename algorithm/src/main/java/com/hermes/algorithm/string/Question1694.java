package com.hermes.algorithm.string;

/**
 * @author herm2s
 * @since 2022/10/1 13:06
 */
public class Question1694 {

    public static String reformatNumber(String number) {
        number = number.replaceAll(" ", "")
                .replaceAll("-", "");
        int length = number.length();
        if (length == 2) {
            return number;
        }
        StringBuilder sb = new StringBuilder();
        // 尾数是4个的情况
        boolean four = length % 3 == 1;
        boolean needAppend = true;
        for (int i = 1; i <= length; i++) {
            sb.append(number.charAt(i - 1));
            if (four && length - i == 2) {
                needAppend = false;
                sb.append("-");
            }
            if (needAppend && i % 3 == 0 && i < length) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("--17-5 229 35-39475 "));
    }
}
