package algorithm;

/**
 * @author xiao
 * @date 2018/12/5
 * @descripion 二维数组顺时针方向旋转90度，不申请额外的数组空间
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        int len = matrix[0].length;
        int temp;
        // 外围循环次数
        for (int i = 0; i < (len + 1) / 2; i++) {
            // 移动步长
            int moveDistance = len - i * 2 - 1;
            int index = i + moveDistance;
            int value;
            for (int j = i; j < len - i - 1; j++) {
                int row = i, col = j;
                temp = matrix[row][col];
                // 右移
                row += col + moveDistance - index;
                col = index;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // 下移
                col = index - (row + moveDistance - index);
                row = index;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // 左移
                row += col - moveDistance - i;
                col = i;
                value = matrix[row][col];
                matrix[row][col] = temp;
                temp = value;
                // 上移
                col -= row - moveDistance - i;
                row = i;
                matrix[row][col] = temp;
            }
        }
    }
}

