package com.xiao.leetcode.algorithm;

/**
 * @Auther: xxb
 * @Date: 2020/1/17 14:29
 * @Description: 最长回文字符串
 */
public class Palindrome {
    public String longestPalindrome(String s) {

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                isPalindrome[i + 1][i] = true;

            }
        }

        int start = 0, maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                isPalindrome[i][j] = isPalindrome[j][i] = isPalindrome[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && i - j > maxLen - 1) {
                    start = j;
                    maxLen = i - j + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.longestPalindrome("abcba"));
    }
}
