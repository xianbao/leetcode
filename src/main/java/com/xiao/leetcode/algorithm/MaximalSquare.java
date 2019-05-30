package com.xiao.leetcode.algorithm;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int area;
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        area = dp[0][0] = matrix[0][0] - '0';
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                area = 1;
            }
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                area = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    // 左上角、左边和上边三个点的最小值
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    area = Math.max(area, dp[i][j] * dp[i][j]);
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        MaximalSquare test = new MaximalSquare();
        char[][] matrix = new char[3][];
        matrix[0] = new char[]{'1', '1', '0', '1'};
        matrix[1] = new char[]{'1', '1', '0', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1'};

//        matrix[1] = new char[]{'1', '1', '0', '1', '0'};
//        matrix[2] = new char[]{'0', '1', '1', '1', '0'};
//        matrix[3] = new char[]{'1', '1', '1', '1', '0'};
//        matrix[4] = new char[]{'1', '1', '1', '1', '1'};
//        matrix[5] = new char[]{'0', '0', '0', '0', '0'};

//        matrix[2] = new char[]{'1','1','1','1','1'};
//        matrix[3] = new char[]{'1','0','0','1','0'};
        System.out.println(test.maximalSquare(matrix));
    }
}
