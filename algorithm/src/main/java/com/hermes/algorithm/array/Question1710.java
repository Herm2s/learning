package com.hermes.algorithm.array;

import java.util.Arrays;

/**
 * 卡车上的最大单元数
 *
 * @author liu.zongbin
 * @since 2022/11/15
 */
public class Question1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int result = 0;
        for (int[] boxType : boxTypes) {
            int num = boxType[0];
            int capacity = boxType[1];
            if (num < truckSize) {
                result += num * capacity;
                truckSize -= num;
            } else {
                result += truckSize * capacity;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
