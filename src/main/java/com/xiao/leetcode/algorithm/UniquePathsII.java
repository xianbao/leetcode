package com.xiao.leetcode.algorithm;

/**A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 .*/
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][col - 1] == 1) return 0;
        else dp[0][0] = 1;
        boolean hasObstacle = false;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 1) hasObstacle = true;
            if (hasObstacle) dp[i][0] = 0;
            else dp[i][0] = 1;
        }
        hasObstacle = false;
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i] == 1) hasObstacle = true;
            if (hasObstacle) dp[0][i] = 0;
            else dp[0][i] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i - 1][j] != 1) dp[i][j] += dp[i - 1][j];
                if (obstacleGrid[i][j - 1] != 1) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        UniquePathsII test = new UniquePathsII();
        int[][] obstacleGrid = new int[1][];
        obstacleGrid[0] = new int[]{1,0};
        test.uniquePathsWithObstacles(obstacleGrid);
    }
}
