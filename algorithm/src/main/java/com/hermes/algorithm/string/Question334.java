package com.hermes.algorithm.string;

/**
 * 反转字符串
 *
 * @author liu.zongbin
 * @since 2022/8/23 22:34
 */
public class Question334 {

    public static void reverseString(char[] s) {
        if (s.length == 1) {
            return;
        }
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // Hannah
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(s);
    }
}
