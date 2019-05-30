package com.xiao.leetcode.algorithm;

/**
 * Given a sorted array nums, remove the duplicates in-place
 * such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 1;
        int length = nums.length;
        int start = 0, end = 0, count = 1, current = nums[0];
        for (int i = 1; i < length; ) {
            if (current == nums[i]) {
                count += 1;
                if (count <= 2) {
                    start += 1;
                    result += 1;
                }
                end += 1;
                i += 1;
            } else {
                // 移动数组
                if (count > 2) {
                    int interval = end - start;
                    System.arraycopy(nums, i, nums, i - interval, length - i);
                    length -= interval;
                    i = i - interval;
                }
                current = nums[i];
                result += 1;
                count = 1;
                start = i;
                end = i;
                i += 1;

            }
        }

        return result;
    }


    public static void main(String[] args) {
        RemoveDuplicatesII test = new RemoveDuplicatesII();
        int[] nums = new int[]{-3,-1,0,0,0,3,3};
        System.out.println(test.removeDuplicates(nums));
    }

}
