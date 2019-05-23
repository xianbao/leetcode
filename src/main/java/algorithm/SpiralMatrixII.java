package algorithm;

/**螺旋构建1-n^2的数组元素.*/
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        // 0->右;1->下;2->左;3->上
        int direction = 0;
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;
        while (count <= n * n) {
            if (direction == 0) {
             for (int col = startCol; col <= endCol; col++) {
                 result[startRow][col] = count++;
             }
             direction = 1;
             startRow++;
            } else if (direction == 1) {
                for (int row = startRow; row <= endRow; row++) {
                    result[row][endCol] = count++;
                }
                direction = 2;
                endCol--;
            } else if (direction == 2) {
                for (int col = endCol; col >= startCol; col--) {
                    result[endRow][col] = count++;
                }
                direction = 3;
                endRow--;
            } else {
                for (int row = endRow; row >= startRow; row--) {
                    result[row][startCol] = count++;
                }
                direction = 0;
                startCol++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SpiralMatrixII test = new SpiralMatrixII();
        test.generateMatrix(4);
    }
}
