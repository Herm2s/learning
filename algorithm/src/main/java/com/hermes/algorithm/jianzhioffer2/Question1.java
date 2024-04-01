package com.hermes.algorithm.jianzhioffer2;

/**
 * @author liu.zongbin
 * @since 2023/4/21
 */
public class Question1 {

    public int divide(int a, int b) {
        // 被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MIN_VALUE;
            }
        }
        // 除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 被除数为0
        if (a == 0) {
            return 0;
        }

        // 使用二分查找，将所有正数取相反数，这样只需考虑1种情况
        boolean rev = false;
        if (a > 0) {
            a = -a;
            rev = true;
        }
        if (b > 0) {
            b = -b;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, result = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            // 快速乘
            boolean check = quickAdd(b, mid, a);
            if (check) {
                result = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return rev ? -result : result;
    }

    private boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }


    public static void main(String[] args) {
        Question1 question1 = new Question1();
        System.out.println(question1.divide(2, 1));
    }
}
