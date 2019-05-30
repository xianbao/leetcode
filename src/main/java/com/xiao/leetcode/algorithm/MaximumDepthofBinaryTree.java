package com.xiao.leetcode.algorithm;

public class MaximumDepthofBinaryTree {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int count) {
        int temp = count;
        if (root != null)
            temp += 1;
        else return temp;
        count = Math.max(count, dfs(root.left, temp));
        count = Math.max(count, dfs(root.right, temp));
        return count;
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
    }
}
