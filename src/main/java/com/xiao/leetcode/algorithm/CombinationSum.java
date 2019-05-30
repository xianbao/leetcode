package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 .*/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, target, candidates, 0, new ArrayList<Integer>());
        return result;
    }

    public void dfs(List<List<Integer>> result, int target, int[] candidates,int step, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = step; i < candidates.length && candidates[i] <= target; i++) {
            temp.add(candidates[i]);
            dfs(result, target - candidates[i], candidates, i, temp);
            temp.remove((Object)candidates[i]);
        }
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2,3,6,7};
        Arrays.sort(candidates);
        List<List<Integer>> result = test.combinationSum(candidates, 7);
    }
}
