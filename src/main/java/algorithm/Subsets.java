package algorithm;

import java.util.ArrayList;
import java.util.List;

/**Given a set of distinct integers, nums,
 * return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets..*/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
        dfs(result, target, temp, step + 1, nums);
    }

    public static void main(String[] args) {
        Subsets test = new Subsets();
        test.subsets(new int[]{2,2});
    }
}
