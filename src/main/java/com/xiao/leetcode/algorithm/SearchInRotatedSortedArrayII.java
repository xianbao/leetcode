package com.xiao.leetcode.algorithm;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 */
public class SearchInRotatedSortedArrayII {

//    private boolean searchBackTracing(int[] nums, int target, int left, int right) {
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            if (nums[middle] == target) return true;
//            // middle 右侧有序.二分查找
//            if (nums[middle] <= nums[right]) {
//                if (nums[middle] == nums[right]) {
//                    boolean temp = searchBackTracing(nums, target, middle + 1, right - 1);
//                    if (temp) return true;
//                    right = middle - 1;
//                } else {
//                    boolean result = binarySearch(nums, middle, right, target);
//                    if (result) return true;
//                    else {
//                        right = middle - 1;
//                    }
//                }
//            } else if (nums[left] <= nums[middle]) {
//                if (nums[left] == nums[middle]) {
//                    boolean temp = searchBackTracing(nums, target, left + 1, middle - 1);
//                    if (temp) return true;
//                    left = middle + 1;
//                } else {
//                    boolean result = binarySearch(nums, left, middle, target);
//                    if (result) return true;
//                    else {
//                        left = middle + 1;
//                    }
//                }
//            }
//        }
//        return false;
//    }

//    public boolean search(int[] nums, int target) {
//        if (nums.length == 1) return nums[0] == target;
//        return searchBackTracing(nums, target, 0, nums.length - 1);
//    }

    public boolean searchII(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) return true;
            else if (nums[middle] > nums[left]) {
                // 左侧有序
                if (target >= nums[left] && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            } else if (nums[middle] < nums[left]) {
                // 右侧有序
                if (target > nums[middle] && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            } else left += 1;
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int left, int right, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == target) return true;
            else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
        int[] nums = new int[]{3,1,1};
        System.out.println(test.searchII(nums, 3));
    }
}
