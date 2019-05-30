package com.xiao.leetcode.algorithm;

/**A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 .*/
public class UniquePaths {

    // 计算两个数的最大公约数
    public int maxCommonDivisor(int m, int n) {
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        while (max != 0 && min != 0) {
            int temp = max - min;
            max = Math.max(temp, min);
            min = Math.min(temp, min);
        }
        return max + min;
    }
    // 使用动态规划
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int row = 1; row < m; row++) dp[row][0] = 1;
        for (int col = 1; col < n; col++) dp[0][col] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(13, 9));
//        System.out.println(test.maxCommonDivisor(22,12));
    }
}
