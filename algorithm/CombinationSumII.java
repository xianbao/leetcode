package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a collection of candidate numbers (candidates) and a target number (target),
 *find all unique combinations in candidates where the candidate numbers sums to target.
 *Each number in candidates may only be used once in the combination.
 * .*/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result, target, candidates, 0, new ArrayList<Integer>());
        return result;
    }
    private void dfs(List<List<Integer>> result, int target, int[] candidates, int step, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) return;
        for (int i = step; i < candidates.length; i++) {
            temp.add(candidates[i]);
            dfs(result, target - candidates[i], candidates, i + 1, temp);
            temp.remove((Object)candidates[i]);
            while (i < candidates.length - 1 && candidates[i] == candidates[i+1])i++;
        }
    }

    public static void main(String[] args) {
        CombinationSumII test = new CombinationSumII();
        int[] candidates = {2,2,2};
        List<List<Integer>> result = test.combinationSum2(candidates, 2);
    }
}
