package com.hermes.algorithm.array;

/**
 * 盛最多水的容器
 *
 * @author liu.zongbin
 * @since 2022/10/31
 */
public class Question11 {

    /**
     * 双指针
     */
    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            // 移动短板，面积可能变大，移动长板，面积一定变小，所以每次都要移动短板
            result = height[left] < height[right] ?
                    Math.max(result, (right - left) * height[left++]) :
                    Math.max(result, (right - left) * height[right--]);
        }
        return result;
    }

    /**
     * 暴力法
     */
    public int maxArea(int[] height) {
        int left = 0;
        int result = 0;
        while (left < height.length - 1) {
            int right = left + 1;
            while (right > left && right < height.length) {
                int length = right - left;
                int high = Math.min(height[left], height[right]);
                result = Math.max(result, length * high);
                right++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        Question11 question11 = new Question11();
        System.out.println(question11.maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
