package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**Given two integers n and k, return all possible combinations of k numbers out of 1 ... n..*/
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= n; i++) data.add(i);
        insertData(result, data, new ArrayList<Integer>(), 0, k);
        return result;
    }

    private void insertData(List<List<Integer>> result, List<Integer> data, List<Integer> temp, int step, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (step >= data.size()) return;
        temp.add(data.get(step));
        insertData(result, data, temp, step + 1, k);
        temp.remove(data.get(step));
        insertData(result, data, temp, step + 1, k);
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        List<List<Integer>> result  = test.combine(4, 2);
    }
}
