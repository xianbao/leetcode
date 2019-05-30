package com.xiao.leetcode.algorithm;

/**查找1-n中重复和确实的元素.*/
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{i + 1, nums[i]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SetMismatch test = new SetMismatch();
        test.findErrorNums(new int[]{4,2,2,1});
    }
}
