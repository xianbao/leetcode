package com.xiao.leetcode.algorithm;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * .
 */
public class WordSearch {

    /**
     * DFS.顺时针旋转
     */
    private boolean dfs(char[][] board, boolean[][] flag,
                       StringBuilder sb, String word, int row, int col) {
        if (!flag[row][col]) {
            sb.append(board[row][col]);
            flag[row][col] = true;
        }
        if (board[row][col] != word.charAt(sb.length() - 1)) {
            flag[row][col] = false;
            return false;
        }
        if (sb.length() == word.length()) {
            return sb.toString().equals(word);
        }
        if (col - 1 >= 0 && !flag[row][col - 1]) {
            if (dfs(board, flag, sb, word, row, col - 1)) return true;
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                flag[row][col - 1] = false;
            }
        }
        if (row - 1 >= 0 && !flag[row - 1][col]) {
            if (dfs(board, flag, sb, word, row - 1, col)) return true;
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                flag[row - 1][col] = false;
            }
        }

        if (col < board[0].length - 1 && !flag[row][col + 1]) {
            if (dfs(board, flag, sb, word, row, col + 1)) return true;
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                flag[row][col + 1] = false;
            }
        }
        if (row < board.length - 1 && !flag[row + 1][col]) {
            if (dfs(board, flag, sb, word, row + 1, col)) return true;
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                flag[row + 1][col] = false;
            }
        }

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board.length * board[0].length < word.length()) return false;
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) continue;
                boolean result = dfs(board, flag, new StringBuilder(), word, i, j);
                flag[i][j] = false;
                if (result) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] board = new char[6][];
        board[0] = new char[]{'b','a','a','b','a','b'};
        board[1] = new char[]{'a','b','a','a','a','a'};
        board[2] = new char[]{'a','b','a','b','b','a'};
        board[3] = new char[]{'a','a','b','b','a','b'};
        board[4] = new char[]{'a','a','b','b','b','a'};
        board[5] = new char[]{'a','a','b','a','a','b'};
        System.out.println(System.currentTimeMillis());
        System.out.println(test.exist(board, "aabbbbabbaababaaaabababbaaba"));
        System.out.println(System.currentTimeMillis());
    }

}
