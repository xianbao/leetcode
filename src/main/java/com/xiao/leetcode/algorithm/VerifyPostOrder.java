package com.xiao.leetcode.algorithm;

/**
 * @Auther: xxb
 * @Date: 2020/3/5 16:54
 * @Description:
 */
public class VerifyPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) return true;
        return recursive(postorder, 0, postorder.length - 1);
    }


    // 递归遍历，数组中最后一个元素为根节点
    private boolean recursive(int[] postorder, int start, int end) {
        if (start < 0 || end < 0 || start >= end) {
            return true;
        }
        int temp = start;
        while (temp < end && postorder[temp] < postorder[end]) {
            temp += 1;
        }

        for (int j = temp + 1; j < end; j++) {
            // i后面的节点全部大于跟节点
            if (postorder[j] < postorder[end]) return false;
        }
        return recursive(postorder, start, temp - 1)
                && recursive(postorder, temp + 1, end - 1);
    }


    public static void main(String[] args) {
        String str = "abc";
        String[] arr = str.split("");
    }
}
