package com.xiao.leetcode.algorithm;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int middle;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            // middle 右侧有序.二分查找
            if (nums[middle] <= nums[right]) {
                int result = binarySearch(nums, middle, right, target);
                if (result > -1) return result;
                else {
                    right = middle - 1;
                }
            } else if (nums[left] <= nums[middle]) {
                int result = binarySearch(nums, left, middle, target);
                if (result > -1) return result;
                else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) return middle;
            else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
