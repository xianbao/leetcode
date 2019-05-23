package algorithm;

/**Given a m x n grid filled with non-negative numbers, \
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0, Integer.MAX_VALUE, 0);
    }
    // 使用dfs，时间复杂度很大
    public int dfs(int[][] grid, int row, int col, int minSum, int sum) {
        sum += grid[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1 && sum < minSum) {
            minSum = Math.min(minSum, sum);
            return minSum;
        }
        if (col < grid[0].length - 1 && sum < minSum) {
            minSum = dfs(grid, row, col + 1, minSum, sum);
        }
        if (row < grid.length - 1 && sum < minSum) {
            minSum = dfs(grid, row + 1, col, minSum, sum);
        }
        return minSum;
    }

    // 使用动态规划DP尝试解决
    public int minPathSumDP(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for (int i = 1; i < col; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];

        for (int m = 1; m < row; m++) {
            for (int n = 1; n < col; n++) {
                dp[m][n] = Math.min(dp[m - 1][n], dp[m][n - 1]) + grid[m][n];
            }
        }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum test = new MinimumPathSum();
        int[][] grid = new int[3][];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};
        System.out.println(test.minPathSumDP(grid));
    }
}
