package com.hermes.algorithm.array;

/**
 * 寻找两个正序数组的中位数
 *
 * @author liu.zongbin
 * @since 2022/10/10
 */
public class Question4 {

    public static void main(String[] args) {
        Question4 question4 = new Question4();
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(question4.findMedianSortedArrays2(nums1, nums2));
    }

    /**
     * 先合并两个有序数组，再根据长度是奇数还是偶数寻找中位数
     * <p>
     * 时间复杂度O(m + n)：遍历全部数组
     * 空间复杂度O(m + n)：开辟了一个数组，保存合并后的两个数组
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, m);
        int i = m - 1;
        int j = n - 1;

        while (j >= 0) {
            if (i >= 0 && nums[i] > nums2[j]) {
                nums[i + j + 1] = nums[i--];
            } else {
                nums[i + j + 1] = nums2[j--];
            }
        }
        if (nums.length % 2 == 0) {
            int n1 = nums[nums.length / 2];
            int n2 = nums[nums.length / 2 - 1];
            return (n1 + n2) / 2D;
        }
        return nums[nums.length / 2];
    }

    /**
     * 直接在两个数组中寻找中位数的位置
     * <p>
     * 时间复杂度O(m + n)：遍历len / 2 + 1次，len = m + n
     * 空间复杂度O(1)：没有开辟数组
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int aLen = nums1.length;
        int bLen = nums2.length;
        int len = aLen + bLen;
        int left = -1, right = -1;
        int aIndex = 0, bIndex = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aIndex < aLen && (bIndex >= bLen || nums1[aIndex] < nums2[bIndex])) {
                right = nums1[aIndex++];
            } else {
                right = nums2[bIndex++];
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2D;
        }
        return right;
    }
}
