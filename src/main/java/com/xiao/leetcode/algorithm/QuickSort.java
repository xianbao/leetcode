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
        int[] nums = new int[]{2,1,2,0,1,1,1,1};
        quickSort(nums, 0, nums.length - 1);
    }
}
