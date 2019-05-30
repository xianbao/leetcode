package com.xiao.leetcode.algorithm;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion
 */
public class MedianNumber {
    /**
     * 获取两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        double preResult = 0.0;
        int num1Length = nums1.length, num2Length = nums2.length;
        int first = 0, second = 0;
        for (int i = 0; i < num1Length + num2Length; i++) {
            if ((first == num1Length) || (num2Length != 0 && second < num2Length && nums1[first] >= nums2[second])) {
                preResult = result;
                result = nums2[second];
                second++;
            } else if (second == num2Length || first < num1Length && nums1[first] < nums2[second]) {
                preResult = result;
                result = nums1[first];
                first++;
            }
            if (i == (num1Length + num2Length) / 2) break;
        }

        if ((num1Length + num2Length) % 2 == 0) {
            return (preResult + result) / 2;
        }
        return result;
    }
}
