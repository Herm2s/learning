package com.hermes.algorithm.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu.zongbin
 * @since 2022/9/26
 */
public class Question202 {

    public static void main(String[] args) {
        Question202 question202 = new Question202();
        System.out.println(question202.isHappy(19));
    }

    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    int getNextNum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}
