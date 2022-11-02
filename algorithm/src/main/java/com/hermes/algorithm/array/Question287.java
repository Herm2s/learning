package com.hermes.algorithm.array;

/**
 * 寻找重复数
 *
 * @author liu.zongbin
 * @since 2022/11/2
 */
public class Question287 {

    /**
     * 二分查找
     */
    public int findDuplicate(int[] nums) {
        // 在 [1..n] 查找 nums 中重复的元素
        int left = 1, right = nums.length - 1;
        // 数组：3, 1, 4, 2, 2
        // 用于二分查找的数组：1, 2, 3, 4
        while (left < right) {
            int mid = (left + right) / 2;
            // 统计数组中小于等于mid的元素个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            // 如果count>mid，说明目标在左边，否则在右边
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 快慢指针
     *
     * @link <a href="https://leetcode.cn/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/">...</a>
     */
    public int findDuplicate1(int[] nums) {
        int slow = 0, fast = 0;
        // 慢指针一次走一步，快指针一次走两步
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 当快慢指针相遇时，将slow置为0，然后快慢指针每次都走一步，再次相遇时即为重复的数字
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Question287 question287 = new Question287();
        System.out.println(question287.findDuplicate1(new int[]{3, 1, 4, 2, 2}));
    }
}
