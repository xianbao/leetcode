package algorithm;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place..
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 记录第一行和第一列是否存在0
        boolean rowZero = false, colZero = false;
        for (int i = 0; i < col; i++) if (matrix[0][i] == 0) rowZero = true;
        for (int i = 0; i < row; i++) if (matrix[i][0] == 0) colZero = true;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero) for (int i = 0; i < col; i++) matrix[0][i] = 0;
        if (colZero) for (int i = 0; i < row; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 0, 2, 1};
        matrix[1] = new int[]{3, 4, 5, 2};
        matrix[2] = new int[]{1, 3, 1, 5};

        SetMatrixZeroes test = new SetMatrixZeroes();
        test.setZeroes(matrix);
    }
}
