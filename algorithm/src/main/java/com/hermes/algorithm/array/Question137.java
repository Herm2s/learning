package com.hermes.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字2
 *
 * @author liu.zongbin
 * @since 2022/11/10
 */
public class Question137 {

    /**
     * 哈希法
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.merge(num, 1, (value1, value2) -> value1 + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 位运算
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                // (num >> i) & 1求出num的第i个进制位
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question137 question137 = new Question137();
        System.out.println(question137.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
