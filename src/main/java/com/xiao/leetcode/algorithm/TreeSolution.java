package com.xiao.leetcode.algorithm;

import com.xiao.leetcode.util.ListNode;
import com.xiao.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: xxb
 * @Date: 2020/4/2 15:42
 * @Description:
 */
public class TreeSolution {

    private static boolean preOrder(TreeNode node, Integer target, List<TreeNode> list) {
        if (node == null) return false;
        list.add(node);
        if (node.value.equals(target)) return true;

        if (preOrder(node.left, target, list)) return true;
        if (preOrder(node.right, target, list)) return true;
        // 删除列表最后一个元素;
        list.remove(list.size() - 1);
        return false;
    }

    // 不使用运算符进行加法运算
    public static int add(int a, int b) {
        //  记录32位比特位的值
        int[] bits = new int[32];
        // 进位标志
        boolean flag = false;
        for (int i = 0; i < 32; i++) {
            int bita = 1 & a;
            int bitb = 1 & b;

            bits[i] = bita ^ bitb;
            // 上一位的进位值
            if (flag) {
                // 异或结果位1，加上进位值
                if (bits[i] == 1) {
                    flag = true;
                    bits[i] = 0;
                } else {
                    bits[i] = 1;
                    flag = (bita & bitb) == 1;
                }
            } else {
                if ((bita & bitb) == 1) {
                    flag = true;
                }
            }

            a = a >> 1;
            b = b >> 1;
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result ^ (bits[i] << i));
        }

        return result;
    }

    public static void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode p = temp.next;
        temp.next = p.next;
        temp = p;
        node = temp;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode lastSmall = null;
        ListNode node = head;
        ListNode list = new ListNode(0);
        list.next = head;
        ListNode pre = list;
        while (node != null) {
            if (node.val < x) {
                pre.next = node.next.next;
                ListNode temp = node;
                if (lastSmall == null) {
                    node.next = head;
                    head = temp;
                    lastSmall = head;
                } else {
                    temp.next = lastSmall.next;
                    lastSmall.next = temp;
                    temp = lastSmall;
                }
                node = pre.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }

        return head;
    }

    public static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen != 0 && pLen == 0) return false;
        if (sLen == 0 && pLen != 0) {
            for (int i = 0; i < pLen; i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        // 首位填充空格
        dp[0][0] = true;
        for (int j = 1; j < pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }


        for (int i = 1; i <= sLen; i++) {
            for (int j =1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '?') {
                    //  进行?匹配
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*'){
                    // 进行*匹配
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static boolean recursive(boolean flag, int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (flag) return false;
                boolean result = false;
                if (s.charAt(left + 1) == s.charAt(right)) {
                    result = recursive(true, left + 1, right, s);
                }
                if (s.charAt(left) == s.charAt(right - 1) && !result) {
                    result = recursive(true, left, right - 1, s);
                }
                return result;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        // 是否已经删除了一个字符
        boolean flag = false;
        for (int left = 0, right = s.length() - 1; left < right;) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return recursive(false, left, right, s);
            }
        }
        return true;
    }

    public void func() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ");
        }
    }
    public static void main(String[] args) {
//        String s = "adceb";
//        String p = "*a*b";
//        System.out.println(isMatch(s, p));

    }
}
