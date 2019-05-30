package com.xiao.leetcode.algorithm;

/**
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing only 1's and return its area..
 */
public class MaximalRectangle {
    /**
     * 使用动态规划计算.
     */
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;

        int[][] left = new int[row][col];
        int[][] right = new int[row][col];
        int[][] height = new int[row][col];
        int currentLeft = 0, currentRight = col;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    left[i][j] = 0;
                    right[i][j] = col;
                    currentLeft = 0;
                    currentRight = col;
                } else {
                    if (j == 0 || matrix[i][j] != matrix[i][j - 1]) {
                        // 查找最左和最右1的位置
                        boolean findFirst = false;
                        for (int k = j; k < col; k++) {
                            if (matrix[i][k] == '1') {
                                if (!findFirst) {
                                    currentLeft = k;
                                    currentRight = k + 1;
                                    findFirst = true;
                                } else currentRight = k + 1;
                            } else if (matrix[i][k] == '0' && findFirst) break;
                        }
                    }
                    if (i == 0) {
                        left[i][j] = currentLeft;
                        right[i][j] = currentRight;
                        height[i][j] = 1;
                    } else {
                        left[i][j] = Math.max(currentLeft, left[i - 1][j]);
                        right[i][j] = Math.min(currentRight, right[i - 1][j]);
                        height[i][j] = height[i - 1][j] + 1;
                    }
                    result = Math.max(result, (right[i][j] - left[i][j]) * height[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximalRectangle test = new MaximalRectangle();
        char[][] matrix = new char[6][];
        matrix[0] = new char[]{'1', '1', '1', '0', '1'};
        matrix[1] = new char[]{'1', '1', '0', '1', '0'};
        matrix[2] = new char[]{'0', '1', '1', '1', '0'};
        matrix[3] = new char[]{'1', '1', '1', '1', '0'};
        matrix[4] = new char[]{'1', '1', '1', '1', '1'};
        matrix[5] = new char[]{'0', '0', '0', '0', '0'};

//        matrix[2] = new char[]{'1','1','1','1','1'};
//        matrix[3] = new char[]{'1','0','0','1','0'};
        System.out.println(test.maximalRectangle(matrix));
    }
}
