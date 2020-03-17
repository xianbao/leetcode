package com.xiao.leetcode.algorithm;

/**
 * @Auther: xxb
 * @Date: 2020/3/17 15:37
 * @Description: 归并排序，查找逆数对
 */
public class MergeSort {

    // 双层for循环时间复杂读O(n^2)超时
    // 改用归并排序
    public int reversePairs(int[] nums) {

        int[] temps = new int[nums.length];
        int count = mergeSortRecursive(nums, 0, nums.length - 1, temps);
        return count;
    }

    public int mergeSortRecursive(int[] nums, int left, int right, int[] temps) {
        if (left == right) return 0;

        int middle = (left + right) / 2;

        // middle左侧逆序对
        int leftPairs = mergeSortRecursive(nums, left, middle, temps);
        // middle右侧逆序对
        int rightPairs = mergeSortRecursive(nums, middle + 1, right, temps);

        // 此时在区间[left, right]已经有序
        if (nums[middle] <= nums[middle + 1]) return leftPairs + rightPairs;

        int crossPairsCount = merge(nums, left, middle, right, temps);

        return crossPairsCount + leftPairs + rightPairs;

    }

    public int merge(int[] nums, int left, int middle, int right, int[] temps) {
        for (int i = left; i <= right; i++) {
            temps[i] = nums[i];
        }
        int crossCount = 0;
        int i = left, j = middle + 1;
        // 排序
        for (int k = left; k <= right; k++) {
            // middle 左侧数组全部遍历完毕，添加右侧数组剩余元素
            if (i > middle) {
                nums[k] = temps[j];
                j++;
            } else if (j > right){
                // 右侧数组遍历完毕，添加左侧剩余的数组元素
                nums[k] = temps[i];
                i++;
            } else if (temps[i] <= temps[j]){
                i++;
                nums[k] = temps[i];
            } else {
                nums[k] =  temps[j];
                j++;
                crossCount += middle - i + 1 ;
            }
        }


        return crossCount;
    }

    public static void main(String[] args) {
        MergeSort object = new MergeSort();
        int[] nums = new int[]{7,5,6,4};
        System.out.println(object.reversePairs(nums));
    }
}
