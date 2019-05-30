package com.xiao.leetcode.algorithm;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) ++cnt;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber test = new FindTheDuplicateNumber();
        System.out.println(test.findDuplicate(new int[]{1,2,3,3,4}));
    }
}
