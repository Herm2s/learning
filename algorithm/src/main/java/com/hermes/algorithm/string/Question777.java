package com.hermes.algorithm.string;

/**
 * @author herm2s
 * @since 2022/10/2 15:06
 */
public class Question777 {

    public static boolean canTransform(String start, String end) {
        int length = start.length();
        int i = 0, j = 0;
        while (i < length && j < length) {
            while (i < length && start.charAt(i) == 'X') {
                i++;
            }
            while (j < length && end.charAt(j) == 'X') {
                j++;
            }
            if (i < length && j < length) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < length) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < length) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
}
