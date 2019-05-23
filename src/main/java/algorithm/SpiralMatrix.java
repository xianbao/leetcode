package algorithm;

import java.util.ArrayList;
import java.util.List;

/**螺旋遍历数组.*/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int count = 1;
        // 0->右;1->下;2->左;3->上
        int direction = 0;
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        while (count <= matrix.length * matrix[0].length) {
            if (direction == 0) {
                for (int col = startCol; col <= endCol; col++) {
                    result.add(matrix[startRow][col]);
                    count++;
                }
                direction = 1;
                startRow++;
            } else if (direction == 1) {
                for (int row = startRow; row <= endRow; row++) {
                    result.add(matrix[row][endCol]);
                    count++;
                }
                direction = 2;
                endCol--;
            } else if (direction == 2) {
                for (int col = endCol; col >= startCol; col--) {
                    result.add(matrix[endRow][col]);
                    count++;
                }
                direction = 3;
                endRow--;
            } else {
                for (int row = endRow; row >= startRow; row--) {
                    result.add(matrix[row][startCol]);
                    count++;
                }
                direction = 0;
                startCol++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        test.spiralOrder(matrix);
    }
}
