package com.xiao.leetcode.algorithm;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion
 */
public class QuickSort {
    private static void quickSort(int[] arr, int left, int right) {
        if (arr.length <= 1 || left >= right) {
            return;
        }
        int middle = arr[left + (right - left) / 2];
        int low = left, high = right;
        while (low <= high) {
            while (arr[low] > middle) {
                low++;
            }
            while (arr[high] < middle) {
                high--;
            }
            if (low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                low++;
                high--;
            } else if (low == high) {
                low++;
            }
        }
        quickSort(arr, left, high);
        quickSort(arr, low, right);
    }

    public static void quickSort1(int[] arr, int left, int right) {
        if (arr.length <= 1 || left >= right) return;
        int middle = arr[(right + left) / 2];
        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < middle) ++i;
            while (middle < arr[j]) --j;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) ++i;
        }
        quickSort1(arr, left, j);
        quickSort1(arr, i, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};
        quickSort1(nums, 0, nums.length - 1);
    }
}
