package algorithm;

public class InterleavingString {
    /**
     * DP动态规划.
     * dp[i][j],表示s1[i]至s2[j]是否能够穿插组成s3[i+j]之前的字符串
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if (s1Length + s2Length != s3Length) return false;
        boolean[][] dp = new boolean[s1Length + 1][s2Length + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i][j] | dp[i - 1][j];
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i][j] | dp[i][j - 1];
            }
        }

        return dp[s1Length][s2Length];
    }


    public static void main(String[] args) {
        InterleavingString test = new InterleavingString();
        System.out.println(test.isInterleave("bab", "abbbcba", "babbbabcba"));
    }
}
