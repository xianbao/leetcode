package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 合并数组
 */

public class MergeIntervals {
    /** 使用二分查找,然后插入.*/
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(){{
            add(intervals[0][0]);
            add(intervals[0][1]);
        }});
        for (int row = 1; row < intervals.length; row++) {
            List<Integer> temp = new ArrayList<>();
            int size = list.size();
            List<Integer> t = list.get(size - 1);
            if (t.get(1) < intervals[row][0]) {
                temp.add(intervals[row][0]);
                temp.add(intervals[row][1]);
                list.add(temp);
            } else if (t.get(1) < intervals[row][1]){
                t.set(1, intervals[row][1]);
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            result[i] = new int[]{temp.get(0), temp.get(1)};
        }
        return result;
    }

    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();
        int[][] intervals = new int[4][];
        intervals[0] = new int[]{1,3};
        intervals[1] = new int[]{8,10};
        intervals[2] = new int[]{2,6};
        intervals[3] = new int[]{15,18};


        System.out.println(test.merge(intervals));
    }
}
