package com.xiao.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**Given a collection of integers that might contain duplicates, nums,
 * return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++)
            dfs(result, i, new ArrayList<Integer>(), 0, nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, int target, List<Integer> temp, int step, int[] nums) {
        if (temp.size() == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (step >= nums.length) return;
        temp.add(nums[step]);
        dfs(result, target, temp, step + 1, nums);
        temp.remove((Object)nums[step]);
        while (step < nums.length - 1 && nums[step] == nums[step + 1]) step++;
        dfs(result, target, temp, step + 1, nums);
    }
}
