package com.hermes.algorithm.dp;

/**
 * 买卖股票的最佳时机
 *
 * @author liu.zongbin
 * @since 2022/10/26
 */
public class Question121 {

    /**
     * 贪心算法
     */
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        // res不断更新，直到数组循环完毕
        int result = 0;
        for (int price : prices) {
            // 找到一个最小的购入点
            low = Math.min(price, low);
            result = Math.max(result, price - low);
            System.out.println();
        }
        return result;
    }

    /**
     * 动态规划
     */
    public int maxProfit1(int[] prices) {
        return 0;
    }

    public static void main(String[] args) {
        Question121 question121 = new Question121();
        System.out.println(question121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
