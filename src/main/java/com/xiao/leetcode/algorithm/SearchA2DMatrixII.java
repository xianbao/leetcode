package com.xiao.leetcode.algorithm;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length - 1;
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (target < matrix[i][middle]) right = middle - 1;
                else if (target > matrix[i][middle]) left = middle + 1;
                else return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrixII test = new SearchA2DMatrixII();
        int[][] matrix = new int[5][];
        matrix[0] = new int[]{1, 4, 7, 11, 15};
        matrix[1] = new int[]{2, 5, 8, 12, 19};
        matrix[2] = new int[]{3, 6, 9, 16, 22};
        matrix[3] = new int[]{10, 13, 14, 17, 24};
        matrix[4] = new int[]{18, 21, 23, 26, 30};

        System.out.println(test.searchMatrix(matrix, 20));
    }
}
