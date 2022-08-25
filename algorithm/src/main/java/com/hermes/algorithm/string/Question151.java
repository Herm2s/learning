package com.hermes.algorithm.string;

/**
 * @author liu.zongbin
 * @since 2022/8/24 20:59
 */
public class Question151 {

    public static String reverseWords(String s) {
        // 去除首尾及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private static void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 1;
        int n = sb.length();
        while (left < n) {
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            reverse(sb, left, right- 1);
            left = right + 1;
            right = left + 1;
        }
    }

    private static StringBuilder reverse(StringBuilder sb, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
        return sb;
    }

    private static StringBuilder removeSpace(String s) {
        int slow = 0;
        int fast = 0;
        // 去掉字符串前面的冗余空格
        while (s.length() > 0 && fast < s.length() && s.charAt(fast) == ' ') {
            fast++;
        }
        StringBuilder sb = new StringBuilder(s);
        for (; fast < sb.length(); fast++) {
            // 去掉字符串中间部分的冗余空格
            if (fast - 1 > 0
                    && sb.charAt(fast) == ' '
                    && sb.charAt(fast - 1) == sb.charAt(fast)) {
                continue;
            } else {
                sb.setCharAt(slow++, sb.charAt(fast));
            }
        }
        // 去掉字符串末尾空格
        StringBuilder result;
        if (slow - 1 > 0 && sb.charAt(slow - 1) == ' ') {
            result = new StringBuilder(sb.substring(0, slow - 1));
        } else {
            result = new StringBuilder(sb.substring(0, slow));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
