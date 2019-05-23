package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后问题.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // 行标志
        boolean[][] flag = new boolean[n][n];
        dfs(0, 0, 0, flag, result);
        return result;
    }

    private boolean dfs(int count, int row, int col, boolean[][] flag, List<List<String>> result) {
        if (count == flag.length) {
            List<String> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < flag.length; i++) {
                for (int j = 0; j < flag[0].length; j++) {
                    if (flag[i][j]) sb.append("Q");
                    else sb.append(".");
                }
                temp.add(sb.toString());
                sb.delete(0, sb.length());
            }
            result.add(temp);
            return true;
        }
        if (row >= flag.length || col >= flag.length) return false;
        boolean duplicated = false;
        // 查找同一列是否重复
        for (int i = 0; i < row; i++) {
            if (flag[i][col]) {
                duplicated = true;
                break;
            }
        }
        // 查找相邻斜边是否存在重复
        int m = row;
        int cnt = 1;
        while (m > 0) {
            if (((col - cnt >= 0) && flag[m - 1][col - cnt]) || ((col + cnt < flag.length) && flag[m - 1][col + cnt])) {
                duplicated = true;
                break;
            }
            m -= 1;
            cnt += 1;
        }
        if (duplicated) {
            dfs(count, row, col + 1, flag, result);
        } else {
            flag[row][col] = true;
            count += 1;
            dfs(count, row + 1, 0, flag, result);
            flag[row][col] = false;
            count -= 1;
            dfs(count, row, col + 1, flag, result);
        }
        return false;
    }


    public static void main(String[] args) {
        NQueens test = new NQueens();
        List<List<String>> list = test.solveNQueens(4);
    }
}
