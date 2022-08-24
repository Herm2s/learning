package com.hermes.algorithm.string;

/**
 * 反转字符串II
 *
 * @author liu.zongbin
 * @since 2022/8/24
 */
public class Question541 {

    public static String reverseStr(String s, int k) {
        if (s.length() == 1 || k < 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, chars.length - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 3));
    }
}
