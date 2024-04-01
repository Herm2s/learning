package com.hermes.algorithm.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 故障键盘
 *
 * @author liu.zongbin
 * @date 2024/4/1
 */
public class Question2810 {

    /**
     * 普通解法
     */
    public static String finalString(String s) {
        if (!s.contains("i")) {
            return s;
        }

        String result = "";
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == 'i') {
                result = reverse(result, i);
            } else {
                result = result + charArray[i];
            }
        }
        return result;
    }

    /**
     * 双端队列
     * 把反转看成是往字符串的头部添加字符。
     * 如果当前处于「往字符串尾部添加字符」的状态，那么遇到 i 后，改成「往字符串头部添加字符」的状态。
     * 如果当前处于「往字符串头部添加字符」的状态，那么遇到 i 后，改成「往字符串尾部添加字符」的状态。
     */
    public static String finalString1(String s) {
        Deque<Character> res = new ArrayDeque<>();
        boolean reverse = false;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                reverse = !reverse;
            } else if (reverse) {
                res.addFirst(c);
            } else {
                res.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character re : res) {
            sb.append(re);
        }
        if (reverse) {
            sb.reverse();
        }
        return sb.toString();
    }

    private static String reverse(String str, int i) {
        if (i == 0) {
            return str;
        }

        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (left >= right) {
                break;
            }
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(finalString1("poiniter"));
    }
}
