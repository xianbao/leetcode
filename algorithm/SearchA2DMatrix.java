package algorithm;

/**Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 .*/
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int rowPos = middle / col;
            int colPos = middle % col;
            if (target < matrix[rowPos][colPos]) right = middle - 1;
            else if (target > matrix[rowPos][colPos]) left = middle + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix test = new SearchA2DMatrix();
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 3, 5, 7};
        matrix[1] = new int[]{10, 11, 16, 20};
        matrix[2] = new int[]{23, 30, 34, 50};
        System.out.println(test.searchMatrix(matrix, 13));
    }
}
