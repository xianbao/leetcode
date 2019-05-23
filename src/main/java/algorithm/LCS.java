package algorithm;

/**
 * @author xiao
 * @date 2019/3/20
 * @descripion 最长公共子序列，动态规划
 */
public class LCS {
    public int getLCSLength(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] c = new int[m + 1][n + 1];
        for(int i = 0; i <= n; i++) {c[0][i] = 0;}
        for(int j = 0; j <= m; j++) {c[j][0] = 0;}
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[m][n];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String str1 = "abc";
        String str2 = "ab12c";
        System.out.println(lcs.getLCSLength(str1, str2));
    }

}
