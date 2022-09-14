package com.hermes.algorithm.hashtable;

/**
 * @author liu.zongbin
 * @since 2022/9/14
 */
public class Question2283 {

    /**
     * 输入：num = "1210"
     * 输出：true
     * 解释：
     * num[0] = '1' 。数字 0 在 num 中出现了一次。
     * num[1] = '2' 。数字 1 在 num 中出现了两次。
     * num[2] = '1' 。数字 2 在 num 中出现了一次。
     * num[3] = '0' 。数字 3 在 num 中出现了零次。
     */
    public static boolean digitCount(String num) {
        // 下标：数字，值：出现次数
        // [1, 2, 1, 0]
        int[] arr = new int[10];
        // 先统计出每个数字出现的位置
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            arr[n - '0']++;
        }
        // 遍历
        for (int i = 0; i < num.length(); i++) {
            char n = num.charAt(i);
            // n - '0' 相当于把n转成int类型的数字
            if (arr[i] != n - '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
    }
}
