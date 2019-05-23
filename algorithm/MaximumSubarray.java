package algorithm;

/**
 * 计算数组中和为最大的子序列.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum > 0 ? sum + nums[i] : nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(new int[]{-2,-1,-3}));
    }
}
