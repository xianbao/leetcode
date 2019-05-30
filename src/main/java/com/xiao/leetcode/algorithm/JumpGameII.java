package com.xiao.leetcode.algorithm;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGameII {
    // 使用贪心法计算。
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        // 当前能到达最远距离
        int cur = 0;
        // 前一步能到达的最远距离
        int previous = 0;
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > cur) return -1;
            if (i > previous) {
                steps += 1;
                previous = cur;
            }
            cur = Math.max(cur, i + nums[i]);
        }
        return steps;
    }
    // 动态规划计算
    public int jumpDP(int[] nums) {
        // 记录到达的最小步数
        int[] dp = new int[nums.length];
        int index = 0;
        int curMax = 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax, i + nums[i]);
            if (i < max) dp[i] = dp[index] + 1;
            else if (i == max){
                max = curMax;
                dp[i] = dp[index] + 1;
                index = i;
            } else if (i > max) {
                dp[i] = -1;
            }
        }
        return dp[nums.length - 1];
    }
    public static void main(String[] args) {
        JumpGameII test = new JumpGameII();
        System.out.println(test.jump(new int[]{2,3,1,1,4}));
    }
}
