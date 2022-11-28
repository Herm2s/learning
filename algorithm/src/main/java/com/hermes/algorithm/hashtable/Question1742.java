package com.hermes.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 盒子中小球的最大数量
 *
 * @author liu.zongbin
 * @since 2022/11/23
 */
public class Question1742 {

    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0;
            int x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            map.put(box, map.getOrDefault(box, 0) + 1);
            result = Math.max(result, map.get(box));
        }
        return result;
    }

    public static void main(String[] args) {
        Question1742 question1742 = new Question1742();
        System.out.println(question1742.countBalls(5, 15));
    }
}
