package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion 排列
 */
public class Permute {
    /**
     * 字典排序全排列
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempResult = new ArrayList<>();
        for (int num : nums) {
            tempResult.add(num);
        }
        Collections.sort(tempResult);
        result.add(new ArrayList<>(tempResult));
        while (true) {
            // 第一个左边数小于右边数的位置
            int index = 0;
            for (int j = tempResult.size() - 1; j > 0; j--) {
                if (tempResult.get(j - 1) < tempResult.get(j)) {
                    index = j - 1;
                    break;
                }
            }
            // index右侧大于index位置值的最小位置
            int lastIndex = 0;
            boolean isFind = false;
            for (int i = tempResult.size() - 1; i > index; i--) {
                if (tempResult.get(i) > tempResult.get(index)) {
                    lastIndex = i;
                    isFind = true;
                    break;
                }
            }
            if (!isFind) {
                break;
            }
            // 交换index和lastIndex的值
            int temp = tempResult.get(index);
            tempResult.set(index, tempResult.get(lastIndex));
            tempResult.set(lastIndex, temp);
            // 将index后的元素翻转
            int len = tempResult.size() - index - 1;
            for (int k = 1, l = tempResult.size() - 1; k <= len / 2; k++) {
                int value = tempResult.get(k + index);
                tempResult.set(k + index, tempResult.get(l));
                tempResult.set(l, value);
                l--;
            }
            result.add(new ArrayList<>(tempResult));
        }
        return result;
    }
    /**全排列坐标法.*/
    public static List<List<Integer>> premuteCoordinate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> posList = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 记录坐标
            temp.add(nums[i]);
            posList.add(i);
        }
        result.add(new ArrayList<>(temp));

        while (true) {
            int len = nums.length - 1;
            int lowIndex = 0;
            int highIndex = 0;
            boolean hasFound = false;
            for (int i = len; i > 0; i--) {
                if (posList.get(i - 1) < posList.get(i)) {
                    lowIndex = i - 1;
                    hasFound = true;
                    break;
                }
            }
            if (!hasFound) {
                break;
            }
            for (int j = len; j > lowIndex; j--) {
                if (posList.get(j) > posList.get(lowIndex)) {
                    highIndex = j;
                    break;
                }
            }
            // 交换下标
            int t = posList.get(lowIndex);
            posList.set(lowIndex, posList.get(highIndex));
            posList.set(highIndex, t);
            // 翻转
            for (int k = lowIndex + 1; k <= len; k++, len--) {
                int l = posList.get(k);
                posList.set(k, posList.get(len));
                posList.set(len, l);
            }
            List<Integer> test = new ArrayList<>();
            for (int key : posList) {
                test.add(nums[key]);
            }
            result.add(test);

        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1};
        List<List<Integer>> result = permute(nums);
    }

}
