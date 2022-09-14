package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * @author liu.zongbin
 * @since 2022/9/14
 */
public class Question1619 {

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int sum = 0;
        for (int i = length / 20; i < 19 * length / 20; i++) {
            sum += arr[i];
        }
        return sum / (length * 0.9);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(trimMean(arr));
    }
}
