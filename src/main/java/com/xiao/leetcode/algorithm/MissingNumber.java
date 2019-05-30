package com.xiao.leetcode.algorithm;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] < nums.length && nums[i] != i) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) return index;
        }
        return nums.length;
    }
}
